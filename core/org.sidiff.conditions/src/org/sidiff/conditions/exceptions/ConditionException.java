package org.sidiff.conditions.exceptions;

import org.sidiff.common.exceptions.SiDiffRuntimeException;


/**
 * Indicates an exception occured on comparing objects.
 * 
 * @author Thomas Bender
 */
public class ConditionException extends SiDiffRuntimeException
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 */
	public ConditionException (String message)
	{
		super (message);
	}
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 * @param exc The parent exception.
	 */
	public ConditionException (String message, Exception exc)
	{
		super (message, exc);
	}
	
}
