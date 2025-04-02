package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;

/**
 * This comparator checks whether two elements are matched. If they are matched
 * 1f is returned. If they are not corresponding the similarity-value between
 * them is looked up and returned.<br>
 * <br>
 *
 * This comparator does not need a parameter.<br>
 * <br>
 * 
 * 
 * @author Pit Pietsch
 */
public class ECMatchedOrSimilar extends AbstractElementComparator {

	/**
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {
		if (getCorrespondences().isCorresponding(elementA, elementB)) {
			return 1.0f;
		}
		return getSimilarities().getSimilarityDegree(elementA, elementB);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("* This comparator checks whether two elements are matched."
				+ " If they are matched 1f is returned. If they are not corresponding the similarity-value "
				+ " between them is looked up and returned.");
	}
}
