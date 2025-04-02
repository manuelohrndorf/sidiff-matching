package org.sidiff.superimposition.conflict.detector.impl;

import static org.sidiff.superimposition.conflict.detector.ConflictDetectorUtil.createConflict;
import static org.sidiff.superimposition.conflict.detector.ConflictDetectorUtil.createConflicting;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictType;
import org.sidiff.superimposition.ConflictingEntities;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.conflict.detector.AbstractConflictDetector;

/**
 * Conflict detector that detects conflicts in
 * the annotations of a superimposed model and its entities.
 * @author rmueller
 */
public class AnnotationConflictDetector extends AbstractConflictDetector {

	@Override
	public Diagnostic detectConflicts(ConflictSet conflictSet, IProgressMonitor monitor) {
		return forEachInput(conflictSet, monitor, AnnotationConflictDetector::detectConflicts);
	}

	private static void detectConflicts(ConflictingEntities input, ConflictSet conflictSet,
			DiagnosticChain diagChain, IProgressMonitor monitor) {

		detectDangling(conflictSet, input);
		detectAnnotatedExternal(conflictSet, input);
		detectInvalidAttributes(conflictSet, input);
		detectInvalidReferences(conflictSet, input);
	}

	private static void detectDangling(ConflictSet conflictSet, ConflictingEntities input) {
		Collection<Element> danglingElements = input.getElements().stream()
			.filter(element -> element.getAnnotations().stream().map(EObject::eContainer).anyMatch(Objects::isNull))
			.collect(Collectors.toList());
		if(!danglingElements.isEmpty()) {
			createConflict(conflictSet, "Superimposed.Element.Annotations.Uncontained",
					"Element has annotations which are not contained in the model", ConflictType.SYNTACTIC,
					createConflicting(input.getContext(), danglingElements));
		}

		Collection<Reference> danglingReferences = input.getReferences().stream()
			.filter(reference -> reference.getAnnotations().stream().map(EObject::eContainer).anyMatch(Objects::isNull))
			.collect(Collectors.toList());
		if(!danglingReferences.isEmpty()) {
			createConflict(conflictSet, "Superimposed.Reference.Annotations.Uncontained",
					"Reference has annotations which are not contained in the model", ConflictType.SYNTACTIC,
					createConflicting(input.getContext(), danglingReferences));
		}

		Collection<Attribute> danglingAttributes = input.getAttributes().stream()
			.filter(attribute -> attribute.getAnnotations().stream().map(EObject::eContainer).anyMatch(Objects::isNull))
			.collect(Collectors.toList());
		if(!danglingAttributes.isEmpty()) {
			createConflict(conflictSet, "Superimposed.Attribute.Annotations.Uncontained",
					"Attribute has annotations which are not contained in the model", ConflictType.SYNTACTIC,
					createConflicting(input.getContext(), danglingAttributes));
		}
	}

	private static void detectAnnotatedExternal(ConflictSet conflictSet, ConflictingEntities input) {
		Collection<Element> annotatedExternal =
			input.getElements().stream()
				.filter(Element::isExternal)
				.filter(e -> !e.getAnnotations().isEmpty())
				.collect(Collectors.toList());
		if(!annotatedExternal.isEmpty()) {
			createConflict(conflictSet, "Superimposed.Element.Annotations.ExternalIsAnnotated",
					"An external element must not have annotations", ConflictType.SEMANTIC,
					createConflicting(input.getContext(), annotatedExternal));
		}
	}

	private static void detectInvalidAttributes(ConflictSet conflictSet, ConflictingEntities input) {
		SuperimposedElement context = input.getContext();
		if(context == null) {
			return;
		}
		for(EAttribute type : input.getContext().getType().getEAllAttributes()) {
			if(type.isDerived() || type.isTransient() || !type.isChangeable()) {
				continue;
			}
			Collection<Attribute> invalidAttributes =
				input.getAttributes(type).stream()
					.filter(a -> ((!context.getAnnotations().containsAll(a.getAnnotations()))
							|| (a.getAnnotations().isEmpty() && !context.getAnnotations().isEmpty())))
					.collect(Collectors.toList());
			if(!invalidAttributes.isEmpty()) {
				createConflict(conflictSet, "Superimposed.Attribute.Annotations.NoSubsetOfContainer",
						"Attribute annotations are no subset of its containing SuperimposedElement",
						ConflictType.SEMANTIC, createConflicting(input.getContext(), invalidAttributes, type));
			}
		}
	}

	private static void detectInvalidReferences(ConflictSet conflictSet, ConflictingEntities input) {
		SuperimposedElement context = input.getContext();
		if(context == null) {
			return;
		}
		for(EReference type : input.getContext().getType().getEAllReferences()) {
			if(type.isDerived() || type.isTransient() || !type.isChangeable()) {
				continue;
			}
	
			Collection<Reference> noSubsetOfContainer =
				input.getReferences(type).stream()
					.filter(r -> !context.getAnnotations().containsAll(r.getAnnotations()))
					.collect(Collectors.toList());
			if(!noSubsetOfContainer.isEmpty()) {
				createConflict(conflictSet, "Superimposed.Reference.Annotations.NoSubsetOfContainer",
						"Reference has annotations which are not present on its containing SuperimposedElement",
						ConflictType.SEMANTIC, createConflicting(input.getContext(), noSubsetOfContainer, type));
			}

			Collection<Reference> noSubsetOfTarget =
				input.getReferences(type).stream()
					.filter(r -> !r.getTarget().isExternal())
					.filter(r -> ((!r.getTarget().getAnnotations().containsAll(r.getAnnotations())) || 
							(r.getAnnotations().isEmpty() && !r.getTarget().getAnnotations().isEmpty())))
					.collect(Collectors.toList());
			if(!noSubsetOfTarget.isEmpty()) {
				createConflict(conflictSet, "Superimposed.Reference.Annotations.NoSubsetOfTarget",
						"Reference annotations are not a subset of its target element",
						ConflictType.SEMANTIC, createConflicting(input.getContext(), noSubsetOfTarget, type));
			}
		}
	}
}
