package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.comparators.events.MatchInformationUsedEvent;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.event.EventUtil;

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
	public static final String COMPARATOR_ID = "ECMatched";
	/**
	 * The correspondenceService used by this comparator
	 */
	private ICorrespondences correspondencesService = null;

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, null);
		correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
	}

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

		if (correspondencesService.isCorresponding(elementA, elementB)) {
			EventUtil.fireEvent(new MatchInformationUsedEvent(this, MatchInformationUsedEvent.USED_MATCH,
					elementA, elementB));
			return 1.0f;
		} else
			return 0.0f;

	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator checks if two elements are matched. If they are matched 1f is returned, otherwise 0f.";
	}
}
