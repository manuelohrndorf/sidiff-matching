package org.sidiff.superimposition.importer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.EntitiesImporter;
import org.sidiff.entities.importer.ImportFailedException;
import org.sidiff.entities.importer.factory.IImporterFactory;
import org.sidiff.entities.importer.signature.IImporterSignatureResolver;
import org.sidiff.entities.importer.uuid.IImporterUuidResolver;
import org.sidiff.entities.importer.uuid.XmiIdImporterUuidResolver;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelPlugin;
import org.sidiff.superimposition.importer.visitor.SuperimpositionAnnotatingImporterVisitor;
import org.sidiff.superimposition.signature.impl.DefaultSignatureCalculator;
import org.sidiff.superimposition.util.SuperimpositionModelUtil;

/**
 * The <code>SuperimpositionModelImporter</code> extends the {@link EntitiesImporter}
 * to add imported entities to a {@link SuperimposedModel}.
 * @author cpietsch
 * @author rmueller
 */
public class SuperimpositionModelImporter extends EntitiesImporter<SuperimposedElement,Reference,Attribute> {

	private SuperimposedModel superimposedModel;

	public SuperimpositionModelImporter() {
		super(SuperimposedElement.class, Reference.class, Attribute.class);
	}

	/**
	 * Initializes this importer using the given superimposed model.
	 * All indices of this importer are cleared and rebuild.
	 * @param superimposedModel the superimposed model
	 */
	public void init(SuperimposedModel superimposedModel) {
		this.superimposedModel = Objects.requireNonNull(superimposedModel,
				"superimposed model must not be null");
		if(superimposedModel.getSignatureCalculators().isEmpty()) {
			superimposedModel.getSignatureCalculators().add(new DefaultSignatureCalculator());
		}

		cleanUp();

		for(SuperimposedElement element : superimposedModel.getElements()) {
			removeFromIndices(element);
			updateIndices(element);
			for(Reference reference : element.getIncomings()) {
				removeFromIndices(reference);
				updateIndices(reference);
			}
			for(Reference reference : element.getOutgoings()) {
				removeFromIndices(reference);
				updateIndices(reference);
			}
			for(Attribute attribute : element.getAttributes()) {
				removeFromIndices(attribute);
				updateIndices(attribute);
			}
		}
	}

	@Override
	protected void updateIndex(SuperimposedElement element) {
		super.updateIndex(element);
		for(EObject object : element.getObjects()) {
			getObjectIndex().put(object, element);
		}
	}

	/**
	 * Augments the object index with the given object -> element mappings.
	 * @param objectIndex the object -> element mappings
	 */
	public void updateObjectIndex(Map<EObject, SuperimposedElement> objectIndex) {
		for(Entry<EObject, SuperimposedElement> entry : objectIndex.entrySet()) {
			if(!entry.getValue().getObjects().contains(entry.getKey())) {
				entry.getValue().getObjects().add(entry.getKey());
				updateIndices(entry.getValue());
			}
		}
	}

	@Override
	protected boolean updateElement(SuperimposedElement element, EObject eObject) throws ImportFailedException {
		boolean update = super.updateElement(element, eObject);
		String signature = getSignatureResolver().computeSignature(element);
		if(!Objects.equals(element.getSignature(), signature)) {
			element.setSignature(signature);
			for(Reference reference : element.getOwnedReferences()) {
				reference.setSignature(getSignatureResolver().computeSignature(reference));
			}
			for(Attribute attribute : element.getOwnedAttributes()) {
				attribute.setSignature(getSignatureResolver().computeSignature(attribute));
			}
			update = true;
		}
		if(!element.getObjects().contains(eObject)) {
			element.getObjects().add(eObject);
			update = true;
		}
		return update;
	}

	@Override
	protected boolean updateAttribute(Attribute attribute, SuperimposedElement element, List<String> values)
			throws ImportFailedException {

		boolean update = super.updateAttribute(attribute, element, values);
		if(attribute.getContainer() != element) {
			throw new ImportFailedException(
				"Attribute cannot change its container "
					+ "(attribute=" + attribute + ", "
					+ "oldContainer=" + attribute.getContainer() + ", "
					+ "newContainer=" + element + ")");
		}
		if(!attribute.getValue().equals(values)) {
			attribute.getValue().clear();
			attribute.getValue().addAll(values);
			update = true;
		}
		String signature = getSignatureResolver().computeSignature(attribute);
		if(!attribute.getSignature().equals(signature)) {
			attribute.setSignature(signature);
			update = true;
		}
		return update;
	}

	@Override
	protected boolean updateReference(Reference reference, SuperimposedElement sourceElement,
			SuperimposedElement targetElement) throws ImportFailedException {

		boolean update = super.updateReference(reference, sourceElement, targetElement);
		if(reference.getSource() != sourceElement) {
			throw new ImportFailedException(
				"Reference cannot change its source "
					+ "(reference=" + reference + ", "
					+ "oldSource=" + reference.getSource() + ", "
					+ "newSource=" + sourceElement + ")");
		}
		if(reference.getTarget() != targetElement) {
			reference.setTarget(targetElement);
			update = true;
		}
		String signature = getSignatureResolver().computeSignature(reference);
		if(!reference.getSignature().equals(signature)) {
			reference.setSignature(signature);
			update = true;
		}
		return update;
	}

