package org.sidiff.conditions;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.path.EMFPath;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.conditions.exceptions.AttributeNotExistsException;
import org.sidiff.conditions.exceptions.NothingToCompareException;

/**
 * This conditions compares the toString()-representations of the values of the
 * specified attributes of two remote nodes with the given string. In case they
 * are equal true is returned, otherwise false.
 * 
 * Parameters: 1. Path to the remote node (must lead to a single element, not a
 * set) 2. Attribute 3. String to be used for comparison
 * 
 * @author Sven Wenzel
 */
public class FixedRemoteAttributeValueCondition extends AbstractCondition {
	public static final String CONDITION_ID = "FixedRemoteAttributeValueCondition";
	/**
	 * The object the attribute values of the nodes is compared with
	 */
	private EMFPath path = null;

	/**
	 * The EAttribute to be compared.
	 */
	private EAttribute attribute = null;

	/**
	 * The attribute values of the nodes is compared with
	 */
	private String attributeValue = null;

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter) {

		super.init(dedicatedClass, policy, parameter);
		this.path = EMFMetaAccess.translatePath(dedicatedClass, parameter.split(",")[0]);

		EStructuralFeature feature = EMFMetaAccess.inferResultType(path).getEStructuralFeature(parameter.split(",")[1]);

		if (feature == null)
			throw new AttributeNotExistsException("Attribute does not exist: " + parameter.split(",")[1]);
		try {
			attribute = (EAttribute) feature;
		} catch (ClassCastException exc) { // Is no attribute
			throw new AttributeNotExistsException("Attribute does not exist: " + parameter.split(",")[1]);
		}
		// parameter: value for comparison
		this.attributeValue = parameter.split(",")[2];

	}

	@Override
	public boolean check(EObject node1, EObject node2) {

		Collection<EObject> targets1 = EMFModelAccess.evaluatePath(node1, path);
		Collection<EObject> targets2 = EMFModelAccess.evaluatePath(node2, path);

		if (targets1.isEmpty() && targets2.isEmpty()) {
			throw new NothingToCompareException(
					"" + this.getClass().getName() + " " + getEClass() + " " + getParameter() + " " + path.toString());
		}

		assert(targets1.size() == 1) : "Too many targets!";
		assert(targets2.size() == 1) : "Too many targets!";

		return (targets1.iterator().next().eGet(attribute).toString().equals(attributeValue)
				&& targets2.iterator().next().eGet(attribute).toString().equals(attributeValue));
	}

	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return " * This conditions compares the toString()-representations of the "
				+ "values of the specified attributes of two remote nodes with the given string. "
				+ "In case they are equal true is returned, otherwise false.";
	}
}
