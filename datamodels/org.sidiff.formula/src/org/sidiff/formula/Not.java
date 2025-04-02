/**
 */
package org.sidiff.formula;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.Not#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @see org.sidiff.formula.FormulaPackage#getNot()
 * @model
 * @generated
 */
public interface Not extends UnaryFormula {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	@Override
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.sidiff.formula.FormulaPackage#getNot_Priority()
	 * @model default="1" required="true" changeable="false"
	 * @generated
	 */
	int getPriority();

} // Not
