package org.sidiff.entities.importer.filter;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * The importer filter filters all to be imported objects,
 * references and attributes.
 * @author rmueller
 */
public interface IImporterFilter {

	/**
	 * Returns whether the object is considered for importing.
	 * @param eObject the object
	 * @return <code>true</code> if it should be imported, <code>false</code> otherwise
	 */
	boolean isConsidered(EObject eObject);

	/**
	 * Returns whether the reference is considered for importing.
	 * @param eReference the reference type
	 * @param eObject the object declaring the reference, i.e. the source of the reference
	 * @return <code>true</code> if it should be imported, <code>false</code> otherwise
	 */
	boolean isConsidered(EReference eReference, EObject eObject);

	/**
	 * Returns whether the attribute is considered for importing.
	 * @param eAttribute the attribute type
	 * @param eObject the object declaring the attribute
	 * @return <code>true</code> if it should be imported, <code>false</code> otherwise
	 */
	boolean isConsidered(EAttribute eAttribute, EObject eObject);
}