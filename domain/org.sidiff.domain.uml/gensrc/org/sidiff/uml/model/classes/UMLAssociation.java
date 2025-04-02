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
import org.sidiff.uml.model.core.UMLStereotypeableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociation#getAssociationEnds <em>Association Ends</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociation#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociation()
 * @model
 * @generated
 */
public interface UMLAssociation extends UMLNamedElement, UMLGeneralizableElement, UMLStereotypeableElement
{
  /**
   * Returns the value of the '<em><b>Association Ends</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLAssociationEnd}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association Ends</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association Ends</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociation_AssociationEnds()
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#getAssociation
   * @model opposite="association" containment="true" ordered="false"
   * @generated
   */
  EList<UMLAssociationEnd> getAssociationEnds();

  /**
   * Returns the value of the '<em><b>Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getAssociations <em>Associations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' container reference.
   * @see #setPackage(UMLPackage)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociation_Package()
   * @see org.sidiff.uml.model.core.UMLPackage#getAssociations
   * @model opposite="associations" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLPackage getPackage();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAssociation#getPackage <em>Package</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' container reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(UMLPackage value);

} // UMLAssociation
