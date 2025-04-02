package org.sidiff.comparefunctions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.exceptions.NothingToCompareException;

/**
 * If both nodes are not <code>null</code>, which is checked by an assert
 * statement, this compare functions returns <code>1</code> in all cases.<br>
 * This compare function has no parameters.
 */
public class MaximumSimilarity extends AbstractCompareFunction {
	public static final String COMPAREFUNCTION_ID = "MaximumSimilarity";

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter) {
		super.init(dedicatedClass, policy, weight, null);
	}

	@Override
	public float compare(EObject nodeInA, EObject nodeInB) {
		if ((nodeInA == null) || (nodeInB == null)) {
			throw new NothingToCompareException("at least one node is null.");
		}
		return 1f;
	}

	@Override
	public String getCompareFunctionID() {
		return COMPAREFUNCTION_ID;
	}

	@Override
	public String getDescription() {
		return " * If both nodes are not <code>null</code>, which is checked by an assert statement, "
				+ "this compare functions returns <code>1</code> in all cases."
				+ " This compare function has no parameters.";
	}

}
