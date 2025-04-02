/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.common.util.EList;

import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLEnumeration#getLiterals <em>Literals</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLEnumeration#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLEnumeration()
 * @model
 * @generated
 */
public interface UMLEnumeration extends UMLType, UMLNamedElement, UMLVisibleElement
{
  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLLiteral}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLLiteral#getEnumeration <em>Enumeration</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLEnumeration_Literals()
   * @see org.sidiff.uml.model.classes.UMLLiteral#getEnumeration
   * @model opposite="enumeration" containment="true" ordered="false"
   * @generated
   */
  EList<UMLLiteral> getLiterals();

  /**
   * Returns the value of the '<em><b>Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getEnumerations <em>Enumerations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' container reference.
   * @see #setPackage(UMLPackage)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLEnumeration_Package()
   * @see org.sidiff.uml.model.core.UMLPackage#getEnumerations
   * @model opposite="enumerations" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLPackage getPackage();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLEnumeration#getPackage <em>Package</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' container reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(UMLPackage value);

} // UMLEnumeration
