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
 * A representation of the model object '<em><b>UML Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLModel#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLModel#getStereotypes <em>Stereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLModel()
 * @model
 * @generated
 */
public interface UMLModel extends UMLNamedElement
{
  /**
   * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLPackage}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packages</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLModel_Packages()
   * @see org.sidiff.uml.model.core.UMLPackage#getModel
   * @model opposite="model" containment="true" ordered="false"
   * @generated
   */
  EList<UMLPackage> getPackages();

  /**
   * Returns the value of the '<em><b>Stereotypes</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLStereotype}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLStereotype#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stereotypes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stereotypes</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLModel_Stereotypes()
   * @see org.sidiff.uml.model.core.UMLStereotype#getModel
   * @model opposite="model" containment="true" ordered="false"
   * @generated
   */
  EList<UMLStereotype> getStereotypes();

} // UMLModel
