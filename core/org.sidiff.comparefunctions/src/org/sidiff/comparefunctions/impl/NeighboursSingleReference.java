package org.sidiff.comparefunctions.impl;

import java.util.Collection;

import org.eclipse.emf.ecore.*;
import org.sidiff.common.emf.EMFUtil;

/**
 * This is a compare function for comparing two nodes' neighbours.<br>
 * The neighbours are defined by the specific rolename of the reference.<br>
 * 
 * This compare function takes two parameters:<br>
 * (1) The comparator that should be used to compare the neighbours of node in
 * model A with those in model B.<br>
 * (2) A string value that specifies the role name of the reference in the
 * meta-model referencing the neighbours.
 * 
 * @author Pit Pietsch
 */
public class NeighboursSingleReference extends AbstractComparatorCompareFunction {
	public static final String COMPAREFUNCTION_ID = "NeighboursSingleReference";

	/**
	 * The references to be compared
	 */
	protected EReference reference;

	@Override
	protected EClass getComparedType(EClass context) {
		// TODO VDUECK ... bessere Lösung ? . Setzen der Reference wird nicht
		// vor Aufruf ausgeführt auf Grund der geänderten Struktur
		reference = (EReference) getEClass().getEStructuralFeature(this.paramItems[1]);
		return reference.getEReferenceType();
	}

	/**
	 * init.
	 * 
	 * @param dedicatedClass
	 *            The compare function's meta-model
	 * @param policy
	 *            The compare function's policy.
	 * @param weight
	 *            The compare function's weight.
	 * @param parameter
	 *            The compare function's parameter<br>
	 *            This compare function expects exactly one parameter fragment:
	 *            the comparator that should be used to compare the two
	 *            collections "children of A" and "children of B".
	 */
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter) {
		super.init(dedicatedClass, policy, weight, parameter);
		// assert: Structural Feature exists and is an EReference?
		assert((getEClass().getEStructuralFeature(paramItems[1]) != null)) : "StructuralFeature " + paramItems[1]
				+ " does not exist in metamodel";
		assert((getEClass().getEStructuralFeature(paramItems[1]) instanceof EReference)) : "StructuralFeature "
				+ paramItems[1] + " is not a EReference";

		// get reference
		reference = (EReference) getEClass().getEStructuralFeature(this.paramItems[1]);
	}

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		return EMFUtil.getObjectListFromReference(context, reference);
	}

	@Override
	public String getCompareFunctionID() {
		return COMPAREFUNCTION_ID;
	}

	@Override
	public String getDescription() {
		return "This is a compare function for comparing two nodes' neighbours. The neighbours are defined by the specific rolename of the reference.";
	}
}
