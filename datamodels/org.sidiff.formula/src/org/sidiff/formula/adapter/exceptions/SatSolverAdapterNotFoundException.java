package org.sidiff.formula.adapter.exceptions;

public class SatSolverAdapterNotFoundException extends Exception {
	
	private static final long serialVersionUID = -6313251856420914067L;

	public SatSolverAdapterNotFoundException(String key) {
		super("No SAT Solver Adapter with key \"" + key + "\" was found");
	}
}
