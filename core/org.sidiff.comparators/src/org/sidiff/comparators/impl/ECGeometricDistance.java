package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.comparators.exceptions.AttributeNotExistsException;

/**
 * This comparator calculates the geometric distance of two attribute values x
 * and y and finally compares this distance on a gauss-calculation with the
 * given scale factor. <br>
 * If one of the attributes does not exist in at least one of the elements a
 * AttributeDoesNotExist-Exception is thrown.
 * 
 * The parameter of this comparator specifies at position
 * <ul>
 * <li>0: The name of the attribute with the x value</li>
 * <li>1: The name of the attribute with the y value</li>
 * <li>2: The scale for the gauss-calculation</li>
 * </ul>
 * 
 * 
 * The following example-configuration shows how to use the comparator <br>
 * 
 * 
 * @see org.sidiff.core.comparators.ECAttributeDynamic
 * @see AttributeNotExistsException
 * 
 * @author kehrer
 */
public class ECGeometricDistance extends AbstractElementComparator {

	/**
	 * The EAttribute holding the x value
	 */
	private EAttribute attributeX = null;

	/**
	 * The EAttribute holding the y value
	 */
	private EAttribute attributeY = null;

	/**
	 * The scale for the gaussian calculation.
	 */
	private float scale = -1f;

	/**
	 * Instantiates the comparator used to do the comparison and extracts the
	 * EAttributes which should be compared from the metamodel. In case on of
	 * the specified attributes does not exist in the specified target class an
	 * AttributeNotExistsException is thrown.
	 * 
	 * With respect to the parameters <code>context</code> and
	 * <code>parameter</code>, please refer to the constructor in base class
	 * {@link AbstractComparator}.
	 * 
	 * @see AbstractComparator#AbstractComparator(EClass, String) Constructor.
	 * @see AttributeNotExistsException
	 */
	@Override
	protected void init(String parameter) {
		String[] paramItems = NestedParameterUtil.getParameterSegments(parameter);
		assert(paramItems.length == 3) : "invalid parameter syntax '" + parameter + "'";

		// first parameter: attribute name for x value
		EStructuralFeature feature = targetClass.getEStructuralFeature(paramItems[0]);
		if (feature == null) // feature does not exist
			throw new AttributeNotExistsException("Attribute does not exist: " + paramItems[0]);

		try {
			attributeX = (EAttribute) feature;
		} catch (ClassCastException exc) { // Is no attribute
			throw new AttributeNotExistsException("Attribute does not exist: " + paramItems[0]);
		}

		// second parameter: attribute name for x value
		feature = targetClass.getEStructuralFeature(paramItems[1]);
		if (feature == null) // feature does not exist
			throw new AttributeNotExistsException("Attribute does not exist: " + paramItems[1]);

		try {
			attributeY = (EAttribute) feature;
		} catch (ClassCastException exc) { // Is no attribute
			throw new AttributeNotExistsException("Attribute does not exist: " + paramItems[1]);
		}

		// third paramter: scale factor
		// (Must be negative for a result between 0 and 1 for comparison)
		this.scale = -Float.parseFloat(paramItems[2]);
	}

	/**
	 * The given elements are compared based on the specified attribute and the
	 * inner comparator and the calculated similarity-value is returned.
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		// test if one or both elements are null. should be already handled in
		// the AbstractComparator class
		assert(elementA != null && elementB != null) : "at least one element is null!";

		// typecheck
		Object xA = elementA.eGet(attributeX);
		Object yA = elementA.eGet(attributeY);
		Object xB = elementB.eGet(attributeX);
		Object yB = elementB.eGet(attributeY);

		// typecheck
		assert(xA instanceof Number && yA instanceof Number && xB instanceof Number
				&& yB instanceof Number) : "All values to be compared must be Numbers! (" + xA + "/" + yA + "/" + xB
						+ "/" + yB + "@" + contextElementA.eClass().getName() + ")";

		// calculate distance (Pythagoras)
		float dist = (float) Math.sqrt(Math.pow((((Number) xA).floatValue() - ((Number) xB).floatValue()), 2.0f)
				+ Math.pow((((Number) yA).floatValue() - ((Number) yB).floatValue()), 2.0f));

		// finally, get similarity using gaussian scale factor
		return (float) Math.exp((dist * dist) / scale);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator calculates the geometric distance of two attribute values x and y "
				+ "and finally compares this distance on a gauss-calculation with the given scale factor.");
	}
}
