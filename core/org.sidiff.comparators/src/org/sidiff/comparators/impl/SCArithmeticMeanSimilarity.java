package org.sidiff.comparators.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractSetComparator;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.ISimilarity;
import org.sidiff.similarities.SimilaritiesServiceUtil;

/**
 * Calculates the similarity of two sets according to the following formula:
 * sim(A,B) = (sum(sim(a,b))/A.size + sum(sim(b,a))/B.size) / 2 = sim(B,A),
 * where sim(a,b) is the highest similarity of an element a with respect to the
 * elements of B.
 * 
 * This similarity is symmetric, i.e. sim(A,B) = sim(B,A)
 * 
 * This comparator does not need a parameter.
 * 
 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractSetComparator#compare(java.util.Collection,
 *      java.util.Collection)
 *
 * @author Timo Kehrer
 */
@Deprecated
public class SCArithmeticMeanSimilarity extends AbstractSetComparator {
	public static final String COMPARATOR_ID = "SCArithmeticMeanSimilarity";
	/**
	 * The SimilarityService used by this comparator
	 */
	private ISimilarities similaritiesService = null;

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, null);
		similaritiesService = SimilaritiesServiceUtil.getSimilaritiesServiceInstance();
	}

	/**
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractSetComparator#compare(java.util.Collection,
	 *      java.util.Collection)
	 */
	public float calculateSetSimilarity(EObject contextElementA, EObject contextElementB,
			Collection<EObject> collectionA, Collection<EObject> collectionB) {

		// calculate sums
		float sumA = 0.0f;
		float sumB = 0.0f;
		for (EObject objectA : collectionA) {
			sumA += getHighestSimilarityInSet(objectA, collectionB);
		}
		for (EObject objectB : collectionB) {
			sumA += getHighestSimilarityInSet(objectB, collectionA);
		}

		// calculate arithmetic mean
		return (sumA / collectionA.size() + sumB / collectionB.size()) / 2;
	}

	/**
	 * Get highest similarity degree for "element" in "collection".
	 * 
	 * @param object
	 * @param collection
	 * @return
	 */
	private float getHighestSimilarityInSet(EObject object, Collection<EObject> collection) {
		for (ISimilarity sim : similaritiesService.getSimilarities(object)) {
			if (collection.contains(sim.getSimilarObject())) {
				return sim.getSimilarity();
			}
		}

		return 0.0f;
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return " * Calculates the similarity of two sets according to the "
				+ "following formula: sim(A,B) = (sum(sim(a,b))/A.size + sum(sim(b,a))/B.size) / 2 = sim(B,A), "
				+ " here sim(a,b) is the highest similarity of an element a with respect to the elements of B.";
	}
}
