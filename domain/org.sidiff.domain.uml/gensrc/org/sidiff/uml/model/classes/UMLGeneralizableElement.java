/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Generalizable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLGeneralizableElement#getSpecializations <em>Specializations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLGeneralizableElement#getGeneralizations <em>Generalizations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLGeneralizableElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLGeneralizableElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Specializations</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLGeneralization}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLGeneralization#getGeneralElement <em>General Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specializations</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specializations</em>' reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLGeneralizableElement_Specializations()
   * @see org.sidiff.uml.model.classes.UMLGeneralization#getGeneralElement
   * @model opposite="generalElement" ordered="false"
   * @generated
   */
  EList<UMLGeneralization> getSpecializations();

  /**
   * Returns the value of the '<em><b>Generalizations</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLGeneralization}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLGeneralization#getSpecialElement <em>Special Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generalizations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generalizations</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLGeneralizableElement_Generalizations()
   * @see org.sidiff.uml.model.classes.UMLGeneralization#getSpecialElement
   * @model opposite="specialElement" containment="true" ordered="false"
   * @generated
   */
  EList<UMLGeneralization> getGeneralizations();

} // UMLGeneralizableElement
