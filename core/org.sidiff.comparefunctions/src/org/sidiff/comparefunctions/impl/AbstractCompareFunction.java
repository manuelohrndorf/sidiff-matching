package org.sidiff.comparefunctions.impl;

import java.util.Arrays;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.util.NestedParameterUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

/**
 * Represents the abstract superclass for each compare function.<br />
 */
public abstract class AbstractCompareFunction implements ICompareFunction {

	/**
	 * The compare function's policy
	 */
	private EvaluationPolicy ePolicy;

	/**
	 * The compare function's weight
	 */
	private float weight;

	/**
	 * The dedicated meta-class (out of the document type specific meta-model)
	 * on whose instances this compare function operates on.
	 */
	private EClass dedicatedClass;

	/**
	 * Holds the parameter string fragments and can be used by subclasses.
	 */
	protected String[] paramItems;

	/**
	 * The init() that has to be used by subclasses.<br>
	 * Initializes attribute values, extracts parameter segments.<br>
	 * 
	 * @param dedicatedClass
	 *            The dedicated meta-class (out of the document type specific
	 *            meta-model) on whose instances this compare function operates
	 *            on.
	 * @param policy
	 *            The compare function's policy.
	 * @param weight
	 *            The compare function's weight.
	 * @param parameter
	 *            The compare function's parameter
	 */

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter,
			ICorrespondences correspondences, ISimilarities similarities) {

		if (weight >= 0.0f && weight <= 1.0f && policy != null && dedicatedClass != null) {

			if (parameter != null) {
				// Extract single segments of parameter string
				this.paramItems = NestedParameterUtil.getParameterSegments(parameter);
			}

			this.weight = weight;
			this.ePolicy = policy;
			this.dedicatedClass = dedicatedClass;

		} else {
			throw new IllegalArgumentException(weight + "," + policy);
		}
	}

	@Override
	public EvaluationPolicy getPolicy() {
		return ePolicy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sidiff.core.comparefunctions.CI#getWeight()
	 */
	@Override
	public float getWeight() {
		return this.weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.sidiff.core.comparefunctions.CI#getEClass()
	 */
	@Override
	public EClass getEClass() {
		return this.dedicatedClass;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.sidiff.core.comparefunctions.CI#compare(org.eclipse.emf.ecore.EObject
	 * , org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public abstract float compare(EObject nodeInA, EObject nodeInB);

	@Override
	public String toString() {

		if (paramItems != null) {
			return getClass().getCanonicalName() + "(" + dedicatedClass.getName() + "/"
					+ Arrays.toString(paramItems) + "/" + ePolicy + ")";
		}
		return getClass().getCanonicalName() + "(" + dedicatedClass.getName() + "/" + ePolicy + ")";
	}

	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}
}
