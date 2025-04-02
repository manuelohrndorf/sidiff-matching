package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;
import org.sidiff.comparators.exceptions.AttributeNotExistsException;

/**
 * This comparator compares the values of the specified attributes of two
 * elements based on the given inner comparator.
 * 
 * <br>
 * <br>
 * <b>Warning: This comparefunction is expensive!</b><br>
 * <br>
 * This comparator compares the values of the specified attributes of two
 * elements based on the given inner comparator. If the attribute does not exist
 * in at least one of the elements a AttributeDoesNotExist-Exception is thrown.
 * Because it is tested for every call of the comparator if the attributed
 * exists in both elements, this comparator is expensive and it's use is
 * discouraged. The comparator ECAttributeStatic should be used whenever
 * possible instead.
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: The inner comparator and it's configuration<br>
 * <li>1: The name of the attribute to be compared<br>
 * </ul>
 *
 * The following example-configuration shows how to use the ECAttributeDynamic
 * comparator to compare two elements based on the equality of their
 * name-attribute. In case both attribute-values are equal 1f is returned, 0f
 * otherwise.<br>
 * <br>
 *
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAttributeDynamic[CEquals;;name]"/&gt;
 * 
 * @see org.sidiff.core.comparators.ECAttributeStatic
 * @see AttributeNotExistsException
 * 
 * @author Pit Pietsch
 */
public class ECAttributeDynamic extends AbstractElementComparator {

	private AbstractValueComparator comparator = null;
	private String attributeName = null;

	@Override
	protected void init(String parameter) {
		String[] paramItems = NestedParameterUtil.getParameterSegments(parameter);
		// first parameter: comparator
		comparator = loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractValueComparator.class, getCorrespondences(), getSimilarities());

		// second parameter: attribute name
		attributeName = paramItems[1];
	}

	/**
	 * The given elements are compared based on the specified attribute and the
	 * inner comparator. In case the attribute does not exist in at least on of
	 * the elements an AttributeNotExistsExcpetion is thrown. Otherwise the
	 * similarity-value calculated by the inner comparator is returned.
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractElementComparator#compare(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 * @see AttributeNotExistsException
	 */
	@Override
	protected float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		// get the feature with the given name
		EStructuralFeature feature = elementA.eClass().getEStructuralFeature(attributeName);

		if (feature == null) {
			throw new AttributeNotExistsException("Attribute does not exist: " + attributeName);			
		}

		// delegate compare attribute values
		return comparator.compare(contextElementA, contextElementB, elementA.eGet(feature), elementB.eGet(feature));
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator compares the values of the specified attributes of two "
				+ "elements based on the given inner comparator.");
	}
}
