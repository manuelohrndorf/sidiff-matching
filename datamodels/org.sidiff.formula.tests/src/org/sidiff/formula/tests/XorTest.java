/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula.tests;

import junit.textui.TestRunner;

import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.Xor;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Xor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class XorTest extends BinaryFormulaTest {

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
		TestRunner.run(XorTest.class);
	}

	/**
	 * Constructs a new Xor test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XorTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Xor test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Xor getFixture() {
		return (Xor)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FormulaFactory.eINSTANCE.createXor());
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

} //XorTest
