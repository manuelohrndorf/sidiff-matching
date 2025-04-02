package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;



/**
 * This condition always returns true.
 * 
 * @author Pit Pietsch
 */
public class TrueCondition extends AbstractCondition {
	public static final String CONDITION_ID = "TrueCondition";
	

	@Override
	public boolean check(EObject node1, EObject node2) {
		return true;
	}

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy) {
		super.init(dedicatedClass, policy);
		
	}
	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "This condition always returns true.";
	}
}
