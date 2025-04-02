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
 * A representation of the model object '<em><b>UML Templateable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTemplateableElement#getTemplateParameters <em>Template Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateableElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLTemplateableElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Template Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLTemplateParameter}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getTemplateableElement <em>Templateable Element</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Parameters</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateableElement_TemplateParameters()
   * @see org.sidiff.uml.model.classes.UMLTemplateParameter#getTemplateableElement
   * @model opposite="templateableElement" containment="true"
   * @generated
   */
  EList<UMLTemplateParameter> getTemplateParameters();

} // UMLTemplateableElement
