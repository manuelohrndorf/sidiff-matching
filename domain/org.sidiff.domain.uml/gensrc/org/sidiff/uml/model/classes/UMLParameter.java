/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLStereotypeableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLParameter#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLParameter#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLParameter()
 * @model
 * @generated
 */
public interface UMLParameter extends UMLNamedElement, UMLStereotypeableElement, UMLTypedElement
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.sidiff.uml.model.classes.UMLParameterKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.sidiff.uml.model.classes.UMLParameterKind
   * @see #setKind(UMLParameterKind)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLParameter_Kind()
   * @model required="true" ordered="false"
   * @generated
   */
  UMLParameterKind getKind();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLParameter#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.sidiff.uml.model.classes.UMLParameterKind
   * @see #getKind()
   * @generated
   */
  void setKind(UMLParameterKind value);

  /**
   * Returns the value of the '<em><b>Operation</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLOperation#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' container reference.
   * @see #setOperation(UMLOperation)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLParameter_Operation()
   * @see org.sidiff.uml.model.classes.UMLOperation#getParameters
   * @model opposite="parameters" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLOperation getOperation();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLParameter#getOperation <em>Operation</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' container reference.
   * @see #getOperation()
   * @generated
   */
  void setOperation(UMLOperation value);

} // UMLParameter
