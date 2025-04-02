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
 * A representation of the model object '<em><b>UML Stereotypeable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLStereotypeableElement#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLStereotypeableElement()
 * @model
 * @generated
 */
public interface UMLStereotypeableElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Stereotypes</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLStereotype}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLStereotype#getStereotypedElements <em>Stereotyped Elements</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotypes</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotypes</em>' reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLStereotypeableElement_Stereotypes()
   * @see org.sidiff.uml.model.core.UMLStereotype#getStereotypedElements
   * @model opposite="stereotypedElements" ordered="false"
   * @generated
   */
  EList<UMLStereotype> getStereotypes();

} // UMLStereotypeableElement
