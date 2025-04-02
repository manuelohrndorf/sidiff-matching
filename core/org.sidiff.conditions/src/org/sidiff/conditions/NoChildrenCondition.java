package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * This condition tests whether both elements do not have children. In case they
 * are true is returned, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Sven Wenzel
 */
public class NoChildrenCondition extends AbstractCondition {

	public static final String CONDITION_ID = "NoChildrenCondition";

	@Override
	public boolean check(EObject node1, EObject node2) {

		return node1.eContents().isEmpty() && node1.eContents().isEmpty();
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
		return "This condition tests whether both elements do not have children. In case they are true is returned, otherwise false.";
	}
}
