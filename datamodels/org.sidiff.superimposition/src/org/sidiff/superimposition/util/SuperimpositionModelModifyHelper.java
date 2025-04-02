package org.sidiff.superimposition.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelFactory;

/**
 * <p>Helper to modify a {@link SuperimposedModel}, e.g. copy and move entities.
 * <p>Keeps track of all changed entities to update all signatures
 * in the correct order after the modification is completed.</p>
 * <p>Call {@link #updateModifiedSignatures()} after modifying the model
 * in such a way that the signatures need to be updated.</p>
 * @author rmueller
 */
public class SuperimpositionModelModifyHelper {

	private Set<Entity> modifiedSignature = new HashSet<>();

	private SuperimposedModel superimposedModel;

	public SuperimpositionModelModifyHelper(SuperimposedModel superimposedModel) {
		this.superimposedModel = Objects.requireNonNull(superimposedModel);
	}

	public SuperimposedModel getSuperimposedModel() {
		return superimposedModel;
	}

	public SuperimposedElement copy(SuperimposedElement element) {
		SuperimposedElement copy = (SuperimposedElement)EMFUtil.copyWithoutReferences(element);
		copy.setType(element.getType());
		copy.setObject(element.getObject());
		copy.getObjects().addAll(element.getObjects());
		element.getObjectAnnotations().stream()
			.forEach(e -> copy.getObjectAnnotations().put(e.getKey(), new BasicEList<>(e.getValue())));
		copy.getAnnotations().addAll(element.getAnnotations());
		superimposedModel.getElements().add(copy);

		modifiedSignature.add(copy);
		modifiedSignature.add(element);
		return copy;
	}

	public void copyContainment(Reference reference, SuperimposedElement container) {
		Map<SuperimposedElement,SuperimposedElement> copyMap = new HashMap<>();
		copyMap.put((SuperimposedElement)reference.getSource(), container);
		Set<Reference> copiedReferences = new HashSet<>();
		copyContainment(reference, copyMap, copiedReferences);

		copyMap.forEach((original, copy) -> {
			for(Reference ref : new ArrayList<>(original.getIncomings())) {
				if(!ref.isContainment() && copy != container && copiedReferences.add(ref)) {
					SuperimposedElement incomingSource = (SuperimposedElement)ref.getSource();
					incomingSource = copyMap.getOrDefault(incomingSource, incomingSource);
					copy(ref, incomingSource, copy);
				}
			}
		});
	}

	protected void copyContainment(Reference reference, Map<SuperimposedElement,SuperimposedElement> copyMap, Set<Reference> copiedReferences) {
		SuperimposedElement element = (SuperimposedElement)reference.getTarget();
		SuperimposedElement copy = copyMap.get(element);
		if(copy != null) {
			return;
		}
		copy = copy(element);
		copyMap.put(element, copy);

		copy(reference, copyMap.get(reference.getSource()), copy);

		for(Reference ref : new ArrayList<>(element.getOwnedReferences())) {
			if(ref.getSource() == element) { // only outgoing references
				if(copiedReferences.add(ref)) {
					if(ref.isContainment()) {
						copyContainment(ref, copyMap, copiedReferences);
					} else {
						SuperimposedElement target = (SuperimposedElement)ref.getTarget();
						// For non-containment references, use the copy map to look-up the target first,
						// to handle the case where a reference references one of its own direct or indirect container elements.
						SuperimposedElement realTarget = copyMap.getOrDefault(target, target);
						copy(ref, copy, realTarget);
					}
				}
			} else {
				throw new IllegalArgumentException("incoming owned reference not supported: " + ref);
			}
		}

		for(Attribute attr : element.getOwnedAttributes()) {
			copy(attr, copy);
		}
	}

	public Reference copy(Reference reference) {
		Reference copy = (Reference)EMFUtil.copyWithoutReferences(reference);
		copy.setType(reference.getType());
		copy.setSource(reference.getSource());
		copy.setTarget(reference.getTarget());
		copy.getAnnotations().addAll(reference.getAnnotations());

		modifiedSignature.add(copy);
		modifiedSignature.add(reference);
		return copy;
	}

	public Reference copy(Reference reference, SuperimposedElement container) {
		Reference copy = copy(reference);
		container.getOutgoings().add(copy);
		container.getOwnedReferences().add(copy);

		if(reference.isContainment()) {
			modifiedSignature.add(copy.getTarget());
		}
		return copy;
	}

	public Reference copy(Reference reference, SuperimposedElement container, SuperimposedElement target) {
		Reference copy = copy(reference, container);
		copy.setTarget(target);

		if(reference.isContainment()) {
			modifiedSignature.add(target);
		}
		return copy;
	}

