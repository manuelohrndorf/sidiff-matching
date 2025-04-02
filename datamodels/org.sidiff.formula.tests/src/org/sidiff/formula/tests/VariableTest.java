/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula.tests;

import junit.textui.TestRunner;

import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.Operator;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VariableTest extends FormulaTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VariableTest.class);
	}

	/**
	 * Constructs a new Variable test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Variable test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Variable getFixture() {
		return (Variable)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FormulaFactory.eINSTANCE.createVariable());
		getFixture().setName("V");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	/**
	 * Tests the '{@link org.sidiff.formula.Variable#equivalent() <em>Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.Variable#equivalent()
	 * @generated NOT
	 */
	public void testEquivalent() {
		Formula formula = this.getFixture().equivalent();
		assertTrue(formula instanceof Variable);
		Variable variable = (Variable) formula;
		assertTrue(variable != this.getFixture() && variable.getName().equals(this.getFixture().getName()));
	}
	
	/**
	 * Tests the '{@link org.sidiff.formula.Variable#deMorgan() <em>De Morgan</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.Variable#deMorgan()
	 * @generated NOT
	 */
	public void testDeMorgan() {
		Formula formula = this.getFixture().equivalent();
		assertTrue(formula instanceof Variable);
		Variable variable = (Variable) formula;
		assertTrue(variable != this.getFixture() && variable.getName().equals(this.getFixture().getName()));
	}
	
	/**
	 * Tests the '{@link org.sidiff.formula.Variable#distributive(org.sidiff.formula.Operator) <em>Distributive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.Variable#distributive(org.sidiff.formula.Operator)
	 * @generated NOT
	 */
	public void testDistributive__Operator() {
		Formula formula = this.getFixture().distributive(Operator.AND);
		assertTrue(formula instanceof Variable);
		Variable variable = (Variable) formula;
		assertTrue(variable != this.getFixture() && variable.getName().equals(this.getFixture().getName()));
		formula = this.getFixture().distributive(Operator.OR);
		assertTrue(formula instanceof Variable);
		variable = (Variable) formula;
		assertTrue(variable != this.getFixture() && variable.getName().equals(this.getFixture().getName()));
	}

} //VariableTest
