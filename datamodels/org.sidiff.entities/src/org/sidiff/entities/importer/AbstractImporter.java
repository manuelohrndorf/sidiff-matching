package org.sidiff.entities.importer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Entity;
import org.sidiff.entities.IdentifiableEntity;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.attributes.IImporterAttributeValueResolver;
import org.sidiff.entities.importer.factory.IImporterFactory;
import org.sidiff.entities.importer.filter.IImporterFilter;
import org.sidiff.entities.importer.signature.IImporterSignatureResolver;
import org.sidiff.entities.importer.type.IImporterTypeResolver;
import org.sidiff.entities.importer.uuid.IImporterUuidResolver;

/**
 * The <code>AbstractImporter</code> provides methods to import {@link EObject}s,
 * {@link EReference}s and {@link EAttribute}s, and provides multiple indices for all
 * the imported entities, which are automatically updated. The abstract importer
 * maintains and uses various strategies for creating and filtering elements,
 * as well as resolving UUIDs and signatures.
 * @param <E> the type of the {@link Element}s
 * @param <R> the type of the {@link Reference}s
 * @param <A> the type of the {@link Attribute}s
 * @author cpietsch
 * @author dreuling
 * @author rmueller
 */
public abstract class AbstractImporter<E extends Element, R extends Reference, A extends Attribute> implements IImporter<E,R,A> {

	private final Map<EObject,E> objectIndex = new HashMap<>();
	private final Map<AttributeKey,A> attributeIndex = new HashMap<>();
	private final Map<ReferenceKey,R> referenceIndex = new HashMap<>();
	private final Map<String,Set<Entity>> signatureIndex = new HashMap<>();
	private final Map<String,IdentifiableEntity> uuidIndex = new HashMap<>();

	private final Class<E> elementClass;
	private final Class<R> referenceClass;
	private final Class<A> attributeClass;

	private IImporterFactory<? extends E, ? extends R, ? extends A> factory;
	private IImporterFilter filter;
	private IImporterUuidResolver uuidResolver;
	private IImporterSignatureResolver signatureResolver;
	private IImporterAttributeValueResolver attributeValueResolver;
	private IImporterTypeResolver typeResolver;

	/**
	 * <p>Creates a new abstract importer using the provided types.</p>
	 * @param elementClass class of the element type
	 * @param referenceClass class of the reference type
	 * @param attributeClass class of the attribute type
	 */
	public AbstractImporter(Class<E> elementClass, Class<R> referenceClass, Class<A> attributeClass) {
		this.elementClass = Objects.requireNonNull(elementClass);
		this.referenceClass = Objects.requireNonNull(referenceClass);
		this.attributeClass = Objects.requireNonNull(attributeClass);
		this.factory = Objects.requireNonNull(createFactory());
		this.filter = Objects.requireNonNull(createFilter());
		this.uuidResolver = Objects.requireNonNull(createUuidResolver());
		this.signatureResolver = Objects.requireNonNull(createSignatureResolver());
		this.attributeValueResolver = Objects.requireNonNull(createAttributeValueResolver());
		this.typeResolver = Objects.requireNonNull(createTypeResolver());
	}

	/**
	 * Imports the object. If the object was already imported (i.e. it
	 * is found is in the object index), it is returned and
	 * {@link #updateElement(E, EObject)} is called, else a new
	 * element is created using {@link #doImportEObject(EObject)} and
	 * the appropriate indices are updated.
	 */
	@Override
	public final E importEObject(EObject eObject) throws ImportFailedException {
		E element = resolveElement(Objects.requireNonNull(eObject));
		if(element == null) {
			element = Objects.requireNonNull(doImportEObject(eObject), "doImportEObject must not return null");
			updateIndices(element);
		} else if(updateElement(element, eObject)) {
			updateIndices(element);
		}
		
		return element;
	}

	/**
	 * <p>Handles import of an object that is already imported,
	 * optionally updating the element accordingly.</p>
	 * @param element the already imported element
	 * @param eObject the object that yielded the element
	 * @return <code>true</code> if the element changed (and indices need to be updated), <code>false</code> otherwise
	 * @throws ImportFailedException if the import failed
	 */
	protected abstract boolean updateElement(E element, EObject eObject) throws ImportFailedException;

	/**
	 * <p>Imports a new object.</p>
	 * <p>To create the element, the super-implementation
	 * or the {@link #getFactory() factory} should be called.</p>
	 * <p>From within this method, the import-methods without the
	 * <code>do</code>-prefix must not be called.</p>
	 * <p>After this method completes, all indices will be updated
	 * automatically, this requires that all significant fields be set.</p>
	 * @param eObject the object
	 * @return newly imported element
	 * @throws ImportFailedException if the import failed
	 */
	protected abstract E doImportEObject(EObject eObject) throws ImportFailedException;

