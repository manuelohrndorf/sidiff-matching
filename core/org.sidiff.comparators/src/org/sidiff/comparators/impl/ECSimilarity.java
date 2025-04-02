package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;

/**
 * This comparator looks up and returns the similarity-value of two elements.
 * 
 * <br>
 * <br>
 * This comparator does not need a parameter.<br>
 * <br>
 * 
 * @author Pit Pietsch
 */
public class ECSimilarity extends AbstractElementComparator {

	/**
	 * The similarity-value of the two elements is returned.
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		return getSimilarities().getSimilarityDegree(elementA, elementB);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator looks up and returns the similarity-value of two elements.");
	}
}
