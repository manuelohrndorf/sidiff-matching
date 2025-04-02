package org.sidiff.formula.adapter.sat4j.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sat4j.core.Vec;
import org.sat4j.core.VecInt;
import org.sat4j.specs.IVec;
import org.sat4j.specs.IVecInt;
import org.sidiff.formula.Formula;
import org.sidiff.formula.Not;
import org.sidiff.formula.Variable;


/**
 *
 * @author cpietsch
 *
 */
public class FormulaConverter {

	public Sat4J_Mapping convert(Formula formula){
		
		Formula cnf = EcoreUtil.copy(formula).cnf();
		Formula[] clauses = cnf.getAssociativeFormulas(cnf.eClass()).toArray(new Formula[] {});
		
		IVec<IVecInt> vec = new Vec<IVecInt>(clauses.length);
		
		Map<String, Integer> variables = new HashMap<>();
		
		int varInt = 1;
		for(Variable variable : cnf.getVariables()) {
			if(!(variable.getName().equals("true") || variables.containsKey(variable.getName()))) {
				variables.put(variable.getName(), varInt);
				varInt++;
			}
		}
		
		for (Formula clause : clauses) {
			VecInt vecInt = new VecInt();
			for(Variable variable : clause.getVariables()) {
				if(!variable.getName().equals("true")) {
				int sign = 1;
				EObject container = variable.eContainer();
				if(container != null) {
					if(container instanceof Not) {
						sign *= -1;
					}
				}
				vecInt.push(sign*variables.get(variable.getName()));
				}
			}
			vec.push(vecInt);
		}
		
		return new Sat4J_Mapping(variables, vec);
	}
	
	public class Sat4J_Mapping{
		Map<String, Integer> variables;
		Map<Integer, String> numbers;
		IVec<IVecInt> clauses;
		
		public Sat4J_Mapping(Map<String, Integer> variables, IVec<IVecInt> vec) {
			this.variables = variables;
			this.numbers = new HashMap<>();
			for(Entry<String, Integer> entry : this.variables.entrySet()) {
				this.numbers.put(entry.getValue(), entry.getKey());
			}
			this.clauses = vec;
		}
		
		public Map<String, Integer> getVariables() {
			return variables;
		}
		
		public Map<Integer, String> getNumbers() {
			return numbers;
		}
		
		public IVec<IVecInt> getClauses() {
			return clauses;
		}
	}
}
