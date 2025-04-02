/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.sidiff.uml.model.core.UMLElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Generalization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLGeneralization#getSpecialElement <em>Special Element</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLGeneralization#getGeneralElement <em>General Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLGeneralization()
 * @model
 * @generated
 */
public interface UMLGeneralization extends UMLElement
{
  /**
   * Returns the value of the '<em><b>Special Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLGeneralizableElement#getGeneralizations <em>Generalizations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Special Element</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Special Element</em>' container reference.
   * @see #setSpecialElement(UMLGeneralizableElement)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLGeneralization_SpecialElement()
   * @see org.sidiff.uml.model.classes.UMLGeneralizableElement#getGeneralizations
   * @model opposite="generalizations" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLGeneralizableElement getSpecialElement();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLGeneralization#getSpecialElement <em>Special Element</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Special Element</em>' container reference.
   * @see #getSpecialElement()
   * @generated
   */
  void setSpecialElement(UMLGeneralizableElement value);

  /**
   * Returns the value of the '<em><b>General Element</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLGeneralizableElement#getSpecializations <em>Specializations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>General Element</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>General Element</em>' reference.
   * @see #setGeneralElement(UMLGeneralizableElement)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLGeneralization_GeneralElement()
   * @see org.sidiff.uml.model.classes.UMLGeneralizableElement#getSpecializations
   * @model opposite="specializations" required="true" ordered="false"
   * @generated
   */
  UMLGeneralizableElement getGeneralElement();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLGeneralization#getGeneralElement <em>General Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>General Element</em>' reference.
   * @see #getGeneralElement()
   * @generated
   */
  void setGeneralElement(UMLGeneralizableElement value);

} // UMLGeneralization
