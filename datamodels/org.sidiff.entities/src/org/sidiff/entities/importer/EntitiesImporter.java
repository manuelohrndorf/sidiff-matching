package org.sidiff.entities.importer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.attributes.DefaultImporterAttributeValueResolver;
import org.sidiff.entities.importer.attributes.IImporterAttributeValueResolver;
import org.sidiff.entities.importer.factory.DefaultImporterFactory;
import org.sidiff.entities.importer.factory.IImporterFactory;
import org.sidiff.entities.importer.filter.DefaultImporterFilter;
import org.sidiff.entities.importer.filter.IImporterFilter;
import org.sidiff.entities.importer.signature.DefaultImporterSignatureResolver;
import org.sidiff.entities.importer.signature.IImporterSignatureResolver;
import org.sidiff.entities.importer.type.GenericImporterTypeResolver;
import org.sidiff.entities.importer.type.IImporterTypeResolver;
import org.sidiff.entities.importer.uuid.GeneratingImporterUuidResolver;
import org.sidiff.entities.importer.uuid.IImporterUuidResolver;
import org.sidiff.entities.importer.visitor.IImporterVisitor;

/**
 * The <code>EntitiesImporter</code> extends the {@link AbstractImporter} to
 * provide a base implementation for importing entities.
 * @param <E> the type of the {@link Element}s
 * @param <R> the type of the {@link Reference}s
 * @param <A> the type of the {@link Attribute}s
 * @author cpietsch
 * @author dreuling
 * @author rmueller
 */
public class EntitiesImporter<E extends Element, R extends Reference, A extends Attribute> extends AbstractImporter<E,R,A> {

	/**
	 * Creates a default entities importer using the type parameters &lt;Element,Reference,Attribute&gt;.
	 * @return new entities importer
	 */
	public static EntitiesImporter<Element,Reference,Attribute> createDefault() {
		return new EntitiesImporter<>(Element.class, Reference.class, Attribute.class);
	}

	private boolean importExternalAttributes = false;
	private boolean importExternalReferences = false;

	/**
	 * <p>Creates a new entities importer using the provided types.</p>
	 * <p><b>If the types do not match &lt;Element,Reference,Attribute&gt; exactly,
	 * the {@link #createFactory() default factory implementation} must be overridden.</b></p>
	 * @param elementClass class of the element type
	 * @param referenceClass class of the reference type
	 * @param attributeClass class of the attribute type
	 */
	public EntitiesImporter(Class<E> elementClass, Class<R> referenceClass, Class<A> attributeClass) {
		super(elementClass, referenceClass, attributeClass);
	}

	@Override
	protected boolean updateElement(E element, EObject eObject) throws ImportFailedException {
		return false; // element is already current
	}
	
	@Override
	protected boolean updateReference(R reference, E sourceElement, E targetElement) throws ImportFailedException {
		return false;
	}
	
	@Override
	protected boolean updateAttribute(A attribute, E element, List<String> values) throws ImportFailedException {
		return false;
	}

	// Map of EObjects to the elements they are currently being imported to in doImportEObject,
	// to prevent infinite recursion because of certain signature resolvers.
	private Map<EObject, E> eObjectsInImport = new HashMap<>();

	@Override
	protected E doImportEObject(EObject eObject) throws ImportFailedException {
		if(eObjectsInImport.containsKey(eObject)) {
			return eObjectsInImport.get(eObject);
		}
		E element = getFactory().createElement();
		element.setObject(eObject);
		eObjectsInImport.put(eObject, element);
		element.updateExternal();
		element.setType(getTypeResolver().resolveType(eObject));
		element.setUuid(getUuidResolver().computeUuid(element)); // compute first, because signature resolver may use UUID
		element.setSignature(getSignatureResolver().computeSignature(element));
		eObjectsInImport.remove(eObject);
		return element;
	}

	@Override
	protected R doImportEReference(EReference eReference, E sourceElement, E targetElement) throws ImportFailedException {
		R reference = getFactory().createReference();
		reference.setSource(sourceElement);
		reference.setTarget(targetElement);
		reference.setType(eReference);
		reference.setSignature(getSignatureResolver().computeSignature(reference));
		return reference;
	}

	@Override
	protected A doImportEAttribute(EAttribute eAttribute, E element, List<String> values) throws ImportFailedException {
		A attribute = getFactory().createAttribute();
		attribute.setType(eAttribute);
		attribute.getValue().addAll(values);
		attribute.setContainer(element);
		attribute.setSignature(getSignatureResolver().computeSignature(attribute));
		return attribute;
	}

