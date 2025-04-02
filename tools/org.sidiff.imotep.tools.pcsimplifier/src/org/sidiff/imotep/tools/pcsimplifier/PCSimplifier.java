package org.sidiff.imotep.tools.pcsimplifier;

import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.sidiff.formula.Formula;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.z3.Z3SatSolverAdapter;
import org.sidiff.formula.exception.InvalidFormulaException;
import org.sidiff.formula.parser.FormulaParser;

/**
 * Tool for simplifying presence conditions.
 * @author dreuling
 * @author jbuerdek
 * @author rmueller
 */
public class PCSimplifier {

	private static final ISatSolverAdapter satSolverAdapter =
		ISatSolverAdapter.MANAGER.getExtension(Z3SatSolverAdapter.class)
			.orElseThrow(() -> new IllegalStateException("Z3 Sat Solver Adapter not available"));

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
		try {
			return convertToExpression(satSolverAdapter.simplify(convertToFormula(expression)));
		} catch (InvalidFormulaException e) {
			throw new RuntimeException("Invalid formula. Expression: " + expression, e);
		}
	}

	private static Formula convertToFormula(String expression) throws InvalidFormulaException {
		String converted = PATTERN_SPACE.matcher(expression).replaceAll(" ").trim();
		converted = PATTERN_C_AND.matcher(converted).replaceAll("and");
		converted = PATTERN_C_OR.matcher(converted).replaceAll("or");
		converted = PATTERN_C_NOT_VARIABLE.matcher(converted).replaceAll("not($1)");
		converted = PATTERN_C_NOT_PARENTHESIS.matcher(converted).replaceAll("not(");
		return FormulaParser.INSTANCE.parse(converted);
	}

	private static String convertToExpression(Formula formula) {
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
		if (conditions.isEmpty()) {
			return "false";
		}
		return simplify(conditions.stream().collect(Collectors.joining(") || (", "(", ")")));
	}

	/**
	 * Combines given presence conditions using conjunction (&&) and simplifies.
	 * @param conditions the conditions
	 * @return simplified combined conditions
	 */
	public static String and(Collection<? extends String> conditions) {
		if (conditions.isEmpty()) {
			return "true";
		}
		return simplify(conditions.stream().collect(Collectors.joining(") && (", "(", ")")));
	}

	/**
	 * Negates the given presence condition and simplifies.
	 * @param condition the condition
	 * @return simplified negated condition
	 */
	public static String negate(String condition) {
		Assert.isLegal(condition != null && !condition.isEmpty(), "Condition cannot be null or empty");
		return simplify("!(" + condition + ")");
	}
}
