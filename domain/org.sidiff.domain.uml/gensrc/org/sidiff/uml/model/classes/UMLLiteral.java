/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.sidiff.uml.model.core.UMLNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLLiteral#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLLiteral()
 * @model
 * @generated
 */
public interface UMLLiteral extends UMLNamedElement
{
  /**
   * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLEnumeration#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumeration</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumeration</em>' container reference.
   * @see #setEnumeration(UMLEnumeration)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLLiteral_Enumeration()
   * @see org.sidiff.uml.model.classes.UMLEnumeration#getLiterals
   * @model opposite="literals" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLEnumeration getEnumeration();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLLiteral#getEnumeration <em>Enumeration</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enumeration</em>' container reference.
   * @see #getEnumeration()
   * @generated
   */
  void setEnumeration(UMLEnumeration value);

} // UMLLiteral
