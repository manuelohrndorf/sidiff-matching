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
 * A representation of the model object '<em><b>UML Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLComment#getPackage <em>Package</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLComment#getComment <em>Comment</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLComment#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLComment()
 * @model
 * @generated
 */
public interface UMLComment extends EObject
{
  /**
   * Returns the value of the '<em><b>Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getStoredComments <em>Stored Comments</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' container reference.
   * @see #setPackage(UMLPackage)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLComment_Package()
   * @see org.sidiff.uml.model.core.UMLPackage#getStoredComments
   * @model opposite="storedComments" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLPackage getPackage();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLComment#getPackage <em>Package</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' container reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(UMLPackage value);

  /**
   * Returns the value of the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Comment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comment</em>' attribute.
   * @see #setComment(String)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLComment_Comment()
   * @model required="true" ordered="false"
   * @generated
   */
  String getComment();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLComment#getComment <em>Comment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Comment</em>' attribute.
   * @see #getComment()
   * @generated
   */
  void setComment(String value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLElement}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLElement#getComments <em>Comments</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLComment_Elements()
   * @see org.sidiff.uml.model.core.UMLElement#getComments
   * @model opposite="comments" ordered="false"
   * @generated
   */
  EList<UMLElement> getElements();

} // UMLComment
