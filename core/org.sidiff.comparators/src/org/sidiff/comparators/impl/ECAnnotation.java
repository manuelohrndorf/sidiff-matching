package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;
import org.sidiff.comparators.exceptions.NothingToCompareException;

/**
 * This comparator compares a specified annotation of two elements based on the
 * specified inner comparator. It is tested by assertion whether the annotations
 * exists or not.
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: The inner comparator and it's configuration<br>
 * <li>1: The name of the annotation to be compared<br>
 * </ul>
 *
 * If both nodes do have the specified annotation a NothingToCompareException is
 * thrown. If only one node has the specified annotation a similarity of 0f is
 * returned
 *
 * The following example-configuration shows how to use the ECAnnotation
 * comparator to compare two elements based on the equality of their
 * TypePath-annotation. In case both attribute-values are equal 1f is returned,
 * 0f otherwise.<br>
 * <br>
 *
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAnnotation[CEquals;TypePath]"/&gt;
 * 
 * @see org.sidiff.core.comparefunctions.comparators.CEquals
 * 
 * @author Pit Pietsch
 */
public class ECAnnotation extends AbstractElementComparator {
	public static final String COMPARATOR_ID = "ECAnnotation";
	/**
	 * The inner comparator
	 */
	private AbstractValueComparator comparator = null;

	/**
	 * The name of the annotation
	 */
	private String annotationName = null;

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, parameter);

		// first parameter: comparator
		comparator = (AbstractValueComparator) loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractValueComparator.class);

		// second annotation name
		this.annotationName = paramItems[1];
	}

	/**
	 * The specified annotation is extracted from both elements and a similarity
	 * value is calculated by the inner comparator. It is assured by assertion
	 * that the annotation exist in both elements.
	 * 
	 * @see org.sidiff.core.comparefunctions.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		AnnotateableElement annotateableElementA = EMFAdapter.INSTANCE.adapt(elementA, AnnotateableElement.class);
		AnnotateableElement annotateableElementB = EMFAdapter.INSTANCE.adapt(elementB, AnnotateableElement.class);

		// both annotations do not exists: -> NothingToCompareException
		if (annotateableElementA.getAnnotation(annotationName, Object.class) == null
				&& annotateableElementB.getAnnotation(annotationName, Object.class) == null)
			throw new NothingToCompareException("Both annotations do not exist");

		// only one annotation exist: --> return 0f
		if (annotateableElementA.getAnnotation(annotationName, Object.class) == null
				|| annotateableElementB.getAnnotation(annotationName, Object.class) == null)
			return 0f;

		return comparator.compare(contextElementA, contextElementB,
				annotateableElementA.getAnnotation(annotationName, Object.class),
				annotateableElementB.getAnnotation(annotationName, Object.class));
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator compares a specified annotation of two elements"
				+ " based on the specified inner comparator. It is tested by assertion whether the annotations "
				+ "exists or not.";
	}
}
