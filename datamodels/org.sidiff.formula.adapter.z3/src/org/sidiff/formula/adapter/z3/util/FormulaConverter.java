package org.sidiff.formula.adapter.z3.util;

import java.util.*;

import org.sidiff.formula.*;
import org.sidiff.formula.util.FormulaUtil;

import com.microsoft.z3.*;

/**
 *
 * @author cpietsch
 *
 */
public class FormulaConverter {

	private Map<String,VariationType> variationTypes = new HashMap<>();

	public BoolExpr convert(Formula formula, Context ctx) {
		variationTypes.clear();
		return convert(formula, ctx, new HashMap<>());
	}

	private BoolExpr convert(Formula formula, Context ctx, Map<String, BoolExpr> variables) {
		if(formula == null) {
			throw new IllegalArgumentException("formula is null");
		} else if (formula instanceof Implies) {
			return convertImplies(ctx, variables, (Implies) formula);
		} else if (formula instanceof Xor) {
			return convertXor(ctx, variables, (Xor) formula);
		} else if (formula instanceof And) {
			return convertAnd(ctx, variables, (And) formula);
		} else if (formula instanceof Or) {
			return convertOr(ctx, variables, (Or) formula);
		} else if (formula instanceof Not) {
			return convertNot(ctx, variables, (Not) formula);
		} else if (formula instanceof Variable) {
			return convertVariable(ctx, variables, (Variable)formula);
		} else {
			throw new UnsupportedOperationException("formula is not supported by FormulaConverter: " + formula);
		}
	}

	private BoolExpr convertImplies(Context ctx, Map<String, BoolExpr> variables, Implies implies) {
		return ctx.mkImplies(convert(implies.getLeft(), ctx, variables), convert(implies.getRight(), ctx, variables));
	}

	private BoolExpr convertXor(Context ctx, Map<String, BoolExpr> variables, Xor xor) {
		return ctx.mkXor(convert(xor.getLeft(), ctx, variables), convert(xor.getRight(), ctx, variables));
	}

	private BoolExpr convertAnd(Context ctx, Map<String, BoolExpr> variables, And and) {
		return ctx.mkAnd(convert(and.getLeft(), ctx, variables), convert(and.getRight(), ctx, variables));
	}

	private BoolExpr convertOr(Context ctx, Map<String, BoolExpr> variables, Or or) {
		return ctx.mkOr(convert(or.getLeft(), ctx, variables), convert(or.getRight(), ctx, variables));
	}

	private BoolExpr convertNot(Context ctx, Map<String, BoolExpr> variables, Not not) {
		return ctx.mkNot(convert(not.getFormula(), ctx, variables));
	}

	private BoolExpr convertVariable(Context ctx, Map<String, BoolExpr> variables, Variable variable) {
		return variables.computeIfAbsent(variable.getName(), var -> {
			if(var.equals("true")) {
				return ctx.mkTrue();
			} else if(var.equals("false")) {
				return ctx.mkFalse();
			} else {
				variationTypes.put(var, variable.getType());
				return ctx.mkBoolConst(var);
			}
		});
	}

	public Formula convert(Expr boolExpr, Context ctx) {
		if(boolExpr.isConst()) {
			String name = boolExpr.toString();
			// Some names (for instance those starting with numbers), are escaped by Z3 using |
			if (name.startsWith("|") && name.endsWith("|")) {
				name = name.substring(1, name.length()-1);
			}
			return FormulaUtil.createVariable(name, variationTypes.getOrDefault(name, VariationType.UNDEFINED));
		} else if(boolExpr.isNot()) {
			assert boolExpr.getArgs().length == 1: "one expression excepted!";
			return FormulaUtil.createNot(convert(boolExpr.getArgs()[0], ctx));
		} else if(boolExpr.isAnd()) {
			Expr left = boolExpr.getArgs()[0];
			Expr right = null;
			if(boolExpr.getArgs().length == 2) {
				right = boolExpr.getArgs()[1];
			} else {
				BoolExpr[] exprs = new BoolExpr[boolExpr.getArgs().length-1];
				for(int i = 1; i < boolExpr.getArgs().length; i++) {
					exprs[i-1] = (BoolExpr) boolExpr.getArgs()[i];
				}
				right = ctx.mkAnd(exprs);
			}
			return FormulaUtil.createAnd(convert(left, ctx), convert(right, ctx));
		} else if(boolExpr.isOr()) {
			Expr left = boolExpr.getArgs()[0];
			Expr right = null;
			if(boolExpr.getArgs().length==2) {
				right = boolExpr.getArgs()[1];
			}else {
				BoolExpr[] exprs = new BoolExpr[boolExpr.getArgs().length-1];
				for(int i = 1; i < boolExpr.getArgs().length; i++) {
					exprs[i-1] = (BoolExpr) boolExpr.getArgs()[i];
				}
				right = ctx.mkOr(exprs);
			}
			return FormulaUtil.createOr(convert(left, ctx), convert(right, ctx));
		} else if(boolExpr.isXor()) {
			assert boolExpr.getArgs().length == 2 : "two expressions expected!";
			return FormulaUtil.createXor(convert(boolExpr.getArgs()[0], ctx), convert(boolExpr.getArgs()[1], ctx));
		} else if(boolExpr.isImplies()) {
			assert boolExpr.getArgs().length == 2 : "two expressions expected!";
			return FormulaUtil.createImplies(convert(boolExpr.getArgs()[0], ctx), convert(boolExpr.getArgs()[1], ctx));
		}
		throw new UnsupportedOperationException(boolExpr + " cannot be converted!");
	}

	public static Set<Expr> getVariables(Expr expr) {
		Set<Expr> result = new HashSet<>();
		if(expr.isConst() && !(expr.isTrue() || expr.isFalse())) {
			result.add(expr);
		} else {
			for(Expr e : expr.getArgs()) {
				result.addAll(getVariables(e));
			}
		}
		return result;
	}
}
