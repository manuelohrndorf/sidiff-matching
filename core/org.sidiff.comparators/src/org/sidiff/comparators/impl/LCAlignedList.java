package org.sidiff.comparators.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.abstractcomperators.AbstractListComparator;
import org.sidiff.comparators.abstractcomperators.AbstractSingleComparator;

/**
 * This comparator compares two aligned list of the same size (this constrained
 * is tested by assertion) element by element. How the single elements are to be
 * compared is specified by the inner comparator. The element-wise calculated
 * similarity values are added and normalized by the size of the lists. <br>
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: The inner comparator and it's configuration<br>
 * <li>1: (optional) "weak" if the list are not required to have the same size
 * </ul>
 * 
 * The following example-configuration shows how to use the LCAlignedList
 * comparator in combination with ECMatched. The children of the dedicated class
 * are compared based on whether they are already matched or not. To use
 * LCAlignedList the the children have to be ordered and of the same number.<br>
 * <br>
 *
 * &lt;CompareFunction class="ChildrenCF" weight="1"
 * parameter="LCAlignedList[ECMatched]"/&gt;
 * 
 * @see org.sidiff.core.comparators.comparefunctions.comparators.ECMatched
 * 
 * @author Pit Pietsch
 */
public class LCAlignedList extends AbstractListComparator {

	private static final String WEAK = "weak";

	private AbstractSingleComparator comparator = null;

	private boolean equalLengthRequired = true;

	@Override
	protected void init(String parameter) {
		String[] paramItems = NestedParameterUtil.getParameterSegments(parameter);
		// first parameter: comparator
		comparator = loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractSingleComparator.class, getCorrespondences(), getSimilarities());

		if (paramItems.length > 1) {
			if (WEAK.equalsIgnoreCase(paramItems[1])) {
				equalLengthRequired = false;
			}
		}
	}

	/**
	 * The passed lists of elements are compared element by element based on the
	 * inner comparator. The element-wise calculated similarity-values are added
	 * and normalized by the size of the lists.
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractListComparator#compare(java.util.List,
	 *      java.util.List)
	 */
	@Override
	protected float calculateListSimilarity(EObject contextElementA, EObject contextElementB, List<EObject> listA,
			List<EObject> listB) {

		if (equalLengthRequired) {
			assert(listA.size() == listB.size()) : "This comparator can only be used with lists of the same size!";
		}

		float simValue = 0f;
		int minSize = Math.min(listA.size(), listB.size());
		int maxSize = Math.max(listA.size(), listB.size());

		for (int i = 0; i < listA.size(); i++) {
			if (i < minSize) {
				simValue += comparator.compare(contextElementA, contextElementB, Collections.singleton(listA.get(i)),
						Collections.singleton(listB.get(i)));
			}
		}

		return simValue / maxSize;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator compares two aligned list of the same size (this constrained is tested by assertion)"
				+ " element by element. How the single elements are to be "
				+ "compared is specified by the inner comparator. The element-wise calculated similarity "
				+ "values are added and normalized by the size of the lists");
	}
}
