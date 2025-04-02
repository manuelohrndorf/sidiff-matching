package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

/**
 * This condition tests whether the parents of an element has same type.
 * 
 * Parameter: none
 * 
 * @author Maik Schmidt
 */
public class SameParentTypeCondition extends AbstractCondition {

	@Override
	public boolean check(EObject node1, EObject node2) {
		EObject parent1 = node1.eContainer();
		EObject parent2 = node2.eContainer();
		return parent1 != null && parent2 != null && parent1.eClass() == parent2.eClass();
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This condition tests whether the parents of an element has same type.");
	}
}
