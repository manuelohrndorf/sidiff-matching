/**
 */
package org.sidiff.entities;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.entities.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link org.sidiff.entities.Attribute#getValue <em>Value</em>}</li>
 *   <li>{@link org.sidiff.entities.Attribute#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see org.sidiff.entities.EntitiesPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Dennis Reuling, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EAttribute)
	 * @see org.sidiff.entities.EntitiesPackage#getAttribute_Type()
	 * @model required="true"
	 * @generated
	 */
	EAttribute getType();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Attribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute list.
	 * @see org.sidiff.entities.EntitiesPackage#getAttribute_Value()
	 * @model
	 * @generated
	 */
	EList<String> getValue();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.entities.Element#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Element)
	 * @see org.sidiff.entities.EntitiesPackage#getAttribute_Container()
	 * @see org.sidiff.entities.Element#getAttributes
	 * @model opposite="attributes" required="true"
	 * @generated
	 */
	Element getContainer();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.Attribute#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Element value);

} // Attribute
