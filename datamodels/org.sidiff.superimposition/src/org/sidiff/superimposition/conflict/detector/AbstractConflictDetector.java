package org.sidiff.superimposition.conflict.detector;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.extension.AbstractTypedExtension;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimpositionModelPlugin;

/**
 * <p>Abstract conflict detector that obtains key, name, generic and document types
 * from the extension's attributes in the plugin manifest.</p>
 * @author rmueller
 */
public abstract class AbstractConflictDetector extends AbstractTypedExtension implements IConflictDetector {

	@Override
	public IExtensionConfiguration getConfiguration() {
		return IExtensionConfiguration.NULL;
	}

	protected Diagnostic forEachInput(ConflictSet conflictSet, IProgressMonitor monitor, IInputConflictingConsumer consumer) {
		SubMonitor progress = SubMonitor.convert(monitor, conflictSet.getInputs().size());
		BasicDiagnostic detectorDiag = new BasicDiagnostic(SuperimpositionModelPlugin.ID, 0,
				"Detecting conflicts using " + getName(), null);
		detectorDiag.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0,
				"Superimposed Model: " + EcoreUtil.getURI(conflictSet.getContext()), null));
		
		int prevNumConflicts = conflictSet.getConflicts().size();
		for(ConflictingEntities input : conflictSet.getInputs()) {
			String contextString = input.getContext() == null
					? "<no context>"
					: "context " + input.getContext().getSignature() + "/" + input.getContext().getUuid();
			BasicDiagnostic inputDiag = new BasicDiagnostic(SuperimpositionModelPlugin.ID, 0,
					"Detecting for " + contextString, null);
			consumer.consume(input, conflictSet, inputDiag, progress.split(1));
			if(!inputDiag.getChildren().isEmpty()) {
				detectorDiag.add(inputDiag);
				if(detectorDiag.getSeverity() == Diagnostic.CANCEL) {
					break;
				}
			}
		}
		detectorDiag.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0,
				"Finished successfully. " + (conflictSet.getConflicts().size()-prevNumConflicts) + " conflict/s detected.", null));
		return detectorDiag;
	}

	@FunctionalInterface
	protected interface IInputConflictingConsumer {
		void consume(ConflictingEntities input, ConflictSet conflictSet,
				DiagnosticChain diagChain, IProgressMonitor monitor);
	}
}
