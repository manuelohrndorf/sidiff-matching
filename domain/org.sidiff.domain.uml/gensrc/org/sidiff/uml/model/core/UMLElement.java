/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLElement#getId <em>Id</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLElement#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLElement_Id()
   * @model id="true" required="true" ordered="false"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLElement#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Comments</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLComment}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLComment#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comments</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comments</em>' reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLElement_Comments()
   * @see org.sidiff.uml.model.core.UMLComment#getElements
   * @model opposite="elements" ordered="false"
   * @generated
   */
  EList<UMLComment> getComments();

} // UMLElement
