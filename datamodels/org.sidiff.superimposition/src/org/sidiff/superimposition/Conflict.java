/**
 * (c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.Conflict#getId <em>Id</em>}</li>
 *   <li>{@link org.sidiff.superimposition.Conflict#getMessage <em>Message</em>}</li>
 *   <li>{@link org.sidiff.superimposition.Conflict#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.sidiff.superimposition.Conflict#getConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.sidiff.superimposition.Conflict#getConflictSet <em>Conflict Set</em>}</li>
 *   <li>{@link org.sidiff.superimposition.Conflict#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflict()
 * @model
 * @generated
 */
public interface Conflict extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflict_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.Conflict#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflict_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.Conflict#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.superimposition.ConflictSeverity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.superimposition.ConflictSeverity
	 * @see #setSeverity(ConflictSeverity)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflict_Severity()
	 * @model required="true"
	 * @generated
	 */
	ConflictSeverity getSeverity();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.Conflict#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.sidiff.superimposition.ConflictSeverity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(ConflictSeverity value);

	/**
	 * Returns the value of the '<em><b>Conflicting</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.superimposition.ConflictingEntities}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflicting</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflicting</em>' reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflict_Conflicting()
	 * @model
	 * @generated
	 */
	EList<ConflictingEntities> getConflicting();

	/**
	 * Returns the value of the '<em><b>Conflict Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.sidiff.superimposition.ConflictSet#getConflicts <em>Conflicts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflict Set</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflict Set</em>' container reference.
	 * @see #setConflictSet(ConflictSet)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflict_ConflictSet()
	 * @see org.sidiff.superimposition.ConflictSet#getConflicts
	 * @model opposite="conflicts" required="true" transient="false"
	 * @generated
	 */
	ConflictSet getConflictSet();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.Conflict#getConflictSet <em>Conflict Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conflict Set</em>' container reference.
	 * @see #getConflictSet()
	 * @generated
	 */
	void setConflictSet(ConflictSet value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.superimposition.ConflictType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.sidiff.superimposition.ConflictType
	 * @see #setType(ConflictType)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflict_Type()
	 * @model required="true"
	 * @generated
	 */
	ConflictType getType();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.Conflict#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.sidiff.superimposition.ConflictType
	 * @see #getType()
	 * @generated
	 */
	void setType(ConflictType value);

} // Conflict
