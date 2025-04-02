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
 * A representation of the model object '<em><b>UML Binding Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLBindingElement#getTemplateBindings <em>Template Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLBindingElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLBindingElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Template Bindings</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLTemplateBinding}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLTemplateBinding#getBinder <em>Binder</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Bindings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Bindings</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLBindingElement_TemplateBindings()
   * @see org.sidiff.uml.model.classes.UMLTemplateBinding#getBinder
   * @model opposite="binder" containment="true" ordered="false"
   * @generated
   */
  EList<UMLTemplateBinding> getTemplateBindings();

} // UMLBindingElement
