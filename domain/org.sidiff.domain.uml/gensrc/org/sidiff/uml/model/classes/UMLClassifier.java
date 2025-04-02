/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.common.util.EList;

import org.sidiff.uml.model.core.UMLPackage;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLClassifier#getTargetedByAssociationEnds <em>Targeted By Association Ends</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLClassifier#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClassifier()
 * @model abstract="true"
 * @generated
 */
public interface UMLClassifier extends UMLType, UMLGeneralizableElement, UMLBindingElement, UMLStereotypeableElement, UMLTemplateableElement, UMLVisibleElement
{
  /**
   * Returns the value of the '<em><b>Targeted By Association Ends</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLAssociationEnd}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Targeted By Association Ends</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Targeted By Association Ends</em>' reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClassifier_TargetedByAssociationEnds()
   * @see org.sidiff.uml.model.classes.UMLAssociationEnd#getTarget
   * @model opposite="target" ordered="false"
   * @generated
   */
  EList<UMLAssociationEnd> getTargetedByAssociationEnds();

  /**
   * Returns the value of the '<em><b>Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getClassifiers <em>Classifiers</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' container reference.
   * @see #setPackage(UMLPackage)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClassifier_Package()
   * @see org.sidiff.uml.model.core.UMLPackage#getClassifiers
   * @model opposite="classifiers" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLPackage getPackage();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLClassifier#getPackage <em>Package</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' container reference.
   * @see #getPackage()
   * @generated
   */
  void setPackage(UMLPackage value);

} // UMLClassifier
