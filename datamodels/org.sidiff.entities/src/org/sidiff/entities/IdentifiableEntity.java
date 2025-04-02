/**
 */
package org.sidiff.entities;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifiable Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.entities.IdentifiableEntity#getUuid <em>Uuid</em>}</li>
 * </ul>
 *
 * @see org.sidiff.entities.EntitiesPackage#getIdentifiableEntity()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IdentifiableEntity extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Dennis Reuling, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see org.sidiff.entities.EntitiesPackage#getIdentifiableEntity_Uuid()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getUuid();

	/**
	 * Sets the value of the '{@link org.sidiff.entities.IdentifiableEntity#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(String value);

} // IdentifiableEntity
