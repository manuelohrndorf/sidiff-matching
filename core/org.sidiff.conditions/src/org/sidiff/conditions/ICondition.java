package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

public interface ICondition extends IExtension {

	Description<ICondition> DESCRIPTION = Description.of(ICondition.class,
			"org.sidiff.conditions.extensionpoint", "client", "class");
	ExtensionManager<ICondition> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	String getParameter();

	/**
	 * Get the compare function's Meta-Model
	 * 
	 * @return Returns the compare function's weight
	 */
	EClass getEClass();

	/**
	 * Get the compare function's policy
	 * 
	 * @return Returns the compare function's policy
	 */
	EvaluationPolicy getPolicy();

	void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter,
			ICorrespondences correspondences, ISimilarities similarities);

	boolean check(EObject node1, EObject node2);
}