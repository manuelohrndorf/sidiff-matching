package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

/**
 * This comparator performs an case-insensitive .equals()-comparison between two
 * Strings. In case they are equals 1f is returned, 0f otherwise. The CEquals
 * comparator should be used for case-sensitive equal-comparison instead.
 * 
 * The comparator needs no additional parameter. It is assured by assertion that
 * object to be compared are of the type strings.
 * 
 * The following example-configuration shows how to use the VCStringEqualsCI
 * comparator to compare the name-attributes from elements of type Operation<br>
 * <br>
 * 
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAttributeStatic[VCStringEqualsCI;Operation;name]"/&gt;
 * 
 * @see CEquals
 * @author Pit Pietsch
 */
@Deprecated
public class VCStringEqualsCI extends AbstractValueComparator {
	public static final String COMPARATOR_ID = "VCStringEqualsCI";

	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object objectA,
			Object objectB) {

		// typecheck
		assert(objectA instanceof String && objectB instanceof String) : "Works only with Strings!";

		return ((String) objectA).toLowerCase().equals(((String) objectB).toLowerCase()) ? 1f : 0f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sidiff.core.comparefunctions.abstractcomparators.AbstractComparator
	 * #init(org.sidiff.common.services.ServiceContext)
	 */
	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator performs an case-insensitive .equals()-comparison between two Strings. "
				+ "In case they are equals 1f is returned, 0f otherwise. The CEquals comparator should be "
				+ "used for case-sensitive equal-comparison instead.";
	}
}
