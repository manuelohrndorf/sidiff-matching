package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

public interface ICondition {
	public static final String EXTENSION_POINT_ID = "org.sidiff.conditions.extensionpoint";
	public static final String CONDITION_ID = "ICondition";

	public String getParameter();

	/**
	 * Get the compare function's Meta-Model
	 * 
	 * @return Returns the compare function's weight
	 */
	public EClass getEClass();

	/**
	 * Get the compare function's policy
	 * 
	 * @return Returns the compare function's policy
	 */
	public EvaluationPolicy getPolicy();

	void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter);

	void init(EClass dedicatedClass, EvaluationPolicy policy);

	public boolean check(EObject node1, EObject node2);

	public abstract String getConditionID();

	public abstract String getDescription();

}