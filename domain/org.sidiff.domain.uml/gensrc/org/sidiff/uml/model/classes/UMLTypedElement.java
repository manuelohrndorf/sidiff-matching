/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTypedElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLTypedElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLType#getUsedByElements <em>Used By Elements</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(UMLType)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTypedElement_Type()
   * @see org.sidiff.uml.model.classes.UMLType#getUsedByElements
   * @model opposite="usedByElements" ordered="false"
   * @generated
   */
  UMLType getType();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLTypedElement#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(UMLType value);

} // UMLTypedElement
