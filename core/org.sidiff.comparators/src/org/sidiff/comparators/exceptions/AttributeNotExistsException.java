package org.sidiff.comparators.exceptions;



/**
 * Comparing:<br />
 * A specified attribute to compare does not exist.
 * 
 * @author Thomas Bender
 */
public class AttributeNotExistsException extends ComparatorException
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 */
	public AttributeNotExistsException (String message)
	{
		super (message);
	}
	
	/**
	 * Constructor.
	 * @param message The exception's message.
	 * @param exc The parent exception.
	 */
	public AttributeNotExistsException (String message, Exception exc)
	{
		super (message, exc);
	}
	
}