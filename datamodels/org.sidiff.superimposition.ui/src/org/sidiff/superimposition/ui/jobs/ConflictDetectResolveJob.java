package org.sidiff.superimposition.ui.jobs;

import java.util.Objects;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.conflict.ConflictFacade;
import org.sidiff.superimposition.conflict.diagnostic.CollectingDiagnosticHandler;

/**
 * 
 * @author rmueller
 */
public final class ConflictDetectResolveJob extends AbstractSuperimpositionJob {

	private SuperimposedModel superimposedModel;
	private URI superimposedUri;
	private boolean saveSuperimposed;
	private ConflictFacade.Configuration configuration;

	public ConflictDetectResolveJob(ConflictFacade.Configuration configuration) {
		super("Detecting and resolving conflicts");
		this.configuration = Objects.requireNonNull(configuration);
	}

	@Override
	protected IStatus safeRun(IProgressMonitor monitor) throws Exception {
		Assert.isLegal(superimposedModel != null || superimposedUri != null,
				"either superimposedModel or superimposedUri must be set");

		SiDiffResourceSet resourceSet = SiDiffResourceSet.create("sim");
		SubMonitor progress = SubMonitor.convert(monitor,
				80 + (superimposedModel == null ? 10 : 0) + (saveSuperimposed ? 10 : 0));
		if(superimposedModel == null) {
			superimposedModel = loadSuperimposedModel(resourceSet, superimposedUri, progress.split(10));			
		}

		CollectingDiagnosticHandler collectingHandler =
				new CollectingDiagnosticHandler("Conflict Detection & Resolution Job");

		configuration
			.addDiagnosticHandler(collectingHandler)
			.build()
			.detectAndResolveConflicts(superimposedModel, progress.split(80));

		if(saveSuperimposed) {
			saveSuperimposedModel(resourceSet, superimposedModel, progress.split(10));			
		}
		return BasicDiagnostic.toIStatus(collectingHandler.getDiagnostic());
	}

	public ConflictDetectResolveJob setSuperimposedModel(SuperimposedModel superimposedModel) {
		this.superimposedModel = superimposedModel;
		return this;
	}

	public ConflictDetectResolveJob setSuperimposedUri(URI superimposedUri) {
		this.superimposedUri = superimposedUri;
		return this;
	}

	public SuperimposedModel getSuperimposedModel() {
		return superimposedModel;
	}

	public ConflictDetectResolveJob setSaveSuperimposedModel(boolean saveSuperimposed) {
		this.saveSuperimposed = saveSuperimposed;
		return this;
	}
}