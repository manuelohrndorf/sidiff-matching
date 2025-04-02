package org.sidiff.superimposition.conflict;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.entities.exporter.filter.DefaultExporterFilter;
import org.sidiff.entities.exporter.filter.IExporterFilter;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelPlugin;
import org.sidiff.superimposition.conflict.detector.IConflictDetector;
import org.sidiff.superimposition.conflict.diagnostic.IDiagnosticHandler;
import org.sidiff.superimposition.conflict.resolver.IConflictResolver;
import org.sidiff.superimposition.conflict.selector.BasicConflictSelector;
import org.sidiff.superimposition.conflict.selector.BatchConflictResolverSelector;
import org.sidiff.superimposition.conflict.selector.IConflictDetectorSelector;
import org.sidiff.superimposition.conflict.selector.IConflictResolverSelector;
import org.sidiff.superimposition.conflict.selector.IConflictSelector;

/**
 * The conflict facade provides access to the conflict
 * detection and resolution facility. To use the facade,
 * create a new {@link Configuration} using {@link ConflictFacade#config()},
 * set all required fields and call {@link Configuration#build()}.
 * @author rmueller
 */
public class ConflictFacade {

	private Configuration configuration;

	private ConflictFacade(Configuration configuration) {
		this.configuration = Objects.requireNonNull(configuration);
	}

	/**
	 * <p>Repeatedly detects and resolves conflicts of the superimposed model, until no
	 * conflicts are detected or the conflict selector returns an empty list of conflicts.</p>
	 * <p><b>Warning: </b> this operation might run indefinitely if the conflict
	 * selector repeatedly selects conflicts that undo each other. Care must be taken
	 * to only select "unconflicting" conflicts.</p>
	 * @param superimposedModel the superimposed model
	 * @param monitor progress monitor
	 * @return diagnostic status of the detections and resolutions
	 */
	public void detectAndResolveConflicts(SuperimposedModel superimposedModel, IProgressMonitor monitor) {

		SubMonitor progress = SubMonitor.convert(monitor, 1000);

		int lastNumConflicts = -1;
		double relativeDelta = 0.0;
		while(true) {
			progress.setWorkRemaining(100);

			ConflictSet conflictSet = superimposedModel.createConflictSet(configuration.filter);

			detectConflicts(conflictSet, progress.split(1));
			if(configuration.diagnosticHandler.isCanceled() || conflictSet.getConflicts().isEmpty()) {
				break;
			}

			// Stop resolution if number of conflicts keeps rising, which means
			// that the resolve is malfunctioning and creating more conflicts.
			int numConflicts = conflictSet.getConflicts().size();
			if(lastNumConflicts != -1) {
				relativeDelta += (numConflicts - lastNumConflicts) / (double)numConflicts;
				if(relativeDelta > 2.0) {
					configuration.diagnosticHandler.handle(Diagnostic.ERROR,
						"Detect-Resolve aborted, because number of conflicts keeps increasing.");
					break;
				}
			}
			lastNumConflicts = numConflicts;

			resolveConflicts(conflictSet, progress.split(9));
			if(configuration.diagnosticHandler.isCanceled()) {
				break;
			}
		}
	}

	/**
	 * Detects all conflicts of the {@link ConflictSet#getInputs()} using all
	 * available conflict detectors for the document types of the {@link ConflictSet#getContext()},
	 * adding them to the conflict set.
	 * @param conflictSet the conflict set
	 * @param monitor progress monitor
	 * @return diagnostic status of the detection
	 */
	public void detectConflicts(ConflictSet conflictSet, IProgressMonitor monitor) {
		Collection<IConflictDetector> detectors = configuration.conflictDetectorSelector.selectDetectors(conflictSet);
		if(detectors.isEmpty()) {
			configuration.diagnosticHandler.handle(Diagnostic.ERROR,
				"No conflict detectors are available/selected for document types: "
					+ conflictSet.getContext().getDocType());
			return;
		}

		SubMonitor progress = SubMonitor.convert(monitor, detectors.size());
		for(IConflictDetector detector : detectors) {
			configuration.diagnosticHandler.handle(detector.detectConflicts(conflictSet, progress.split(1)));
			if(configuration.diagnosticHandler.isCanceled()) {
				return;
			}
		}
		if(conflictSet.getConflicts().isEmpty()) {
			configuration.diagnosticHandler.handle(Diagnostic.INFO, "No conflicts have been found.");
		}
	}

	/**
	 * Selects conflicts from the {@link ConflictSet} using the {@link IConflictSelector} and
	 * attempts to solve them in the specified order using {@link #resolveConflict(Conflict, IProgressMonitor)}.
	 * @param conflictSet the conflict set
	 * @param monitor progress monitor
	 * @return diagnostic status of the resolution
	 */
	public void resolveConflicts(ConflictSet conflictSet, IProgressMonitor monitor) {
		List<Conflict> conflicts = configuration.conflictSelector.selectConflicts(conflictSet);
		if(conflicts.isEmpty()) {
			configuration.diagnosticHandler.handle(Diagnostic.CANCEL, "No conflicts have been selected. Resolution stopped.");
			return;
		}
		SubMonitor progress = SubMonitor.convert(monitor, conflicts.size());
		for(Conflict conflict : conflicts) {
			configuration.diagnosticHandler.handle(resolveConflict(conflict, progress.split(1)));
			if(configuration.diagnosticHandler.isCanceled()) {
				return;
			}
		}
	}

