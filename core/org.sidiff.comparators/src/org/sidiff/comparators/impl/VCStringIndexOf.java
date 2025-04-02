package org.sidiff.comparators.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

/**
 * This comparator compares two string values based on a their index-of
 * similarity. It is assured by assertion that the two values are of the type
 * string.
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: Indication whether the strings are to be compared case-insensitive
 * (ci) or not (cs)
 * </ul>
 * 
 * The following example-configuration shows how to use the VCStringLCS
 * comparator to compare the name-attributes from elements of type Operation
 * with an case-insensitive index-of similarity calculation. <br>
 * <br>
 * 
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAttributeStatic[VCStringIndexOf[ci];Operation;name]"/&gt;
 * 
 * @author Pit Pietsch
 */

@Deprecated
public class VCStringIndexOf extends AbstractValueComparator {
	public static final String COMPARATOR_ID = "VCStringIndexOf";
	/**
	 * indicates whether a case-sensitive (false) or case-insensitive (true)
	 * comparison is to be used.
	 */
	private boolean ci = false;;

	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, parameter);
		// case sensitivity ? default: case-sensitive
		if (parameter.equals("ci")) {
			this.ci = true;
		}
	}

	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object objectA,
			Object objectB) {

		// typecheck
		assert(objectA instanceof String && objectB instanceof String) : "Works only with Strings!";

		String stringA = null;
		String stringB = null;

		if (ci) {
			stringA = ((String) objectA).toLowerCase();
			stringB = ((String) objectB).toLowerCase();
		} else {
			stringA = (String) objectA;
			stringB = (String) objectB;
		}

		// Prevent division by zero !!
		if (stringA.equals("") && stringB.equals("")) {
			return 0.0f;
		}

		if (stringA.indexOf(stringB) != -1)
			return (float) stringB.length() / (float) stringA.length();
		else if (stringB.indexOf(stringA) != -1)
			return (float) stringA.length() / (float) stringB.length();
		else
			return 0.0f;
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return " This comparator compares two string values based on a their index-of similarity."
				+ " It is assured by assertion that the two values are of the type string.";
	}
}
