package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
@Deprecated
public class LogicXorCondition extends AbstractLogicCondition {
	public static final String CONDITION_ID = "LogicXorCondition";

	@Override
	public boolean check(EObject node1, EObject node2) {
		assert(getConditions().size()>=2);
		int result = 0;
		for (ICondition condition : getConditions()) {
			if (condition.check(node1, node2))
				result++;
		}
		return result == 1;
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
		return "LogicXorCondition";
	}
}
