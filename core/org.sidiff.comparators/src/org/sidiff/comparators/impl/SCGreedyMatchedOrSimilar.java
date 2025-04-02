package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractGreedySetComparator;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.SimilaritiesServiceUtil;

/**
 * This comparator calculates a similarity value between two sets of elements
 * based on matchings and similarities. The greedy algorithm used is parted in 3
 * steps: <br>
 * <br>
 * 
 * (1) In a first step the algorithm looks for matches. Every match is deemed as
 * a similarity of 1f and added to a temporary similarity value. <br>
 * (2) In a second step a greedy algorithm tries to match the rest of the
 * elements as best as possible based on their similarity. The similarity-value
 * of every found element-pair is added to the temporary similarity. <br>
 * (3) In a last step the temporary similarity is normalized by the size of the
 * bigger element-set and the calculated similarity is returned. <br>
 * <br>
 *
 * This comparator does not need a parameter.
 * 
 */
public class SCGreedyMatchedOrSimilar extends AbstractGreedySetComparator {
	public static final String COMPARATOR_ID = "SCGreedyMatchedOrSimilar";
	private ISimilarities similaritiesService = null;
	private ICorrespondences correspondencesService = null;

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, null);
		similaritiesService = SimilaritiesServiceUtil.getSimilaritiesServiceInstance();
		correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
	}

	@Override
	protected float getRating(EObject a, EObject b) {
		if (correspondencesService.isCorresponding(a, b))
			return 1.0f;
		else
			return similaritiesService.getSimilarityDegree(a, b);
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return " This comparator calculates a similarity value between two sets of "
				+ "elements based on matchings and similarities. The greedy algorithm used is parted in 3 steps:";
	}
}
