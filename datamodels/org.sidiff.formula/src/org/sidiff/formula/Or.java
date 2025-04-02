/**
 */
package org.sidiff.formula;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.Or#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @see org.sidiff.formula.FormulaPackage#getOr()
 * @model
 * @generated
 */
public interface Or extends BinaryFormula {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	@Override
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.sidiff.formula.FormulaPackage#getOr_Priority()
	 * @model default="3" required="true" changeable="false"
	 * @generated
	 */
	int getPriority();

} // Or
