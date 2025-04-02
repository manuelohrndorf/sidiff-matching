package org.sidiff.comparefunctions.impl;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFMetaAccess;

/**
 * Compare function for comparing two nodes' direct children.<br>
 * This compare function expects exactly one parameter fragment: The comparator
 * that should be used to compare the two collections "children of A" and
 * "children of B".<br>
 * 
 * All types of comparators are allowed for this compare function.
 * 
 * @author Pit Pietsch
 */
public class Children extends AbstractComparatorCompareFunction {

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		return context.eContents();
	}

	@Override
	protected EClass getComparedType(EClass context) {
		return EMFMetaAccess.inferCommonSupertype(EMFMetaAccess.getChildrenClasses(context));
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Compare function for comparing two nodes' direct children."
				+ "This compare function expects exactly one parameter fragment: The comparator"
				+ " that should be used to compare the two collections 'children of A' and 'children of B");
	}
}
