package org.sidiff.conditions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.conditions.exceptions.AttributeNotExistsException;

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
	public static final String CONDITION_ID = "FixedAttributeValueCondition";
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
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter) {
		super.init(dedicatedClass, policy, parameter);
		// parameter: attribute name
		EStructuralFeature feature = dedicatedClass.getEStructuralFeature(parameter.split(",")[0]);

		if (feature == null)
			throw new AttributeNotExistsException("Attribute does not exist: " + parameter.split(",")[0]);
		try {
			attribute = (EAttribute) feature;
		} catch (ClassCastException exc) { // Is no attribute
			throw new AttributeNotExistsException("Attribute does not exist: " + parameter.split(",")[0]);
		}
		// parameter: value for comparison
		this.attributeValue = parameter.split(",")[1];

	}

	@Override
	public boolean check(EObject node1, EObject node2) {

		return (node1.eGet(attribute).toString().equals(attributeValue)
				&& node2.eGet(attribute).toString().equals(attributeValue));
	}

	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return " This conditions compares the toString()-representations of the values of "
				+ "the specified attributes with the given string. In case they are equal true "
				+ "is returned, otherwise false";
	}
}
