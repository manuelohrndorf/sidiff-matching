package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

/**
 * This condition always returns true.
 * 
 * @author Pit Pietsch
 */
public class TrueCondition extends AbstractCondition {

	@Override
	public boolean check(EObject node1, EObject node2) {
		return true;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This condition always returns true.");
	}
}
