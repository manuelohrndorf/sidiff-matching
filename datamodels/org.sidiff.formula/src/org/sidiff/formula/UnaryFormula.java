/**
 */
package org.sidiff.formula;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.UnaryFormula#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @see org.sidiff.formula.FormulaPackage#getUnaryFormula()
 * @model abstract="true"
 * @generated
 */
public interface UnaryFormula extends Formula {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' containment reference.
	 * @see #setFormula(Formula)
	 * @see org.sidiff.formula.FormulaPackage#getUnaryFormula_Formula()
	 * @model containment="true"
	 * @generated
	 */
	Formula getFormula();

	/**
	 * Sets the value of the '{@link org.sidiff.formula.UnaryFormula#getFormula <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' containment reference.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(Formula value);

} // UnaryFormula
