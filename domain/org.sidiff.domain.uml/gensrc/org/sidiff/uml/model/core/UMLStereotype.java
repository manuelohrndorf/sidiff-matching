/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Stereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLStereotype#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLStereotype#getStereotypedElements <em>Stereotyped Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLStereotype()
 * @model
 * @generated
 */
public interface UMLStereotype extends UMLNamedElement
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLModel#getStereotypes <em>Stereotypes</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see #setModel(UMLModel)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLStereotype_Model()
   * @see org.sidiff.uml.model.core.UMLModel#getStereotypes
   * @model opposite="stereotypes" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLModel getModel();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLStereotype#getModel <em>Model</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' container reference.
   * @see #getModel()
   * @generated
   */
  void setModel(UMLModel value);

  /**
   * Returns the value of the '<em><b>Stereotyped Elements</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLStereotypeableElement}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLStereotypeableElement#getStereotypes <em>Stereotypes</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotyped Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotyped Elements</em>' reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLStereotype_StereotypedElements()
   * @see org.sidiff.uml.model.core.UMLStereotypeableElement#getStereotypes
   * @model opposite="stereotypes" ordered="false"
   * @generated
   */
  EList<UMLStereotypeableElement> getStereotypedElements();

} // UMLStereotype
