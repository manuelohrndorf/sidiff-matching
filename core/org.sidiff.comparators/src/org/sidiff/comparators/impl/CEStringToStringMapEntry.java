package org.sidiff.comparators.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

/**
 * This comparator compares two EStringToStringMapEntry objects as used within
 * Ecore. The keys of the entries are compared with .equals(), the values are
 * compared by the comparator given as parameter.
 * 
 * To compare the complete map, the CEStringToStringMapEntry comparator should
 * be encapsulated by the LCAlignedList comparator.
 * 
 * Example usage: <CompareFunction class="NeighboursSingleReferenceCF"
 * policy="fulfilled" weight="0.1" parameter=
 * "LCAlignedList[CEStringToStringMapEntry[VCStringLCS[cs]]];details"/>
 * 
 * @author wenzel
 * 
 */
public class CEStringToStringMapEntry extends AbstractValueComparator {
	public static final String COMPARATOR_ID = "CEStringToStringMapEntry";
	private AbstractValueComparator comparator = null;

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, parameter);
		comparator = (AbstractValueComparator) loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractValueComparator.class);
	}

	/**
	 * Compares two elements based on their .equals()-method. In case the
	 * elements are equal a similarity-value of 1f is returned, 0f otherwise.<br>
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractComparator#compare(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB) {

		// TODO (TK, 14.12.2011): Warum liefert uebergeordneter LCAlignedList
		// comparator Collections f. elementA und elementB...?
		EStringToStringMapEntryImpl meA = (EStringToStringMapEntryImpl) ((Collection) elementA).iterator().next();
		EStringToStringMapEntryImpl meB = (EStringToStringMapEntryImpl) ((Collection) elementB).iterator().next();

		if (meA.getKey().equals(meB.getKey()))
			return comparator.compare(contextElementA, contextElementB, meA.getValue(), meB.getValue());
		else
			return 0f;
	}
	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator compares two EStringToStringMapEntry objects as used within Ecore. "
				+ "The keys of the entries are compared with .equals(), the values are"
				+ " compared by the comparator given as parameter.";
	}
}
