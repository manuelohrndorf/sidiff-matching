package org.sidiff.comparefunctions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public interface ICompareFunction {

	public static final String EXTENSION_POINT_ID = "org.sidiff.comparefunctions.extensionpoint";

	public abstract EvaluationPolicy getPolicy();

	public abstract float getWeight();

	public abstract EClass getEClass();

	public abstract float compare(EObject nodeInA, EObject nodeInB);

	public abstract void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter);

	public enum EvaluationPolicy {
		mandatory, // Verbindlich -> SiDiff-Abbruch bei Fehler(Exception)
		fulfilled, // Erfuellt -> gemaess gewicht!
		unfulfilled; // Nicht Erfuellt -> 0.0f
	}

	public abstract String getCompareFunctionID();

	public abstract String getDescription();
}
