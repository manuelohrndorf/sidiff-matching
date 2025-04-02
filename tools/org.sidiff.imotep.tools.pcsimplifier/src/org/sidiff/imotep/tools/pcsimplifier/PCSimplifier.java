package org.sidiff.imotep.tools.pcsimplifier;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.microsoft.z3.ApplyResult;
import com.microsoft.z3.BoolExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Goal;
import com.microsoft.z3.Tactic;
import com.microsoft.z3.Z3Exception;

import de.imotep.SimpleFeatureExpressionParser;
import de.imotep.simpleFeatureExpression.BracedExpression;
import de.imotep.simpleFeatureExpression.SimpleFeatureExpression;

/**
 * Tool for simplifying presence conditions
 * @author dreuling / jbuerdek
 *
 */
public class PCSimplifier {

	private static Map<String, BoolExpr> variables;

	/**
	 * Simplifies a given boolean presence condition.
	 * The expression may only use negation, parentheses, conjunction (&&) and disjunction (||). 
	 * Furthermore only infix expressions are supported.
	 * @param featureExpression expression to simplify
	 * @param nt notation type to return (infix or prefix)
	 * @return simplified expression
	 * @throws IOException
	 * @throws Z3Exception
	 */
	public static String simplify(String featureExpression, NotationType nt) throws IOException, Z3Exception {
		String result = null;

		variables = new HashMap<String, BoolExpr>();

		featureExpression = "(" + featureExpression + ")";

		SimpleFeatureExpressionParser parser = new SimpleFeatureExpressionParser();
		EObject expr = parser.parse(featureExpression);

		if (expr instanceof SimpleFeatureExpression) {
			SimpleFeatureExpression simpleFeatureExpression = (SimpleFeatureExpression) expr;
			Context ctx = new Context();

			BoolExpr boolExpr = parseSimpleFeatureExpression(simpleFeatureExpression, ctx);

			Tactic css = ctx.mkTactic("ctx-solver-simplify");
			Goal goal = ctx.mkGoal(true, true, false);
			goal.add(boolExpr);
			ApplyResult res = css.apply(goal);

			Goal subgoal = res.getSubgoals()[0];
			if (subgoal.getFormulas().length != 0) {
				if (subgoal.getFormulas().length == 1) {
					result = subgoal.getFormulas()[0].toString();
				} else {
					result = "(and";
					for (BoolExpr formula : subgoal.getFormulas()) {
						result += " " + formula;
					}
					result += ")";
				}
			}
		}
		
		//Replace prefix notation with infix
		if(nt == NotationType.INFIX)
			result =  LogParser.parse(result);
		else{
			result = result.replaceAll("\\band\\b", "&&");
			result = result.replaceAll("\\bor\\b", "||");
			result = result.replaceAll("\\bnot\\b\\s+", "!");
		}
		result = result.replaceAll("\n", "");


		return result;
	}
	
	private static BoolExpr parseSimpleFeatureExpression(SimpleFeatureExpression simpleFeatureExpression, Context ctx)
			throws Z3Exception {
		BoolExpr expr = null;

		if (simpleFeatureExpression.getBraExpr() != null) {
			BracedExpression bracedExpression = simpleFeatureExpression.getBraExpr();
			if (bracedExpression.getOp() != null && bracedExpression.getExpr1() != null
					&& bracedExpression.getExpr2() != null) {
				expr = parseSimpleFeatureExpression(bracedExpression.getExpr1(), ctx);

				for (int i = 0; i < bracedExpression.getExpr2().size(); i++) {
					BoolExpr expr2 = parseSimpleFeatureExpression(bracedExpression.getExpr2().get(i), ctx);
					String op = bracedExpression.getOp().get(i);
					if (op.equals("&&")) {
						expr = ctx.mkAnd(expr, expr2);
					} else if (op.equals("||")) {
						expr = ctx.mkOr(expr, expr2);
					} else {
						return null;
					}
				}
			}

			if (simpleFeatureExpression.getNeg() != null) {
				expr = ctx.mkNot(expr);
			}
		} else if (simpleFeatureExpression.getVar() != null) {
			expr = getVariableExpression(simpleFeatureExpression.getVar(), ctx);
			if (simpleFeatureExpression.getNeg() != null) {
				expr = ctx.mkNot(expr);
			}
		}

		return expr;
	}

	private static BoolExpr getVariableExpression(String var, Context ctx) throws Z3Exception {
		if (variables.get(var) == null) {
			return ctx.mkBoolConst(var);
		} else {
			return variables.get(var);
		}
	}

}
