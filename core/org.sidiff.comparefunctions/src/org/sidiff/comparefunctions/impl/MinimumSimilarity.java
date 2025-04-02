package org.sidiff.comparefunctions.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparefunctions.exceptions.NothingToCompareException;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * If both nodes are not <code>null</code>, which is checked by an assert
 * statement, this compare functions returns <code>0</code> in all cases.<br>
 * This compare function has no parameters.
 */
public class MinimumSimilarity extends AbstractCompareFunction {

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter,
			ICorrespondences correspondences, ISimilarities similarities) {
		super.init(dedicatedClass, policy, weight, null, correspondences, similarities);
	}

	@Override
	public float compare(EObject nodeInA, EObject nodeInB) {
		if ((nodeInA == null) || (nodeInB == null)) {
			throw new NothingToCompareException("at least one node is null.");
		}
		return 0f;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of(" * If both nodes are not <code>null</code>, which is checked by an"
				+ " assert statement, this compare functions returns <code>0</code> in all"
				+ " cases.<br> This compare function has no parameters.");
	}
}
