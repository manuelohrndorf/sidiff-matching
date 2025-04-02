package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

/**
 * This comparator compares two numerical values based on a gauss-calculation.
 * It is assured by assertion that the values are of a numerical type.
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: The scale for the gauss-calculation
 * </ul>
 *
 * The following example-configuration shows how to use the VCGauss comparator
 * to compare two (numerical) attributes from elements of type ElementB.<br>
 * <br>
 *
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAttributeStatic[VCGauss[0.7f];ElementB;numberX]"/&gt;
 *
 * @see java.lang.Number
 * 
 * @author Pit Pietsch
 * */
public class VCGauss extends AbstractValueComparator {

	/**
	 * The scale for the gaussian calculation.
	 */
	private float scale = -1f;

	@Override
	public void init(String parameter) {
		// Must be negative for a result between 0 and 1 for comparation
		this.scale = -Float.parseFloat(parameter);
	}

	/**
	 * Calculates the similarity of two numerical values based on a
	 * gauss-calculation.
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractComparator#compare(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object objectA, Object objectB) {
		// typecheck
		assert (objectA instanceof Number && objectB instanceof Number) :
			"Both elements to compare must be descendents of supertype java.lang.number! ("
				+ objectA + "/" + objectB + "@" + contextElementA.eClass().getName() + ")";

		float dx = (((Number) objectA).floatValue() - ((Number) objectB).floatValue());
		return (float) Math.exp((dx * dx) / scale);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator compares two numerical values based on a gauss-calculation."
				+ " It is assured by assertion that the values are of a numerical type.");
	}
}
