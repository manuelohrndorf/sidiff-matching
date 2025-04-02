package org.sidiff.comparefunctions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

public interface ICompareFunction extends IExtension {

	Description<ICompareFunction> DESCRIPTION = Description.of(ICompareFunction.class,
			"org.sidiff.comparefunctions.extensionpoint", "client", "class");
	ExtensionManager<ICompareFunction> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	EvaluationPolicy getPolicy();
	float getWeight();
	EClass getEClass();

	void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter,
			ICorrespondences correspondences, ISimilarities similarities);
	float compare(EObject nodeInA, EObject nodeInB);

	enum EvaluationPolicy {
		mandatory, // Verbindlich -> SiDiff-Abbruch bei Fehler(Exception)
		fulfilled, // Erfuellt -> gemaess gewicht!
		unfulfilled; // Nicht Erfuellt -> 0.0f
	}
}
