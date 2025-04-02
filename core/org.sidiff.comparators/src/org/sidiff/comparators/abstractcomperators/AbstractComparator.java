package org.sidiff.comparators.abstractcomperators;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.IComparator;
import org.sidiff.comparators.exceptions.CannotInstantiateComparatorException;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * marker class that defines the basic behaviour of the comparator, e.g. on what
 * kind of data structure (an element, a set of elements, a list of...) the
 * comparator will work and how to process these structures. How datastructure
 * are compared is defined in the implementations
 */
public abstract class AbstractComparator implements IComparator {

	protected EClass dedicatedClass;
	protected EClass targetClass;

	private ICorrespondences correspondences;
	private ISimilarities similarities;

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
	protected void init(EClass dedicatedClass, EClass targetClass, ICorrespondences correspondences, ISimilarities similarities) {
		// original context class
		this.dedicatedClass = dedicatedClass;

		// classes that the comparators will work on
		this.targetClass = targetClass;

		this.correspondences = Objects.requireNonNull(correspondences, "correspondences must be set");
		this.similarities = Objects.requireNonNull(similarities, "similarities must be set");
	}

	protected void init(String parameter) {

	}

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter, ICorrespondences correspondences,
			ISimilarities similarities) {
		this.init(dedicatedClass, targetClass, correspondences, similarities);
		this.init(parameter);
	}

	@Override
	public float compare(EObject contextElementA, EObject contextElementB, Object elementA, Object elementB) {
		// check if both objects are null
		if (elementA == null && elementB == null) {
			// throw new NothingToCompareException("Both objects are null and therefore can't be compared");
			return 1.0f;
		}
			
		// check if one of the objects is null
		if (elementA == null || elementB == null) {
			return 0f;			
		}

		// otherwise, return calculate similarity value
		return calculateSimilarity(contextElementA, contextElementB, elementA, elementB);

	}

	protected abstract float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB);

	protected ICorrespondences getCorrespondences() {
		return correspondences;
	}
	
	protected ISimilarities getSimilarities() {
		return similarities;
	}

	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}

	/**
	 * static method that is used to load comparators reflectivly based on a
	 * parameter string
	 */
	public static <C extends IComparator> C loadComparator(String parameter, EClass dedicatedClass,
			EClass targetClass, Class<C> comparatorClass, ICorrespondences correspondences, ISimilarities similarities) {
		try {
			if (NestedParameterUtil.hasNestedParameter(parameter)) {
				String[] parts = NestedParameterUtil.splitCompositeParamter(parameter);
				IComparator comparator = IComparator.MANAGER.getExtension(parts[0]).get();
				comparator.init(dedicatedClass, targetClass, parts[1], correspondences, similarities);
				return comparatorClass.cast(comparator);
			}
			IComparator comparator = IComparator.MANAGER.getExtension(parameter).get();
			comparator.init(dedicatedClass, targetClass, null, correspondences, similarities);
			return comparatorClass.cast(comparator);
		} catch (Exception e) {
			throw new CannotInstantiateComparatorException("Cannot instantiate comparator '" + parameter + "'", e);
		}
	}
}
