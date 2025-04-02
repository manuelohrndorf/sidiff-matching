package org.sidiff.superimposition.conflict.resolver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.sidiff.common.extension.AbstractExtension;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimpositionModelPlugin;
import org.sidiff.superimposition.conflict.selector.ConflictPattern;
import org.sidiff.superimposition.util.SuperimpositionModelModifyHelper;

/**
 * <p>Abstract conflict resolver that obtains key, name, and supported conflicts
 * from the extension's attributes in the plugin manifest.</p>
 * @author rmueller
 */
public abstract class AbstractConflictResolver extends AbstractExtension implements IConflictResolver {

	public static final String ATTRIBUTE_MODE = "mode";
	public static final String ELEMENT_SUPPORTED_CONFLICT = "supportedConflict";

	private Mode mode;
	private ConflictPattern conflictPattern;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		super.setInitializationData(config, propertyName, data);

		String stringMode = config.getAttribute(ATTRIBUTE_MODE);
		if(stringMode == null) {
			throw new CoreException(new Status(IStatus.ERROR, SuperimpositionModelPlugin.ID,
					"Attribute 'mode' must be set for conflict resolver"));
		}
		try {
			mode = Mode.valueOf(stringMode);			
		} catch(IllegalArgumentException e) {
			throw new CoreException(new Status(IStatus.ERROR, SuperimpositionModelPlugin.ID,
					"Attribute 'mode' of conflict resolver must be a valid enum literal of IConflictResolver.Mode"));
		}

		Collection<String> supportedConflicts = Collections.unmodifiableList(
				Arrays.stream(config.getChildren(ELEMENT_SUPPORTED_CONFLICT))
					.map(IConfigurationElement::getValue)
					.filter(Objects::nonNull)
					.map(String::trim)
					.filter(conflict -> !conflict.isEmpty())
					.collect(Collectors.toList()));
		conflictPattern = new ConflictPattern(supportedConflicts);
	}

	@Override
	public Mode getMode() {
		return mode;
	}

	@Override
	public boolean canHandle(Conflict conflict) {
		return conflictPattern.matches(conflict.getId());
	}

	@Override
	public Collection<String> getSupportedConflicts() {
		return conflictPattern.getSupportedConflicts();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof IConflictResolver))
			return false;
		return Objects.equals(this.getKey(), ((IConflictResolver)obj).getKey());
	}

	@Override
	public int hashCode() {
		return getKey().hashCode();
	}

	protected Diagnostic errorNotSupported(Conflict conflict) {
		return new BasicDiagnostic(Diagnostic.ERROR, SuperimpositionModelPlugin.ID, 0,
				conflict.getId() + " not supported by " + getName(), null);
	}

	protected Diagnostic forEachConflicting(Conflict conflict, IProgressMonitor monitor, IConflictConflictingConsumer consumer) {
		BasicDiagnostic resolverDiag = new BasicDiagnostic(SuperimpositionModelPlugin.ID, 0,
				"Resolving " + conflict.getConflicting().size() + " conflicting using " + getName(), null);
		SubMonitor progress = SubMonitor.convert(monitor, conflict.getConflicting().size()+1);
		SuperimpositionModelModifyHelper modifyHelper =
				new SuperimpositionModelModifyHelper(conflict.getConflictSet().getContext());
		for(ConflictingEntities conflicting : conflict.getConflicting()) {
			String contextString = conflicting.getContext() == null
					? "<no context>"
					: "context " + conflicting.getContext().getSignature() + "/" + conflicting.getContext().getUuid();
			BasicDiagnostic inputDiag = new BasicDiagnostic(SuperimpositionModelPlugin.ID, 0,
					"Resolving for " + contextString, null);

			if(conflicting.isInvalidated()) {
				inputDiag.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0,
						"Ignoring invalidated conflicting entities", null));
			} else {
				consumer.consume(conflicting, conflict, inputDiag, progress.split(1), modifyHelper);				
			}
			
			resolverDiag.add(inputDiag);
			if(resolverDiag.getSeverity() == Diagnostic.CANCEL) {
				break;
			}
		}
		modifyHelper.updateModifiedSignatures();
		progress.worked(1);
		return resolverDiag;
	}

	@FunctionalInterface
	protected interface IConflictConflictingConsumer {
		void consume(ConflictingEntities conflicting, Conflict conflict,
				DiagnosticChain diagChain, IProgressMonitor monitor,
				SuperimpositionModelModifyHelper modifyHelper);
	}
}
