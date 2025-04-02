package org.sidiff.comparefunctions.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Compare function for comparing two nodes' parents.<br>
 * This compare function expects exactly one parameter fragment: The comparator
 * that should be used to compare the parent of node in model A with the parent
 * of node in model B.<br>
 * All types of comparators are allowed for this compare function.
 * 
 * 
 * @author Pit Pietsch
 */
public class Parent extends AbstractComparatorCompareFunction {

	@Override
	protected EClass getComparedType(EClass context) {
		return getEClass().eContainer().eClass();
	}

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		if (context.eContainer() == null) {
			return Collections.emptyList();			
		}
		return Collections.singleton(context.eContainer());
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Compare function for comparing two nodes' parents.");
	}
}
