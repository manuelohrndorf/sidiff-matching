/**
 */
package org.sidiff.formula;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.Variable#getName <em>Name</em>}</li>
 *   <li>{@link org.sidiff.formula.Variable#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.sidiff.formula.Variable#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.sidiff.formula.FormulaPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Formula {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.sidiff.formula.FormulaPackage#getVariable_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.sidiff.formula.Variable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	@Override
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.sidiff.formula.FormulaPackage#getVariable_Priority()
	 * @model default="0" required="true" changeable="false"
	 * @generated
	 */
	int getPriority();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sidiff.formula.VariationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.sidiff.formula.VariationType
	 * @see #setType(VariationType)
	 * @see org.sidiff.formula.FormulaPackage#getVariable_Type()
	 * @model required="true"
	 * @generated
	 */
	VariationType getType();

	/**
	 * Sets the value of the '{@link org.sidiff.formula.Variable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.sidiff.formula.VariationType
	 * @see #getType()
	 * @generated
	 */
	void setType(VariationType value);

} // Variable
