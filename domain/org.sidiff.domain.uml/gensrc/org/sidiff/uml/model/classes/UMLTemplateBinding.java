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
 * A representation of the model object '<em><b>UML Template Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getFormalParam <em>Formal Param</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getActualParam <em>Actual Param</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getBinder <em>Binder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateBinding()
 * @model
 * @generated
 */
public interface UMLTemplateBinding extends UMLElement
{
  /**
   * Returns the value of the '<em><b>Formal Param</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLTemplateParameter#getBindings <em>Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Param</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Param</em>' reference.
   * @see #setFormalParam(UMLTemplateParameter)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateBinding_FormalParam()
   * @see org.sidiff.uml.model.classes.UMLTemplateParameter#getBindings
   * @model opposite="bindings" required="true" ordered="false"
   * @generated
   */
  UMLTemplateParameter getFormalParam();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getFormalParam <em>Formal Param</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Param</em>' reference.
   * @see #getFormalParam()
   * @generated
   */
  void setFormalParam(UMLTemplateParameter value);

  /**
   * Returns the value of the '<em><b>Actual Param</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actual Param</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actual Param</em>' attribute.
   * @see #setActualParam(String)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateBinding_ActualParam()
   * @model required="true" ordered="false"
   * @generated
   */
  String getActualParam();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getActualParam <em>Actual Param</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actual Param</em>' attribute.
   * @see #getActualParam()
   * @generated
   */
  void setActualParam(String value);

  /**
   * Returns the value of the '<em><b>Binder</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLBindingElement#getTemplateBindings <em>Template Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Binder</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Binder</em>' container reference.
   * @see #setBinder(UMLBindingElement)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLTemplateBinding_Binder()
   * @see org.sidiff.uml.model.classes.UMLBindingElement#getTemplateBindings
   * @model opposite="templateBindings" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLBindingElement getBinder();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getBinder <em>Binder</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Binder</em>' container reference.
   * @see #getBinder()
   * @generated
   */
  void setBinder(UMLBindingElement value);

} // UMLTemplateBinding
