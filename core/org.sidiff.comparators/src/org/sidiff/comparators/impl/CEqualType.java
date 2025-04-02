package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

/**
 * This comparator compares two object based on their class. The returned
 * similarity is<br>
 * <ul>
 * <li>1f in case the given objects are of equal-type or
 * <li>0f in case they differ.
 * </ul>
 * No additional parameters are necessary to use this comparator.<br>
 * <br>
 * 
 * The following example-configuration shows how to use the CEqualType
 * comparator to compare two Elements based on their type. In case they are of
 * equal type, 1f is returned, 0f otherwise. <br>
 * <br>
 * 
 * &lt;CompareFunction class="SelfCF" weight="1" parameter="CEqualType"/&gt;
 * 
 * @author Pit Pietsch
 */
@Deprecated
public class CEqualType extends AbstractValueComparator {
	public static final String COMPARATOR_ID = "CEqualType";

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, null);
	}

	/**
	 * Compares two elements based on their .equals()-method. In case the
	 * elements are equal a similarity-value of 1f is returned, 0f otherwise.
	 * <br>
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractComparator#compare(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB) {

		return elementA.getClass().equals(elementB.getClass()) ? 1.0f : 0.0f;
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator compares two object based on their class. The returned  similarity is "
				+ "1f in case the given objects are of equal-type or 0f in case they differ."
				+ " No additional parameters are necessary to use this comparator.";

	}
}
