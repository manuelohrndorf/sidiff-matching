package org.sidiff.formula.pcsimplifier;

import java.util.Collection;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Assert;
import org.sidiff.formula.Formula;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.z3.Z3SatSolverAdapter;
import org.sidiff.formula.exception.InvalidFormulaException;
import org.sidiff.formula.parser.FormulaParser;
import org.sidiff.formula.util.FormulaUtil;

/**
 * Tool for simplifying C-style presence conditions.
 * @author dreuling
 * @author jbuerdek
 * @author rmueller
 */
public class PCSimplifier {

	private static class LazyLoader {
		public static final ISatSolverAdapter satSolverAdapter =
			ISatSolverAdapter.MANAGER.getExtension(Z3SatSolverAdapter.class)
				.orElseThrow(() -> new IllegalStateException("Z3 Sat Solver Adapter not available"));
	}

	private static final Pattern PATTERN_SPACE = Pattern.compile("\\s+");
	private static final Pattern PATTERN_C_AND = Pattern.compile(Pattern.quote("&&"));
	private static final Pattern PATTERN_C_OR = Pattern.compile(Pattern.quote("||"));
	private static final Pattern PATTERN_C_NOT_VARIABLE = Pattern.compile("!(\\w+)");
	private static final Pattern PATTERN_C_NOT_PARENTHESIS = Pattern.compile("!\\(");
	private static final Pattern PATTERN_F_AND = Pattern.compile("\\band\\b");
	private static final Pattern PATTERN_F_OR = Pattern.compile("\\bor\\b");
	private static final Pattern PATTERN_F_NOT_VARIABLE = Pattern.compile("\\bnot\\(\\s*(\\w+)\\s*\\)");
	private static final Pattern PATTERN_F_NOT_PARENTHESIS = Pattern.compile("\\bnot\\(");

	/**
	 * Simplifies a given boolean presence condition. The expression may only use
	 * negation, parentheses, conjunction (&&) and disjunction (||).
	 * @param featureExpression expression to simplify
	 * @return simplified expression
	 */
	public static String simplify(String expression) {
		return convertToExpression(LazyLoader.satSolverAdapter.simplify(convertToFormula(expression)));
	}

	private static Formula convertToFormula(String expression) {
		Assert.isLegal(expression != null && !expression.isEmpty());
		String converted = PATTERN_SPACE.matcher(expression).replaceAll(" ").trim();
		converted = PATTERN_C_AND.matcher(converted).replaceAll("and");
		converted = PATTERN_C_OR.matcher(converted).replaceAll("or");
		converted = PATTERN_C_NOT_VARIABLE.matcher(converted).replaceAll("not($1)");
		converted = PATTERN_C_NOT_PARENTHESIS.matcher(converted).replaceAll("not(");
		try {
			return FormulaParser.INSTANCE.parse(converted);
		} catch (InvalidFormulaException e) {
			throw new RuntimeException("Invalid formula: " + converted, e);
		}
	}

	private static String convertToExpression(Formula formula) {
		Assert.isLegal(formula != null);
		String converted = FormulaParser.INSTANCE.unparse(formula);
		converted = PATTERN_F_AND.matcher(converted).replaceAll("&&");
		converted = PATTERN_F_OR.matcher(converted).replaceAll("||");
		converted = PATTERN_F_NOT_VARIABLE.matcher(converted).replaceAll("!$1");
		return PATTERN_F_NOT_PARENTHESIS.matcher(converted).replaceAll("!(");
	}

	/**
	 * Combines given presence conditions using disjunction (||) and simplifies.
	 * @param conditions the conditions
	 * @return simplified combined conditions
	 */
	public static String or(Collection<? extends String> conditions) {
		switch(conditions.size()) {
			case 0: return Boolean.FALSE.toString();
			case 1: return conditions.iterator().next();
			default: return convertToExpression(LazyLoader.satSolverAdapter.simplify(
						conditions.stream()
							.map(PCSimplifier::convertToFormula)
							.reduce(FormulaUtil::createOr).get()));
		}
	}

	/**
	 * Combines given presence conditions using xor, converts to DNF and simplifies.
	 * @param conditions the conditions
	 * @return simplified combined conditions
	 */
	public static String xor(Collection<? extends String> conditions) {
		switch(conditions.size()) {
			case 0: return Boolean.FALSE.toString();
			case 1: return conditions.iterator().next();
			default: return convertToExpression(LazyLoader.satSolverAdapter.simplify(
						conditions.stream()
							.map(PCSimplifier::convertToFormula)
							.reduce(FormulaUtil::createXor).get()).dnf());
		}
	}

	/**
	 * Combines given presence conditions using conjunction (&&) and simplifies.
	 * @param conditions the conditions
	 * @return simplified combined conditions
	 */
	public static String and(Collection<? extends String> conditions) {
		switch(conditions.size()) {
			case 0: return Boolean.TRUE.toString();
			case 1: return conditions.iterator().next();
			default: return convertToExpression(LazyLoader.satSolverAdapter.simplify(
					conditions.stream()
					.map(PCSimplifier::convertToFormula)
					.reduce(FormulaUtil::createAnd).get()));
		}
	}

	/**
	 * Negates the given presence condition and simplifies.
	 * @param condition the condition
	 * @return simplified negated condition
	 */
	public static String negate(String condition) {
		Assert.isLegal(condition != null && !condition.isEmpty(), "Condition cannot be null or empty");
		if (condition.equals(Boolean.TRUE.toString())) {
			return Boolean.FALSE.toString();
		} else if (condition.equals(Boolean.FALSE.toString())) {
			return Boolean.TRUE.toString();
		}
		return convertToExpression(LazyLoader.satSolverAdapter.simplify(
				FormulaUtil.createNot(convertToFormula(condition))));
	}

	/**
	 * Checks whether two presence conditions are equivalent,
	 * i.e. whether "L and not(R)" and "not(L) and R" are unsatisfiable.
	 * @param lhs first presence condition
	 * @param rhs second presence condition
	 * @return <code>true</code> if equivalent, <code>false</code> otherwise
	 */
	public static boolean areEquivalent(String lhs, String rhs) {
		Assert.isLegal(lhs != null && !lhs.isEmpty());
		Assert.isLegal(rhs != null && !rhs.isEmpty());
		return
			LazyLoader.satSolverAdapter.isSatisfiable(
				FormulaUtil.createAnd(
					convertToFormula(lhs),
					FormulaUtil.createNot(convertToFormula(rhs)))
				).getStatus() == SatResult.EStatus.UNSATISFIABLE
			&& LazyLoader.satSolverAdapter.isSatisfiable(
				FormulaUtil.createAnd(
					FormulaUtil.createNot(convertToFormula(lhs)),
					convertToFormula(rhs))
				).getStatus() == SatResult.EStatus.UNSATISFIABLE;
	}

	/**
	 * Checks whether a presence condition is specialization of another,
	 * i.e. whether "L and not(R)" is unsatisfiable.
	 * @param specific the specialization
	 * @param general the generalization
	 * @return <code>true</code> if specific is a specialization of general, <code>false</code> otherwise
	 */
	public static boolean isSpecialization(String specific, String general) {
		Assert.isLegal(specific != null && !specific.isEmpty());
		Assert.isLegal(general != null && !general.isEmpty());
		return LazyLoader.satSolverAdapter.isSatisfiable(
					FormulaUtil.createAnd(
						convertToFormula(specific),
						FormulaUtil.createNot(convertToFormula(general)))
				).getStatus() == SatResult.EStatus.UNSATISFIABLE;
	}
}
