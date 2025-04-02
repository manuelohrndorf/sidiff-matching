package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class LogicNotCondition extends AbstractLogicCondition {
	public static final String CONDITION_ID = "LogicNotCondition";

	@Override
	public boolean check(EObject node1, EObject node2) {
		assert(getConditions().size()==1);
		return !getConditions().get(0).check(node1, node2);
	}

	@Override
	public void init(EClass dedicatedClass) {
		super.init(dedicatedClass);
		
	}
	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "LogicNotCondition";
	}
}
