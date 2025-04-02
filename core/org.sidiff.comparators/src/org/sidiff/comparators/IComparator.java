package org.sidiff.comparators;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * Interface for the Comparators
 * @author vdueck
 *
 */
public interface IComparator {
	public static final String EXTENSION_POINT_ID = "org.sidiff.comparators.extensionpoint";
	public static final String COMPARATOR_ID = "IComperator";
	public float compare(EObject contextElementA, EObject contextElementB, Object elementA, Object ElementB);

	public void init(EClass dedicatedClass, EClass targetClass, String parameter);

	public String getComparatorID();
	public String getDescription();
}
