package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;

/**
 * This comparator checks if two elements are matched. If they are matched 1f is
 * returned, otherwise 0f.
 * 
 * This comparator does not need a parameter.
 * 
 * @author Pit Pietsch
 *
 */
public class ECMatched extends AbstractElementComparator {

	/**
	 * Checks if the two elements to be compared are already matched. If they
	 * are matched 1f is returned, otherwise 0f
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		// test if one or both elements are null. should be already handled in
		// the AbstractComparator class
		assert (elementA != null && elementB != null) : "at least one element is null!";

		if (getCorrespondences().isCorresponding(elementA, elementB)) {
			return 1.0f;
		}
		return 0.0f;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator checks if two elements are matched. If they are matched 1f is returned, otherwise 0f.");
	}
}
