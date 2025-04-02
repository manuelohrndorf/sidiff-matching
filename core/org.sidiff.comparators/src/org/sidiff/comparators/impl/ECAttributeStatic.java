package org.sidiff.comparators.impl;

import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;
import org.sidiff.comparators.exceptions.AttributeNotExistsException;

/**
 * This comparator compares the attributes of two elements based on the
 * specified inner comparator. If the attribute does not exist in at least one
 * of the elements a AttributeDoesNotExist-Exception is thrown.
 * 
 * The parameter of this comparator specifies at position
 * <ul>
 * <li>0: The inner comparator and it's configuration<br>
 * <li>1: The name of the attribute to be compared<br>
 * </ul>
 * 
 * 
 * The following example-configuration shows how to use the ECAttributeDynamic
 * comparator to compare two elements based on the equality of their
 * name-attribute. In case both attribute-values are equal 1f is returned, 0f
 * otherwise.<br>
 * <br>
 * 
 * &lt;CompareFunction class="SelfCF" weight="1"
 * parameter="ECAttributeStatic[CEquals;name]"/&gt;
 * 
 * @see org.sidiff.core.comparators.ECAttributeDynamic
 * @see AttributeNotExistsException
 * 
 * @author Pit Pietsch
 */
public class ECAttributeStatic extends AbstractElementComparator {

	/**
	 * The inner comparator.
	 */
	private AbstractValueComparator comparator = null;

	/**
	 * The EAttribute to be compared.
	 */
	private EAttribute attribute = null;

	/**
	 * Instantiates the comparator used to do the comparison and extracts the
	 * {@link EAttribute} which should be compared from the metamodel. In case
	 * the specified attribute does not exist in the specified target class an
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
		assert(paramItems.length == 2) : "invalid parameter syntax '" + parameter + "'";

		// first parameter: comparator
		comparator = loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractValueComparator.class, getCorrespondences(), getSimilarities());

		// second parameter: attribute name
		EStructuralFeature feature = targetClass.getEStructuralFeature(paramItems[1]);
		if (feature == null) { // feature does not exist
			throw new AttributeNotExistsException("Attribute does not exist: " + paramItems[1]);
		}

		try {
			attribute = (EAttribute) feature;
		} catch (ClassCastException exc) { // Is no attribute
			throw new AttributeNotExistsException("Attribute does not exist: " + paramItems[1]);
		}
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

		return comparator.compare(contextElementA, contextElementB, elementA.eGet(attribute), elementB.eGet(attribute));
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This comparator compares the attributes of two elements based on the specified inner comparator. "
				+ "If the attribute does not exist in at least one of the elements a AttributeDoesNotExist-Exception is thrown.");
	}
}
