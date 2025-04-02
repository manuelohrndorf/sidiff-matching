/**
 */
package org.sidiff.formula.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Operator;
import org.sidiff.formula.UnaryFormula;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Formula</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.UnaryFormulaImpl#getFormula <em>Formula</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class UnaryFormulaImpl extends FormulaImpl implements UnaryFormula {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";
	/**
	 * The cached value of the '{@link #getFormula() <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormula()
	 * @generated
	 * @ordered
	 */
	protected Formula formula;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryFormulaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.UNARY_FORMULA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Variable> getVariables() {
		return formula.getVariables();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Formula getFormula() {
		return formula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormula(Formula newFormula, NotificationChain msgs) {
		Formula oldFormula = formula;
		formula = newFormula;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormulaPackage.UNARY_FORMULA__FORMULA, oldFormula, newFormula);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFormula(Formula newFormula) {
		if (newFormula != formula) {
			NotificationChain msgs = null;
			if (formula != null)
				msgs = ((InternalEObject)formula).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormulaPackage.UNARY_FORMULA__FORMULA, null, msgs);
			if (newFormula != null)
				msgs = ((InternalEObject)newFormula).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormulaPackage.UNARY_FORMULA__FORMULA, null, msgs);
			msgs = basicSetFormula(newFormula, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormulaPackage.UNARY_FORMULA__FORMULA, newFormula, newFormula));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula equivalent() {
		UnaryFormula unaryFormula = (UnaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		unaryFormula.setFormula(this.getFormula().equivalent());
		return unaryFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula deMorgan() {
		UnaryFormula unaryFormula = (UnaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		unaryFormula.setFormula(this.getFormula().deMorgan());
		return unaryFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula distributive(Operator op) {
		UnaryFormula unaryFormula = (UnaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		unaryFormula.setFormula(this.getFormula().distributive(op));
		return unaryFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula associative() {
		UnaryFormula unaryFormula = (UnaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		unaryFormula.setFormula(this.getFormula().associative());
		return unaryFormula;
	}
	


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Formula> getAssociativeFormulas(EClass type) {
		EList<Formula> associativeFormulas = new BasicEList<Formula>();
		if(this.eClass().equals(type)) {
			associativeFormulas.addAll(getFormula().getAssociativeFormulas(type));
		}else {
			associativeFormulas.add(this);
		}
		return associativeFormulas;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FormulaPackage.UNARY_FORMULA__FORMULA:
				return basicSetFormula(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormulaPackage.UNARY_FORMULA__FORMULA:
				return getFormula();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FormulaPackage.UNARY_FORMULA__FORMULA:
				setFormula((Formula)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FormulaPackage.UNARY_FORMULA__FORMULA:
				setFormula((Formula)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FormulaPackage.UNARY_FORMULA__FORMULA:
				return formula != null;
		}
		return super.eIsSet(featureID);
	}

} //UnaryFormulaImpl
