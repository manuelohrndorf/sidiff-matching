package org.sidiff.comparators.exceptions;


public class CannotInstantiateComparatorException extends ComparatorException {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 */
	public CannotInstantiateComparatorException(String message) {
		super(message);
	}

	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 * @param exc The parent exception.
	 */
	public CannotInstantiateComparatorException (String message, Exception exc)
	{
		super (message, exc);
	}
}
