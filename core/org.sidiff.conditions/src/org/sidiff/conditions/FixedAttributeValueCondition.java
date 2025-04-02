package org.sidiff.conditions;

import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.conditions.exceptions.AttributeNotExistsException;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * This conditions compares the toString()-representations of the values of the
 * specified attributes with the given string. In case they are equal true is
 * returned, otherwise false.
 * 
 * Parameters: 1. Attribute 2. String to be used for comparison
 * 
 * @author Sven Wenzel
 */
public class FixedAttributeValueCondition extends AbstractCondition {

	/**
	 * The attribute values of the nodes is compared with
	 */
	private String attributeValue = null;

	/**
	 * The EAttribute to be compared.
	 */
	private EAttribute attribute = null;

	/**
	 * @param dedicatedClass
	 * @param policy
	 * @param parameter
	 */
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter,
			ICorrespondences correspondences, ISimilarities similarities) {
		super.init(dedicatedClass, policy, parameter, correspondences, similarities);
		// parameter: attribute name
		String[] splitParameter = parameter.split(",");
		EStructuralFeature feature = dedicatedClass.getEStructuralFeature(splitParameter[0]);

		if (feature == null)
			throw new AttributeNotExistsException("Attribute does not exist: " + splitParameter[0]);
		try {
			attribute = (EAttribute) feature;
		} catch (ClassCastException exc) { // Is no attribute
			throw new AttributeNotExistsException("Attribute does not exist: " + splitParameter[0]);
		}
		// parameter: value for comparison
		this.attributeValue = splitParameter[1];

	}

	@Override
	public boolean check(EObject node1, EObject node2) {
		return (node1.eGet(attribute).toString().equals(attributeValue)
				&& node2.eGet(attribute).toString().equals(attributeValue));
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of(" This conditions compares the toString()-representations of the values of "
				+ "the specified attributes with the given string. In case they are equal true "
				+ "is returned, otherwise false");
	}
}
