package org.sidiff.comparefunctions.impl;

import java.util.Collection;
import java.util.Collections;

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
	public static final String COMPAREFUNCTION_ID = "Parent";

	/**
	 * init.
	 * 
	 * @param dedicatedClass
	 *            The compare function's meta-model.
	 * @param policy
	 *            The compare function's policy.
	 * @param weight
	 *            The compare function's weight.
	 * @param parameter
	 *            The compare function's parameter.
	 */
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter) {
		super.init(dedicatedClass, policy, weight, parameter);
	}

	@Override
	protected EClass getComparedType(EClass context) {
		return getEClass().eContainer().eClass();
	}

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		if (context.eContainer() == null)
			return Collections.emptyList();
		else
			return Collections.singleton(context.eContainer());
	}
	@Override
	public String getCompareFunctionID() {
		return COMPAREFUNCTION_ID;
	}

	@Override
	public String getDescription() {
		return "Compare function for comparing two nodes' parents.";
	}
}
