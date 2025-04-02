/**
 */
package org.sidiff.formula.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Not;
import org.sidiff.formula.*;
import org.sidiff.formula.parser.FormulaParser;
import org.sidiff.formula.util.FormulaUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.NotImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NotImpl extends UnaryFormulaImpl implements Not {
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
	protected static final int PRIORITY_EDEFAULT = 1;

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
	protected NotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.NOT;
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
			case FormulaPackage.NOT__PRIORITY:
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
			case FormulaPackage.NOT__PRIORITY:
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
		return !formula.eval(config);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula deMorgan() {
		if(this.getFormula() instanceof And) {
			And and = (And) this.getFormula();
			Or or = FormulaFactory.eINSTANCE.createOr();
			Not notLeft = FormulaFactory.eINSTANCE.createNot();
			notLeft.setFormula(EcoreUtil.copy(and.getLeft()));
			or.setLeft(notLeft);
			Not notRight = FormulaFactory.eINSTANCE.createNot();
			notRight.setFormula(EcoreUtil.copy(and.getRight()));
			or.setRight(notRight);
			return or.deMorgan();
		}else if(this.getFormula() instanceof Or) {
			Or or = (Or) this.getFormula();
			And and = FormulaFactory.eINSTANCE.createAnd();
			Not notLeft = FormulaFactory.eINSTANCE.createNot();
			notLeft.setFormula(EcoreUtil.copy(or.getLeft()));
			and.setLeft(notLeft);
			Not notRight = FormulaFactory.eINSTANCE.createNot();
			notRight.setFormula(EcoreUtil.copy(or.getRight()));
			and.setRight(notRight);
			return and.deMorgan();
		}else if(this.getFormula() instanceof Not) {
			Not not = (Not) this.getFormula();
			return EcoreUtil.copy(not.getFormula()).deMorgan();
		}else {
			Not not = FormulaFactory.eINSTANCE.createNot();
			not.setFormula(this.getFormula().deMorgan());
			return not;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula simplify() {
		Formula formula = this.getFormula().simplify();
		if(formula instanceof Not) {
			// not(not(f)) -> f 
			return ((Not)formula).getFormula();
		}
		Boolean bool = FormulaUtil.getBooleanValue(formula).orElse(null);
		if(bool != null) {
			// not(true/false) -> false/true
			return FormulaUtil.createVariable(Boolean.toString(!bool));
		}
		return FormulaUtil.createNot(formula);
	}

} //NotImpl
