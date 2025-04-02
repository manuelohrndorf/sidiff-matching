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
 * A representation of the model object '<em><b>UML Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociationEnd#isIsNavigable <em>Is Navigable</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getKind <em>Kind</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociationEnd#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociationEnd()
 * @model
 * @generated
 */
public interface UMLAssociationEnd extends UMLNamedElement, UMLStereotypeableElement
{
  /**
   * Returns the value of the '<em><b>Association</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLAssociation#getAssociationEnds <em>Association Ends</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Association</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Association</em>' container reference.
   * @see #setAssociation(UMLAssociation)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociationEnd_Association()
   * @see org.sidiff.uml.model.classes.UMLAssociation#getAssociationEnds
   * @model opposite="associationEnds" required="true" transient="false" ordered="false"
   * @generated
   */
  UMLAssociation getAssociation();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getAssociation <em>Association</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Association</em>' container reference.
   * @see #getAssociation()
   * @generated
   */
  void setAssociation(UMLAssociation value);

  /**
   * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity</em>' attribute.
   * @see #setMultiplicity(String)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociationEnd_Multiplicity()
   * @model required="true" ordered="false"
   * @generated
   */
  String getMultiplicity();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getMultiplicity <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity</em>' attribute.
   * @see #getMultiplicity()
   * @generated
   */
  void setMultiplicity(String value);

  /**
   * Returns the value of the '<em><b>Is Navigable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Navigable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Navigable</em>' attribute.
   * @see #setIsNavigable(boolean)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociationEnd_IsNavigable()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsNavigable();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#isIsNavigable <em>Is Navigable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Navigable</em>' attribute.
   * @see #isIsNavigable()
   * @generated
   */
  void setIsNavigable(boolean value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.sidiff.uml.model.classes.UMLAggregationKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.sidiff.uml.model.classes.UMLAggregationKind
   * @see #setKind(UMLAggregationKind)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociationEnd_Kind()
   * @model required="true" ordered="false"
   * @generated
   */
  UMLAggregationKind getKind();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.sidiff.uml.model.classes.UMLAggregationKind
   * @see #getKind()
   * @generated
   */
  void setKind(UMLAggregationKind value);

  /**
   * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Ordered</em>' attribute.
   * @see #setIsOrdered(boolean)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociationEnd_IsOrdered()
   * @model required="true" ordered="false"
   * @generated
   */
  boolean isIsOrdered();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#isIsOrdered <em>Is Ordered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Ordered</em>' attribute.
   * @see #isIsOrdered()
   * @generated
   */
  void setIsOrdered(boolean value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLClassifier#getTargetedByAssociationEnds <em>Targeted By Association Ends</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(UMLClassifier)
   * @see org.sidiff.uml.model.classes.ClassesPackage#getUMLAssociationEnd_Target()
   * @see org.sidiff.uml.model.classes.UMLClassifier#getTargetedByAssociationEnds
   * @model opposite="targetedByAssociationEnds" required="true" ordered="false"
   * @generated
   */
  UMLClassifier getTarget();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.classes.UMLAssociationEnd#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(UMLClassifier value);

} // UMLAssociationEnd
