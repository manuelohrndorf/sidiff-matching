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
 * A representation of the model object '<em><b>UML Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLInterface#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLInterface()
 * @model
 * @generated
 */
public interface UMLInterface extends UMLClassifier
{
  /**
   * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLOperation}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLOperation#getInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operations</em>' containment reference list.
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLInterface_Operations()
   * @see org.sidiff.uml.model.classes.UMLOperation#getInterface
   * @model opposite="interface" containment="true" ordered="false"
   * @generated
   */
  EList<UMLOperation> getOperations();

} // UMLInterface
