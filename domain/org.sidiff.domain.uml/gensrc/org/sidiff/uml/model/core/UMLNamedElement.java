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
 * A representation of the model object '<em><b>UML Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLNamedElement#getOutgoingDependencies <em>Outgoing Dependencies</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLNamedElement#getDependees <em>Dependees</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLNamedElement#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface UMLNamedElement extends UMLElement
{
  /**
   * Returns the value of the '<em><b>Outgoing Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLDependency}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLDependency#getDependee <em>Dependee</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Dependencies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing Dependencies</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLNamedElement_OutgoingDependencies()
   * @see org.sidiff.uml.model.core.UMLDependency#getDependee
   * @model opposite="dependee" containment="true" ordered="false"
   * @generated
   */
  EList<UMLDependency> getOutgoingDependencies();

  /**
   * Returns the value of the '<em><b>Dependees</b></em>' reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLDependency}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLDependency#getSupplier <em>Supplier</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dependees</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dependees</em>' reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLNamedElement_Dependees()
   * @see org.sidiff.uml.model.core.UMLDependency#getSupplier
   * @model opposite="supplier" ordered="false"
   * @generated
   */
  EList<UMLDependency> getDependees();

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLNamedElement_Name()
   * @model required="true" ordered="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLNamedElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // UMLNamedElement
