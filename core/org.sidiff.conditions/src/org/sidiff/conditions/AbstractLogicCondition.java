package org.sidiff.conditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

public abstract class AbstractLogicCondition extends AbstractCondition {

	protected List<ICondition> conditions = new ArrayList<>();

	@Override
	public void init(EClass dedicatedClass, EvaluationPolicy policy, String parameter, ICorrespondences correspondences,
			ISimilarities similarities) {
		super.init(dedicatedClass, EvaluationPolicy.mandatory, null, correspondences, similarities);
	}

	public void addCondition(ICondition condition) {
		assert(getEClass().equals(condition.getEClass()));
		this.conditions.add(condition);
	}

	public List<ICondition> getConditions() {
		return Collections.unmodifiableList(this.conditions);
	}
}