	/**
	 * Imports the reference. If the reference was already imported
	 * (i.e. it is found is in the reference index), it is returned,
	 * else a new reference is created using {@link #doImportEReference(EReference, Element, Element)}
	 * and the appropriate indices are updated.
	 */
	@Override
	public final R importEReference(EReference eReference, EObject srcEObject, EObject tgtEObject) throws ImportFailedException {
		E srcElement = importEObject(srcEObject);
		E tgtElement = importEObject(tgtEObject);
		return importReference(eReference, srcElement, tgtElement);
	}

	protected R importReference(EReference eReference, E srcElement, E tgtElement) throws ImportFailedException {
		R reference = resolveReference(srcElement, tgtElement, eReference);
		if(reference == null) {
			reference = Objects.requireNonNull(doImportEReference(eReference, srcElement, tgtElement),
						"doImportEReference must not return null");
			updateIndices(reference);
		} else if(updateReference(reference, srcElement, tgtElement)) {
			updateIndices(reference);
		}
		return reference;
	}

	/**
	 * <p>Handles import of a reference that is already imported,
	 * optionally updating the reference accordingly.</p>
	 * @param reference the already imported reference
	 * @return <code>true</code> if the reference changed (and indices need to be updated), <code>false</code> otherwise
	 * @throws ImportFailedException if the import failed
	 */
	protected abstract boolean updateReference(R reference, E sourceElement, E targetElement) throws ImportFailedException;
	
	/**
	 * <p>Imports a new reference.</p>
	 * <p>To create the reference, the super-implementation
	 * or the {@link #getFactory() factory} should be called.</p>
	 * <p>From within this method, the import-methods without the
	 * <code>do</code>-prefix must not be called.</p>
	 * <p>After this method completes, all indices will be updated
	 * automatically, this requires that all significant fields be set.</p>
	 * @param eReference the reference type
	 * @param sourceElement the source element
	 * @param targetElement the target element
	 * @return newly imported reference
	 * @throws ImportFailedException if the import failed
	 */
	protected abstract R doImportEReference(EReference eReference, E sourceElement, E targetElement) throws ImportFailedException;

	/**
	 * Imports the attribute. If the attribute was already imported
	 * (i.e. it is found is in the attribute index), and it has exactly
	 * the same values are returned by the attribute values resolver, it is returned,
	 * else a new attribute is created using {@link #doImportEAttribute(EAttribute, Element)}
	 * and the appropriate indices are updated.
	 */
	@Override
	public final A importEAttribute(EAttribute eAttribute, EObject eObject) throws ImportFailedException {
		List<String> values = getAttributeValueResolver().resolveValues(eObject, eAttribute);
		E element = importEObject(eObject);
		return importAttribute(eAttribute, element, values);
	}

	protected A importAttribute(EAttribute eAttribute, E element, List<String> values) throws ImportFailedException {
		A attribute = resolveAttribute(element, eAttribute, values);
		if(attribute == null) {
			attribute = Objects.requireNonNull(doImportEAttribute(eAttribute, element, values),
					"doImportEAttribute must not return null");
			updateIndices(attribute);
		} else if(updateAttribute(attribute, element, values)) {
			updateIndices(attribute);			
		}
		return attribute;
	}
	
	/**
	 * <p>Handles import of an attribute that is already imported,
	 * optionally updating the attribute accordingly.</p>
	 * @param attribute the already imported attribute
	 * @param element the container element
	 * @param values the attribute values
	 * @return <code>true</code> if the attribute changed (and indices need to be updated), <code>false</code> otherwise
	 * @throws ImportFailedException if the import failed
	 */
	protected abstract boolean updateAttribute(A attribute, E element, List<String> values) throws ImportFailedException;

	/**
	 * <p>Imports a new attribute.</p>
	 * <p>To create the attribute, the super-implementation
	 * or the {@link #getFactory() factory} should be called.</p>
	 * <p>From within this method, the import-methods without the
	 * <code>do</code>-prefix must not be called.</p>
	 * <p>After this method completes, all indices will be updated
	 * automatically, this requires that all significant fields be set.</p>
	 * @param eAttribute the attribute type
	 * @param element the container element
	 * @param values the attribute values
	 * @return newly created attribute
	 * @throws ImportFailedException
	 */
	protected abstract A doImportEAttribute(EAttribute eAttribute, E element, List<String> values) throws ImportFailedException;

	/**
	 * Returns the object index, mapping {@link EObject}s
	 * to their imported counterpart of type {@link E}.
	 * @return the object index
	 */
	protected final Map<EObject, E> getObjectIndex() {
		return objectIndex;
	}

	/**
	 * Returns the reference index, mapping {@link ReferenceKey}s
	 * to their imported counterpart of type {@link R}.
	 * @return the reference index
	 */
	protected final Map<ReferenceKey, R> getReferenceIndex() {
		return referenceIndex;
	}

