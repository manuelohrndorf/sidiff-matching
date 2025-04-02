package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.annotation.AnnotateableElement;


/**
 * This condition tests whether two annotation values are equal. In case they are true is returned, otherwise false. 
 * It is assured by assertion  that the annotation exists in both elements.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Pit Pietsch
 */
public class EqualAnnotationValueCondition extends AbstractCondition {

	@Override
	public boolean check(EObject node1, EObject node2) {
		AnnotateableElement annotateableElementA = EMFAdapter.INSTANCE.adapt(node1, AnnotateableElement.class);
		AnnotateableElement annotateableElementB = EMFAdapter.INSTANCE.adapt(node2, AnnotateableElement.class);
		
		return annotateableElementA.getAnnotation(this.getParameter(), Object.class).equals(
				annotateableElementB.getAnnotation(this.getParameter(), Object.class));
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This condition tests whether two annotation values are equal. In case they are true is returned, otherwise false.  "
				+ "It is assured by assertion  that the annotation exists in both elements.");
	}
}
