package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.IComparator;
import org.sidiff.comparators.impl.SCMatched;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * This condition checks if the parents of the elements are matched. In case
 * they are, true is returned, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null and have parents.
 * 
 * @author Pit Pietsch
 */
public class ChildrenMatchedCondition extends AbstractCondition {

	private SCMatched comparator = null;

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter, ICorrespondences correspondences,
			ISimilarities similarities) {
		super.init(dedicatedClass, policy, parameter, correspondences, similarities);
		comparator = IComparator.MANAGER.getExtension(SCMatched.class).get();
		comparator.init(getEClass(), null, null, getCorrespondences(), getSimilarities());
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
		return 1f == comparator.compare(node1, node2, node1.eContents(), node2.eContents());
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of(
				"This condition checks if the parents of the elements are matched. In case they are, true is returned, otherwise false.");
	}
}
