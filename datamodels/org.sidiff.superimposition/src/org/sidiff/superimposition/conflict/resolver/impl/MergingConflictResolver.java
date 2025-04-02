package org.sidiff.superimposition.conflict.resolver.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimpositionModelPlugin;
import org.sidiff.superimposition.conflict.resolver.AbstractConflictResolver;
import org.sidiff.superimposition.util.SuperimpositionModelModifyHelper;

/**
 * Conflict resolver that resolves conflicts by merging entities,
 * namely merging superimposed elements with duplicated UUID.
 * @author rmueller
 */
public class MergingConflictResolver extends AbstractConflictResolver {

	@Override
	public Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor) {
		switch(conflict.getId()) {
		case "Superimposed.Element.UUID.Duplicated":
		case "Ecore.ENamedElement.Name.Duplicated":
			return forEachConflicting(conflict, monitor, MergingConflictResolver::mergeSuperimposedElements);
		}

		return errorNotSupported(conflict);
	}

	private static void mergeSuperimposedElements(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		Collection<SuperimposedElement> elements =
			conflicting.getElements().stream()
				.filter(SuperimposedElement.class::isInstance)
				.map(SuperimposedElement.class::cast)
				.collect(Collectors.toList());
		SuperimposedElement merged = modifyHelper.merge(elements);
		diagChain.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0,
				"Merged " + elements.size() + " superimposed elements into: "
						+ merged.getSignature() + "/" + merged.getUuid(), null));
	}
}
