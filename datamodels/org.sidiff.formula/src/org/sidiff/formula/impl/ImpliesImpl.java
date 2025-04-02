/**
 */
package org.sidiff.formula.impl;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Implies;
import org.sidiff.formula.Not;
import org.sidiff.formula.Or;
import org.sidiff.formula.parser.FormulaParser;
import org.sidiff.formula.util.FormulaUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implies</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.ImpliesImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImpliesImpl extends BinaryFormulaImpl implements Implies {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 4;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpliesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.IMPLIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormulaPackage.IMPLIES__PRIORITY:
				return getPriority();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FormulaPackage.IMPLIES__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();
		return FormulaParser.INSTANCE.unparse(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eval(Configuration config) {
		return !left.eval(config) || right.eval(config);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT 
	 */
	@Override
	public Formula equivalent() {
		Or or = FormulaFactory.eINSTANCE.createOr();
		Not notLeft = FormulaFactory.eINSTANCE.createNot();
		notLeft.setFormula(this.getLeft().equivalent());
		or.setLeft(notLeft);
		or.setRight(this.getRight().equivalent());
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula simplify() {
		Formula left = this.getLeft().simplify();
		Formula right = this.getRight().simplify();

		Boolean leftBool = FormulaUtil.getBooleanValue(left).orElse(null);
		Boolean rightBool = FormulaUtil.getBooleanValue(right).orElse(null);

		if((leftBool != null && leftBool == false)
				|| (rightBool != null && rightBool == true)) {
			return FormulaUtil.createTrue();
		}
		if(leftBool != null && rightBool != null
				&& leftBool == true && rightBool == false) {
			return FormulaUtil.createFalse();
		}
		if(leftBool != null && leftBool == true) {
			return right;
		}
		if(rightBool != null && rightBool == false) {
			return FormulaUtil.createNot(left);
		}
		return FormulaUtil.createImplies(left, right);
	}

} //ImpliesImpl