	/**
	 * Returns the attribute index, mapping {@link AttributeKey}s
	 * to their imported counterpart of type {@link A}.
	 * @return the attribute index
	 */
	protected final Map<AttributeKey, A> getAttributeIndex() {
		return attributeIndex;
	}

	/**
	 * Returns the signature index, mapping signatures (String)
	 * to the set entities that have that signature.
	 * @return signature index
	 */
	protected final Map<String, Set<Entity>> getSignatureIndex() {
		return signatureIndex;
	}

	/**
	 * Returns the UUID index, mapping UUIDs (String) to
	 * the identifiable entity with that UUID.
	 * @return UUID index
	 */
	protected final Map<String, IdentifiableEntity> getUuidIndex() {
		return uuidIndex;
	}

	protected E resolveElement(EObject object) {
		return getObjectIndex().get(object);
	}

	protected R resolveReference(E srcElement, E tgtElement, EReference eReference) {
		return getReferenceIndex().get(new ReferenceKey(srcElement, tgtElement, eReference));
	}

	protected A resolveAttribute(E element, EAttribute eAttribute, List<String> values) {
		return getAttributeIndex().get(new AttributeKey(element, eAttribute, values));
	}

	/**
	 * Creates all appropriate indices for the given entity
	 * using the different <code>updateIndex</code> methods.
	 * @param entity the entity
	 */
	protected final void updateIndices(Entity entity) {
		updateIndex(entity);

		if(entity instanceof IdentifiableEntity) {
			updateIndex((IdentifiableEntity)entity);
		}

		if(elementClass.isInstance(entity)) {
			updateIndex(elementClass.cast(entity));
		} else if(referenceClass.isInstance(entity)) {
			updateIndex(referenceClass.cast(entity));
		} else if(attributeClass.isInstance(entity)) {
			updateIndex(attributeClass.cast(entity));
		}
	}

	/**
	 * Updates the signature index for given entity.
	 * @param entity the entity
	 */
	protected void updateIndex(Entity entity) {
		getSignatureIndex().computeIfAbsent(entity.getSignature(), (signature) -> new HashSet<>()).add(entity);
	}

	/**
	 * Updates the UUID index for the given identifiable entity.
	 * @param idEntity the identifiable entity
	 */
	protected void updateIndex(IdentifiableEntity idEntity) {
		getUuidIndex().put(idEntity.getUuid(), idEntity);
	}

	/**
	 * Updates the object index for the given element.
	 * @param element the element
	 */
	protected void updateIndex(E element) {
		getObjectIndex().put(element.getObject(), element);
	}

	/**
	 * Updates the reference index for the given reference.
	 * @param reference the reference
	 */
	protected void updateIndex(R reference) {
		getReferenceIndex().put(ReferenceKey.get(reference), reference);
	}

	/**
	 * Updates the attribute index for the given attribute.
	 * @param attribute the attribute
	 */
	protected void updateIndex(A attribute) {
		getAttributeIndex().put(AttributeKey.get(attribute), attribute);
	}

	/**
	 * Removes the entity from all indices and from its
	 * containing resource/object and all other references.
	 * @param entity
	 */
	protected void removeEntity(Entity entity) {
		removeFromIndices(entity);

		// Remove incoming references, which would otherwise remain without a target
		if(entity instanceof Element) {
			EcoreUtil.deleteAll(((Element)entity).getIncomings(), false);
		}

		EcoreUtil.delete(entity, true);
	}

	/**
	 * Removes the entity from all indices
	 * @param entity the entity
	 */
	protected void removeFromIndices(Entity entity) {
		getSignatureIndex().values().forEach(entities -> entities.remove(entity));

		if(entity instanceof IdentifiableEntity) {
			getUuidIndex().values().removeIf(identifiableEntity -> identifiableEntity == entity);
		}

		if(elementClass.isInstance(entity)) {
			getObjectIndex().values().removeIf(element -> element == entity);
			getAttributeIndex().keySet().removeIf(key -> key.element == entity);
			getReferenceIndex().keySet().removeIf(key -> key.source == entity || key.target == entity);
		} else if(referenceClass.isInstance(entity)) {
			getReferenceIndex().values().removeIf(reference -> reference == entity);
		} else if(attributeClass.isInstance(entity)) {
			getAttributeIndex().values().removeIf(attribute -> attribute == entity);			
		}
	}

	/**
	 * Clears all indices, removing all mappings.
	 */
	protected final void clearIndices() {
		getUuidIndex().clear();
		getSignatureIndex().clear();
		getObjectIndex().clear();
		getReferenceIndex().clear();
		getAttributeIndex().clear();
	}

	@Override
	public final IImporterFactory<? extends E, ? extends R, ? extends A> getFactory() {
		return factory;
	}

