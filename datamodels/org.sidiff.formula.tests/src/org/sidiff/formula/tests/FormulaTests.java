/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>formula</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class FormulaTests extends TestSuite {

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
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new FormulaTests("formula Tests");
		suite.addTestSuite(VariableTest.class);
		suite.addTestSuite(NotTest.class);
		suite.addTestSuite(AndTest.class);
		suite.addTestSuite(OrTest.class);
		suite.addTestSuite(XorTest.class);
		suite.addTestSuite(ImpliesTest.class);
		suite.addTestSuite(ConfigurationTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaTests(String name) {
		super(name);
	}

} //FormulaTests
