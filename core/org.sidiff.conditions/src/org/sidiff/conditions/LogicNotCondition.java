package org.sidiff.conditions;

import org.eclipse.emf.ecore.EObject;

public class LogicNotCondition extends AbstractLogicCondition {

	@Override
	public boolean check(EObject node1, EObject node2) {
		assert(getConditions().size()==1);
		return !getConditions().get(0).check(node1, node2);
	}
}
