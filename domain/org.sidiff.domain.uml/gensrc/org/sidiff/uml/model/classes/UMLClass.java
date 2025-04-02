/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.classes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLClass#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLClass#isIsFinal <em>Is Final</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLClass#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLClass#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClass()
 * @model
 * @generated
 */
public interface UMLClass extends UMLClassifier
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
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClass_IsAbstract()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsAbstract();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLClass#isIsAbstract <em>Is Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Abstract</em>' attribute.
   * @see #isIsAbstract()
   * @generated
   */
  void setIsAbstract(boolean value);

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
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClass_IsFinal()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsFinal();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLClass#isIsFinal <em>Is Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Final</em>' attribute.
   * @see #isIsFinal()
   * @generated
   */
  void setIsFinal(boolean value);

  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLOperation}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLOperation#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClass_Operations()
   * @see org.sidiff.uml.model.classes.UMLOperation#getClass_
   * @model opposite="class" containment="true" ordered="false"
   * @generated
   */
  EList<UMLOperation> getOperations();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLAttribute}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLAttribute#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLClass_Attributes()
   * @see org.sidiff.uml.model.classes.UMLAttribute#getClass_
   * @model opposite="class" containment="true" ordered="false"
   * @generated
   */
  EList<UMLAttribute> getAttributes();

} // UMLClass
