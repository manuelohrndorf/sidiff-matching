/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.common.util.EList;

import org.sidiff.uml.model.core.UMLNamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLType#getUsedByElements <em>Used By Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLType()
 * @model abstract="true"
 * @generated
 */
public interface UMLType extends UMLNamedElement
{
  /**
   * Returns the value of the '<em><b>Used By Elements</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLTypedElement}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLTypedElement#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Used By Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Used By Elements</em>' reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLType_UsedByElements()
   * @see org.sidiff.uml.model.classes.UMLTypedElement#getType
   * @model opposite="type" ordered="false"
   * @generated
   */
  EList<UMLTypedElement> getUsedByElements();

} // UMLType
