package org.sidiff.comparefunctions.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Compare function for comparing local properties of two nodes.<br>
 * This compare function expects exactly one parameter fragment: The comparator
 * that should be used to do the comparison.<br>
 * All types of comparators are allowed for this compare function.
 * 
 * 
 * @author Pit Pietsch
 */
public class Self extends AbstractComparatorCompareFunction {

	@Override
	protected EClass getComparedType(EClass context) {
		return getEClass();
	}

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		return Collections.singleton(context);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Compare function for comparing local properties of two nodes.");
	}
}