	/**
	 * Creates the importer's factory.
	 * @return the factory for this importer
	 */
	protected abstract IImporterFactory<? extends E, ? extends R, ? extends A> createFactory();

	@Override
	public final IImporterFilter getFilter() {
		return filter;
	}

	/**
	 * Creates the importer's filter.
	 * @return the filter for this importer
	 */
	protected abstract IImporterFilter createFilter();

	@Override
	public final IImporterUuidResolver getUuidResolver() {
		return uuidResolver;
	}

	/**
	 * Creates the importer's UUID resolver.
	 * @return the UUID resolver for this importer
	 */
	protected abstract IImporterUuidResolver createUuidResolver();

	@Override
	public final IImporterSignatureResolver getSignatureResolver() {
		return signatureResolver;
	}

	/**
	 * Creates the importer's signature resolver.
	 * @return the signature resolver for this importer
	 */
	protected abstract IImporterSignatureResolver createSignatureResolver();

	@Override
	public final IImporterAttributeValueResolver getAttributeValueResolver() {
		return attributeValueResolver;
	}

	/**
	 * Creates the importer's attribute value resolver.
	 * @return the attribute value resolver for this importer
	 */
	protected abstract IImporterAttributeValueResolver createAttributeValueResolver();

	@Override
	public final IImporterTypeResolver getTypeResolver() {
		return typeResolver;
	}

	/**
	 * Creates the importer's type resolver.
	 * @return the type resolver for this importer
	 */
	protected abstract IImporterTypeResolver createTypeResolver();

	protected final Class<E> getElementClass() {
		return elementClass;
	}

	protected final Class<R> getReferenceClass() {
		return referenceClass;
	}

	protected final Class<A> getAttributeClass() {
		return attributeClass;
	}

	/**
	 * Key used for {@link AbstractImporter#getAttributeIndex()},
	 * consisting of the reference source, target and type.
	 * @author cpietsch, Robert Müller
	 */
	protected static final class ReferenceKey {

		/**
		 * The source of the reference
		 */
		public final Element source;

		/**
		 * The target of the reference
		 */
		public final Element target;

		/**
		 * The type of the reference
		 */
		public final EReference type;

		public ReferenceKey(Element source, Element target, EReference type) {
			this.source = Objects.requireNonNull(source);
			this.target = Objects.requireNonNull(target);
			this.type = Objects.requireNonNull(type);
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == this) return true;
			if(!(obj instanceof ReferenceKey)) return false;
			ReferenceKey otherRef = (ReferenceKey)obj;
			return Objects.equals(source, otherRef.source)
					&& Objects.equals(target, otherRef.target)
					&& Objects.equals(type, otherRef.type);
		}

		@Override
		public int hashCode() {
			return Objects.hash(source, target, type);
		}

		/**
		 * Returns a key for the given reference.
		 * @param reference the reference
		 * @return reference key
		 */
		public static ReferenceKey get(Reference reference) {
			return new ReferenceKey(
					reference.getSource(),
					reference.getTarget(),
					reference.getType());
		}

		/**
		 * Returns a key for the opposite of the given reference.
		 * @param reference the reference
		 * @return reference key of opposite reference
		 */
		public static ReferenceKey getOpposite(Reference reference) {
			EReference opposite = reference.getType().getEOpposite();
			if(opposite == null || reference.getSource() == null || reference.getTarget() == null)
				return null;
			return new ReferenceKey(
					reference.getTarget(),
					reference.getSource(),
					opposite);
		}
	}

	/**
	 * Key used for {@link AbstractImporter#getAttributeIndex()},
	 * consisting of the attribute object and type.
	 * @author Robert Müller
	 */
	protected static class AttributeKey {

		public final Element element;
		public final EAttribute type;
		public final List<String> values;

		public AttributeKey(Element element, EAttribute type, List<String> values) {
			this.element = Objects.requireNonNull(element);
			this.type = Objects.requireNonNull(type);
			this.values = Collections.unmodifiableList(Objects.requireNonNull(values));
		}

		@Override
		public boolean equals(Object obj) {
			if(obj == this) return true;
			if(!(obj instanceof AttributeKey)) return false;
			AttributeKey otherRef = (AttributeKey)obj;
			return Objects.equals(element, otherRef.element)
					&& Objects.equals(type, otherRef.type)
					&& Objects.equals(values, otherRef.values);
		}

		@Override
		public int hashCode() {
			return Objects.hash(element, type, values);
		}

		/**
		 * Returns a key for the given attribute.
		 * @param attribute the attribute
		 * @return attribute key
		 */
		public static AttributeKey get(Attribute attribute) {
			return new AttributeKey(
					attribute.getContainer(),
					attribute.getType(),
					attribute.getValue());
		}
	}
}
