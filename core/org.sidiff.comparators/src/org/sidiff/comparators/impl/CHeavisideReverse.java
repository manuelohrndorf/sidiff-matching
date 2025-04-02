package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractComparator;

/**
 * This comparator compares two object based on the specified inner comparator.
 * In case the similarity-value returned by the inner comparator is below the
 * given threshold 0f is returned, otherwise the calculated similarity value is
 * passed. This comparator is similar to the comparator CHeaviside. <br>
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: The inner comparator and it's configuration<br>
 * <li>1: The threshold used for the heaviside-decision.<br>
 * </ul>
 * 
 * The following example-configuration shows how to use the CHeavisideReverse
 * comparator in combination with ECSimilarity to compare two elements based on
 * their similarity. In case the similarity-value is above the specified
 * 0.5f-threshold 1f is returned, the similarity-value.<br>
 * <br>
 * 
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="CHeavisideReverse[ECSimilarity;0.5]"/&gt;
 * 
 * @see org.sidiff.core.comparators.CHeaviside
 * @see org.sidiff.core.comparators.comparefunctions.comparators.ECSimilarity
 * 
 * @author Pit Pietsch
 */
public class CHeavisideReverse extends AbstractComparator {
	public static final String COMPARATOR_ID = "CHeavisideReverse";
	private AbstractComparator comparator = null;
	private float threshold = -1f;

	/**
	 * Constructor.
	 * 
	 * @param dedicatedClass
	 *            the Class this comparator is used on
	 * @param parameter
	 *            the parameter for this comparator
	 */
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, parameter);

		// first parameter: comparator
		comparator = (AbstractComparator) loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractComparator.class);

		// second parameter: threshold
		threshold = Float.parseFloat(paramItems[1]);

	}

	/**
	 * Compares two Elements based on the specified inner comparator. If the
	 * returned similarity-value is below the given threshold, 0f is returned,
	 * otherwise the similarity-value.
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractComparator#compare(java.lang.Object,
	 *      java.lang.Object)
	 * 
	 */
	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB) {

		float simValue = comparator.compare(contextElementA, contextElementB, elementA, elementB);
		return simValue < threshold ? 0.0f : simValue;
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator compares two object based on the specified inner comparator."
				+ " In case the similarity-value returned by the inner comparator is below the given"
				+ " threshold 0f is returned, otherwise the calculated similarity value is passed."
				+ " This comparator is similar to the comparator CHeaviside.";
	}
}
