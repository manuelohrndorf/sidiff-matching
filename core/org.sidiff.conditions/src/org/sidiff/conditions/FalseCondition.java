package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * This condition always returns false;
 * 
 * @author Pit Pietsch
 */
public class FalseCondition extends AbstractCondition {
	public static final String CONDITION_ID = "FalseCondition";

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy) {
		super.init(dedicatedClass, policy);

	}

	@Override
	public boolean check(EObject node1, EObject node2) {
		return false;
	}
	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "This condition always returns false";
	}
}
