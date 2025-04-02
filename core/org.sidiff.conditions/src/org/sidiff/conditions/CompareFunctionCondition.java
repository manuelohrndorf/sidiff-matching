package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * DEPRECATED
 * unausgereiftes Konzept - nicht verwenden!
 */

/**
 * This condition uses a comparefunction to perform the check. If the
 * comparefunction returns a similarity value above the threshold the condition
 * is true, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Pit Pietsch
 *
 */
@Deprecated
public class CompareFunctionCondition extends AbstractCondition {
	public static final String CONDITION_ID = "CompareFunctionCondition";
	/*
	 * The comparefunction for to check the condition
	 */
	private ICompareFunction conditionCF = null;

	/*
	 * Threshold
	 */
	private float threshold = -1f;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sidiff.core.comparefunctions.conditions.Condition#init(org.sidiff.
	 * common.services.ServiceContext)
	 */
	/**
	 * @param dedicatedClass
	 * @param policy
	 * @param parameter
	 *            the threshold
	 * @param conditionCF
	 *            the comparefunction used in this condition
	 */
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter, ICompareFunction conditionCF) {
		super.init(dedicatedClass, policy, parameter);
		this.conditionCF = conditionCF;
		// parameter: threshold
		this.threshold = Float.parseFloat(parameter);
	}

	/**
	 * Calls the inner comparefunctions .compare()-method to check the
	 * condition. In case the returned similarity is above the threshold true is
	 * returned, otherwise false.
	 * 
	 * @see org.sidiff.conditions.AbstractCondition#check(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean check(EObject node1, EObject node2) {

		if (conditionCF.compare(node1, node2) > this.threshold)
			return true;
		else
			return false;
	}

	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return " This condition uses a comparefunction to perform the check. If the comparefunction returns a similarity value above the threshold the condition is true, otherwise false.";
	}

}
