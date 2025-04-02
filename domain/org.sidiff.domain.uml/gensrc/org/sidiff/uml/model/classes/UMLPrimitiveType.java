/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.sidiff.uml.model.core.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLPrimitiveType#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLPrimitiveType()
 * @model
 * @generated
 */
public interface UMLPrimitiveType extends UMLType
{
  /**
   * Returns the value of the '<em><b>Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getPrimitiveTypes <em>Primitive Types</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' container reference.
   * @see #setPackage(UMLPackage)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLPrimitiveType_Package()
   * @see org.sidiff.uml.model.core.UMLPackage#getPrimitiveTypes
   * @model opposite="primitiveTypes" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLPackage getPackage();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLPrimitiveType#getPackage <em>Package</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' container reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(UMLPackage value);

} // UMLPrimitiveType
