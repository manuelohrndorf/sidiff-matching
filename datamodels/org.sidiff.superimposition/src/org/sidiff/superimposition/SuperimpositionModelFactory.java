/**
 */
package org.sidiff.superimposition;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.superimposition.SuperimpositionModelPackage
 * @generated
 */
public interface SuperimpositionModelFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SuperimpositionModelFactory eINSTANCE = org.sidiff.superimposition.impl.SuperimpositionModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Superimposed Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Superimposed Model</em>'.
	 * @generated
	 */
	SuperimposedModel createSuperimposedModel();

	/**
	 * Returns a new object of class '<em>Superimposed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Superimposed Element</em>'.
	 * @generated
	 */
	SuperimposedElement createSuperimposedElement();

	/**
	 * Returns a new object of class '<em>Conflicting Entities</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflicting Entities</em>'.
	 * @generated
	 */
	ConflictingEntities createConflictingEntities();

	/**
	 * Returns a new object of class '<em>Conflict</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflict</em>'.
	 * @generated
	 */
	Conflict createConflict();

	/**
	 * Returns a new object of class '<em>Conflict Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conflict Set</em>'.
	 * @generated
	 */
	ConflictSet createConflictSet();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SuperimpositionModelPackage getSuperimpositionModelPackage();

} //SuperimpositionModelFactory
