/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.common.util.EList;

import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLOperation#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLOperation#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLOperation#getInterface <em>Interface</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLOperation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLOperation#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLOperation()
 * @model
 * @generated
 */
public interface UMLOperation extends UMLNamedElement, UMLStereotypeableElement, UMLTypedElement, UMLVisibleElement
{
  /**
   * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Abstract</em>' attribute.
   * @see #setIsAbstract(boolean)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLOperation_IsAbstract()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsAbstract();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLOperation#isIsAbstract <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Abstract</em>' attribute.
   * @see #isIsAbstract()
   * @generated
   */
  void setIsAbstract(boolean value);

  /**
   * Returns the value of the '<em><b>Is Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Static</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Static</em>' attribute.
   * @see #setIsStatic(boolean)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLOperation_IsStatic()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsStatic();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLOperation#isIsStatic <em>Is Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Static</em>' attribute.
   * @see #isIsStatic()
   * @generated
   */
  void setIsStatic(boolean value);

  /**
   * Returns the value of the '<em><b>Interface</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLInterface#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface</em>' container reference.
   * @see #setInterface(UMLInterface)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLOperation_Interface()
   * @see org.sidiff.uml.model.classes.UMLInterface#getOperations
   * @model opposite="operations" transient="false" ordered="false"
   * @generated
   */
  UMLInterface getInterface();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLOperation#getInterface <em>Interface</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface</em>' container reference.
   * @see #getInterface()
   * @generated
   */
  void setInterface(UMLInterface value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLParameter}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLParameter#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLOperation_Parameters()
   * @see org.sidiff.uml.model.classes.UMLParameter#getOperation
   * @model opposite="operation" containment="true" ordered="false"
   * @generated
   */
  EList<UMLParameter> getParameters();

  /**
   * Returns the value of the '<em><b>Class</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLClass#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class</em>' container reference.
   * @see #setClass(UMLClass)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLOperation_Class()
   * @see org.sidiff.uml.model.classes.UMLClass#getOperations
   * @model opposite="operations" transient="false" ordered="false"
   * @generated
   */
  UMLClass getClass_();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLOperation#getClass_ <em>Class</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class</em>' container reference.
   * @see #getClass_()
   * @generated
   */
  void setClass(UMLClass value);

} // UMLOperation
