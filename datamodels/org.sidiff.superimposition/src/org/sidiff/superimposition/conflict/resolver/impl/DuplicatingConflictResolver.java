package org.sidiff.superimposition.conflict.resolver.impl;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.sidiff.entities.*;
import org.sidiff.superimposition.*;
import org.sidiff.superimposition.conflict.resolver.AbstractConflictResolver;
import org.sidiff.superimposition.util.SuperimpositionModelModifyHelper;
import org.sidiff.superimposition.util.SuperimpositionModelUtil;

/**
 * Conflict resolver that resolves conflicts by
 * duplicating the conflicting entities.
 * @author rmueller
 */
public class DuplicatingConflictResolver extends AbstractConflictResolver {

	@Override
	public Diagnostic resolveConflict(Conflict conflict, IProgressMonitor monitor) {
		switch(conflict.getId()) {
			case "Ecore.EAttribute.UpperBound.Violated":
			case "Ecore.EReference.UpperBound.Violated":
			case "ConsolidationDesign.Immutability.Violated":
			case "Ecore.ENamedElement.Name.Duplicated":
				return forEachConflicting(conflict, monitor, DuplicatingConflictResolver::createDuplicateElements);
		}
		return errorNotSupported(conflict);
	}

	private static void createDuplicateElements(ConflictingEntities conflicting, Conflict conflict,
			DiagnosticChain diagChain, IProgressMonitor monitor, SuperimpositionModelModifyHelper modifyHelper) {

		Assert.isLegal(!conflicting.getContext().isExternal(), "Conflicting element must not be external");
		final int desired = getDesiredBound(conflict, conflicting);
		SubMonitor progress = SubMonitor.convert(monitor, conflicting.getNumberOfConflictingFeatures() / desired);
		while(conflicting.getNumberOfConflictingFeatures() > desired) {
			if(duplicateElement(conflict, conflicting, progress.split(1), modifyHelper)) {
				diagChain.add(new BasicDiagnostic(Diagnostic.INFO, SuperimpositionModelPlugin.ID, 0, "Duplicated element: "
						+ conflicting.getContext().getSignature() + "/" + conflicting.getContext().getUuid(), null));
			} else {
				// duplicateElement did not actually move any conflicting features,
				// which might happen if multiple conflicts with the same context
				// element are resolved simultaneously
				diagChain.add(new BasicDiagnostic(Diagnostic.WARNING, SuperimpositionModelPlugin.ID, 0,
						"No conflicting features were found while duplicating element: "
						+ conflicting.getContext().getSignature() + "/" + conflicting.getContext().getUuid(), null));
				break;
			}
		}
		// The conflicting entities are now only those which
		// are still owned by the original element, and their
		// annotations are the only ones which the original
		// element will keep.
		intersectAnnotations(conflicting.getContext().getAnnotations(), getConflictingModelAnnotations(conflicting));
		fixAnnotations(conflicting.getContext(), modifyHelper);
	}

	private static int getDesiredBound(Conflict conflict, ConflictingEntities conflicting) {
		switch(conflict.getId()) {
			case "ConsolidationDesign.Immutability.Violated":
			case "Ecore.ENamedElement.Name.Duplicated":
				// the desired bound is always 1 for immutabilities
				// and to fix duplicated names
				return 1;

			default:
				return Math.max(conflicting.getType().getLowerBound(), 1);
		}
	}

	private static boolean isConflicting(Entity entity, ConflictingEntities conflicting) {
		if(entity instanceof Attribute) {
			return ((Attribute)entity).getType() == conflicting.getType();
		} else if(entity instanceof Reference) {
			return ((Reference)entity).getType() == conflicting.getType()
				&& (conflicting.getElements().isEmpty()
						|| conflicting.getElements().contains(((Reference)entity).getTarget()));
		}
		throw new AssertionError();
	}

	private static Set<Annotation> getConflictingModelAnnotations(ConflictingEntities conflicting) {
		EStructuralFeature type = conflicting.getType();
		if(type instanceof EAttribute) {
			return conflicting.getAttributes((EAttribute)type).stream()
					.map(Attribute::getAnnotations)
					.flatMap(Collection::stream)
					.collect(Collectors.toSet());
		} else if(type instanceof EReference) {
			return conflicting.getReferences((EReference)type).stream()
					.map(Reference::getAnnotations)
					.flatMap(Collection::stream)
					.collect(Collectors.toSet());
		}
		throw new AssertionError();
	}

