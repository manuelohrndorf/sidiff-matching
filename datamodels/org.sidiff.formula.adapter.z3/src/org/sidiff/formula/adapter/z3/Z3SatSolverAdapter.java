package org.sidiff.formula.adapter.z3;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;

import org.sidiff.formula.Formula;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.SatResult.EStatus;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterException;
import org.sidiff.formula.adapter.z3.util.FormulaConverter;

import com.microsoft.z3.*;

/**
 * Adapter for the <a href="https://github.com/Z3Prover/z3">Z3 Theorem
 * Prover</a> Java API.
 *
 * @author cpietsch
 * @author rmueller
 */
public class Z3SatSolverAdapter implements ISatSolverAdapter {

	@Override
	public SatResult isSatisfiable(Formula formula) {
		try (Context ctx = new Context()) {
			BoolExpr boolExpr = new FormulaConverter().convert(formula, ctx);

			Solver solver = ctx.mkSolver();
			solver.add(boolExpr);
			Status status = solver.check();

			Map<String, String> assignments = new HashMap<>();
			if (status.equals(Status.SATISFIABLE)) {
				for (Expr expr : FormulaConverter.getVariables(boolExpr)) {
					Expr assignment = solver.getModel().getConstInterp(expr);
					assignments.put(expr.toString(), assignment != null ? assignment.toString() : "X");
				}
			}
			return new SatResult(convertStatusToEStatus(status), formula, assignments);
		}
	}

	@Override
	public Set<SatResult> findAllSolutions(Formula formula, Duration timeout) throws SatSolverAdapterException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Set<SatResult> results = new HashSet<>();
		Future<Set<SatResult>> result = executor.submit(new SolutionFinder(formula));
		try {
			results.addAll(result.get(timeout.getSeconds(), TimeUnit.SECONDS));
			if(results.isEmpty()) {
				results.add(new SatResult(EStatus.UNSATISFIABLE, formula));
			}
		} catch (InterruptedException | ExecutionException e) {
			throw new SatSolverAdapterException(e);
		} catch (TimeoutException e) {
			results.add(new SatResult(EStatus.TIMEOUT, formula));
		}
		return results;
	}

	private static EStatus convertStatusToEStatus(Status status) {
		switch (status) {
		case SATISFIABLE:
			return EStatus.SATISFIABLE;
		case UNSATISFIABLE:
			return EStatus.UNSATISFIABLE;
		default:
			return EStatus.UNKNOWN;
		}
	}

	@Override
	public Formula simplify(Formula formula) throws SatSolverAdapterException {
		try (Context ctx = new Context()) {
			FormulaConverter converter = new FormulaConverter();
			BoolExpr boolExpr = converter.convert(formula, ctx);

			Tactic css = ctx.mkTactic("ctx-solver-simplify");
			Goal goal = ctx.mkGoal(true, true, false);
			goal.add(boolExpr);
			BoolExpr simplifiedExpr = css.apply(goal).getSubgoals()[0].AsBoolExpr();

			return converter.convert(simplifiedExpr, ctx);
		}
	}

	@Override
	public String getKey() {
		return this.getClass().getName();
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	class SolutionFinder implements Callable<Set<SatResult>> {

		private Formula formula;

		public SolutionFinder(Formula formula) {
			this.formula = formula;
		}

		@Override
		public Set<SatResult> call() throws Exception {
			Set<SatResult> result = new HashSet<>();
			try (Context ctx = new Context()) {
				BoolExpr boolExpr = new FormulaConverter().convert(formula, ctx);

				Solver solver = ctx.mkSolver();
				solver.add(boolExpr);
				Status status = solver.check();

				while (status.equals(Status.SATISFIABLE)) {
					Map<String, String> assignments = new HashMap<>();
					if (status.equals(Status.SATISFIABLE)) {
						Set<Expr> expressions = new HashSet<>();
						for (Expr expr : FormulaConverter.getVariables(boolExpr)) {
							Expr assignment = solver.getModel().getConstInterp(expr);
							if (assignment != null) {
								assignments.put(expr.toString(), assignment.toString());
								Boolean b = Boolean.valueOf(assignment.toString());
								expressions.add(ctx.mkEq(expr, ctx.mkBool(!b)));
							} else {
								assignments.put(expr.toString(), "X");
							}
						}
						if (!expressions.isEmpty()) {
							solver.add(ctx.mkOr(expressions.toArray(new BoolExpr[] {})));
						}
						result.add(new SatResult(convertStatusToEStatus(status), formula, assignments));
					}

					status = solver.check();

				}

				return result;
			}
		}
	}
}
