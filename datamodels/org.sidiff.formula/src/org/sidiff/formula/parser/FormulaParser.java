package org.sidiff.formula.parser;

import java.util.regex.Pattern;

import org.sidiff.formula.*;
import org.sidiff.formula.exception.InvalidFormulaException;
import org.sidiff.formula.util.FormulaUtil;

/**
 * The formula parser parses strings and unparses formulas.
 * This class is immutable and {@link #INSTANCE} is the singleton instance.
 * <pre>
 * &lt;expression>  ::= &lt;formula1> { 'implies' &lt;formula1> }
 * &lt;formula1>    ::= &lt;formula2> { ('or' | 'xor') &lt;formula2> }
 * &lt;formula2>    ::= &lt;formula3> { 'and' &lt;formula3> }
 * &lt;formula3>    ::= &lt;variable> | (' &lt;expression> ')' | 'not(' &lt;expression> ')'
 * &lt;variable>    ::= &lt;letter> { &lt;letter> | &lt;digit> } {'=' ('mandatory' | 'optional')}
 * &lt;letter>      ::= 'A' | ... | 'z' | 'a' | ... | 'z'
 * &lt;digit>       ::= '0' | ... | '9'
 * </pre>
 * @author cpietsch
 * @author rmueller
 */
public class FormulaParser {

	/**
	 * The singleton instance
	 */
	public static final FormulaParser INSTANCE = new FormulaParser();

	private static final String NEG = "not";
	private static final String OR = "or";
	private static final String XOR = "xor";
	private static final String AND = "and";
	private static final String IMPLIES = "implies";
	private static final String OPEN_BRACKET = "(";
	private static final String CLOSE_BRACKET = ")";
	private static final String EQUALS = "=";

	private static final Pattern PATTERN_OPEN_BRACKET = Pattern.compile("\\s*" + Pattern.quote(OPEN_BRACKET) + "\\s*");
	private static final Pattern PATTERN_CLOSE_BRACKET = Pattern.compile("\\s*" + Pattern.quote(CLOSE_BRACKET) + "\\s*");
	private static final Pattern PATTERN_SPACES = Pattern.compile("\\s+");
	private static final Pattern PATTERN_WORD = Pattern.compile("\\w+");

	private FormulaParser() {
		// singleton constructor
	}

	private static Formula expression(Tokenizer<String> tokenizer) throws InvalidFormulaException{
		Formula formula = formula1(tokenizer);
		while(tokenizer.hasNext() && tokenizer.peek().equals(IMPLIES)){
			tokenizer.next();
			formula = FormulaUtil.createImplies(formula, formula1(tokenizer));
		}
		return formula;
	}

	private static Formula formula1(Tokenizer<String> tokenizer) throws InvalidFormulaException{
		Formula formula = formula2(tokenizer);
		while(tokenizer.hasNext() && (tokenizer.peek().equals(OR) || tokenizer.peek().equals(XOR))) {
			if(tokenizer.peek().equals(OR)) {
				tokenizer.next();
				formula = FormulaUtil.createOr(formula, formula2(tokenizer));
			} else if(tokenizer.peek().equals(XOR)) {
				tokenizer.next();
				formula = FormulaUtil.createXor(formula, formula2(tokenizer));
			}
		}
		return formula;
	}

	private static Formula formula2(Tokenizer<String> tokenizer) throws InvalidFormulaException{
		Formula formula = formula3(tokenizer);
		while(tokenizer.hasNext() && tokenizer.peek().equals(AND)) {
			tokenizer.next();
			formula = FormulaUtil.createAnd(formula, formula3(tokenizer));
		}
		return formula;
	}

