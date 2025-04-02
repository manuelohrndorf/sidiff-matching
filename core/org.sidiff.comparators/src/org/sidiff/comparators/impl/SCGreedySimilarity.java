package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractGreedySetComparator;

/**
 * The calculation of the similarity value is separated in two parts:<br>
 * <br>
 * 
 * (1) In a first step the algorithm looks tries to match the elements as best
 * as possible based on their similarity. The similarity-value of every found
 * element-pair is added to the temporary similarity. <br>
 * (2) In a second step the temporary similarity is normalized by the size of
 * the bigger element-set and the calculated similarity is returned. <br>
 * <br>
 * 
 * This comparator does not need a parameter.
 * 
 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractSetComparator#compare(java.util.Collection,
 *      java.util.Collection)
 *
 */
public class SCGreedySimilarity extends AbstractGreedySetComparator {

	@Override
	protected float getRating(EObject objectA, EObject objectB) {
		return getSimilarities().getSimilarityDegree(objectA, objectB);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("The calculation of the similarity value is separated in two parts:  "
				+ "(1) In a first step the algorithm looks tries to match the elements as best as possible based on their similarity. "
				+ "The similarity-value of every found element-pair is added to the temporary similarity. "
				+ " (2) In a second step the temporary similarity is normalized by the size of the bigger "
				+ "element-set and the calculated similarity is returned");
	}
}
