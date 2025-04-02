package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;


/**
 * This condition tests whether two annotation values are equal. In case they are true is returned, otherwise false. 
 * It is assured by assertion  that the annotation exists in both elements.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Pit Pietsch
 */
public class EqualAnnotationValueCondition extends AbstractCondition {
	public static final String CONDITION_ID = "EqualAnnotationValueCondition";
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy,
			String parameter) {
		super.init(dedicatedClass, policy, parameter);
		
	}
	
	@Override
	public boolean check(EObject node1, EObject node2) {
		
		AnnotateableElement annotateableElementA = EMFAdapter.INSTANCE.adapt(node1, AnnotateableElement.class);
		AnnotateableElement annotateableElementB = EMFAdapter.INSTANCE.adapt(node2, AnnotateableElement.class);
		
		return annotateableElementA.getAnnotation(this.getParameter(), Object.class).equals(
				annotateableElementB.getAnnotation(this.getParameter(), Object.class));
	}

	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "This condition tests whether two annotation values are equal. In case they are true is returned, otherwise false.  "
				+ "It is assured by assertion  that the annotation exists in both elements.";
	}

}
