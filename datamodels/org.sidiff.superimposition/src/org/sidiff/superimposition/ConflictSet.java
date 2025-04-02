/**
 * (c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.superimposition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conflict Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.superimposition.ConflictSet#getContext <em>Context</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictSet#getConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictSet#getConflicts <em>Conflicts</em>}</li>
 *   <li>{@link org.sidiff.superimposition.ConflictSet#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictSet()
 * @model
 * @generated
 */
public interface ConflictSet extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch and Robert Mueller, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(SuperimposedModel)
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictSet_Context()
	 * @model required="true"
	 * @generated
	 */
	SuperimposedModel getContext();

	/**
	 * Sets the value of the '{@link org.sidiff.superimposition.ConflictSet#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(SuperimposedModel value);

	/**
	 * Returns the value of the '<em><b>Conflicting</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.superimposition.ConflictingEntities}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.superimposition.ConflictingEntities#getConflictSet <em>Conflict Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflicting</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflicting</em>' containment reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictSet_Conflicting()
	 * @see org.sidiff.superimposition.ConflictingEntities#getConflictSet
	 * @model opposite="conflictSet" containment="true"
	 * @generated
	 */
	EList<ConflictingEntities> getConflicting();

	/**
	 * Returns the value of the '<em><b>Conflicts</b></em>' containment reference list.
	 * The list contents are of type {@link org.sidiff.superimposition.Conflict}.
	 * It is bidirectional and its opposite is '{@link org.sidiff.superimposition.Conflict#getConflictSet <em>Conflict Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflicts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conflicts</em>' containment reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictSet_Conflicts()
	 * @see org.sidiff.superimposition.Conflict#getConflictSet
	 * @model opposite="conflictSet" containment="true"
	 * @generated
	 */
	EList<Conflict> getConflicts();

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.superimposition.ConflictingEntities}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.sidiff.superimposition.SuperimpositionModelPackage#getConflictSet_Inputs()
	 * @model
	 * @generated
	 */
	EList<ConflictingEntities> getInputs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the highest severity of all contained conflicts.
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	ConflictSeverity computeSeverity();

} // ConflictSet
