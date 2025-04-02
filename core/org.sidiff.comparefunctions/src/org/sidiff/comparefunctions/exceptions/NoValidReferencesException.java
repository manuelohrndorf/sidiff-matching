package org.sidiff.comparefunctions.exceptions;


public class NoValidReferencesException extends CompareException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * @param message The exception's message.
	 */
	public NoValidReferencesException(String message) {
		super(message);
	}
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 * @param exc The parent exception.
	 */
	public NoValidReferencesException(String message, Exception exc)
	{
		super (message, exc);
	}

}
