package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * This condition tests whether the parents of an element has same type.
 * 
 * Parameter: none
 * 
 * @author Maik Schmidt
 */
public class SameParentTypeCondition extends AbstractCondition {
	public static final String CONDITION_ID = "SameParentTypeCondition";

	@Override
	public boolean check(EObject node1, EObject node2) {

		EObject parent1 = node1.eContainer();
		EObject parent2 = node2.eContainer();

		if (parent1 != null && parent2 != null) {
			return parent1.eClass() == parent2.eClass();
		}
		return false;
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
		return "This condition tests whether the parents of an element has same type.";
	}
}
