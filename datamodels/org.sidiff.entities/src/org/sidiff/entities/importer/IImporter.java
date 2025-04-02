package org.sidiff.entities.importer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.entities.importer.attributes.IImporterAttributeValueResolver;
import org.sidiff.entities.importer.factory.IImporterFactory;
import org.sidiff.entities.importer.filter.IImporterFilter;
import org.sidiff.entities.importer.signature.IImporterSignatureResolver;
import org.sidiff.entities.importer.type.IImporterTypeResolver;
import org.sidiff.entities.importer.uuid.IImporterUuidResolver;

/**
 * The <code>IImporter</code> interface specifies the public methods
 * of all entity importers.
 * @param <E> the type of the {@link Element}s
 * @param <R> the type of the {@link Reference}s
 * @param <A> the type of the {@link Attribute}s
 * @author rmueller
 */
public interface IImporter<E extends Element, R extends Reference, A extends Attribute> {

	/**
	 * Imports the object.
	 * @param eObject the object
	 * @return the imported element
	 * @throws ImportFailedException if the import failed
	 */
	E importEObject(EObject eObject) throws ImportFailedException;

	/**
	 * Imports the reference.
	 * @param eReference the reference type
	 * @param srcEObject the source object
	 * @param tgtEObject the target object
	 * @return the imported reference
	 * @throws ImportFailedException if the import failed
	 */
	R importEReference(EReference eReference, EObject srcEObject, EObject tgtEObject) throws ImportFailedException;

	/**
	 * Imports the attribute.
	 * @param eAttribute the attribute type
	 * @param eObject the object declaring the attribute
	 * @return the imported attribute
	 * @throws ImportFailedException if the import failed
	 */
	A importEAttribute(EAttribute eAttribute, EObject eObject) throws ImportFailedException;

	/**
	 * Returns the factory of this importer.
	 * @return the factory
	 */
	IImporterFactory<? extends E, ? extends R, ? extends A> getFactory();

	/**
	 * Returns the filter of this importer.
	 * @return the filter
	 */
	IImporterFilter getFilter();

	/**
	 * Returns the UUID resolver of this importer.
	 * @return the UUID resolver
	 */
	IImporterUuidResolver getUuidResolver();

	/**
	 * Returns the signature resolver of this importer.
	 * @return the signature resolver
	 */
	IImporterSignatureResolver getSignatureResolver();

	/**
	 * Returns the attribute value resolver of this importer.
	 * @return the attribute value resolver
	 */
	IImporterAttributeValueResolver getAttributeValueResolver();

	/**
	 * Returns the type resolver of this importer.
	 * @return the type resolver
	 */
	IImporterTypeResolver getTypeResolver();
}
