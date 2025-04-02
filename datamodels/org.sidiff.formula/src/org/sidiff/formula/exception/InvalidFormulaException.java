package org.sidiff.formula.exception;

public class InvalidFormulaException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFormulaException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFormulaException(String message) {
		super(message);
	}

	public InvalidFormulaException(Throwable cause) {
		super(cause);
	}
}