	@Override
	protected SuperimposedElement doImportEObject(EObject eObject) throws ImportFailedException {
		SuperimposedElement element = super.doImportEObject(eObject);
		element.getObjects().add(eObject);
		superimposedModel.getElements().add(element);
		superimposedModel.getType().add(element.getType().getEPackage());
		return element;
	}

	@Override
	protected Reference doImportEReference(EReference eReference,
			SuperimposedElement srcElement, SuperimposedElement tgtElement) throws ImportFailedException {
		Reference reference = super.doImportEReference(eReference, srcElement, tgtElement);
		srcElement.getOwnedReferences().add(reference);
		return reference;
	}

	@Override
	protected Attribute doImportEAttribute(EAttribute eAttribute, SuperimposedElement element, List<String> values) throws ImportFailedException {
		Attribute attribute = super.doImportEAttribute(eAttribute, element, values);
		element.getOwnedAttributes().add(attribute);
		return attribute;
	}

	public SuperimposedElement importEObjects(List<EObject> eObjects) throws ImportFailedException {
		switch(eObjects.size()) {
			case 0: throw new ImportFailedException("At least one object required to import");
			case 1: return importEObject(eObjects.get(0));
			default:
				List<SuperimposedElement> existingElements = eObjects.stream()
					.map(getObjectIndex()::get)
					.filter(Objects::nonNull)
					.distinct()
					.collect(Collectors.toList());
				SuperimposedElement element;
				switch(existingElements.size()) {
					case 0:
						element = importEObject(eObjects.get(0));
						break;
					case 1:
						element = existingElements.get(0);
						break;
					default:
						throw new ImportFailedException(
							"Objects already imported to multiple different superimposed elements: "
								+ eObjects + " -> " + existingElements);
				}
				for(EObject obj : eObjects) {
					if(obj != null && !element.getObjects().contains(obj)) {
						element.getObjects().add(obj);
					}
				}
				updateIndices(element);
				return element;
		}
	}

	public SuperimposedElement importEObjects(List<EObject> eObjects, Annotation annotation) throws ImportFailedException {
		SuperimposedElement element = importEObjects(eObjects);
		for(EObject object : eObjects) {
			SuperimpositionModelUtil.annotateElement(object, annotation, element);
		}
		return element;
	}

	public SuperimposedElement importEObject(EObject eObject, Annotation annotation) throws ImportFailedException {
		SuperimposedElement element = importEObject(eObject);
		SuperimpositionModelUtil.annotateElement(eObject, annotation, element);
		return element;
	}

	public Set<Entity> importResource(Resource resource, Annotation annotation) throws ImportFailedException {
		Assert.isNotNull(resource, "resource is null");
		Assert.isNotNull(annotation, "annotation is null");
		Annotation actualAnnotation = superimposedModel.getOrAddAnnotation(annotation);
		Set<Entity> removedEntities = new HashSet<>(actualAnnotation.getEntities());
		Set<Entity> result = super.importResource(resource, new SuperimpositionAnnotatingImporterVisitor(actualAnnotation));
		// Remove all entities which are annotated with the annotation but have not
		// been imported by the current importing process
		removedEntities.removeAll(result);
		cleanUp(actualAnnotation);
		removeAnnotated(removedEntities, actualAnnotation);
		return result;
	}

	/**
	 * Clean up and remove all annotated superimposed elements from the superimposed model,
	 * using {@link EntitiesImporter#removeAnnotated(Collection, Annotation)},
	 * as well as the annotation itself.
	 * @param annotation the annotation
	 */
	public void removeAllAnnotated(Annotation annotation) {
		cleanUp(annotation);
		super.removeAnnotated(superimposedModel.getElements(), annotation);
		EcoreUtil.delete(annotation);
	}

	/**
	 * Cleans up all elements in the superimposed model.
	 */
	protected void cleanUp() {
		cleanUp(element -> true);
	}

	/**
	 * Cleans up all elements that contain any of the given annotations.
	 * @param annotations annotations which determine elements to clean
	 */
	protected void cleanUp(Annotation ...annotations) {
		Set<Annotation> annotationsSet = Stream.of(annotations).collect(Collectors.toSet());
		cleanUp(element -> element.getAnnotations().stream().anyMatch(annotationsSet::contains));
	}

	/**
	 * Cleans up all elements in the model which satisfy the given predicate.
	 * @param elementFilter a filter which determines the elements to clean
	 */
	protected void cleanUp(Predicate<SuperimposedElement> elementFilter) {
		// The following always needs to create a copy of the element collection,
		// because cleanUp may remove elements from the model.
		for(SuperimposedElement element : superimposedModel.getElements().stream().filter(elementFilter).collect(Collectors.toList())) {
			cleanUp(element);
		}
	}

