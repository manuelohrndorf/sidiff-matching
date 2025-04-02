package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

/**
 * This condition tests whether both elements do not have children. In case they
 * are true is returned, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Sven Wenzel
 */
public class NoChildrenCondition extends AbstractCondition {

	@Override
	public boolean check(EObject node1, EObject node2) {
		return node1.eContents().isEmpty() && node1.eContents().isEmpty();
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of(
				"This condition tests whether both elements do not have children. In case they are true is returned, otherwise false.");
	}
}