	public Attribute copy(Attribute attribute) {
		Attribute copy = (Attribute)EMFUtil.copyWithoutReferences(attribute);
		copy.setType(attribute.getType());
		copy.getAnnotations().addAll(attribute.getAnnotations());

		modifiedSignature.add(copy);
		modifiedSignature.add(attribute);
		return copy;
	}

	public Attribute copy(Attribute attribute, SuperimposedElement container) {
		Attribute copy = copy(attribute);
		container.getAttributes().add(copy);
		container.getOwnedAttributes().add(copy);

		if("name".equalsIgnoreCase(attribute.getType().getName())) {
			modifiedSignature.add(container);
		}
		return copy;
	}

	public void move(Reference reference, SuperimposedElement fromElem, SuperimposedElement toElem) {
		fromElem.getOutgoings().remove(reference);
		fromElem.getOwnedReferences().remove(reference);
		toElem.getOutgoings().add(reference);
		toElem.getOwnedReferences().add(reference);

		modifiedSignature.add(reference);
		if(reference.isContainment()) {
			modifiedSignature.add(reference.getTarget());
		}
	}

	public void move(Attribute attribute, SuperimposedElement fromElem, SuperimposedElement toElem) {
		fromElem.getAttributes().remove(attribute);
		fromElem.getOwnedAttributes().remove(attribute);
		toElem.getAttributes().add(attribute);
		toElem.getOwnedAttributes().add(attribute);

		modifiedSignature.add(attribute);
		if("name".equalsIgnoreCase(attribute.getType().getName())) {
			modifiedSignature.add(fromElem);
			modifiedSignature.add(toElem);			
		}
	}

	/**
	 * Removes the entity (element/reference/attribute) and all
	 * contained entities from the superimposed model.
	 * @param entity the entity to remove
	 */
	public void remove(Entity entity) {
		// This method avoids using EcoreUtil.delete, because EcoreUtil's cross
		// reference check is very inefficient, and instead cleans all references manually.

		Objects.requireNonNull(entity, "entity must not be null");
		modifiedSignature.remove(entity);
		entity.getAnnotations().clear();

		if(entity instanceof SuperimposedElement) {
			SuperimposedElement elem = (SuperimposedElement)entity;
			elem.getObjectAnnotations().clear();

			// remove elements contained in this one
			elem.getContained().forEach(this::remove);

			// remove all references and attributes
			Set<Entity> toRemove = new LinkedHashSet<>();
			toRemove.addAll(elem.getIncomings());
			toRemove.addAll(elem.getOutgoings());
			toRemove.addAll(elem.getOwnedReferences());
			toRemove.addAll(elem.getAttributes());
			toRemove.addAll(elem.getOwnedAttributes());
			toRemove.forEach(this::remove);
			// remove the element itself from the superimposed model
			EcoreUtil.remove(elem);
		} else if(entity instanceof Attribute) {
			Attribute attr = (Attribute)entity;
			if(attr.getContainer() != null) {
				attr.getContainer().getAttributes().remove(attr);				
			}
			EcoreUtil.remove(attr); // remove owned attribute reference
		} else if(entity instanceof Reference) {
			Reference ref = (Reference)entity;
			if(ref.getOpposite() != null) {
				ref.getOpposite().setOpposite(null);
				ref.setOpposite(null);
			}
			if(ref.getTarget() != null) {
				ref.getTarget().getIncomings().remove(ref);				
			}
			if(ref.getSource() != null) {
				ref.getSource().getOutgoings().remove(ref);				
			}
			EcoreUtil.remove(ref); // remove owned reference reference
		}
	}

