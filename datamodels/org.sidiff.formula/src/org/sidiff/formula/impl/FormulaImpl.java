/**
 * (c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved
 */
package org.sidiff.formula.impl;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaFactory;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Operator;
import org.sidiff.formula.Variable;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formula</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sidiff.formula.impl.FormulaImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.sidiff.formula.impl.FormulaImpl#getSatSolverAdapter <em>Sat Solver Adapter</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FormulaImpl extends MinimalEObjectImpl.Container implements Formula {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The default value of the '{@link #getSatSolverAdapter() <em>Sat Solver Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatSolverAdapter()
	 * @generated
	 * @ordered
	 */
	protected static final ISatSolverAdapter SAT_SOLVER_ADAPTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSatSolverAdapter() <em>Sat Solver Adapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSatSolverAdapter()
	 * @generated
	 * @ordered
	 */
	protected ISatSolverAdapter satSolverAdapter = SAT_SOLVER_ADAPTER_EDEFAULT;
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormulaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormulaPackage.Literals.FORMULA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract EList<Variable> getVariables();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ISatSolverAdapter getSatSolverAdapter() {
		return satSolverAdapter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSatSolverAdapter(ISatSolverAdapter newSatSolverAdapter) {
		ISatSolverAdapter oldSatSolverAdapter = satSolverAdapter;
		satSolverAdapter = newSatSolverAdapter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormulaPackage.FORMULA__SAT_SOLVER_ADAPTER, oldSatSolverAdapter, satSolverAdapter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract boolean eval(Configuration config);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract Formula equivalent();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract Formula deMorgan();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract Formula distributive(Operator op);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract Formula associative();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract Formula simplify();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula cnf() {
		return this.equivalent().deMorgan().distributive(Operator.OR).associative();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Formula dnf() {
		return this.equivalent().deMorgan().distributive(Operator.AND).associative();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract int getPriority();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws TimeoutException 
	 * @throws SatSolverAdapterException 
	 * @generated NOT
	 */
	@Override
	public EList<Configuration> getValidConfigurations(int timeout) throws SatSolverAdapterException {
		EList<Configuration> validConfigurations = new BasicEList<Configuration>();
		Map<String, Set<Variable>> variables = new HashMap<String, Set<Variable>>();

		for (Variable variable : this.getVariables()) {
			if (variables.get(variable.getName()) == null) {
				variables.put(variable.getName(), new HashSet<Variable>());
			}
			variables.get(variable.getName()).add(variable);
		}
		
		if (getSatSolverAdapter() != null) {
			Set<SatResult> satResults = getSatSolverAdapter().findAllSolutions(this, Duration.ofSeconds(timeout));
			for (SatResult satResult : satResults) {

				List<String> orderedVariableNames = new ArrayList<String>(satResult.getAssignments().keySet().stream()
						.filter(key -> satResult.getAssignments().get(key).equals("X")).collect(Collectors.toList()));
				Collections.sort(orderedVariableNames);
				int bit_count = orderedVariableNames.size();

				for (int i = 0; i < Math.pow(2, bit_count); i++) {
					int[] bits = new int[bit_count];
					char[] binaryChar = Integer.toBinaryString(i).toCharArray();
					for (int j = 0; j < bit_count; j++) {
						int index = binaryChar.length - bit_count + j;
						if (index < 0) {
							bits[j] = 0;
						} else {
							bits[j] = Integer.parseInt(String.valueOf(binaryChar[index]));
						}
					}

					Configuration config = FormulaFactory.eINSTANCE.createConfiguration();
					config.init(this);
					for (String variable : satResult.getAssignments().keySet()) {
						String assignment = satResult.getAssignments().get(variable);
						if (!assignment.equals("X")) {
							for (Variable v : variables.get(variable)) {
								config.getVariableAssignments().put(v, Boolean.parseBoolean(assignment));
							}
						}
					}

					for (int j = 0; j < bit_count; j++) {
						String variableName = orderedVariableNames.get(j);
						int variableValue = bits[j];
						for (Variable variable : variables.get(variableName)) {
							config.getVariableAssignments().put(variable, variableValue == 1 ? true : false);
						}
					}

					validConfigurations.add(config);
				}
			}
		} else {

			List<String> orderedVariableNames = new ArrayList<String>(variables.keySet());
			Collections.sort(orderedVariableNames);
			int bit_count = orderedVariableNames.size();

			for (int i = 0; i < Math.pow(2, bit_count); i++) {
				int[] bits = new int[bit_count];
				char[] binaryChar = Integer.toBinaryString(i).toCharArray();
				for (int j = 0; j < bit_count; j++) {
					int index = binaryChar.length - bit_count + j;
					if (index < 0) {
						bits[j] = 0;
					} else {
						bits[j] = Integer.parseInt(String.valueOf(binaryChar[index]));
					}
				}

				Configuration config = FormulaFactory.eINSTANCE.createConfiguration();
				config.init(this);
				for (int j = 0; j < bit_count; j++) {
					String variableName = orderedVariableNames.get(j);
					int variableValue = bits[j];
					for (Variable variable : variables.get(variableName)) {
						config.getVariableAssignments().put(variable, variableValue == 1 ? true : false);
					}
				}
				if (this.eval(config)) {
					validConfigurations.add(config);
				}
			}
		}
		return validConfigurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public abstract EList<Formula> getAssociativeFormulas(EClass type);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public SatResult isSatisfiable() throws SatSolverAdapterException {
		ISatSolverAdapter adapter = getSatSolverAdapter();
		if(adapter == null) {
			throw new IllegalStateException("SAT Solver Adapter is not set");
		}
		return adapter.isSatisfiable(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormulaPackage.FORMULA__VARIABLES:
				return getVariables();
			case FormulaPackage.FORMULA__SAT_SOLVER_ADAPTER:
				return getSatSolverAdapter();
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
			case FormulaPackage.FORMULA__SAT_SOLVER_ADAPTER:
				setSatSolverAdapter((ISatSolverAdapter)newValue);
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
			case FormulaPackage.FORMULA__SAT_SOLVER_ADAPTER:
				setSatSolverAdapter(SAT_SOLVER_ADAPTER_EDEFAULT);
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
			case FormulaPackage.FORMULA__VARIABLES:
				return !getVariables().isEmpty();
			case FormulaPackage.FORMULA__SAT_SOLVER_ADAPTER:
				return SAT_SOLVER_ADAPTER_EDEFAULT == null ? satSolverAdapter != null : !SAT_SOLVER_ADAPTER_EDEFAULT.equals(satSolverAdapter);
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
			case FormulaPackage.FORMULA___EVAL__CONFIGURATION:
				return eval((Configuration)arguments.get(0));
			case FormulaPackage.FORMULA___EQUIVALENT:
				return equivalent();
			case FormulaPackage.FORMULA___DE_MORGAN:
				return deMorgan();
			case FormulaPackage.FORMULA___DISTRIBUTIVE__OPERATOR:
				return distributive((Operator)arguments.get(0));
			case FormulaPackage.FORMULA___ASSOCIATIVE:
				return associative();
			case FormulaPackage.FORMULA___SIMPLIFY:
				try {
					return simplify();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FormulaPackage.FORMULA___CNF:
				return cnf();
			case FormulaPackage.FORMULA___DNF:
				return dnf();
			case FormulaPackage.FORMULA___GET_PRIORITY:
				return getPriority();
			case FormulaPackage.FORMULA___GET_VALID_CONFIGURATIONS__INT:
				try {
					return getValidConfigurations((Integer)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FormulaPackage.FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS:
				return getAssociativeFormulas((EClass)arguments.get(0));
			case FormulaPackage.FORMULA___IS_SATISFIABLE:
				try {
					return isSatisfiable();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (satSolverAdapter: ");
		result.append(satSolverAdapter);
		result.append(')');
		return result.toString();
	}

} //FormulaImpl