	/**
	 * Attempts to resolve the conflict with all available conflict resolvers that support it.
	 * @param conflict the conflict
	 * @param monitor progress monitor
	 * @return diagnostic status of the resolution
	 */
	public Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor) {
		Collection<IConflictResolver> resolvers = IConflictResolver.MANAGER.getConflictResolvers(conflict);
		BasicDiagnostic diagnostic = new BasicDiagnostic(SuperimpositionModelPlugin.ID, 0,
				"Resolving Conflict " + conflict.getId() + ": " + conflict.getMessage(), null);
		if(resolvers.isEmpty()) {
			diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR,
					SuperimpositionModelPlugin.ID, 0, "No conflict resolver is available.", null));
			return diagnostic;
		}
		resolvers = configuration.conflictResolverSelector.selectResolvers(conflict, resolvers);
		if(resolvers.isEmpty()) {
			diagnostic.add(new BasicDiagnostic(Diagnostic.CANCEL,
					SuperimpositionModelPlugin.ID, 0, "No conflict resolver was selected. Stopping resolution.", null));
			return diagnostic;
		}

		SubMonitor progress = SubMonitor.convert(monitor, resolvers.size());
		for(IConflictResolver resolver : resolvers) {
			Diagnostic diag = resolver.resolveConflict(conflict, progress.split(1));
			diagnostic.add(diag);
			if(diag.getSeverity() != Diagnostic.ERROR) {
				// stop after first successful resolution or if cancelled
				return diagnostic;
			}
		}

		diagnostic.add(new BasicDiagnostic(Diagnostic.ERROR, SuperimpositionModelPlugin.ID,
				0, "None of the available conflict resolver were able to resolve this conflict.", null));
		return diagnostic;
	}

	/**
	 * Creates a new Configuration to initialize a new instance of a ConflictFacade.
	 * @return new configuration
	 */
	public static Configuration config() {
		return new Configuration();
	}

	/**
	 * This class is used to configure a new ConflictFacade, which can be
	 * created using {@link #build()}.
	 */
	public static class Configuration {

		// fields for access by the ConflictFacade
		IConflictDetectorSelector conflictDetectorSelector;
		IConflictSelector conflictSelector;
		IConflictResolverSelector conflictResolverSelector;
		IDiagnosticHandler diagnosticHandler;
		IExporterFilter filter;

		// internal
		private List<IDiagnosticHandler> diagnosticHandlers = new LinkedList<>();
		private boolean build = false;

		public Configuration setConflictDetectorSelector(IConflictDetectorSelector conflictDetectorSelector) {
			assertNotBuild();
			this.conflictDetectorSelector = Objects.requireNonNull(conflictDetectorSelector);
			return this;
		}

		public Configuration setConflictSelector(IConflictSelector conflictSelector) {
			assertNotBuild();
			this.conflictSelector = Objects.requireNonNull(conflictSelector);
			return this;
		}

		public Configuration setResolverSelector(IConflictResolverSelector conflictResolverSelector) {
			assertNotBuild();
			this.conflictResolverSelector = Objects.requireNonNull(conflictResolverSelector);
			return this;
		}

		public Configuration addDiagnosticHandler(IDiagnosticHandler diagnosticHandler) {
			assertNotBuild();
			this.diagnosticHandlers.add(Objects.requireNonNull(diagnosticHandler));
			return this;
		}

		public Configuration setFilter(IExporterFilter filter) {
			assertNotBuild();
			this.filter = Objects.requireNonNull(filter);
			return this;
		}

		protected void initDefaults() {
			if(filter == null) {
				filter = new DefaultExporterFilter();
			}
			if(diagnosticHandler == null) {
				diagnosticHandler = IDiagnosticHandler.wrap(diagnosticHandlers);
			}
			if(conflictDetectorSelector == null) {
				conflictDetectorSelector = IConflictDetectorSelector.ALL;
			}
			if(conflictSelector == null) {
				conflictSelector = new BasicConflictSelector();
			}
			if(conflictResolverSelector == null) {
				conflictResolverSelector = new BatchConflictResolverSelector();
			}
		}

		protected void assertInitialized() {
			Objects.requireNonNull(conflictSelector);
			Objects.requireNonNull(conflictResolverSelector);
			Objects.requireNonNull(diagnosticHandler);
			Objects.requireNonNull(filter);
		}

		protected void assertNotBuild() {
			if(build) {
				throw new IllegalStateException("Configuration has already been build. Configuration objects must not be reused.");
			}
		}

		/**
		 * Builds a ConflictFacade that uses this configuration.
		 * After building, the Configuration must not be modified
		 * or build again.
		 * @return new ConflictFacade with the current configuration
		 */
		public ConflictFacade build() {
			assertNotBuild();
			initDefaults();
			assertInitialized();
			build = true;
			return new ConflictFacade(this);
		}
	}
}
