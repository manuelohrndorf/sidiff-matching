package org.sidiff.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

/**
 * This condition tests whether the parent of an element is of a particular
 * type.
 * 
 * Parameter: The name of the type that the parent should have.
 * 
 * @author Sven Wenzel
 */
public class ParentOfTypeCondition extends AbstractCondition {
	public static final String CONDITION_ID = "ParentOfTypeCondition";
	private EClass expectedType = null;


	@Override
	public boolean check(EObject node1, EObject node2) {

		EObject parent1 = node1.eContainer();
		EObject parent2 = node2.eContainer();

		if (parent1 != null && parent2 != null) {
			return expectedType.isInstance(parent1) && expectedType.isInstance(parent2);
		}
		return false;
	}

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter) {

		super.init(dedicatedClass, policy, parameter);

		expectedType = (EClass) dedicatedClass.getEPackage().getEClassifier(parameter);
		if (expectedType == null) {
			expectedType = (EClass) EMFMetaAccess.getMetaObjectByName(
					EMFUtil.getRootPackage(dedicatedClass).getNsURI(), parameter);
		}

		if (expectedType == null)
			throw new SiDiffRuntimeException("Type does not exist: " + parameter);

	}
	@Override
	public String getConditionID() {
		return CONDITION_ID;
	}

	@Override
	public String getDescription() {
		return "This condition tests whether the parent of an element is of a particular type.";
	}
}
