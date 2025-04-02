package org.sidiff.conditions;

import org.eclipse.emf.ecore.EObject;

public class LogicOrCondition extends AbstractLogicCondition {

	@Override
	public boolean check(EObject node1, EObject node2) {
		assert(getConditions().size()>=2);
		boolean result = false;
		for (ICondition condition : getConditions()) {
			result |= condition.check(node1, node2);
		}
		return result;
	}
}
