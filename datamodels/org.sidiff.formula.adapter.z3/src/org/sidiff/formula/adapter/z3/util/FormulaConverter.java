package org.sidiff.formula.adapter.z3.util;

import static org.sidiff.formula.util.FormulaUtil.*;

import java.util.*;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.formula.*;
import org.sidiff.formula.util.FormulaUtil;

import com.microsoft.z3.*;

/**
 * Helper class to convert between our {@link Formula}s and Z3 {@link BoolExpr}s.
 * @author cpietsch
 * @author rmueller
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
			Implies implies = (Implies) formula;
			return ctx.mkImplies(convert(implies.getLeft(), ctx, variables), convert(implies.getRight(), ctx, variables));
		} else if (formula instanceof Xor) {
			Xor xor = (Xor) formula;
			return ctx.mkXor(convert(xor.getLeft(), ctx, variables), convert(xor.getRight(), ctx, variables));
		} else if (formula instanceof And) {
			And and = (And) formula;
			return ctx.mkAnd(convert(and.getLeft(), ctx, variables), convert(and.getRight(), ctx, variables));
		} else if (formula instanceof Or) {
			Or or = (Or) formula;
			return ctx.mkOr(convert(or.getLeft(), ctx, variables), convert(or.getRight(), ctx, variables));
		} else if (formula instanceof Not) {
			return ctx.mkNot(convert(((Not) formula).getFormula(), ctx, variables));
		} else if (formula instanceof Variable) {
			Variable variable = (Variable)formula;
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
		throw new UnsupportedOperationException("Formula is not supported by FormulaConverter: " + formula);
	}

	public Formula convert(Expr<?> boolExpr, Context ctx) {
		if(boolExpr.isConst()) {
			String name = boolExpr.toString();
			// Some names (for instance those starting with numbers), are escaped by Z3 using |
			if (name.startsWith("|") && name.endsWith("|")) {
				name = name.substring(1, name.length()-1);
			}
			return createVariable(name, variationTypes.getOrDefault(name, VariationType.UNDEFINED));
		} else if(boolExpr.isNot()) {
			assert boolExpr.getArgs().length == 1: "one expression excepted!";
			return createNot(convert(boolExpr.getArgs()[0], ctx));
		} else if(boolExpr.isAnd()) {
			return Stream.of(boolExpr.getArgs())
				.map(expr -> convert(expr, ctx))
				.reduce(FormulaUtil::createAnd)
				.get();
		} else if(boolExpr.isOr()) {
			return Stream.of(boolExpr.getArgs())
				.map(expr -> convert(expr, ctx))
				.reduce(FormulaUtil::createOr)
				.get();
		} else if(boolExpr.isXor()) {
			assert boolExpr.getArgs().length == 2 : "two expressions expected!";
			return createXor(convert(boolExpr.getArgs()[0], ctx), convert(boolExpr.getArgs()[1], ctx));
		} else if(boolExpr.isImplies()) {
			assert boolExpr.getArgs().length == 2 : "two expressions expected!";
			return createImplies(convert(boolExpr.getArgs()[0], ctx), convert(boolExpr.getArgs()[1], ctx));
		} else if(boolExpr.isEq()) {
			assert boolExpr.getArgs().length == 2 : "two expressions expected!";
			Formula left = convert(boolExpr.getArgs()[0], ctx);
			Formula right = convert(boolExpr.getArgs()[1], ctx);
			return createAnd(
					createImplies(left, right),
					createImplies(EcoreUtil.copy(right), EcoreUtil.copy(left)));
		}
		throw new UnsupportedOperationException("BoolExpr is not supposed by FormulaConverted: " + boolExpr);
	}

	public static Set<Expr<?>> getVariables(Expr<?> expr) {
		Set<Expr<?>> result = new HashSet<>();
		if(expr.isConst() && !(expr.isTrue() || expr.isFalse())) {
			result.add(expr);
		} else {
			for(Expr<?> e : expr.getArgs()) {
				result.addAll(getVariables(e));
			}
		}
		return result;
	}
}
