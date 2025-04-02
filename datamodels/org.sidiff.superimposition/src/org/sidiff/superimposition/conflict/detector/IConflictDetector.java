package org.sidiff.superimposition.conflict.detector;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.common.extension.ITypedExtension;
import org.sidiff.common.extension.TypedExtensionManager;
import org.sidiff.common.extension.configuration.IConfigurableExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.superimposition.ConflictSet;

/**
 * <p>A conflict detector detects conflicts for a {@link ConflictSet}
 * consisting of multiple inputs.</p>
 * <p>The conflict detector extends {@link IExecutableExtension} and
 * the fixed attributes of the conflict detector are managed via
 * the plugin manifest. Extend {@link AbstractConflictDetector}
 * to use these attributes.</p>
 * @author rmueller
 */
public interface IConflictDetector extends ITypedExtension, IConfigurableExtension {

	Description<IConflictDetector> DESCRIPTION = Description.of(IConflictDetector.class,
			"org.sidiff.superimposition.conflict_detector", "conflictDetector", "class");
	TypedExtensionManager<IConflictDetector> MANAGER = new TypedExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	/**
	 * <p>Analyzes the {@link ConflictSet#getInputs()} and possibly
	 * adds conflicts to {@link ConflictSet#getConflicts()}.</p>
	 * <p>Implementers must not store strong references to the input
	 * parameters, because the same conflict detector might be reused
	 * multiple times.</p>
	 * @param conflictSet the conflict set (in/out)
	 * @param monitor progress monitor
	 * @return diagnostic status of the detection
	 */
	Diagnostic detectConflicts(ConflictSet conflictSet, IProgressMonitor monitor);
}
