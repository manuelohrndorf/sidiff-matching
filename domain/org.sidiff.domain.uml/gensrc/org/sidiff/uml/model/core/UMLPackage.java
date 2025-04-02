/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.sidiff.uml.model.core;

import org.eclipse.emf.common.util.EList;

import org.sidiff.uml.model.classes.UMLAssociation;
import org.sidiff.uml.model.classes.UMLClassifier;
import org.sidiff.uml.model.classes.UMLEnumeration;
import org.sidiff.uml.model.classes.UMLPrimitiveType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getModel <em>Model</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getSuperPackage <em>Super Package</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getStoredComments <em>Stored Comments</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getEnumerations <em>Enumerations</em>}</li>
 *   <li>{@link org.sidiff.uml.model.core.UMLPackage#getPrimitiveTypes <em>Primitive Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage()
 * @model
 * @generated
 */
public interface UMLPackage extends UMLNamedElement, UMLStereotypeableElement, UMLVisibleElement
{
  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLModel#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Model</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model</em>' container reference.
   * @see #setModel(UMLModel)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_Model()
   * @see org.sidiff.uml.model.core.UMLModel#getPackages
   * @model opposite="packages" transient="false" ordered="false"
   * @generated
   */
  UMLModel getModel();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLPackage#getModel <em>Model</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model</em>' container reference.
   * @see #getModel()
   * @generated
   */
  void setModel(UMLModel value);

  /**
   * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLPackage}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getSuperPackage <em>Super Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Packages</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_Packages()
   * @see org.sidiff.uml.model.core.UMLPackage#getSuperPackage
   * @model opposite="superPackage" containment="true" ordered="false"
   * @generated
   */
  EList<UMLPackage> getPackages();

  /**
   * Returns the value of the '<em><b>Super Package</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLPackage#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Package</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Package</em>' container reference.
   * @see #setSuperPackage(UMLPackage)
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_SuperPackage()
   * @see org.sidiff.uml.model.core.UMLPackage#getPackages
   * @model opposite="packages" transient="false" ordered="false"
   * @generated
   */
  UMLPackage getSuperPackage();

  /**
   * Sets the value of the '{@link org.sidiff.uml.model.core.UMLPackage#getSuperPackage <em>Super Package</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Package</em>' container reference.
   * @see #getSuperPackage()
   * @generated
   */
  void setSuperPackage(UMLPackage value);

  /**
   * Returns the value of the '<em><b>Classifiers</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLClassifier}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLClassifier#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Classifiers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classifiers</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_Classifiers()
   * @see org.sidiff.uml.model.classes.UMLClassifier#getPackage
   * @model opposite="package" containment="true" ordered="false"
   * @generated
   */
  EList<UMLClassifier> getClassifiers();

  /**
   * Returns the value of the '<em><b>Stored Comments</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.core.UMLComment}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.core.UMLComment#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stored Comments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stored Comments</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_StoredComments()
   * @see org.sidiff.uml.model.core.UMLComment#getPackage
   * @model opposite="package" containment="true" ordered="false"
   * @generated
   */
  EList<UMLComment> getStoredComments();

  /**
   * Returns the value of the '<em><b>Associations</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLAssociation}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLAssociation#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Associations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Associations</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_Associations()
   * @see org.sidiff.uml.model.classes.UMLAssociation#getPackage
   * @model opposite="package" containment="true" ordered="false"
   * @generated
   */
  EList<UMLAssociation> getAssociations();

  /**
   * Returns the value of the '<em><b>Enumerations</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLEnumeration}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLEnumeration#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumerations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumerations</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_Enumerations()
   * @see org.sidiff.uml.model.classes.UMLEnumeration#getPackage
   * @model opposite="package" containment="true" ordered="false"
   * @generated
   */
  EList<UMLEnumeration> getEnumerations();

  /**
   * Returns the value of the '<em><b>Primitive Types</b></em>' containment reference list.
   * The list contents are of type {@link org.sidiff.uml.model.classes.UMLPrimitiveType}.
   * It is bidirectional and its opposite is '{@link org.sidiff.uml.model.classes.UMLPrimitiveType#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Primitive Types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Primitive Types</em>' containment reference list.
   * @see org.sidiff.uml.model.core.CorePackage#getUMLPackage_PrimitiveTypes()
   * @see org.sidiff.uml.model.classes.UMLPrimitiveType#getPackage
   * @model opposite="package" containment="true" ordered="false"
   * @generated
   */
  EList<UMLPrimitiveType> getPrimitiveTypes();

} // UMLPackage
