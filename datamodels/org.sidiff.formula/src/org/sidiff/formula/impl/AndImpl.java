/**
 */
package org.sidiff.formula.impl;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.formula.And;
import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Operator;
import org.sidiff.formula.Or;
import org.sidiff.formula.parser.FormulaParser;
import org.sidiff.formula.util.FormulaUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.AndImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AndImpl extends BinaryFormulaImpl implements And {
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
	protected static final int PRIORITY_EDEFAULT = 2;

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
	protected AndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.AND;
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
			case FormulaPackage.AND__PRIORITY:
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
			case FormulaPackage.AND__PRIORITY:
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
		return left.eval(config) && right.eval(config);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * TODO test
	 */
	@Override
	public Formula distributive(Operator op) {
		if(op.equals(Operator.AND)) {
			if(this.getLeft() instanceof Or) {
				Or thisLeft = (Or) this.getLeft();
				
				Formula orLeft = thisLeft.getLeft().distributive(op);
				Formula orRight = thisLeft.getRight().distributive(op);
				
				And andLeft = FormulaFactory.eINSTANCE.createAnd();
				
				andLeft.setLeft(orLeft);
				andLeft.setRight(this.getRight().distributive(op));
				
				And andRight = FormulaFactory.eINSTANCE.createAnd();
				
				andRight.setLeft(orRight);
				andRight.setRight(this.getRight().distributive(op));
				
				Or or = FormulaFactory.eINSTANCE.createOr();
				or.setLeft(andLeft.distributive(op));
				or.setRight(andRight.distributive(op));
				
				return or;
			}else if(this.getRight() instanceof Or) {
				Or thisRight = (Or) this.getRight();
				
				Formula orLeft = thisRight.getLeft().distributive(op);
				Formula orRight = thisRight.getRight().distributive(op);
				
				And andLeft = FormulaFactory.eINSTANCE.createAnd();
				
				andLeft.setLeft(this.getLeft().distributive(op));
				andLeft.setRight(orLeft);
				
				And andRight = FormulaFactory.eINSTANCE.createAnd();
				
				andRight.setLeft(this.getLeft().distributive(op));
				andRight.setRight(orRight);;
				
				Or or = FormulaFactory.eINSTANCE.createOr();
				or.setLeft(andLeft.distributive(op));
				or.setRight(andRight.distributive(op));
				
				return or;
			} else if(this.getLeft() instanceof And || this.getRight() instanceof And){
				And and = FormulaFactory.eINSTANCE.createAnd();
				and.setLeft(this.getLeft().distributive(op));
				and.setRight(this.getRight().distributive(op));
				if(and.getLeft() instanceof Or || and.getRight() instanceof Or) {
					return and.distributive(op);
				}else {
					return and;
				}
			}
		}
		
		return super.distributive(op);
		
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
				|| (rightBool != null && rightBool == false)) {
			return FormulaUtil.createFalse();
		}
		if(leftBool != null && rightBool != null
				&& leftBool == true && rightBool == true) {
			return FormulaUtil.createTrue();
		}
		if(leftBool != null && leftBool == true) {
			return right;
		}
		if(rightBool != null && rightBool == true) {
			return left;
		}
		return FormulaUtil.createAnd(left, right);
	}

} //AndImpl
