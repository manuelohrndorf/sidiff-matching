/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.sidiff.uml.model.core.UMLNamedElement;
import org.sidiff.uml.model.core.UMLStereotypeableElement;
import org.sidiff.uml.model.core.UMLVisibleElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAttribute#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAttribute#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAttribute#isIsReadOnly <em>Is Read Only</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAttribute#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAttribute()
 * @model
 * @generated
 */
public interface UMLAttribute extends UMLNamedElement, UMLStereotypeableElement, UMLTypedElement, UMLVisibleElement
{
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
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAttribute_IsStatic()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsStatic();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAttribute#isIsStatic <em>Is Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Static</em>' attribute.
   * @see #isIsStatic()
   * @generated
   */
  void setIsStatic(boolean value);

  /**
   * Returns the value of the '<em><b>Is Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Final</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Final</em>' attribute.
   * @see #setIsFinal(boolean)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAttribute_IsFinal()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsFinal();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAttribute#isIsFinal <em>Is Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Final</em>' attribute.
   * @see #isIsFinal()
   * @generated
   */
  void setIsFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Is Read Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Read Only</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Read Only</em>' attribute.
   * @see #setIsReadOnly(boolean)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAttribute_IsReadOnly()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsReadOnly();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAttribute#isIsReadOnly <em>Is Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Read Only</em>' attribute.
   * @see #isIsReadOnly()
   * @generated
   */
  void setIsReadOnly(boolean value);

  /**
   * Returns the value of the '<em><b>Class</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLClass#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class</em>' container reference.
   * @see #setClass(UMLClass)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAttribute_Class()
   * @see org.sidiff.uml.model.classes.UMLClass#getAttributes
   * @model opposite="attributes" transient="false" ordered="false"
   * @generated
   */
  UMLClass getClass_();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAttribute#getClass_ <em>Class</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class</em>' container reference.
   * @see #getClass_()
   * @generated
   */
  void setClass(UMLClass value);

} // UMLAttribute
