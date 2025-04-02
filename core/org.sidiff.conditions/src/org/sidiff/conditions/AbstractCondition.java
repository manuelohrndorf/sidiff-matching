//TODO review & documentation & usage of conditions (PP & HS  2 day)
//TODO test of condition mechanism (PP & HS  1 day)
//TODO add functionality to be able to later use it on any number of elements (PP & HS 1 day)
//TODO add functionality for using OCL constraints to validate conditions (PP & HS 1 day)

package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

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
	
	private ICorrespondences correspondences;
	private ISimilarities similarities;

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter,
			ICorrespondences correspondences, ISimilarities similarities) {

		this.dedicatedClass = dedicatedClass;
		this.policy = policy;
		this.parameter = parameter;
		this.correspondences = correspondences;
		this.similarities = similarities;
	}

	@Override
	public String getParameter() {
		return this.parameter;
	}

	@Override
	public EClass getEClass() {
		return this.dedicatedClass;
	}

	@Override
	public EvaluationPolicy getPolicy() {
		return policy;
	}

	@Override
	public abstract boolean check(EObject node1, EObject node2);

	protected ICorrespondences getCorrespondences() {
		return correspondences;
	}

	protected ISimilarities getSimilarities() {
		return similarities;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "(" + getEClass().getName() + ", " + getParameter() + ")";
	}

	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}
}
