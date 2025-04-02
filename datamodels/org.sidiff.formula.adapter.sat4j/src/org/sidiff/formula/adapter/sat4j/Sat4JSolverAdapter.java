package org.sidiff.formula.adapter.sat4j;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sidiff.formula.Formula;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.SatResult.EStatus;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterException;
import org.sidiff.formula.adapter.sat4j.util.FormulaConverter;
import org.sidiff.formula.adapter.sat4j.util.FormulaConverter.Sat4J_Mapping;


public class Sat4JSolverAdapter implements ISatSolverAdapter {

	@Override
	public SatResult isSatisfiable(Formula formula)  {
		ISolver solver = SolverFactory.newDefault();

		Sat4J_Mapping mapping = new FormulaConverter().convert(formula);

		// prepare the solver to accept MAXVAR variables. MANDATORY for MAXSAT solving
		solver.newVar(mapping.getVariables().size());
		solver.setExpectedNumberOfClauses(mapping.getClauses().size());
		// Feed the solver using Dimacs format, using arrays of int
		// (best option to avoid dependencies on SAT4J IVecInt)
		Map<String, String> assignments = new HashMap<>();
		try {
			try {
			solver.addAllClauses(mapping.getClauses());
			}catch(ContradictionException e) {
				System.out.println(e.getMessage());
			}
		
			
			boolean b = solver.isSatisfiable();
			

			if (b) {
				int[] solution = solver.model();
			
				for(int i = 0; i < solution.length; i++) {
					int assignment = solution[i];
					String variable = mapping.getNumbers().get(assignment < 0? assignment*-1: assignment);
					assignments.put(variable, "true");
					System.out.println(assignments);
				}
			}
			return new SatResult(convertStatusToEStatus(b), formula, assignments);
			
		} catch (TimeoutException e) {
				return new SatResult(EStatus.TIMEOUT, formula, assignments);			
		}
		

//        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".isSatisfiable(Formula formula)" + " is not supported!");
	}

	private static EStatus convertStatusToEStatus(boolean bool) {
		if(bool)
			return EStatus.SATISFIABLE;
		else
			return EStatus.UNSATISFIABLE;
	}
	@Override
	public String getKey() {
		return this.getClass().getName();
	}

	@Override
	public String getName() {
		return "Sat4J";
	}

	@Override
	public Formula simplify(Formula formula) {
		  throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".simplify(Formula formula)" + " is not supported!");
	}

	@Override
	public Set<SatResult> findAllSolutions(Formula formula, Duration timeout) throws SatSolverAdapterException {
		throw new UnsupportedOperationException("Not implemented");
	}

}
