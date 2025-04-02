/**
 */
package org.sidiff.formula;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.Formula#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.sidiff.formula.Formula#getSatSolverAdapter <em>Sat Solver Adapter</em>}</li>
 * </ul>
 *
 * @see org.sidiff.formula.FormulaPackage#getFormula()
 * @model abstract="true"
 * @generated
 */
public interface Formula extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link org.sidiff.formula.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see org.sidiff.formula.FormulaPackage#getFormula_Variables()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sat Solver Adapter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sat Solver Adapter</em>' attribute.
	 * @see #setSatSolverAdapter(ISatSolverAdapter)
	 * @see org.sidiff.formula.FormulaPackage#getFormula_SatSolverAdapter()
	 * @model dataType="org.sidiff.formula.ISatSolverAdapter"
	 * @generated
	 */
	ISatSolverAdapter getSatSolverAdapter();

	/**
	 * Sets the value of the '{@link org.sidiff.formula.Formula#getSatSolverAdapter <em>Sat Solver Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sat Solver Adapter</em>' attribute.
	 * @see #getSatSolverAdapter()
	 * @generated
	 */
	void setSatSolverAdapter(ISatSolverAdapter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean eval(Configuration config);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Formula deMorgan();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" opRequired="true"
	 * @generated
	 */
	Formula distributive(Operator op);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Formula associative();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" exceptions="org.sidiff.formula.SatSolverAdapterException"
	 * @generated
	 */
	Formula simplify() throws SatSolverAdapterException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Formula cnf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Formula dnf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getPriority();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.sidiff.formula.SatSolverAdapterException" timeoutRequired="true"
	 * @generated
	 */
	EList<Configuration> getValidConfigurations(int timeout) throws SatSolverAdapterException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	EList<Formula> getAssociativeFormulas(EClass type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.sidiff.formula.SatResult" required="true" exceptions="org.sidiff.formula.SatSolverAdapterException"
	 * @generated
	 */
	SatResult isSatisfiable() throws SatSolverAdapterException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	Formula equivalent();

} // Formula
