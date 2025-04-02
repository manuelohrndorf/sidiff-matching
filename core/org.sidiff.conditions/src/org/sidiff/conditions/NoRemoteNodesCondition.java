package org.sidiff.conditions;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * This condition tests whether both elements do not have children. In case they
 * are true is returned, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Sven Wenzel
 */
public class NoRemoteNodesCondition extends AbstractCondition {

	/**
	 * The path to the remote elements
	 */
	protected EMFPath path = null;

	@Override
	public boolean check(EObject node1, EObject node2) {
		Collection<EObject> remoteNodesA = EMFModelAccess.evaluatePath(node1, path);
		Collection<EObject> remoteNodesB = EMFModelAccess.evaluatePath(node2, path);

		return remoteNodesA.isEmpty() && remoteNodesB.isEmpty();
	}

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter, ICorrespondences correspondences,
			ISimilarities similarities) {
		super.init(dedicatedClass, policy, parameter, correspondences, similarities);
		path = EMFMetaAccess.translatePath(dedicatedClass, parameter);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of(
				"This condition tests whether both elements do not have children. In case they are true is returned, otherwise false.");
	}
}