	/**
	 * Cleans up a single SuperimposedElement and its children.
	 * This may remove the element from its model.
	 * @param element the element to clean
	 */
	protected void cleanUp(SuperimposedElement element) {
		if(element.isExternal()) {
			// external elements without incoming references can be removed
			if(element.getIncomings().isEmpty()) {
				SuperimpositionModelPlugin.getPlugin().log(
					new Status(IStatus.INFO, SuperimpositionModelPlugin.ID,
					"Removing external superimposed element without incomings: " + element));
				removeEntity(element);
				return; // element removed
			}
			// external elements should not have annotations
			if(!element.getAnnotations().isEmpty() || !element.getObjectAnnotations().isEmpty()) {
				SuperimpositionModelPlugin.getPlugin().log(
					new Status(IStatus.INFO, SuperimpositionModelPlugin.ID,
					"Removing annotations from external superimposed element: " + element +
					", removed: " + element.getAnnotations() + " " + element.getObjectAnnotations()));
				element.getAnnotations().clear();
				element.getObjectAnnotations().clear();
			}
		}

		// Remove proxy objects from all object annotations and elements
		List<EObject> removedObjects = new ArrayList<>();
		element.getObjectAnnotations().keySet().removeIf(EObject::eIsProxy);
		for (Iterator<EObject> it = element.getObjects().iterator(); it.hasNext();) {
			EObject eObject = it.next();
			if(eObject.eIsProxy()) {
				removedObjects.add(eObject);
				it.remove();
			}
		}
		if(element.getObjects().isEmpty()) {
			SuperimpositionModelPlugin.getPlugin().log(
					new Status(IStatus.WARNING, SuperimpositionModelPlugin.ID,
					"Removing superimposed element without objects: " + element + ", removed objects: " + removedObjects));
			removeEntity(element);
			return; // element removed
		} else if(element.getObject() == null || element.getObject().eIsProxy()) {
			element.setObject(element.getObjects().get(0));
			element.updateExternal();
		}

		// Clean up owned references
		for(Reference reference : new ArrayList<>(element.getOwnedReferences())) {
			if(reference.getSource() == null || reference.getTarget() == null
					|| reference.getType() == null || reference.getType().eIsProxy()) {
				SuperimpositionModelPlugin.getPlugin().log(
					new Status(IStatus.WARNING, SuperimpositionModelPlugin.ID,
					"Removing invalid reference: " + reference));
				removeEntity(reference);
			} else {
				cleanUpAnnotations(reference);
			}
		}

		// Clean up owned attributes
		for(Attribute attribute : new ArrayList<>(element.getOwnedAttributes())) {
			if(attribute.getType() == null || attribute.getType().eIsProxy()) {
				SuperimpositionModelPlugin.getPlugin().log(
					new Status(IStatus.WARNING, SuperimpositionModelPlugin.ID,
					"Removing invalid attribute: " + attribute));
				removeEntity(attribute);
			} else {
				cleanUpAnnotations(attribute);
			}
		}

		// Clean up annotations of the element itself
		cleanUpAnnotations(element);
	}

	/**
	 * Cleans up uncontained/proxy annotations references by the given entity.
	 * @param entity the entity to clean
	 */
	protected void cleanUpAnnotations(Entity entity) {
		for(Annotation annotation : new ArrayList<>(entity.getAnnotations())) {
			if(annotation.eContainer() == null || annotation.eIsProxy()) {
				SuperimpositionModelPlugin.getPlugin().log(
					new Status(IStatus.WARNING, SuperimpositionModelPlugin.ID,
					"Removing uncontained/proxy annotation '" + annotation + "' from '" + entity + "'"));
				entity.getAnnotations().remove(annotation);
			}
		}
		if(entity instanceof SuperimposedElement) {
			SuperimposedElement element = (SuperimposedElement)entity;
			element.getObjectAnnotations().values().stream()
				.forEach(annotations -> {
					for (Iterator<Annotation> it = annotations.iterator(); it.hasNext(); ) {
						Annotation annotation = it.next();
						if(annotation.eContainer() == null || annotation.eIsProxy()) {
							SuperimpositionModelPlugin.getPlugin().log(
								new Status(IStatus.WARNING, SuperimpositionModelPlugin.ID,
								"Removing uncontained/proxy object annotation '" + annotation + "' from '" + entity + "'"));
							it.remove();
						}
					}
				});
			element.getObjectAnnotations().entrySet().removeIf(entry -> entry.getValue().isEmpty());
		}
	}

	public SuperimposedModel getSuperimposedModel() {
		return superimposedModel;
	}

	@Override
	protected IImporterFactory<? extends SuperimposedElement, ? extends Reference, ? extends Attribute> createFactory() {
		return new SuperimpositionModelImporterFactory();
	}

	@Override
	protected IImporterSignatureResolver createSignatureResolver() {
		// Not using a method reference here, because the superimposed model is not yet set when the resolver is created
		return new SuperimpositionModelImporterSignatureResolver(obj -> superimposedModel.calculateSignature(obj));
	}

	@Override
	protected IImporterUuidResolver createUuidResolver() {
		return new XmiIdImporterUuidResolver(false);
	}
}
