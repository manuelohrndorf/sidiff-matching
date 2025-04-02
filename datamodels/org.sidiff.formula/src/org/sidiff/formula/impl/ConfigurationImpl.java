/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.ConfigurationImpl#getVariableAssignments <em>Variable Assignments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";
	/**
	 * The cached value of the '{@link #getVariableAssignments() <em>Variable Assignments</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAssignments()
	 * @generated
	 * @ordered
	 */
	protected EMap<Variable, Boolean> variableAssignments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<Variable, Boolean> getVariableAssignments() {
		if (variableAssignments == null) {
			variableAssignments = new EcoreEMap<>(FormulaPackage.Literals.VARIABLE_ASSIGNMENT, VariableAssignmentImpl.class, this, FormulaPackage.CONFIGURATION__VARIABLE_ASSIGNMENTS);
		}
		return variableAssignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void init(Formula formula) {
		for(Variable variable : formula.getVariables()){
			getVariableAssignments().put(variable, false);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String export() {
		StringBuilder builder = new StringBuilder();
		Set<String> variableNames = new HashSet<>();
		for (Variable variable : variableAssignments.keySet()) {
			if (variableAssignments.get(variable)) {
				variableNames.add(variable.getName());
			}
		}
		List<String> orderedVariableNames = new ArrayList<>(variableNames);
		Collections.sort(orderedVariableNames);
		for (String variableName : orderedVariableNames) {
			builder.append(variableName);
			builder.append(System.lineSeparator());
		}
		return builder.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FormulaPackage.CONFIGURATION__VARIABLE_ASSIGNMENTS:
				return ((InternalEList<?>)getVariableAssignments()).basicRemove(otherEnd, msgs);
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
			case FormulaPackage.CONFIGURATION__VARIABLE_ASSIGNMENTS:
				if (coreType) return getVariableAssignments();
				else return getVariableAssignments().map();
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
			case FormulaPackage.CONFIGURATION__VARIABLE_ASSIGNMENTS:
				((EStructuralFeature.Setting)getVariableAssignments()).set(newValue);
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
			case FormulaPackage.CONFIGURATION__VARIABLE_ASSIGNMENTS:
				getVariableAssignments().clear();
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
			case FormulaPackage.CONFIGURATION__VARIABLE_ASSIGNMENTS:
				return variableAssignments != null && !variableAssignments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FormulaPackage.CONFIGURATION___INIT__FORMULA:
				init((Formula)arguments.get(0));
				return null;
			case FormulaPackage.CONFIGURATION___EXPORT:
				return export();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConfigurationImpl
