package org.sidiff.comparefunctions.impl;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.*;

/**
 * This is a compare function for comparing two nodes' neighbours. It only works
 * when the cardinality of the reference is exactly 1.<br>
 * The two neighbour nodes are defined by the specific rolename of the
 * reference.<br>
 * 
 * This compare function takes two parameters:<br>
 * (1) The comparator that should be used to compare the neighbours of node in
 * model A with those in model B.<br>
 * (2) A string value that specifies the role name of the reference in the
 * meta-model referencing the neighbours.
 * 
 * @author Pit Pietsch
 */
public class SingleNeighbour extends AbstractComparatorCompareFunction {
	public static final String COMPAREFUNCTION_ID = "SingleNeighbour";

	/**
	 * The references to be compared
	 */
	protected EReference reference;

	@Override
	protected EClass getComparedType(EClass context) {
		// TODO VDUECK ..
		assert((getEClass().getEStructuralFeature(paramItems[1]) != null)) : "StructuralFeature \"" + paramItems[1]
				+ "\" of \"" + getEClass().getName() + "\" does not exist in metamodel";
		assert((getEClass().getEStructuralFeature(paramItems[1]) instanceof EReference)) : "StructuralFeature "
				+ paramItems[1] + " is not a EReference";

		// if so, get reference
		reference = (EReference) getEClass().getEStructuralFeature(paramItems[1]);

		// check for cardinality of 1
		assert(!reference.isMany()) : "This CompareFunction can only be used with references where 'many=false': "
				+ reference;

		return reference.getEReferenceType();
	}

	@Override
	protected Collection<EObject> getToBeCompared(EObject context) {
		if (context.eGet(reference) == null) {
			return Collections.emptyList();
		} else {
			return Collections.singleton((EObject) context.eGet(reference));
		}
	}

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter) {
		super.init(dedicatedClass, policy, weight, parameter);
		// structural features exit
		assert((getEClass().getEStructuralFeature(paramItems[1]) != null)) : "StructuralFeature \"" + paramItems[1]
				+ "\" of \"" + getEClass().getName() + "\" does not exist in metamodel";
		assert((getEClass().getEStructuralFeature(paramItems[1]) instanceof EReference)) : "StructuralFeature "
				+ paramItems[1] + " is not a EReference";

		// if so, get reference
		reference = (EReference) getEClass().getEStructuralFeature(paramItems[1]);

		// check for cardinality of 1
		assert(!reference.isMany()) : "This CompareFunction can only be used with references where 'many=false': "
				+ reference;
	}

	@Override
	public String getCompareFunctionID() {
		return COMPAREFUNCTION_ID;
	}

	@Override
	public String getDescription() {
		return "This is a compare function for comparing two nodes' neighbours. "
				+ "It only works when the cardinality of the reference is exactly 1.";
	}

}
