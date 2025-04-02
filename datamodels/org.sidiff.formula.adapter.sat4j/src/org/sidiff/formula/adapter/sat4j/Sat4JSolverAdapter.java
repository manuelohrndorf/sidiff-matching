package org.sidiff.formula.adapter.sat4j;

import java.time.Duration;
import java.util.*;

import org.eclipse.emf.ecore.EObject;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.ISolver;
import org.sidiff.formula.*;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterException;

public class Sat4JSolverAdapter implements ISatSolverAdapter {

	@Override
	public SatResult isSatisfiable(Formula formula)  {
		ISolver solver = SolverFactory.newDefault();

		Formula cnf_Formula = formula.cnf();
		List<Variable> variables = formula.getVariables();
		Map<String, Integer> variable2int = new HashMap<>();
		int varInt = 1;
		for(Variable variable : variables) {
			if(!variable2int.containsKey(variable.getName())) {
				variable2int.put(variable.getName(), varInt);
				varInt++;
			}
		}

		// prepare the solver to accept MAXVAR variables. MANDATORY for MAXSAT solving
		solver.newVar(variable2int.size());
		Formula[] clauses =  cnf_Formula.getAssociativeFormulas(cnf_Formula.eClass()).toArray(new Formula[] {});

		solver.setExpectedNumberOfClauses(clauses.length);
		// Feed the solver using Dimacs format, using arrays of int
		// (best option to avoid dependencies on SAT4J IVecInt)
		for (Formula clause : clauses) {
			VecInt vecInt = new VecInt();
			for(Variable variable : clause.getVariables()) {
				int sign = 1;
				EObject container = variable.eContainer();
				while(container != null) {
					if(container instanceof Not) {
						sign *= -1;
					}
					container = container.eContainer();
				}
				vecInt.push(sign*variable2int.get(variable.getName()));
			}
			try {
				solver.addClause(vecInt);
			} catch (ContradictionException e) {
				throw new RuntimeException(e);
			}
		}

        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".isSatisfiable(Formula formula)" + " is not supported!");
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
