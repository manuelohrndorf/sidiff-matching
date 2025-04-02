package org.sidiff.comparefunctions.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * This is a compare function for comparing two nodes based on the comparison of
 * remote nodes.<br>
 * The remote nodes are defined by several path expressions based on the
 * document type specific meta-model.<br>
 * It is similar to RemoteNodesCF, the difference is that several paths can be
 * given as parameter. Attention: The user must assure, that the target element
 * type of all paths is the same!
 * 
 * This compare function takes two parameters:<br>
 * (1) The comparator that should be used to compare the remote nodes collected
 * by the given path expression.<br>
 * (2) 1 to n string values that specify a path expression identifying the
 * remote nodes.<br>
 * 
 * 
 * <b>Attention: this compare function is expensive!</b>
 * 
 */
public class MultipleRemoteNodes extends AbstractComparatorCompareFunction {

	/*
	 * The path to the remote elements, not initialized here due to init-call!
	 */
	protected List<EMFPath> pathsList;

	/**
	 * init.
	 * 
	 * @param dedicatedClass
	 *            The compare function's meta-model
	 * @param policy
	 *            The compare function's policy.
	 * @param weight
	 *            The compare function's weight.
	 * @param parameter
	 *            The compare function's parameter<br>
	 *            This compare function expects exactly one parameter fragment:
	 *            the comparator that should be used to compare the two
	 *            collections "children of A" and "children of B".
	 */
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter,
			ICorrespondences correspondences, ISimilarities similarities) {
		super.init(dedicatedClass, policy, weight, parameter, correspondences, similarities);
		this.pathsList = new LinkedList<>();
		// get all paths from parameter
		for (int i = 1; i < paramItems.length; i++) {
			pathsList.add(EMFMetaAccess.translatePath(getEClass(), paramItems[i]));
		}
	}

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		Collection<EObject> toBeCompared = new ArrayList<>();
		for (EMFPath path : pathsList) {
			toBeCompared.addAll(EMFModelAccess.evaluatePath(context, path));			
		}
		return toBeCompared;
	}

	@Override
	protected EClass getComparedType(EClass context) {
		// infer types of target classes
		Set<EClass> targetClasses = new HashSet<>();

		for (EMFPath path : pathsList) {
			EClass targetClazz = EMFMetaAccess.inferResultType(path);
			if (targetClazz != null)
				targetClasses.add(targetClazz);
		}

		// infer common supertype
		return EMFMetaAccess.inferCommonSupertype(targetClasses);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This is a compare function for comparing two nodes based on the comparison of remote nodes."
				+ " The remote nodes are defined by several path expressions based on the document type specific meta-model."
				+ " It is similar to RemoteNodesCF, the difference is that several paths can be given as parameter. "
				+ "Attention: The user must assure, that the target element type of all paths is the same!");
	}
}
