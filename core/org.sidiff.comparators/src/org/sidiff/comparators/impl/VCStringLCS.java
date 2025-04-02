package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.lcs.StringLCSUtil;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

/**
 * This comparator compares two string values based on a longest common
 * subsequence calculation. It is assured by assertion that the two values are
 * of the type string.
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: Indication whether the strings are to be compared case-insensitive
 * (ci) or not (cs)
 * </ul>
 *
 * The following example-configuration shows how to use the VCStringLCS
 * comparator to compare the name-attributes from elements of type Operation
 * with an case-sensitive longest common subsequence calculation. <br>
 * <br>
 *
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAttributeStatic[VCStringLCS[cs];Operation;name]"/&gt;
 *
 * WARNING: this comparefunction is expensive and should only be used sparsly
 * and wisely
 * 
 * @author Pit Pietsch
 */

public class VCStringLCS extends AbstractValueComparator {

	/**
	 * indicates whether a case-sensitive (false) or case-insensitive (true)
	 * comparison is to be used.
	 */
	private boolean ci = false;

	@Override
	public void init(String parameter) {
		// case sensitivity ? default: case-sensitive
		if (parameter.equals("ci")) {
			this.ci = true;
		}
	}

	/**
	 * Calculates the similarity of two string values based on the longest
	 * common subsequence. It is assured by assertion that the two values are of
	 * the strings.
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractComparator#compare(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object objectA,
			Object objectB) {

		String stringA = (String) objectA;
		String stringB = (String) objectB;

		if (ci) {
			return StringLCSUtil.compareStringIgnoringCase(stringA, stringB);
		}
		return StringLCSUtil.compareStringConsideringCase(stringA, stringB);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator compares two string values based on a longest common subsequence calculation. "
				+ "It is assured by assertion that the two values are of the type string.");
	}
}