	/**
	 * <p>Merges the given collection of elements into a single element with all
	 * attributes and references superimposed.</p>
	 * <p>The collection may not be empty. If the collection contains only
	 * a single element, it is returned directly. All elements must have
	 * the same type.</p>
	 * <p>The original elements will be removed from the superimposed model
	 * and the merged element will be added to it.</p>
	 * @param elements collection of elements, must not be empty
	 * @return merged superimposed element
	 * @throws IllegalArgumentException if the collection is empty,
	 * or if the elements don't have the same type
	 */
	public SuperimposedElement merge(Collection<? extends SuperimposedElement> elements) {
		switch(elements.size()) {
			case 0: throw new IllegalArgumentException("elements must not be empty");
			case 1: return elements.stream().findFirst().get();
			default:
				EClass type = null;
				EObject object = null;
				String signature = null;
				String uuid = null;
				Set<EObject> objects = new LinkedHashSet<>();
				Set<Annotation> annotations = new LinkedHashSet<>();
				EMap<EObject,EList<Annotation>> objectAnnotations = new BasicEMap<>();
				for(SuperimposedElement element : elements) {
					if(type == null) {
						type = element.getType();
					} else if(type != element.getType()) {
						throw new IllegalArgumentException("elements don't have the same type, found: " + type + " and " + element.getType());
					}

					if(signature == null || signature.isEmpty()) {
						signature = element.getSignature();
					}

					if(uuid == null || uuid.isEmpty()) {
						uuid = element.getUuid();
					}

					if(object == null || (object.eIsProxy() && !element.getObject().eIsProxy())) {
						object = element.getObject();
					}

					objects.addAll(element.getObjects());
					objectAnnotations.putAll(element.getObjectAnnotations());
					annotations.addAll(element.getAnnotations());
				}

				SuperimposedElement merged = SuperimpositionModelFactory.eINSTANCE.createSuperimposedElement();
				merged.setType(type);
				merged.setSignature(signature);
				merged.setUuid(uuid);
				merged.setObject(object);
				merged.getObjects().addAll(objects);
				merged.getAnnotations().addAll(annotations);
				merged.getObjectAnnotations().putAll(objectAnnotations);
				superimposedModel.getElements().add(merged);

				for(SuperimposedElement element : elements) {
					// merge attributes
					for(Attribute attribute : new ArrayList<>(element.getOwnedAttributes())) {
						Optional<Attribute> equivalentAttribute = merged.getOwnedAttributes().stream()
							.filter(a -> a.getType() == attribute.getType() && a.getValue().equals(attribute.getValue()))
							.findFirst();
						if(equivalentAttribute.isPresent()) {
							equivalentAttribute.get().getAnnotations().addAll(attribute.getAnnotations());
						} else {
							move(attribute, element, merged);							
						}
					}

					// merge owned references
					for(Reference reference : new ArrayList<>(element.getOwnedReferences())) {
						Optional<Reference> equivalentReference = merged.getOwnedReferences().stream()
							.filter(r -> r.getType() == reference.getType() && r.getTarget().equals(reference.getTarget()))
							.findFirst();
						if(equivalentReference.isPresent()) {
							equivalentReference.get().getAnnotations().addAll(reference.getAnnotations());
						} else {
							move(reference, element, merged);							
						}
					}

					// merge incoming references
					for(Reference reference : new ArrayList<>(element.getIncomings())) {
						Optional<Reference> existingReference = reference.getSource().getOutgoings().stream()
							.filter(r -> r.getTarget() == merged && r.getType() == reference.getType())
							.findFirst();
						if(existingReference.isPresent()) {
							existingReference.get().getAnnotations().addAll(reference.getAnnotations());
						} else {
							reference.setTarget(merged);							
						}
					}
				}
				
				// remove the original elements
				for(SuperimposedElement element : elements) {
					remove(element);
				}
				return merged;
		}
	}

	public void updateModifiedSignatures() {
		Collection<SuperimposedElement> elements = modifiedSignature.parallelStream()
			.filter(SuperimposedElement.class::isInstance)
			.map(SuperimposedElement.class::cast)
			.filter(element -> !element.isExternal())
			.collect(Collectors.toList());
		SuperimposedElementTopologicalSorter.sort(elements).parallelStream().forEach(this::updateSignature);
		modifiedSignature.parallelStream()
			.filter(Attribute.class::isInstance)
			.map(Attribute.class::cast)
			.forEach(this::updateSignature);
		modifiedSignature.parallelStream()
			.filter(Reference.class::isInstance)
			.map(Reference.class::cast)
			.forEach(this::updateSignature);
	}

	public void collectModifiedSignatures(SuperimposedElement element) {
		if(modifiedSignature.add(element)) {
			modifiedSignature.addAll(element.getOwnedAttributes());
			for(Reference ref : element.getOutgoings()) {
				modifiedSignature.add(ref);
				if(ref.isContainment()) {
					collectModifiedSignatures((SuperimposedElement)ref.getTarget());
				}
			}
			modifiedSignature.addAll(element.getIncomings());
		}
	}

	public void updateSignature(SuperimposedElement element) {
		String fragment = getSignatureFragment(element);
		SuperimposedElement container = element.getContainer();
		if(container != null) {
			element.setSignature(String.format("%s.%s", container.getSignature(), fragment));
		} else {
			element.setSignature(fragment);
		}
	}

	protected String getSignatureFragment(SuperimposedElement element) {
		return element.getAttributes().stream()
				.filter(attr -> "name".equalsIgnoreCase(attr.getType().getName()))
				.map(Attribute::getValue)
				.flatMap(Collection::stream)
				.findFirst()
				.orElseGet(() -> "<" + element.getType().getName() + ">");
	}

	public void updateSignature(Reference reference) {
		String signature = String.format("%s/%s/%s",
				reference.getSource().getSignature(),
				reference.getType().getName(),
				reference.getTarget().getSignature());
		reference.setSignature(signature);
	}

	public void updateSignature(Attribute attribute) {
		String signature = String.format("%s/%s/%s",
				attribute.getContainer().getSignature(),
				attribute.getType().getName(),
				attribute.getValue());
		attribute.setSignature(signature);
	}
}
