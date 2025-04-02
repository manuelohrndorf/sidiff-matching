package org.sidiff.comparators.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractSetComparator;
import org.sidiff.correspondences.exceptions.ExternalElementException;

/**
 * This comparator counts the number of matched elements between to sets and
 * normalize the sum by dividing through the number of elements in the bigger
 * set. <br>
 * <br>
 *
 * It is assured by assertion that this comparator can only be used for 1:1
 * matchings.<br>
 * <br>
 * 
 * This comparator does not need a parameter.<br>
 * <br>
 * 
 * 
 * @author Pit Pietsch
 */
public class SCMatched extends AbstractSetComparator {

	/**
	 * The number of matched elements between to sets are counted and the sum is
	 * normalized by dividing through the number of elements in the bigger set. <br>
	 * <br>
	 * 
	 * It is assured by assertion that this comparator can only be used for 1:1
	 * matchings.
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractSetComparator#compare(java.util.Collection,
	 *      java.util.Collection)
	 */
	@Override
	protected float calculateSetSimilarity(EObject contextElementA, EObject contextElementB,
			Collection<EObject> collectionA, Collection<EObject> collectionB) {

		float totalSimilarity = 0.0f;

		List<EObject> copyOfCollectionB = new ArrayList<>(collectionB);
		EObject partner;

		// Loop through nodes in set A
		for (EObject nodeInA : collectionA) {
			Collection<EObject> partners;
			try {
				partners = getCorrespondences().getCorrespondences(nodeInA);
				// only 1 partner
				assert (partners.size() <= 1) : "incorrect number of partners";
				partner = partners.isEmpty() ? null : partners.iterator().next();
			} catch (ExternalElementException e) {
				partner = nodeInA;
			}

			if (partner != null) {
				if (copyOfCollectionB.contains(partner)) {
					copyOfCollectionB.remove(partner);
					totalSimilarity++;
				}
			}
		}

		// normalize similarity
		return totalSimilarity / Math.max(collectionA.size(), collectionB.size());
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator counts the number of matched elements between to sets and"
				+ " normalize the sum by dividing through the number of elements in the bigger set.");
	}

}
