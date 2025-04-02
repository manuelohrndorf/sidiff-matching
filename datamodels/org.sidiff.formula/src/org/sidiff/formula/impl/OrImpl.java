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
 * An implementation of the model object '<em><b>Or</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.OrImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrImpl extends BinaryFormulaImpl implements Or {
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
	protected OrImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.OR;
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
			case FormulaPackage.OR__PRIORITY:
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
			case FormulaPackage.OR__PRIORITY:
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
		return left.eval(config) || right.eval(config);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * TODO test
	 */
	@Override
	public Formula distributive(Operator op) {
		if(op.equals(Operator.OR)) {
			if(this.getLeft() instanceof And) {
				And thisLeft = (And) this.getLeft();
				
				Formula andLeft = thisLeft.getLeft().distributive(op);
				Formula andRight = thisLeft.getRight().distributive(op);
				
				Or orLeft = FormulaFactory.eINSTANCE.createOr();
				
				orLeft.setLeft(andLeft);
				orLeft.setRight(this.getRight().distributive(op));
				
				Or orRight = FormulaFactory.eINSTANCE.createOr();
				
				orRight.setLeft(andRight);
				orRight.setRight(this.getRight().distributive(op));
				
				And and = FormulaFactory.eINSTANCE.createAnd();
				and.setLeft(orLeft.distributive(op));
				and.setRight(orRight.distributive(op));
				
				return and;
			}else if(this.getRight() instanceof And) {
				And thisRight = (And) this.getRight();
				
				Formula andLeft = thisRight.getLeft().distributive(op);
				Formula andRight = thisRight.getRight().distributive(op);
				
				Or orLeft = FormulaFactory.eINSTANCE.createOr();
				
				orLeft.setLeft(this.getLeft().distributive(op));
				orLeft.setRight(andLeft);
				
				Or orRight = FormulaFactory.eINSTANCE.createOr();
				
				orRight.setLeft(this.getLeft().distributive(op));
				orRight.setRight(andRight);;
				
				And and = FormulaFactory.eINSTANCE.createAnd();
				and.setLeft(orLeft.distributive(op));
				and.setRight(orRight.distributive(op));
				
				return and;
			}else if(this.getLeft() instanceof Or || this.getRight() instanceof Or){
				Or or = FormulaFactory.eINSTANCE.createOr();
				or.setLeft(this.getLeft().distributive(op));
				or.setRight(this.getRight().distributive(op));
				if(or.getLeft() instanceof And || or.getRight() instanceof And) {
					return or.distributive(op);
				}else {
					return or;
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

		if((leftBool != null && leftBool == true)
				|| (rightBool != null && rightBool == true)) {
			return FormulaUtil.createTrue();
		}
		if(leftBool != null && rightBool != null
				&& leftBool == false && rightBool == false) {
			return FormulaUtil.createFalse();
		}
		if(leftBool != null && leftBool == false) {
			return right;
		}
		if(rightBool != null && rightBool == false) {
			return left;
		}
		return FormulaUtil.createOr(left, right);
	}

} //OrImpl
