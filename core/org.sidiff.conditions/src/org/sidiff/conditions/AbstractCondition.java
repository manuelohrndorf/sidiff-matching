//TODO review & documentation & usage of conditions (PP & HS  2 day)
//TODO test of condition mechanism (PP & HS  1 day)
//TODO add functionality to be able to later use it on any number of elements (PP & HS 1 day)
//TODO add functionality for using OCL constraints to validate conditions (PP & HS 1 day)

package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

@Deprecated
public abstract class AbstractCondition implements ICondition {

	/**
	 * The compare function's policy
	 */
	private EvaluationPolicy policy = null;

	/**
	 * The compare condition's meta-model-element
	 */
	private EClass dedicatedClass = null;

	/**
	 * The compare condition's parameter
	 */
	private String parameter = null;

	public void init(EClass dedicatedClass, EvaluationPolicy policy) {
		init(dedicatedClass, policy, null);
	}

	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter) {
		this.parameter = parameter;
		this.dedicatedClass = dedicatedClass;
		this.policy = policy;
	}

	public String getParameter() {

		return this.parameter;
	}

	public EClass getEClass() {
		return this.dedicatedClass;
	}

	public EvaluationPolicy getPolicy() {

		return policy;
	}

	public abstract boolean check(EObject node1, EObject node2);

	public String toString() {
		return this.getClass().getName() + "(" + getEClass().getName() + ", " + getParameter() + ")";
	}

}
