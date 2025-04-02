package org.sidiff.conditions;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.ComparatorUtil;
import org.sidiff.comparators.impl.ECMatched;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * This condition checks if the parents of the elements are matched. In case
 * they are, true is returned, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null and have parents.
 * 
 * @author Pit Pietsch
 */
public class ParentMatchedCondition extends AbstractCondition {
	public static final String CONDITION_ID = "ParentMatchedCondition";

	private ECMatched comparator = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sidiff.core.comparefunctions.conditions.Condition#init(org.sidiff.
	 * common.services.ServiceContext)
	 */
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy) {
		super.init(dedicatedClass, policy);
		comparator = (ECMatched) ComparatorUtil.getComparator("ECMatched");
		comparator.init(dedicatedClass, null, null);
	}

	/**
	 * Checks of the parents of the two given nodes are corresponding.
	 * 
	 * It is assured by assertion that both nodes are not null, as well as that
	 * both nodes have parents
	 * 
	 * @see org.sidiff.core.comparefunctions.conditions.AbstractCondition#check(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean check(EObject node1, EObject node2) {

		return 1f == comparator.compare(node1, node2, Collections.singleton(node1.eContainer()),
				Collections.singleton(node2.eContainer()));
	}

	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "This condition checks if the parents of the elements are matched. In case they are, true is returned, otherwise false.";
	}

}
