package org.sidiff.comparefunctions.impl;

import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.collections.DefaultComparators;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.comparators.IComparator;
import org.sidiff.comparators.abstractcomperators.AbstractComparator;
import org.sidiff.comparators.exceptions.ComparatorException;
import org.sidiff.comparefunctions.exceptions.CompareException;
import org.sidiff.comparefunctions.exceptions.NothingToCompareException;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

public abstract class AbstractComparatorCompareFunction extends AbstractCompareFunction {

	/**
	 * The compare function's comparator
	 */
	private IComparator cfComparator;

	/**
	 * contains the cached objects for nodes in A, calculated by "getToBeCompared(EObject)"
	 */
	private Map<EObject, Collection<EObject>> staticCacheComparedInA;
	/**
	 * contains the cached objects for nodes in B, calculated by "getToBeCompared(EObject)"
	 */
	private Map<EObject, Collection<EObject>> staticCacheComparedInB;

	private Map<EObject, Map<EObject, Float>> staticCacheSimilarity;
	
	
	/**
	 * The init method that has to be used by subclasses.<br>
	 * Initializes attribute values, extracts parameter segments and checks parameter segment correctness via assertion.<br>
	 * 
	 * @param dedicatedClass
	 *            The dedicated meta-class (out of the document type specific meta-model) on whose instances this compare function operates on.
	 * @param epolicy
	 *            The compare function's policy.
	 * @param weight
	 *            The compare function's weight.
	 * @param parameter
	 *            The compare function's parameter
	 */
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter,
			ICorrespondences correspondences, ISimilarities similarities) {
		super.init(dedicatedClass, policy, weight, parameter, correspondences, similarities);
		this.cfComparator = AbstractComparator.loadComparator(paramItems[0], dedicatedClass,
				getComparedType(dedicatedClass), AbstractComparator.class, correspondences, similarities);
	}
	
	

	/**
	 * Calculates the similarity of two nodes according to the following proceeding:<br>
	 * (1) If one of the origin nodes is null, the calculation is aborted.<br>
	 * (2) If if both neighbour nodes are null, a NothingToCompareException is thrown.<br>
	 * (3) Else if only one of the neighbour nodes is null, a similarity value if 0 is returned <br>
	 * (3) Else a similarity calculation is delegated to the comparator specified as parameter.<br>
	 * 
	 * 
	 * Compares the two nodes on the basis of their neigbour sets given by the reference name and using the specified comparator.
	 * 
	 * @param nodeInA
	 *            The node in model A
	 * @param nodeInB
	 *            The node in model B
	 * @return The calculated similarity
	 * @throws NothingToCompareException
	 *             , if both neighbour sets given by the reference name are empty.
	 */
	@Override
	public float compare(EObject nodeInA, EObject nodeInB) throws NothingToCompareException {
		if (staticCacheSimilarity != null) {
			// caching similarities is active
			float similarity = -1;
			// get Map according to node "fromA"
			Map<EObject, Float> temp = staticCacheSimilarity.get(nodeInA);
			if (temp != null) {
				try {
					similarity = temp.get(nodeInB);
					assert (LogUtil.log(LogEvent.DEBUG, "Using similarity-value from cache: ", similarity, " (", nodeInA, ",", nodeInB, ")"));
					return similarity;
				} catch (NullPointerException e) {
					// no similarity has been cached yet > will be cached on first compare
					assert (LogUtil.log(LogEvent.DEBUG, "No similarity-value can be found in cache (", nodeInA, ",", nodeInB, ")"));
				}
			}
		}

		// define variables
		Collection<EObject> toBeComparedA = null;
		Collection<EObject> toBeComparedB = null;

		// get values from cache, if possible
		if (staticCacheComparedInA != null) {
			toBeComparedA = staticCacheComparedInA.get(nodeInA);
		}
		if (staticCacheComparedInB != null) {
			toBeComparedB = staticCacheComparedInB.get(nodeInB);
		}
		/*
		 * get Collection from "getToBeCompared(...)" and update cache if possible
		 */
		if (toBeComparedA == null) {
			toBeComparedA = getToBeCompared(nodeInA);
			if (staticCacheComparedInA != null) {
				// save collection to cache
				staticCacheComparedInA.put(nodeInA, toBeComparedA);
			}
		}
		if (toBeComparedB == null) {
			toBeComparedB = getToBeCompared(nodeInB);
			if (staticCacheComparedInB != null) {
				// save collection to cache
				staticCacheComparedInB.put(nodeInB, toBeComparedB);
			}
		}

		if (toBeComparedA.isEmpty() && toBeComparedB.isEmpty()) {
			// Let the caller decide what is to do.
			// throw new NothingToCompareException("Both nodes lack of nodes that should be compared!");
			return 1.0f;

		} else if (toBeComparedA.isEmpty() || toBeComparedB.isEmpty()) {
			// Anyway, a comperator just can determ "no similarity"
			return 0.0f;
		} else if ((toBeComparedA.contains(null) && toBeComparedA.size() == 1) || (toBeComparedB.contains(null) && toBeComparedB.size() == 1)) {
			return 0.0f;
			
		} else {
			// Compute similarity
			try {
				float similarity = this.cfComparator.compare(nodeInA, nodeInB, toBeComparedA, toBeComparedB);

				if (staticCacheSimilarity != null) {
					Map<EObject, Float> similaritiesOfA = staticCacheSimilarity.get(nodeInA);
					if (similaritiesOfA == null) {
						// create child-map if it does not exist
						similaritiesOfA = new TreeMap<>(DefaultComparators.getHashComparator(EObject.class));
						staticCacheSimilarity.put(nodeInA, similaritiesOfA);
					}
					// cache similarity in map
					similaritiesOfA.put(nodeInB, similarity);
				}
				// return similarity
				return similarity;
			} catch (ComparatorException e) {
				throw new CompareException("Comparator exception thrown!", e);
			}
		}
	}


	/**
	 * WARNING: if the implementation of the method is used to initialize variables of the subclasses, they MUST NOT be initialized in the declaration, e.g. "String c = null;" because otherwise the constructor of the subclass will override them again.
	 */

	protected abstract Collection<EObject> getToBeCompared(EObject context);

	protected abstract EClass getComparedType(EClass context);
}
