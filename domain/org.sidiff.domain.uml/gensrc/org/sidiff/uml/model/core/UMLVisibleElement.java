/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Visible Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLVisibleElement#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLVisibleElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLVisibleElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link org.sidiff.uml.model.core.UMLVisibility}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see org.sidiff.uml.model.core.UMLVisibility
   * @see #setVisibility(UMLVisibility)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLVisibleElement_Visibility()
   * @model required="true" ordered="false"
   * @generated
   */
  UMLVisibility getVisibility();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLVisibleElement#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see org.sidiff.uml.model.core.UMLVisibility
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(UMLVisibility value);

} // UMLVisibleElement
