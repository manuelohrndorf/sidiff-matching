package org.sidiff.comparators.impl;

import java.util.Optional;

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

public class VCStringIndexOf extends AbstractValueComparator {

	/**
	 * indicates whether a case-sensitive (false) or case-insensitive (true)
	 * comparison is to be used.
	 */
	private boolean ci = false;

	@Override
	public void init(String parameter) {
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

		String stringA = (String) objectA;
		String stringB = (String) objectB;

		if (ci) {
			stringA = stringA.toLowerCase();
			stringB = stringB.toLowerCase();
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
	public Optional<String> getDescription() {
		return Optional.of("This comparator compares two string values based on a their index-of similarity."
				+ " It is assured by assertion that the two values are of the type string.");
	}
}
