package org.sidiff.superimposition.conflict.resolver.impl;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimpositionModelPlugin;
import org.sidiff.superimposition.conflict.resolver.AbstractConflictResolver;
import org.sidiff.superimposition.util.SuperimpositionModelModifyHelper;

/**
 * Resolves duplicate UUID conflicts by generating new
 * UUIDs for the conflicting elements.
 * @author rmueller
 */
public class UuidGeneratingConflictResolver extends AbstractConflictResolver {

	@Override
	public Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor) {
		switch(conflict.getId()) {
			case "Superimposed.Element.UUID.Duplicated":
				return forEachConflicting(conflict, monitor, UuidGeneratingConflictResolver::generateNewUuid);
		}
		return errorNotSupported(conflict);
	}

	private static void generateNewUuid(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		// generate new UUID for all but one of the conflicting elements
		conflicting.getElements().stream().skip(1).forEach(element -> {
			String oldUuid = element.getUuid();
			element.setUuid(EcoreUtil.generateUUID());
			diagChain.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0,
				"Changed UUID of " + element.getSignature() + ": " + oldUuid + " -> " + element.getUuid(), null));
		});
	}
}
