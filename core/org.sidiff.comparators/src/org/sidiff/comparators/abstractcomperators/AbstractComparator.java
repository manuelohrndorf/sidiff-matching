package org.sidiff.comparators.abstractcomperators;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.ComparatorUtil;
import org.sidiff.comparators.IComparator;
import org.sidiff.comparators.exceptions.CannotInstantiateComparatorException;
import org.sidiff.comparators.exceptions.NothingToCompareException;

/**
 * marker class that defines the basic behaviour of the comparator, e.g. on what
 * kind of data structure (an element, a set of elements, a list of...) the
 * comparator will work and how to process these structures. How datastructure
 * are compared is defined in the implementations
 */
public abstract class AbstractComparator implements IComparator {

	public static final String COMPARATOR_NAMESPACE = "org.sidiff.comparators.impl.";

	protected String[] paramItems;

	protected EClass dedicatedClass = null;

	protected EClass targetClass = null;

	/**
	 * Simply checks the correctness of the parameter string. If the parameter
	 * string is correct, it is split up into its single fragments.
	 * 
	 * @param contextClass
	 *            The {@link EClass} which provides the context of the
	 *            {@link CompareFunction} in which this comparator is used.
	 * @param targetClasses
	 *            The {@link EClass}es which target of the
	 *            {@link CompareFunction} on which this comparator is used.
	 * @param parameter
	 *            The parameter string for this comparator. The caller of the
	 *            comparator is responsible for extracting the part of the whole
	 *            parameter sting of a {@link CompareFunction} which is
	 *            dedicated to this comparator.
	 */
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		// original context class
		this.dedicatedClass = dedicatedClass;

		// classes that the comparators will work on
		this.targetClass = targetClass;

		if (parameter != null) {
			// Extract single segments of parameter string
			this.paramItems = NestedParameterUtil.getParameterSegments(parameter);
		}
	}

	public float compare(EObject contextElementA, EObject contextElementB, Object elementA, Object elementB) {
		// check if both objects are null. if true throw
		// NothingToCompareException
		if (elementA == null && elementB == null)
			throw new NothingToCompareException("Both objects are null and therefore can't be compared");

		// check if one of the objects is null. if true, 0f is returned
		if (elementA == null || elementB == null)
			return 0f;

		// otherwise, return calculate similarity value
		return calculateSimilarity(contextElementA, contextElementB, elementA, elementB);

	}

	protected abstract float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB);

	/**
	 * static method that is used to load comparators reflectivly based on a
	 * paramter string
	 */

	@SuppressWarnings("hiding")
	public static <AbstractComparator> IComparator loadComparator(String parameter, EClass dedicatedClass,
			EClass targetClass, Class<AbstractComparator> comparatorClass) {
		try {
			if (NestedParameterUtil.hasNestedParameter(parameter)) {
				String[] parts = NestedParameterUtil.splitCompositeParamter(parameter);
				IComparator comparator = ComparatorUtil.getComparator(parts[0]);
				comparator.init(dedicatedClass, targetClass, parts[1]);
				return comparator;
			} else {
				IComparator comparator = ComparatorUtil.getComparator(parameter);
				comparator.init(dedicatedClass, targetClass, null);
				return comparator;
				
			}
		} catch (Exception e) {
			throw new CannotInstantiateComparatorException("Cannot intantiate comparator `" + parameter + "'", e);
		}
	}

	@Override
	public abstract String getComparatorID();

}
