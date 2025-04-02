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
 * This condition tests whether two attribute values are equal. In case they are true is returned, otherwise false.
 * 
 * It is assured by assertion that both nodes are not null.
 * 
 * @author Pit Pietsch
 */
public class EqualAttributeValueCondition extends AbstractCondition {

	/**
	 * The EAttribute to be compared.
	 */
	private EAttribute attribute = null;

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter, ICorrespondences correspondences,
			ISimilarities similarities) {
		super.init(dedicatedClass, policy, parameter, correspondences, similarities);
		//parameter: attribute name
		EStructuralFeature feature = dedicatedClass.getEStructuralFeature(parameter);
	
		if (feature == null)
			throw new AttributeNotExistsException("Attribute does not exist: " + parameter);
		try {
			attribute = (EAttribute) feature;			
		} catch (ClassCastException exc) { // Is no attribute
			throw new AttributeNotExistsException("Attribute does not exist: " + parameter);
		}
	}
	
	@Override
	public boolean check(EObject node1, EObject node2) {
		return node1.eGet(attribute).equals(node2.eGet(attribute));
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This condition tests whether two attribute values are equal. In case they are true is returned, otherwise false.");
	}
}
