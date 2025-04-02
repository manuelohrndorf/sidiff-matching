/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.sidiff.uml.model.classes.ClassesPackage
 * @generated
 */
public interface ClassesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ClassesFactory eINSTANCE = org.sidiff.uml.model.classes.impl.ClassesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>UML Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Association</em>'.
   * @generated
   */
  UMLAssociation createUMLAssociation();

  /**
   * Returns a new object of class '<em>UML Generalization</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Generalization</em>'.
   * @generated
   */
  UMLGeneralization createUMLGeneralization();

  /**
   * Returns a new object of class '<em>UML Template Binding</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Template Binding</em>'.
   * @generated
   */
  UMLTemplateBinding createUMLTemplateBinding();

  /**
   * Returns a new object of class '<em>UML Template Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Template Parameter</em>'.
   * @generated
   */
  UMLTemplateParameter createUMLTemplateParameter();

  /**
   * Returns a new object of class '<em>UML Association End</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Association End</em>'.
   * @generated
   */
  UMLAssociationEnd createUMLAssociationEnd();

  /**
   * Returns a new object of class '<em>UML Enumeration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Enumeration</em>'.
   * @generated
   */
  UMLEnumeration createUMLEnumeration();

  /**
   * Returns a new object of class '<em>UML Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Literal</em>'.
   * @generated
   */
  UMLLiteral createUMLLiteral();

  /**
   * Returns a new object of class '<em>UML Primitive Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Primitive Type</em>'.
   * @generated
   */
  UMLPrimitiveType createUMLPrimitiveType();

  /**
   * Returns a new object of class '<em>UML Association Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Association Class</em>'.
   * @generated
   */
  UMLAssociationClass createUMLAssociationClass();

  /**
   * Returns a new object of class '<em>UML Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Class</em>'.
   * @generated
   */
  UMLClass createUMLClass();

  /**
   * Returns a new object of class '<em>UML Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Operation</em>'.
   * @generated
   */
  UMLOperation createUMLOperation();

  /**
   * Returns a new object of class '<em>UML Interface</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Interface</em>'.
   * @generated
   */
  UMLInterface createUMLInterface();

  /**
   * Returns a new object of class '<em>UML Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Parameter</em>'.
   * @generated
   */
  UMLParameter createUMLParameter();

  /**
   * Returns a new object of class '<em>UML Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UML Attribute</em>'.
   * @generated
   */
  UMLAttribute createUMLAttribute();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ClassesPackage getClassesPackage();

} //ClassesFactory