	private static boolean duplicateElement(Conflict conflict, ConflictingEntities conflicting,
			IProgressMonitor monitor, SuperimpositionModelModifyHelper helper) {

		SuperimposedElement copy = helper.copy(conflicting.getContext());
		boolean changedConflicting = duplicateOwnedReferences(conflict, conflicting, copy, helper);
		changedConflicting |= duplicateAttributes(conflict, conflicting, copy, helper);
		duplicateIncomingReferences(conflicting, copy, helper);
		fixAnnotations(copy, helper);
		return changedConflicting;
	}

	private static boolean duplicateOwnedReferences(Conflict conflict, ConflictingEntities conflicting,
			SuperimposedElement copy, SuperimpositionModelModifyHelper helper) {

		SuperimposedElement context = conflicting.getContext();
		final int desired = getDesiredBound(conflict, conflicting);
		boolean changedConflicting = false;
		for(Reference ref : new ArrayList<>(context.getOwnedReferences())) {
			if(ref.getSource() == context) { // only outgoing references
				if(isConflicting(ref, conflicting)) {
					Collection<Reference> references = copy.getReferences(ref.getType());
					if(shouldMoveReference(conflicting, desired, references)) {
						changedConflicting = true;
						conflicting.getReferences().remove(ref); // for the exit condition
						// move reference to copied element
						helper.move(ref, context, copy);

						// Annotate parent (copy) element only with the annotations of the reference.
						// This is need for the last step, which fixes all annotations.
						intersectAnnotations(copy, ref);
					}
				} else if(ref.isContainment()) {
					// duplicate containment reference and contained element recursively
					helper.copyContainment(ref, copy);
				} else {
					// duplicate outgoing reference for copied element
					helper.copy(ref, copy);
				}
			} else {
				throw new IllegalArgumentException("incoming owned reference not supported: " + ref);
			}
		}
		return changedConflicting;
	}

	private static boolean shouldMoveReference(ConflictingEntities conflicting, final int desired, Collection<Reference> references) {
		Collection<Element> elements = conflicting.getElements();
		if(elements.isEmpty()) {
			return references.size() < desired;
		}
		return references.stream()
				.map(Reference::getTarget)
				.noneMatch(elements::contains);
	}

	private static void duplicateIncomingReferences(ConflictingEntities conflicting,
			SuperimposedElement copy, SuperimpositionModelModifyHelper helper) {

		for(Reference ref : new ArrayList<>(conflicting.getContext().getIncomings())) {
			SuperimposedElement container = (SuperimposedElement)ref.getSource();
			if(container.getOwnedReferences().contains(ref)) {
				// Do not duplicate the incoming reference if it is contained in the conflicting element or its copy.
				// Make sure that incoming references are not duplicated if equivalent references already exist.
				if(!SuperimpositionModelUtil.isElementContainedIn(container, conflicting.getContext())
						&& !SuperimpositionModelUtil.isElementContainedIn(container, copy)
						&& container.getOutgoings().stream().map(Reference::getTarget).noneMatch(Predicate.isEqual(copy))) {
					helper.copy(ref, container, copy);
				}
			} else {
				throw new IllegalArgumentException("reference is not owned by source: " + ref);
			}
		}
	}

