package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.SimilaritiesServiceUtil;

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
	public static final String COMPARATOR_ID = "ECSimilarity";
	/**
	 * The SimilarityService used by this comparator
	 */
	private ISimilarities similaritiesService = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sidiff.core.comparefunctions.abstractcomparators.AbstractComparator
	 * #init(org.sidiff.common.services.ServiceContext)
	 */
	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, null);
		similaritiesService = SimilaritiesServiceUtil.getSimilaritiesServiceInstance();
	}

	/**
	 * The similarity-value of the two elements is returned.
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		return similaritiesService.getSimilarityDegree(elementA, elementB);
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator looks up and returns the similarity-value of two elements.";
	}
}
