package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

/**
 * This comparator compares two object based on their .equals()-method. The
 * returned similarity is<br>
 * <ul>
 * <li>1f in case the given objects are equal or
 * <li>0f in case they differ.
 * </ul>
 * No additional parameters are necessary to use this comparator.<br>
 * <br>
 * 
 * The following example-configuration shows how to use the CEquals comparator
 * to compare two (Operation-)elements based on their "isStatic"-Attribute. In
 * case the values of the isStatic-attributes are equal, 1f is returned, 0f
 * otherwise. <br>
 * <br>
 *
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAttributeStatic[CEquals;Operation;isStatic]"/&gt;
 * 
 * @see org.sidiff.core.comparators.ECAttributeStatic
 * 
 * @author Pit Pietsch
 */
public class CEquals extends AbstractValueComparator {

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

		return elementA.equals(elementB) ? 1.0f : 0.0f;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Compares two elements based on their .equals()-method. In case the "
				+ "elements are equal a similarity-value of 1f is returned, 0f otherwise");
	}
}
