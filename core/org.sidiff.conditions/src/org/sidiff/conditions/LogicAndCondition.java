package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
@Deprecated
public class LogicAndCondition extends AbstractLogicCondition {
	public static final String CONDITION_ID = "LogicAndCondition";
	
	
	@Override
	public boolean check(EObject node1, EObject node2) {
		assert(getConditions().size()>=2);
		boolean result = true;
		for (ICondition condition : getConditions()) {
			result &= condition.check(node1, node2);
		}
		return result;
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
		return "LogicAndCondition";
	}
}
