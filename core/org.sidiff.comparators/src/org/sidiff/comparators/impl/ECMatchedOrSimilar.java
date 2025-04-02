package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.comparators.events.MatchInformationUsedEvent;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.event.EventUtil;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.SimilaritiesServiceUtil;

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
	public static final String COMPARATOR_ID = "ECMatchedOrSimilar";
	/**
	 * The SimilarityService used by this comparator
	 */
	private ISimilarities similaritiesService = null;

	/**
	 * The CorrespondenceService used by this comparator
	 */
	private ICorrespondences correspondencesService = null;

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, null);
		similaritiesService = SimilaritiesServiceUtil.getSimilaritiesServiceInstance();
		correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
	}

	/**
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {
		if (correspondencesService.isCorresponding(elementA, elementB)) {
			EventUtil.fireEvent(
					new MatchInformationUsedEvent(this, MatchInformationUsedEvent.USED_MATCH, elementA, elementB));
			return 1.0f;
		} else
			return similaritiesService.getSimilarityDegree(elementA, elementB);
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "* This comparator checks whether two elements are matched."
				+ " If they are matched 1f is returned. If they are not corresponding the similarity-value "
				+ " between them is looked up and returned.";
	}
}
