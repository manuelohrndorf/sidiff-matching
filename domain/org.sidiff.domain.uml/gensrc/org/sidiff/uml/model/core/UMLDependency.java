/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLDependency#getDependee <em>Dependee</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLDependency#getSupplier <em>Supplier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLDependency()
 * @model
 * @generated
 */
public interface UMLDependency extends UMLNamedElement, UMLStereotypeableElement
{
  /**
   * Returns the value of the '<em><b>Dependee</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLNamedElement#getOutgoingDependencies <em>Outgoing Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dependee</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dependee</em>' container reference.
   * @see #setDependee(UMLNamedElement)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLDependency_Dependee()
   * @see org.sidiff.uml.model.core.UMLNamedElement#getOutgoingDependencies
   * @model opposite="outgoingDependencies" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLNamedElement getDependee();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLDependency#getDependee <em>Dependee</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dependee</em>' container reference.
   * @see #getDependee()
   * @generated
   */
  void setDependee(UMLNamedElement value);

  /**
   * Returns the value of the '<em><b>Supplier</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLNamedElement#getDependees <em>Dependees</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Supplier</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supplier</em>' reference.
   * @see #setSupplier(UMLNamedElement)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLDependency_Supplier()
   * @see org.sidiff.uml.model.core.UMLNamedElement#getDependees
   * @model opposite="dependees" required="true" ordered="false"
   * @generated
   */
  UMLNamedElement getSupplier();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLDependency#getSupplier <em>Supplier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supplier</em>' reference.
   * @see #getSupplier()
   * @generated
   */
  void setSupplier(UMLNamedElement value);

} // UMLDependency
