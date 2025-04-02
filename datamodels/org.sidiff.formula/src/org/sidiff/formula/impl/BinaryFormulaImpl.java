/**
 */
package org.sidiff.formula.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.sidiff.formula.BinaryFormula;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Operator;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Formula</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.BinaryFormulaImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.sidiff.formula.impl.BinaryFormulaImpl#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BinaryFormulaImpl extends FormulaImpl implements BinaryFormula {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeft()
	 * @generated
	 * @ordered
	 */
	protected Formula left;

	/**
	 * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRight()
	 * @generated
	 * @ordered
	 */
	protected Formula right;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryFormulaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.BINARY_FORMULA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Variable> getVariables() {
		EList<Variable> variables = new BasicEList<>();
		variables.addAll(left.getVariables());
		variables.addAll(right.getVariables());
		return new EcoreEList.UnmodifiableEList<>(this,FormulaPackage.Literals.FORMULA__VARIABLES, variables.size(), variables.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Formula getLeft() {
		return left;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeft(Formula newLeft, NotificationChain msgs) {
		Formula oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormulaPackage.BINARY_FORMULA__LEFT, oldLeft, newLeft);
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
	public void setLeft(Formula newLeft) {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject)left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormulaPackage.BINARY_FORMULA__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject)newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormulaPackage.BINARY_FORMULA__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormulaPackage.BINARY_FORMULA__LEFT, newLeft, newLeft));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Formula getRight() {
		return right;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRight(Formula newRight, NotificationChain msgs) {
		Formula oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormulaPackage.BINARY_FORMULA__RIGHT, oldRight, newRight);
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
	public void setRight(Formula newRight) {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject)right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormulaPackage.BINARY_FORMULA__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject)newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormulaPackage.BINARY_FORMULA__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormulaPackage.BINARY_FORMULA__RIGHT, newRight, newRight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula equivalent() {
		BinaryFormula binaryFormula_ = (BinaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		binaryFormula_.setLeft(this.getLeft().equivalent());
		binaryFormula_.setRight(this.getRight().equivalent());
		return binaryFormula_;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula deMorgan() {
		BinaryFormula binaryFormula = (BinaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		binaryFormula.setLeft(this.getLeft().deMorgan());
		binaryFormula.setRight(this.getRight().deMorgan());
		return binaryFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula distributive(Operator op) {
		BinaryFormula binaryFormula = (BinaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		binaryFormula.setLeft(this.getLeft().distributive(op));
		binaryFormula.setRight(this.getRight().distributive(op));
		return binaryFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula associative() {
		List<Formula> associativeFormulas = getAssociativeFormulas(this.eClass());
		
		BinaryFormula binaryFormula = (BinaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
		Formula sortedFormula = binaryFormula;
		for(int i = 0; i<associativeFormulas.size()-1; i++) {

			binaryFormula.setLeft(associativeFormulas.get(i).associative());
			
			if(i<associativeFormulas.size()-2) {
			BinaryFormula nestedBinaryFormula = (BinaryFormula) FormulaFactory.eINSTANCE.create(this.eClass());
				
			binaryFormula.setRight(nestedBinaryFormula);
			binaryFormula = nestedBinaryFormula;
			}else {
				binaryFormula.setRight(associativeFormulas.get(++i).associative());
			}
		}
		
		return sortedFormula;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<Formula> getAssociativeFormulas(EClass type) {
		EList<Formula> associativeFormulas = new BasicEList<>();
		if(this.eClass().equals(type)) {
			associativeFormulas.addAll(getLeft().getAssociativeFormulas(type));
			associativeFormulas.addAll(getRight().getAssociativeFormulas(type));
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
			case FormulaPackage.BINARY_FORMULA__LEFT:
				return basicSetLeft(null, msgs);
			case FormulaPackage.BINARY_FORMULA__RIGHT:
				return basicSetRight(null, msgs);
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
			case FormulaPackage.BINARY_FORMULA__LEFT:
				return getLeft();
			case FormulaPackage.BINARY_FORMULA__RIGHT:
				return getRight();
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
			case FormulaPackage.BINARY_FORMULA__LEFT:
				setLeft((Formula)newValue);
				return;
			case FormulaPackage.BINARY_FORMULA__RIGHT:
				setRight((Formula)newValue);
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
			case FormulaPackage.BINARY_FORMULA__LEFT:
				setLeft((Formula)null);
				return;
			case FormulaPackage.BINARY_FORMULA__RIGHT:
				setRight((Formula)null);
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
			case FormulaPackage.BINARY_FORMULA__LEFT:
				return left != null;
			case FormulaPackage.BINARY_FORMULA__RIGHT:
				return right != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryFormulaImpl
