package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.abstractcomperators.AbstractComparator;

/**
 * This comparator mimics the characteristics of a heaviside-function. It
 * compares two object based on the specified inner comparator and in case the
 * similarity-value returned by the inner comparator is below the given
 * threshold 0f is returned, otherwise 1f.<br>
 * 
 * The parameter of this comparefunction specifies at position<br>
 * <ul>
 * <li>0: The inner comparator and it's configuration
 * <li>1: The threshold used for the heaviside-decision.
 * </ul>
 * 
 * The following example-configuration shows how to use the CHeviside comparator
 * in combination with ECSimilarity to compare two elements based on their
 * similarity. In case the similarity-value is above the specified threshold
 * (here 0.5f) a similarity of 1f is returned, 0f otherwise.<br>
 * <br>
 * 
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="CHeaviside[ECSimilarity;0.5]"/&gt;
 * 
 * @see org.sidiff.core.comparators.comparefunctions.comparators.ECSimilarity
 * 
 * @author Pit Pietsch
 */
public class CHeaviside extends AbstractComparator {

	private AbstractComparator comparator = null;
	private float threshold = -1f;

	/**
	 * init.
	 * 
	 * @param dedicatedClass
	 *            the Class this comparator is used on
	 * @param parameter
	 *            the parameter for this comparator
	 */
	@Override
	protected void init(String parameter) {
		String[] paramItems = NestedParameterUtil.getParameterSegments(parameter);

		// first parameter: inner comparator
		comparator = loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractComparator.class, getCorrespondences(), getSimilarities());

		// second parameter: threshold
		threshold = Float.parseFloat(paramItems[1]);
	}

	/**
	 * Compares two Elements based on the specified inner comparator. If the
	 * returned similarity-value is below the given threshold, 0f is returned,
	 * otherwise 1f.
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractComparator#compare(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA, Object elementB) {
		return comparator.compare(contextElementA, contextElementB, elementA, elementB) < threshold ? 0.0f : 1.0f;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator mimics the characteristics of a heaviside-function. It"
				+ " compares two object based on the specified inner comparator and in case the"
				+ " similarity-value returned by the inner comparator is below the given"
				+ " threshold 0f is returned, otherwise 1f");
	}
}
