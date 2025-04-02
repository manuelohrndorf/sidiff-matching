/**
 */
package org.sidiff.entities;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.entities.Element#getOutgoings <em>Outgoings</em>}</li>
 *   <li>{@link org.sidiff.entities.Element#getIncomings <em>Incomings</em>}</li>
 *   <li>{@link org.sidiff.entities.Element#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.sidiff.entities.Element#getObject <em>Object</em>}</li>
 *   <li>{@link org.sidiff.entities.Element#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.entities.Element#isExternal <em>External</em>}</li>
 * </ul>
 *
 * @see org.sidiff.entities.EntitiesPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends Entity, IdentifiableEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Dennis Reuling, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.entities.Reference}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.entities.Reference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see org.sidiff.entities.EntitiesPackage#getElement_Outgoings()
	 * @see org.sidiff.entities.Reference#getSource
	 * @model opposite="source" ordered="false"
	 * @generated
	 */
	EList<Reference> getOutgoings();

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.entities.Reference}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.entities.Reference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see org.sidiff.entities.EntitiesPackage#getElement_Incomings()
	 * @see org.sidiff.entities.Reference#getTarget
	 * @model opposite="target" ordered="false"
	 * @generated
	 */
	EList<Reference> getIncomings();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.entities.Attribute}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.entities.Attribute#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see org.sidiff.entities.EntitiesPackage#getElement_Attributes()
	 * @see org.sidiff.entities.Attribute#getContainer
	 * @model opposite="container" ordered="false"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see org.sidiff.entities.EntitiesPackage#getElement_Object()
	 * @model
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Element#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see org.sidiff.entities.EntitiesPackage#getElement_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Element#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External</em>' attribute.
	 * @see #setExternal(boolean)
	 * @see org.sidiff.entities.EntitiesPackage#getElement_External()
	 * @model required="true"
	 * @generated
	 */
	boolean isExternal();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Element#isExternal <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External</em>' attribute.
	 * @see #isExternal()
	 * @generated
	 */
	void setExternal(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Attribute> getAttributes(EAttribute type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Reference> getReferences(EReference type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Updates this element's External-Attribute depending on the element's object.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void updateExternal();

} // Element
