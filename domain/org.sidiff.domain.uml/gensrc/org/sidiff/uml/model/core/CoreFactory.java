/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.uml.model.core.CorePackage
 * @generated
 */
public interface CoreFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CoreFactory eINSTANCE = org.sidiff.uml.model.core.impl.CoreFactoryImpl.init();

  /**
   * Returns a new object of class '<em>UML Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Package</em>'.
   * @generated
   */
  UMLPackage createUMLPackage();

  /**
   * Returns a new object of class '<em>UML Stereotypeable Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Stereotypeable Element</em>'.
   * @generated
   */
  UMLStereotypeableElement createUMLStereotypeableElement();

  /**
   * Returns a new object of class '<em>UML Stereotype</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Stereotype</em>'.
   * @generated
   */
  UMLStereotype createUMLStereotype();

  /**
   * Returns a new object of class '<em>UML Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Model</em>'.
   * @generated
   */
  UMLModel createUMLModel();

  /**
   * Returns a new object of class '<em>UML Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Comment</em>'.
   * @generated
   */
  UMLComment createUMLComment();

  /**
   * Returns a new object of class '<em>UML Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Dependency</em>'.
   * @generated
   */
  UMLDependency createUMLDependency();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CorePackage getCorePackage();

} //CoreFactory
