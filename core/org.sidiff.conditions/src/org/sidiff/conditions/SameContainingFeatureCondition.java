package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * This condition tests whether the objects of an element has same type.
 * 
 * Parameter: none
 * 
 * @author Maik Schmidt
 */
public class SameContainingFeatureCondition extends AbstractCondition {
	public static final String CONDITION_ID = "SameContainingFeatureCondition";

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy) {
		super.init(dedicatedClass, policy);

	}

	@Override
	public boolean check(EObject node1, EObject node2) {

		EObject feature1 = node1.eContainingFeature();
		EObject feature2 = node2.eContainingFeature();

		if (feature1 != null && feature2 != null) {
			return feature1 == feature2;
		}

		return false;
	}

	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "This condition tests whether the objects of an element has same type.";
	}
}
