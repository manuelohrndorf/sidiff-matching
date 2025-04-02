package org.sidiff.similaritiescalculation;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.comparefunctions.ICompareFunction;
import org.sidiff.conditions.ICondition;
import org.sidiff.similaritiescalculation.configuration.CompareConfiguration;


/**
 * This compare function compares two nodes depending on a condition. If the
 * condition is <code>true</code> the similarity is going the be calculated
 * using the compare functions nested in the <code>Then</code> element,
 * otherwise the compare functions in the <code>Else</code> element are going to
 * be executed.
 * 
 * @see ICondition
 */
public class IfThenElse implements ICompareFunction {

	/** The compare if-then-else function's policy */
	private EvaluationPolicy ePolicy = null;

	/** The compare if-then-else function's weight */
	private float weight = 0.0f;

	/**
	 * The if-then-else function context type - whose instances this compare
	 * function operates on.
	 */
	private EClass dedicatedClass = null;
	private CompareConfiguration compareConfiguration = null;

	/** The if-then-else modules. */
	private ICondition condition = null;
	private Collection<ICompareFunction> thenItems = new LinkedList<ICompareFunction>();
	private Collection<ICompareFunction> elseItems = new LinkedList<ICompareFunction>();

	/** The state */
	private boolean normalize = false;
	private float thenSum = 0.0f;
	private float elseSum = 0.0f;

	/**
	 * Constructor.
	 * 
	 * @param dedicatedClass
	 *            The compare function's meta-model.
	 * @param policy
	 *            The compare function's policy.
	 * @param weight
	 *            The compare function's weight.
	 */
	public IfThenElse(EClass dedicatedClass, ICondition condition, EvaluationPolicy epolicy, float weight,
			CompareConfiguration compareConfiguration) {

		assert (dedicatedClass != null && condition != null && epolicy != null) : "Missing Argument (null)";
		assert (condition.getEClass() == dedicatedClass); // Conditions
															// dedicatedClass
															// and if-then-else
															// dedicatedClass
															// must match!

		this.dedicatedClass = dedicatedClass;
		this.condition = condition;
		this.ePolicy = epolicy;
		this.weight = weight;
		this.compareConfiguration = compareConfiguration;
	}
	
	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, float weight, String parameter) {
		
	}

	/**
	 * Evaluates the condition and triggers the compare functions of the if- or
	 * the else-block respectively.
	 */
	public float compare(EObject nodeInA, EObject nodeInB) {

		float result = 0.0f;

		if (condition.check(nodeInA, nodeInB)) {
			assert (LogUtil.log(LogEvent.DEBUG, "Condition " + condition.getClass().getName()
					+ condition.getClass().getName().substring(condition.getClass().getName().lastIndexOf(".") + 1)
					+ " (Parameter " + condition.getParameter() + ")" + " with nodes " + EMFUtil.getEObjectID(nodeInA)
					+ "," + EMFUtil.getEObjectID(nodeInB) + " evaluated as True"));

			result = DefaultSimilaritiesCalculation.computeSimilarity(nodeInA, nodeInB, this.thenItems);

			if (normalize) {
				result = result / thenSum;
			}

		} else {
			assert (LogUtil.log(LogEvent.DEBUG, "Condition " + condition.getClass().getName()
					+ condition.getClass().getName().substring(condition.getClass().getName().lastIndexOf(".") + 1)
					+ " (Parameter " + condition.getParameter() + ")" + " with nodes " + EMFUtil.getEObjectID(nodeInA)
					+ "," + EMFUtil.getEObjectID(nodeInB) + " evaluated as False"));

			if (elseItems.size() > 0) {
				result = DefaultSimilaritiesCalculation.computeSimilarity(nodeInA, nodeInB, this.elseItems);

				if (normalize) {
					result = result / elseSum;
				}
			} else {
				assert (LogUtil.log(LogEvent.DEBUG, "No 'else' Item(s) -> Similarity is 0.0f"));
			}
		}

		return result;
	}

	// @Override
	public void setContext() {
		// TODO VDUECK Context ???

		// this.context= context;
		// condition.init(context);

		this.thenSum = 0.0f;
		this.elseSum = 0.0f;

		for (ICompareFunction cf : thenItems) {
			// cf.setContext(context);
			thenSum += cf.getWeight();
		}
		for (ICompareFunction cf : elseItems) {
			// cf.setContext(context);
			elseSum += cf.getWeight();
		}

		this.normalize = false;
		if (this.compareConfiguration.isNormalizeWeights()) {
			this.normalize |= (Math.abs((thenSum - 1.0f)) > CompareConfiguration.EPSILON);
			this.normalize |= !elseItems.isEmpty() && (Math.abs((elseSum - 1.0f)) > CompareConfiguration.EPSILON);
		}

		// Warnings
		assert (normalize || ((Math.abs((thenSum - 1.0f)) > CompareConfiguration.EPSILON) ? LogUtil.log(
				LogEvent.WARNING, "No normalization: Sum of weight (then) isn't 1.0(" + thenSum + ") (Type: "
						+ this.dedicatedClass.getName() + ")") : true));

		assert (normalize || elseItems.isEmpty() || ((Math.abs((elseSum - 1.0f)) > CompareConfiguration.EPSILON) ? LogUtil
				.log(LogEvent.WARNING, "No normalization: Sum of weight (else) isn't 1.0(" + elseSum + ") (Type: "
						+ this.dedicatedClass.getName() + ")") : true));

	}

	public void addThenItem(ICompareFunction ci) {

		assert (ci != null);
		assert (ci.getEClass() == this.getEClass());

		thenItems.add(ci);
	}

	public void addElseItem(ICompareFunction ci) {

		assert (ci != null);
		assert (ci.getEClass() == this.getEClass());

		elseItems.add(ci);
	}

	@Override
	public EClass getEClass() {
		return this.dedicatedClass;
	}

	@Override
	public EvaluationPolicy getPolicy() {
		return this.ePolicy;
	}

	@Override
	public float getWeight() {
		return this.weight;
	}



	@Override
	public String getCompareFunctionID() {
		return "IfThenElse";
	}

	@Override
	public String getDescription() {
		return "IfThenElse";
	}



}
