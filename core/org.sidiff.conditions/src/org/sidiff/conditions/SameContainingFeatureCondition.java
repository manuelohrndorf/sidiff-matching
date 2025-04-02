package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

/**
 * This condition tests whether the objects of an element has same type.
 * 
 * Parameter: none
 * 
 * @author Maik Schmidt
 */
public class SameContainingFeatureCondition extends AbstractCondition {

	@Override
	public boolean check(EObject node1, EObject node2) {
		EObject feature1 = node1.eContainingFeature();
		EObject feature2 = node2.eContainingFeature();
		return feature1 != null && feature1 == feature2;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This condition tests whether the objects of an element has same type.");
	}
}