	/**
	 * <p>Imports all {@link #getFilter() considered} objects, their references and attributes,
	 * and all referenced objects from the resource. Returns a set of all the imported entities.</p>
	 * @param resource the resource to import
	 * @param visitor visitors that is called for all imported entities
	 * @return set of imported entities
	 * @throws ImportFailedException if the import failed
	 */
	public Set<Entity> importResource(Resource resource, IImporterVisitor<? super E, ? super R, ? super A> visitor) throws ImportFailedException {
		RecursiveImportHelper helper = new RecursiveImportHelper(visitor,
				element -> !element.isExternal() || importExternalAttributes,
				element -> !element.isExternal() || importExternalReferences,
				reference -> reference.isContainment()
					|| (!reference.getSource().isExternal() && reference.getTarget().isExternal()
							&& (importExternalAttributes || importExternalReferences)));
		helper.importResource(resource);
		hookUpOppositeReferences();
		return helper.getImportedEntities();
	}

	/**
	 * Set the {@link Reference#getOpposite() opposite reference} for all
	 * imported references (i.e. those in the reference index).
	 */
	protected final void hookUpOppositeReferences() {
		for(R ref : getReferenceIndex().values()) {
			if(ref.getOpposite() != null)
				continue;
			R oppRef = getReferenceIndex().get(ReferenceKey.getOpposite(ref));
			if(oppRef == null)
				continue;
			ref.setOpposite(oppRef);
			oppRef.setOpposite(ref);
		}
	}

	/**
	 * If the entity is annotated with the given annotation,
	 * the annotation is removed. If the entity has only this
	 * annotation, the entity itself is deleted from its containing
	 * resource and/or its containing object.
	 * @param entity the entity
	 * @param annotation the annotation
	 */
	protected final void removeAnnotated(Entity entity, Annotation annotation) {
		if(entity.getAnnotations().contains(annotation)) {
			if(entity.getAnnotations().size() == 1) {
				removeEntity(entity);
			} else {
				entity.getAnnotations().remove(annotation);
			}
		}
	}

	/**
	 * Removes the annotation from all given entities. If the annotation
	 * is the only one of the entity, the entity itself is also removed. For elements,
	 * this method is called recursively for all references and attributes.
	 * @param entities the entities
	 * @param annotation the annotation
	 */
	protected final void removeAnnotated(Collection<? extends Entity> entities, Annotation annotation) {
		for(Entity entity : new ArrayList<>(entities)) {
			if(entity instanceof Element) {
				Element element = (Element)entity;
				removeAnnotated(element.getIncomings(), annotation);
				removeAnnotated(element.getOutgoings(), annotation);
				removeAnnotated(element.getAttributes(), annotation);
			}
			removeAnnotated(entity, annotation);
		}
	}

	/**
	 * {@inheritDoc}
	 * The default implementation of {@link EntitiesImporter}
	 * creates a {@link DefaultImporterFactory default factory},
	 * <b>which is only valid for the type arguments &lt;Element,Reference,Attribute&gt;</b>.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected IImporterFactory<? extends E, ? extends R, ? extends A> createFactory() {
		Assert.isLegal(getElementClass() == Element.class
				&& getReferenceClass() == Reference.class
				&& getAttributeClass() == Attribute.class,
				"The default factory can only be used with exactly the type arguments <Element,Reference,Attribute>. "
				+ "Override EntitiesImporter.createFactory to create an appropriate factory.");
		return (IImporterFactory<? extends E, ? extends R, ? extends A>)new DefaultImporterFactory();
	}

	/**
	 * {@inheritDoc}
	 * The default implementation of {@link EntitiesImporter}
	 * creates a {@link DefaultImporterFilter default filter} (with set-check).
	 */
	@Override
	protected IImporterFilter createFilter() {
		return new DefaultImporterFilter(true);
	}

	/**
	 * {@inheritDoc}
	 * The default implementation of {@link EntitiesImporter}
	 * creates a {@link DefaultImporterSignatureResolver default signature resolver}.
	 */
	@Override
	protected IImporterSignatureResolver createSignatureResolver() {
		return new DefaultImporterSignatureResolver();
	}

	/**
	 * {@inheritDoc}
	 * The default implementation of {@link EntitiesImporter}
	 * creates a {@link GeneratingImporterUuidResolver generating UUID resolver}.
	 */
	@Override
	protected IImporterUuidResolver createUuidResolver() {
		return new GeneratingImporterUuidResolver();
	}

	/**
	 * {@inheritDoc}
	 * The default implementation of {@link EntitiesImporter}
	 * creates a {@link DefaultImporterAttributeValueResolver default attribute value resolver}.
	 */
	@Override
	protected IImporterAttributeValueResolver createAttributeValueResolver() {
		return new DefaultImporterAttributeValueResolver();
	}

	/**
	 * {@inheritDoc}
	 * The default implementation of {@link EntitiesImporter}
	 * creates a {@link GenericImporterTypeResolver generic type resolver}.
	 */
	@Override
	protected IImporterTypeResolver createTypeResolver() {
		return new GenericImporterTypeResolver();
	}

	/**
	 * <p>Returns whether attributes of external elements, which are <u>directly</u> referenced
	 * by imported elements, are imported during recursive importing.</p>
	 * <p>The default value is <code>false</code>.</p>
	 * @return <code>true</code> if external attributes are imported, <code>false</code> otherwise
	 */
	public boolean isImportExternalAttributes() {
		return importExternalAttributes;
	}

