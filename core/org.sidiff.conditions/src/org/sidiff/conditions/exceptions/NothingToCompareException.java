package org.sidiff.conditions.exceptions;


/**
 * Comparing:<br />
 * A compare function has nothing to compare.<br />
 * View semantics in context.
 * 
 * @author Thomas Bender
 */
public class NothingToCompareException extends ConditionException
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 */
	public NothingToCompareException (String message)
	{
		super (message);
	}
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 * @param exc The parent exception.
	 */
	public NothingToCompareException (String message, Exception exc)
	{
		super (message, exc);
	}
	
}