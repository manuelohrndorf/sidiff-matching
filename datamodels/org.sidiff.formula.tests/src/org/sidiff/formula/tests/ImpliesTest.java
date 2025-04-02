/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula.tests;

import org.sidiff.formula.Formula;
import org.sidiff.formula.Implies;
import org.sidiff.formula.Not;
import org.sidiff.formula.Or;
import org.sidiff.formula.Variable;
import org.sidiff.formula.util.FormulaUtil;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Implies</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImpliesTest extends BinaryFormulaTest {

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
		TestRunner.run(ImpliesTest.class);
	}

	/**
	 * Constructs a new Implies test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpliesTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Implies test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Implies getFixture() {
		return (Implies)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		Variable leftVariable = FormulaUtil.createVariable("v_left");
		Variable rightVariable = FormulaUtil.createVariable("v_right");
		Implies implies = FormulaUtil.createImplies(leftVariable, rightVariable);
		setFixture(implies);
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
	 * Tests the '{@link org.sidiff.formula.Implies#equivalent() <em>Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.Implies#equivalent()
	 * @generated NOT
	 */
	public void testEquivalent() {
		Formula formula = this.getFixture().equivalent();
		assertTrue(formula instanceof Or);
		Or or = (Or) formula;
		assertTrue(or.getLeft() instanceof Not);
		Not not_left = (Not) or.getLeft();
		assertTrue (not_left.getFormula() instanceof Variable);
		Variable not_variable = (Variable) not_left.getFormula();
		assertTrue(not_variable != this.getFixture().getLeft() && not_variable.getName().equals(((Variable)this.getFixture().getLeft()).getName()));
		assertTrue(or.getRight() instanceof Variable);
		Variable right_variable = (Variable) or.getRight();
		assertTrue(right_variable != this.getFixture().getRight() && right_variable.getName().equals(((Variable)this.getFixture().getRight()).getName()));
	}

} //ImpliesTest