	/**
	 * <p>Sets whether attributes of external elements, which are <u>directly</u> referenced
	 * by imported elements, should also be imported during recursive importing.</p>
	 * <p>The default value is <code>false</code>.</p>
	 * @param importExternalAttributes <code>true</code> to import external attributes, <code>false</code> otherwise
	 */
	public void setImportExternalAttributes(boolean importExternalAttributes) {
		this.importExternalAttributes = importExternalAttributes;
	}

	/**
	 * <p>Returns whether references of external elements, which are <u>directly</u> referenced
	 * by imported elements, are imported during recursive importing.</p>
	 * <p>The default value is <code>false</code>.</p>
	 * @return <code>true</code> if external references are imported, <code>false</code> otherwise
	 */
	public boolean isImportExternalReferences() {
		return importExternalReferences;
	}

	/**
	 * <p>Sets whether references of external elements, which are <u>directly</u> referenced
	 * by imported elements, should also be imported during recursive importing.</p>
	 * <p>The default value is <code>false</code>.</p>
	 * @param importExternalReferences <code>true</code> to import external references, <code>false</code> otherwise
	 */
	public void setImportExternalReferences(boolean importExternalReferences) {
		this.importExternalReferences = importExternalReferences;
	}

	protected class RecursiveImportHelper {

		private Set<Entity> importedEntities = new HashSet<>();
		private Set<EObject> importedObjects = new HashSet<>();
		private IImporterVisitor<? super E, ? super R, ? super A> visitor;
		private Predicate<? super E> importAttributesPredicate;
		private Predicate<? super E> importReferencesPredicate;
		private Predicate<? super R> followReferencePredicate;

		/**
		 * Creates a new helper.
		 * @param visitor the visitor that is called for all imported entities
		 * @param deepImportFilter predicate that returns, for an element, whether its
		 * attributes and references as well as referenced objects should also be imported;
		 * else only the element itself will be imported
		 */
		public RecursiveImportHelper(
				IImporterVisitor<? super E, ? super R, ? super A> visitor,
				Predicate<? super E> importAttributesPredicate,
				Predicate<? super E> importReferencesPredicate,
				Predicate<? super R> followReferencePredicate) {

			this.visitor = visitor;
			this.importAttributesPredicate = importAttributesPredicate;
			this.importReferencesPredicate = importReferencesPredicate;
			this.followReferencePredicate = followReferencePredicate;
		}

		/**
		 * <p>Imports the object and it attributes and references, following
		 * references and also importing the reference target recursively.</p>
		 * @param initialObjectsToImport collection of the root EObjects to import
		 * @throws ImportFailedException if the import failed
		 */
		public void importEObjectsRecursively(Collection<? extends EObject> initialObjectsToImport) throws ImportFailedException {
			List<EObject> importQueue = new ArrayList<>(initialObjectsToImport);
			for(int i = 0; i < importQueue.size(); i++) {
				EObject eObject = importQueue.get(i);
				if(!importedObjects.add(eObject)) {
					// Object was already imported
					continue;
				}
				if(!getFilter().isConsidered(eObject)) {
					continue;
				}

				// Import the object
				E element = importEObject(eObject);
				if(importedEntities.add(element)) {
					// Multiple objects might be mapped to the same element.
					// We only visit each element once, but allow each different EObject
					// to be imported separately with its attributes and references.
					visitor.visitElement(element);				
				}

				// Import attributes of the object
				if(importAttributesPredicate.test(element)) {
					for(EAttribute eAttribute : eObject.eClass().getEAllAttributes()) {
						if(getFilter().isConsidered(eAttribute, eObject)) {
							A attribute = importEAttribute(eAttribute, eObject);
							if(importedEntities.add(attribute)) {							
								visitor.visitAttribute(attribute);
							}
						}
					}
				}
				
				// Import references of the object
				if(importReferencesPredicate.test(element)) {
					for(EReference eReference : eObject.eClass().getEAllReferences()) {
						if(getFilter().isConsidered(eReference, eObject)) {
							for(EObject tgtObject : EMFUtil.getReferenceTargets(eObject, eReference)) {
								if(getFilter().isConsidered(tgtObject)) {
									R reference = importEReference(eReference, eObject, tgtObject);
									if(importedEntities.add(reference)) {
										visitor.visitReference(reference);
										
										// import the target object recursively if the reference is followed
										if(followReferencePredicate.test(reference)) {
											importQueue.add(tgtObject);
										}									
									}
								}
							}
						}
					}
				}
			}
		}

		/**
		 * <p>Imports all {@link #getFilter() considered} objects, their references and attributes,
		 * and all referenced objects from the resource.</p>
		 * @param resource the resource to import
		 * @throws ImportFailedException if the import failed
		 */
		public void importResource(Resource resource) throws ImportFailedException {
			importEObjectsRecursively(resource.getContents());
		}

		public Set<Entity> getImportedEntities() {
			return importedEntities;
		}
	}
}
