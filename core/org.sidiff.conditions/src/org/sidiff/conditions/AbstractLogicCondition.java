package org.sidiff.conditions;

import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.sidiff.comparefunctions.ICompareFunction.EvaluationPolicy;

@Deprecated
public abstract class AbstractLogicCondition extends AbstractCondition {

	protected ArrayList<ICondition> conditions;
	
	public void init(EClass dedicatedClass){
		super.init(dedicatedClass, EvaluationPolicy.mandatory);
		this.conditions = new ArrayList<ICondition>();
	}
	
	public void addCondition(ICondition condition) {
		assert(getEClass().equals(condition.getEClass()));
		this.conditions.add(condition);
	}

	public List<ICondition> getConditions() {
		return Collections.unmodifiableList(this.conditions);
	}
	
	//TODO VDUECK...wie ist dies zu realisieren?
//	@Override
//	public void init() {
//		for (ICondition condition : this.conditions) {
//			condition.init();
//		}
//	}

}