	private static Formula formula3(Tokenizer<String> tokenizer) throws InvalidFormulaException {
		Formula formula = null;
		if(tokenizer.hasNext() && tokenizer.peek().equals(NEG)) {
			tokenizer.next();
			if(tokenizer.hasNext() && tokenizer.peek().equals(OPEN_BRACKET)) {
				tokenizer.next();
				formula = FormulaUtil.createNot(expression(tokenizer));
				if(tokenizer.hasNext() && tokenizer.peek().equals(CLOSE_BRACKET)) {
					tokenizer.next();
				} else {
					throw new InvalidFormulaException("Missing '" + CLOSE_BRACKET + "'");
				}
			} else {
				throw new InvalidFormulaException("Missing '" + OPEN_BRACKET + "'");
			}
		} else if(tokenizer.hasNext() && tokenizer.peek().equals(OPEN_BRACKET)) {
			tokenizer.next();
			formula = expression(tokenizer);
			if(tokenizer.hasNext() && tokenizer.peek().equals(CLOSE_BRACKET)) {
				tokenizer.next();
			} else{
				throw new InvalidFormulaException("Missing '" + CLOSE_BRACKET + "'");
			}
		} else {
			formula = variable(tokenizer);
		}
		return formula;
	}

	private static Formula variable(Tokenizer<String> tokenizer) throws InvalidFormulaException {
		if(tokenizer.hasNext() && PATTERN_WORD.matcher(tokenizer.peek()).matches()) {
			Variable variable = FormulaUtil.createVariable(tokenizer.next());
			if(tokenizer.hasNext() && tokenizer.peek().equals(EQUALS)) {
				tokenizer.next();
				if(tokenizer.hasNext()) {
					String kind = tokenizer.next().toUpperCase();
					VariationType type = VariationType.get(kind);
					if(type == null) {
						throw new InvalidFormulaException("Variation type invalid: " + kind);
					}
					variable.setType(type);
				} else {
					throw new InvalidFormulaException("Variation type of variable expected");
				}
			}
			return variable;
		}
		throw new InvalidFormulaException("Variable expected");
	}

	private static String normalizeSpaces(String input) {
		String expression = PATTERN_OPEN_BRACKET.matcher(input).replaceAll(" ( ");
		expression = PATTERN_CLOSE_BRACKET.matcher(expression).replaceAll(" ) ");
		expression = expression.replace("=", " = ");
		expression = expression.trim();
		expression = PATTERN_SPACES.matcher(expression).replaceAll(";");
		return expression;
	}

	public Formula parse(String input) throws InvalidFormulaException {
		try {
			// the tokenizer is passed by argument to allow this class to be immutable
			Tokenizer<String> tokenizer = new Tokenizer<>(normalizeSpaces(input).split(";"));
			Formula formula = expression(tokenizer);
			if(tokenizer.hasNext()) {
				throw new InvalidFormulaException("'" + AND + "', '" + OR + "', '" + XOR + "' or '" +
						IMPLIES + "' " + "instead of " + tokenizer.next() + " expected");
			}
			return formula;
		} catch(InvalidFormulaException e) {
			// Wrap the low level problem in exception that describes the invalid input.
			throw new InvalidFormulaException("The formula is invalid: " + input, e);
		}
	}

	public String unparse(Formula formula) {
		StringBuilder builder = new StringBuilder();
		if (formula instanceof Variable) {
			Variable variable = (Variable)formula;
			builder.append(variable.getName());
			if (variable.getType() != VariationType.UNDEFINED) {
				builder.append(EQUALS);
				builder.append(variable.getType().getLiteral());
			}
		} else if (formula instanceof Not) {
			builder.append(NEG).append(OPEN_BRACKET).append(" ")
				.append(unparse(((Not)formula).getFormula()))
				.append(" ").append(CLOSE_BRACKET);
		} else if (formula instanceof BinaryFormula) {
			BinaryFormula binaryFormula = (BinaryFormula)formula;
			boolean bracketed = binaryFormula.eContainer() instanceof Formula
					&& !(binaryFormula.eContainer() instanceof Not)
					&& ((Formula)binaryFormula.eContainer()).getPriority() < binaryFormula.getPriority();
			if (bracketed) {
				builder.append(OPEN_BRACKET).append(" ");
			}
			builder.append(unparse(binaryFormula.getLeft()));
			builder.append(" ").append(formula.eClass().getName().toLowerCase()).append(" ");
			builder.append(unparse(binaryFormula.getRight()));
			if (bracketed) {
				builder.append(" ").append(CLOSE_BRACKET);
			}
		}
		return builder.toString();
	}
}
