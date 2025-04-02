package org.sidiff.superimposition.conflict.resolver.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.conflict.resolver.AbstractConflictResolver;
import org.sidiff.superimposition.util.SuperimpositionModelModifyHelper;

/**
 * Conflict resolver for resolving annotation conflicts by removing
 * invalid annotations and unsatisfiable containments.
 * @author rmueller
 */
public class AnnotationConflictResolver extends AbstractConflictResolver {

	@Override
	public Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor) {
		switch(conflict.getId()) {
			case "Superimposed.Element.Annotations.ExternalIsAnnotated":
			case "Superimposed.Element.Annotations.Uncontained":
				return forEachConflicting(conflict, monitor, AnnotationConflictResolver::fixElementAnnotations);

			case "Superimposed.Attribute.Annotations.NoSubsetOfContainer":
			case "Superimposed.Attribute.Annotations.Uncontained":
				return forEachConflicting(conflict, monitor, AnnotationConflictResolver::fixAttributeAnnotations);

			case "Superimposed.Reference.Annotations.NoSubsetOfContainer":
			case "Superimposed.Reference.Annotations.ContainmentNotExact":
			case "Superimposed.Reference.Annotations.NoSubsetOfTarget":
			case "Superimposed.Reference.Annotations.Uncontained":
				return forEachConflicting(conflict, monitor, AnnotationConflictResolver::fixReferenceAnnotations);
		}
		return errorNotSupported(conflict);
	}

	private static void fixElementAnnotations(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		for(Element element : conflicting.getElements()) {
			if(element.isExternal()) {
				element.getAnnotations().clear();
			} else {
				element.getAnnotations().removeIf(annotation -> annotation.eIsProxy() || annotation.eContainer() == null);
			}
		}
	}

	private static void fixAttributeAnnotations(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		Assert.isNotNull(conflicting.getContext());
		for(Attribute attribute : conflicting.getAttributes()) {
			attribute.getAnnotations().retainAll(conflicting.getContext().getAnnotations());
			attribute.getAnnotations().removeIf(annotation -> annotation.eIsProxy() || annotation.eContainer() == null);
			if(attribute.getAnnotations().isEmpty()) {
				modifyHelper.remove(attribute);
			}
		}
	}

	private static void fixReferenceAnnotations(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		for(Reference reference : conflicting.getReferences()) {
			if(reference.getTarget() == null) {
				// safety check because multiple annotation conflicts may be resolve at once
				modifyHelper.remove(reference);
			} else {
				reference.getAnnotations().retainAll(conflicting.getContext().getAnnotations());
				reference.getAnnotations().retainAll(reference.getTarget().getAnnotations());
				reference.getAnnotations().removeIf(annotation -> annotation.eIsProxy() || annotation.eContainer() == null);
				if(reference.isContainment()) {
					reference.getTarget().getAnnotations().retainAll(reference.getAnnotations());
					if(reference.getTarget().getAnnotations().isEmpty()) {
						modifyHelper.remove(reference.getTarget());
					}
				} else if(reference.getAnnotations().isEmpty()) {
					modifyHelper.remove(reference);
				}					
			}
		}
	}
}
