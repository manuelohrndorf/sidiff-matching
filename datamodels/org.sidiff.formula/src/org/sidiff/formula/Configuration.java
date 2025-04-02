/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.Configuration#getVariableAssignments <em>Variable Assignments</em>}</li>
 * </ul>
 *
 * @see org.sidiff.formula.FormulaPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Variable Assignments</b></em>' map.
	 * The key is of type {@link org.sidiff.formula.Variable},
	 * and the value is of type {@link java.lang.Boolean},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Assignments</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Assignments</em>' map.
	 * @see org.sidiff.formula.FormulaPackage#getConfiguration_VariableAssignments()
	 * @model mapType="org.sidiff.formula.VariableAssignment&lt;org.sidiff.formula.Variable, org.eclipse.emf.ecore.EBooleanObject&gt;"
	 * @generated
	 */
	EMap<Variable, Boolean> getVariableAssignments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void init(Formula formula);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String export();

} // Configuration
