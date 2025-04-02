package org.sidiff.formula.adapter.sat4j.cnf;

import java.util.Map;

import org.sidiff.formula.util.FormulaUtil;

public class CNFUtil {

	

	public static Formula convert(org.sidiff.formula.Formula formula, Map<String, Var> variables) {
		
		if(formula instanceof org.sidiff.formula.Implies) {
			org.sidiff.formula.Implies implies = (org.sidiff.formula.Implies) formula;
			return CNF.iff(convert(implies.getLeft(), variables), convert(implies.getRight(), variables));
		}else if (formula instanceof org.sidiff.formula.Xor) {
			org.sidiff.formula.Xor xor = (org.sidiff.formula.Xor) formula;
			return CNF.xor(convert(xor.getLeft(), variables), convert(xor.getRight(), variables));
		}else if(formula instanceof org.sidiff.formula.And) {
			org.sidiff.formula.And and = (org.sidiff.formula.And) formula;
			return CNF.and(convert(and.getLeft(), variables), convert(and.getRight(), variables));
		}else if(formula instanceof org.sidiff.formula.Or) {
			org.sidiff.formula.Or or = (org.sidiff.formula.Or) formula;
			return CNF.or(convert(or.getLeft(),variables), convert(or.getRight(), variables));
		}else if(formula instanceof org.sidiff.formula.Not) {
			org.sidiff.formula.Not not = (org.sidiff.formula.Not) formula;
			return CNF.neg(convert(not.getFormula(), variables));
		}else if(formula instanceof org.sidiff.formula.Variable) {
			org.sidiff.formula.Variable variable = (org.sidiff.formula.Variable) formula;
			Var var = variables.get(variable.getName());
			if(var == null) {
				var = CNF.freshVar();
				variables.put(variable.getName(), var);
			}
			return CNF.var(variable.getName(), var);
		}
		return null;
	}
	
//	public static org.sidiff.formula.Formula convert(Formula formula) {
//		
//		if(formula instanceof FormulaAnd) {
//			FormulaAnd and = (FormulaAnd) formula;
//		
//			return FormulaUtil.createAnd(convert(and.fms.get(0)), convert(and.fms.get(0)));
//			
//		}else if(formula instanceof FormulaOr) {
//			FormulaOr or = (FormulaOr) formula;
//			
//			return FormulaUtil.createOr(convert(or.fms.get(0)), convert(or.fms.get(0)));
//		}else if(formula instanceof FormulaNeg) {
//			FormulaNeg neg = (FormulaNeg) formula;
//			return FormulaUtil.createNot(convert(neg.fm));
//		}else if(formula instanceof FormulaVar) {
//			FormulaVar variable = (FormulaVar) formula;
//			return FormulaUtil.createVariable(variable.getLabel());
//		}
//	
//		return null;
//	}
}
