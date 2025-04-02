/**
 */
package org.sidiff.formula.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.formula.And;
import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Not;
import org.sidiff.formula.Or;
import org.sidiff.formula.Xor;
import org.sidiff.formula.parser.FormulaParser;
import org.sidiff.formula.util.FormulaUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.XorImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XorImpl extends BinaryFormulaImpl implements Xor {
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
	protected static final int PRIORITY_EDEFAULT = 3;

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
	protected XorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.XOR;
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
			case FormulaPackage.XOR__PRIORITY:
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
			case FormulaPackage.XOR__PRIORITY:
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
		return left.eval(config) != right.eval(config);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula equivalent() {
		Or or = FormulaFactory.eINSTANCE.createOr();
		Formula left = this.getLeft().equivalent();
		Formula right = this.getRight().equivalent();
		Not notLeft = FormulaFactory.eINSTANCE.createNot();
		notLeft.setFormula(EcoreUtil.copy(left));
		Not notRight = FormulaFactory.eINSTANCE.createNot();
		notRight.setFormula(EcoreUtil.copy(right));
		And andLeft = FormulaFactory.eINSTANCE.createAnd();
		andLeft.setLeft(notLeft);
		andLeft.setRight(right);
		
		And andRight = FormulaFactory.eINSTANCE.createAnd();
		andRight.setLeft(left);
		andRight.setRight(notRight);
		
		or.setLeft(andLeft);
		or.setRight(andRight);
		
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

		if(leftBool != null && rightBool != null) {
			if(Boolean.logicalXor(leftBool, rightBool)) {
				return FormulaUtil.createTrue();
			}
			if(leftBool.equals(rightBool)) {
				return FormulaUtil.createFalse();
			}			
		}
		if(leftBool != null) {
			if(leftBool == false) {
				return right;
			}
			if(leftBool == true) {
				return FormulaUtil.createNot(right);
			}			
		}
		if(rightBool != null) {
			if(rightBool == false) {
				return left;
			}
			if(rightBool == true) {
				return FormulaUtil.createNot(left);
			}			
		}

		return FormulaUtil.createXor(left, right);
	}

} //XorImpl
