package org.sidiff.conditions;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * This condition tests whether both elements do not have children. In case they
 * are true is returned, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Sven Wenzel
 */
public class NoRemoteNodesCondition extends AbstractCondition {
	public static final String CONDITION_ID = "NoRemoteNodesCondition";
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
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter) {
		super.init(dedicatedClass, policy, parameter);
		path = EMFMetaAccess.translatePath(dedicatedClass, parameter);
	}
	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "This condition tests whether both elements do not have children. In case they are true is returned, otherwise false.";
	}
}
