package org.sidiff.comparators.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractSetComparator;

/**
 * This comparator compares two collections based on their .size()-method. The
 * returned similarity is<br>
 * <ul>
 * <li>1f in case the given collections have the same size or
 * <li>0f in case their size differ.
 * </ul>
 * No additional parameters are necessary to use this comparator.<br>
 * <br>
 * 
 * The following example-configuration shows how to use the SCSize comparator to
 * compare two (Method-)elements based on their number of operations.<br>
 * <br>
 *
 * &lt;CompareFunction class="NeighborsSingleReferenceCF" weight="1"
 * parameter="SCSize;operations"/&gt;
 * 
 * @author wenzel
 *
 */
public class SCSize extends AbstractSetComparator {
	public static final String COMPARATOR_ID = "SCSize";

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, null);

	}

	protected float calculateSetSimilarity(EObject contextElementA, EObject contextElementB,
			Collection<EObject> collectionA, Collection<EObject> collectionB) {

		return (collectionA.size() == collectionB.size()) ? 1.0f : 0.0f;
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator compares two collections based on their .size()-method";
	}
}
