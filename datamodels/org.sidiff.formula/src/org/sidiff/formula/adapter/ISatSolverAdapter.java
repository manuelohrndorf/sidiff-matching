package org.sidiff.formula.adapter;

import java.time.Duration;
import java.util.Set;

import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.formula.Formula;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterException;

public interface ISatSolverAdapter extends IExtension {

	Description<ISatSolverAdapter> DESCRIPTION = Description.of(ISatSolverAdapter.class,
			"org.sidiff.formula.sat_solver_adapter", "sat_solver_adapter", "class");
	ExtensionManager<ISatSolverAdapter> MANAGER = new ExtensionManager<>(DESCRIPTION);

	SatResult isSatisfiable(Formula formula) throws SatSolverAdapterException;
	Set<SatResult> findAllSolutions(Formula formula, Duration timeout) throws SatSolverAdapterException;
	Formula simplify(Formula formula) throws SatSolverAdapterException;
}
