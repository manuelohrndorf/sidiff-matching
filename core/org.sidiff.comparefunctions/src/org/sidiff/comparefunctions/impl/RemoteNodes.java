package org.sidiff.comparefunctions.impl;

import java.util.Collection;
import java.util.Optional;

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
 * The remote nodes are defined by a path expression based on the document type
 * specific meta-model.<br>
 * 
 * This compare function takes two parameters:<br>
 * (1) The comparator that should be used to compare the remote nodes collected
 * by the given path expression.<br>
 * (2) A string value that specifies the a path expression identifying the
 * remote nodes.<br>
 * 
 * 
 * <b>Attention: this compare function is expensive!</b>
 * 
 * @author Pit Pietsch
 */
public class RemoteNodes extends AbstractComparatorCompareFunction {
	
	/**
	 * The path to the remote elements
	 */
	protected EMFPath path;

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
	 *            The compare function's parameter.
	 */
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter,
			ICorrespondences correspondences, ISimilarities similarities) {
		super.init(dedicatedClass, policy, weight, parameter, correspondences, similarities);
		path = EMFMetaAccess.translatePath(getEClass(), paramItems[1]);
	}

	@Override
	protected EClass getComparedType(EClass context) {
		//TODO VDUECK ...schon wieder..ein Aufruf vor der Definierung..temporäre Lösung mit Definition vor Aufruf.
		path = EMFMetaAccess.translatePath(getEClass(), paramItems[1]);
		return EMFMetaAccess.inferResultType(path);
	}

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		return EMFModelAccess.evaluatePath(context, path);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This is a compare function for comparing two nodes based on the comparison of remote nodes.");
	}
}
