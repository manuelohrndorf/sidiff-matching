package org.sidiff.comparators.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;


/**
 * Indicates an exception occured on comparing objects.
 * 
 * @author Thomas Bender
 */
public class ComparatorException extends SiDiffRuntimeException
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 */
	public ComparatorException (String message)
	{
		super (message);
	}
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 * @param exc The parent exception.
	 */
	public ComparatorException (String message, Exception exc)
	{
		super (message, exc);
	}
	
}
