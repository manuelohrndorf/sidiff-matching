package org.sidiff.superimposition.conflict.resolver;

import java.util.Collection;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.common.extension.IExtension;
import org.sidiff.superimposition.Conflict;

/**
 * <p>A conflict resolver resolves {@link Conflict}s.</p>
 * <p>The conflict resolver extends {@link IExecutableExtension} and
 * the fixed attributes of the conflict resolver are managed via
 * the plugin manifest. Extend {@link AbstractConflictResolver}
 * to use these attributes.</p>
 * <p>The supported conflicts support pattern matching
 * using <code>*</code> to match any characters.</p>
 * <p>Conflict resolvers might be cached by the registry and
 * are therefore required to be stateless.</p>
 * @author rmueller
 */
public interface IConflictResolver extends IExtension, IExecutableExtension {

	Description<IConflictResolver> DESCRIPTION = Description.of(IConflictResolver.class,
			"org.sidiff.superimposition.conflict_resolver", "conflictResolver", "class");
	ConflictResolverExtensionManager MANAGER = new ConflictResolverExtensionManager(DESCRIPTION);

	Mode getMode();
	Collection<String> getSupportedConflicts();
	boolean canHandle(Conflict conflict);

	/**
	 * <p>Resolves the conflict by modifying the entities referenced by the conflict.</p>
	 * <p>Will only be called for {@link #canHandle(Conflict) supported} conflicts.</p>
	 * <p>Implementers must not store strong references to the input
	 * parameters, because the same conflict resolver might be reused
	 * multiple times.</p>
	 * @param conflict the conflict
	 * @param monitor progress monitor
	 * @return diagnostic status of the resolution
	 */
	Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor);

	enum Mode {
		BATCH,
		INTERACTIVE
	}
}
