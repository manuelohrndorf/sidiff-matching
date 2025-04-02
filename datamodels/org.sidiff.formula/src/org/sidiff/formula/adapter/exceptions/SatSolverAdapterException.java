package org.sidiff.formula.adapter.exceptions;

public class SatSolverAdapterException extends RuntimeException {

	private static final long serialVersionUID = 4189491032018915457L;

	public SatSolverAdapterException(String message, Throwable cause) {
		super(message, cause);
	}

	public SatSolverAdapterException(String message) {
		super(message);
	}

	public SatSolverAdapterException(Throwable cause) {
		super(cause);
	}
}
