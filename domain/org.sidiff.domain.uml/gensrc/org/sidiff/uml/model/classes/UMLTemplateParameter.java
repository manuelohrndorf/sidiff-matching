/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.common.util.EList;

import org.sidiff.uml.model.core.UMLElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Template Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getTemplateableElement <em>Templateable Element</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateParameter()
 * @model
 * @generated
 */
public interface UMLTemplateParameter extends UMLElement
{
  /**
   * Returns the value of the '<em><b>Templateable Element</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLTemplateableElement#getTemplateParameters <em>Template Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Templateable Element</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Templateable Element</em>' container reference.
   * @see #setTemplateableElement(UMLTemplateableElement)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateParameter_TemplateableElement()
   * @see org.sidiff.uml.model.classes.UMLTemplateableElement#getTemplateParameters
   * @model opposite="templateParameters" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLTemplateableElement getTemplateableElement();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getTemplateableElement <em>Templateable Element</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Templateable Element</em>' container reference.
   * @see #getTemplateableElement()
   * @generated
   */
  void setTemplateableElement(UMLTemplateableElement value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateParameter_Type()
   * @model required="true" ordered="false"
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

  /**
   * Returns the value of the '<em><b>Bindings</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLTemplateBinding}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getFormalParam <em>Formal Param</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bindings</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bindings</em>' reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateParameter_Bindings()
   * @see org.sidiff.uml.model.classes.UMLTemplateBinding#getFormalParam
   * @model opposite="formalParam" ordered="false"
   * @generated
   */
  EList<UMLTemplateBinding> getBindings();

} // UMLTemplateParameter