	private static boolean duplicateAttributes(Conflict conflict, ConflictingEntities conflicting,
			SuperimposedElement copy, SuperimpositionModelModifyHelper helper) {

		SuperimposedElement context = conflicting.getContext();
		final int desired = getDesiredBound(conflict, conflicting);
		// firstly, duplicate attributes if they have more values than allowed
		for(Attribute attr : new ArrayList<>(context.getOwnedAttributes())) {
			if(isConflicting(attr, conflicting)) {
				while(attr.getValue().size() > attr.getType().getUpperBound()) {
					Attribute copyAttr = helper.copy(attr, copy);
					copyAttr.getValue().clear();
					// move the desired number of values to the copied attribute
					for(int i = 0; i < desired; i++) {
						copyAttr.getValue().add(attr.getValue().remove(0)); // remove the first one
					}
				}
			}
		}
		// secondly, move attributes to copy / copy attributes
		boolean changedConflicting = false;
		for(Attribute attr : new ArrayList<>(context.getOwnedAttributes())) {
			if(isConflicting(attr, conflicting)) {
				if(copy.getAttributes(attr.getType()).size() < desired) {
					changedConflicting = true;
					conflicting.getAttributes().remove(attr); // for the exit condition
					helper.move(attr, context, copy);

					// Annotate parent (copy) element only with the annotations of the attribute.
					// This is need for the last step, which fixes all annotations.
					intersectAnnotations(copy, attr);
				}
			} else {
				helper.copy(attr, copy);
			}
		}
		return changedConflicting;
	}

	private static void fixAnnotations(SuperimposedElement element, SuperimpositionModelModifyHelper helper) {
		if(element.isExternal()) {
			// external elements are never annotated
			element.getAnnotations().clear();
			element.getObjectAnnotations().clear();
			return;
		}

		// fix attribute annotations
		for(Attribute attribute : new ArrayList<>(element.getOwnedAttributes())) {
			intersectAnnotations(attribute, element);
			if(attribute.getAnnotations().isEmpty()) {
				helper.remove(attribute);
			}
		}

		// fix reference annotations
		for(Reference reference : new ArrayList<>(element.getOwnedReferences())) {
			SuperimposedElement target = (SuperimposedElement)reference.getTarget();
			intersectAnnotations(reference, element);
			if(target != null && !target.isExternal()) {
				intersectAnnotations(reference, target);
				if(reference.isContainment()) {
					intersectAnnotations(target, reference);
					fixAnnotations(target, helper);
					if(target.getAnnotations().isEmpty()) {
						helper.remove(target);
					}
				}
			}
			if(target == null || reference.getAnnotations().isEmpty()) {
				helper.remove(reference);
			}
		}

		// fix object annotations
		Collection<EObject> removedObjects =
			element.getObjectAnnotations().stream()
			  	.peek(e -> intersectAnnotations(e.getValue(), element.getAnnotations()))
				.filter(e -> e.getValue().isEmpty() || !element.getObjects().contains(e.getKey()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		element.getObjects().removeAll(removedObjects);
		for(EObject object : removedObjects) {
			element.getObjectAnnotations().removeKey(object);
		}
		if(removedObjects.contains(element.getObject())) {
			element.setObject(element.getObjects().stream().findFirst().orElse(null));
		}

		// fix annotations of incoming references
		for(Reference reference : new ArrayList<>(element.getIncomings())) {
			// sanity check because resolving multiple conflicts in
			// non-deterministic order may cause invalid references
			if(reference.getSource() == null) {
				helper.remove(reference);
				continue;
			}
			intersectAnnotations(reference, reference);
			if(!element.isExternal()) {
				intersectAnnotations(reference, element);
			}
			if(reference.isContainment()) {
				intersectAnnotations(element, reference);
				if(element.getAnnotations().isEmpty()) {
					helper.remove(element);
				}
			} else if(reference.getAnnotations().isEmpty()) {
				helper.remove(reference);
			}
		}
	}

	private static boolean isSetBasedAnnotationsProcessing(Collection<? extends Annotation> annotations) {
		// Assume set based annotations processing only if no annotation has a formula.
		return annotations.stream().map(Annotation::getFormula).allMatch(Objects::isNull);
	}

	private static void intersectAnnotations(Entity target, Entity source) {
		intersectAnnotations(target.getAnnotations(), source.getAnnotations());
	}

	private static void intersectAnnotations(Collection<Annotation> targetAnnotations, Collection<? extends Annotation> annotations) {
		if(isSetBasedAnnotationsProcessing(targetAnnotations) && isSetBasedAnnotationsProcessing(annotations)) {
			targetAnnotations.retainAll(annotations);
		} else {
			targetAnnotations.clear();
			targetAnnotations.addAll(annotations);
		}
	}
}
