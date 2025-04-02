package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * This conditions compares the toString()-representations of the values of the
 * specified annotations with the given string. In case they are equal true is
 * returned, otherwise false.
 * 
 * Parameters: 1. Annotation key 2. String to be used for comparison
 * 
 * @author Sven Wenzel
 */
public class FixedAnnotationValueCondition extends AbstractCondition {

	/**
	 * The annotations values of the nodes is compared with
	 */
	private String objectOfComparisonToString = null;
	private String annotationKey = null;

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter, ICorrespondences correspondences,
			ISimilarities similarities) {
		super.init(dedicatedClass, policy, parameter, correspondences, similarities);
		String[] splitParameter = parameter.split(",");
		this.annotationKey = splitParameter[0];
		this.objectOfComparisonToString = splitParameter[1];
	}

	@Override
	public boolean check(EObject node1, EObject node2) {
		AnnotateableElement annotateableElementA = EMFAdapter.INSTANCE.adapt(node1, AnnotateableElement.class);
		AnnotateableElement annotateableElementB = EMFAdapter.INSTANCE.adapt(node2, AnnotateableElement.class);

		return (annotateableElementA.getAnnotation(annotationKey, Object.class).toString()
				.equals(objectOfComparisonToString)
				&& annotateableElementB.getAnnotation(annotationKey, Object.class).toString()
						.equals(objectOfComparisonToString));
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of(" This conditions compares the toString()-representations of the values of the "
				+ "specified annotations with the given string. In case they are equal true isreturned, "
				+ "otherwise false.");
	}
}
