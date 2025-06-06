/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula.tests;

import junit.textui.TestRunner;

import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.Not;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NotTest extends UnaryFormulaTest {

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
		TestRunner.run(NotTest.class);
	}

	/**
	 * Constructs a new Not test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Not test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Not getFixture() {
		return (Not)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(FormulaFactory.eINSTANCE.createNot());
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

} //NotTest
