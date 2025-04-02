package org.sidiff.debugger.db;

import java.util.*;

public class MySQLScript implements Iterable<String> 
{
	private ArrayList<String> mStatements;
	
	public MySQLScript()
	{
		mStatements = new ArrayList<String>();
	}
	
	public MySQLScript(String script)
	{
		mStatements = new ArrayList<String>(Arrays.asList(script.split(";")));
		if (mStatements.get(mStatements.size() - 1).trim().isEmpty()) mStatements.remove(mStatements.size() - 1);
	}
	
	public MySQLScript(String[] statements)
	{
		mStatements = new ArrayList<String>(Arrays.asList(statements));
	}
	
	public void addStatement(String statement)
	{
		mStatements.add(statement);
	}
	
	public String getStatement(int index)
	{
		return mStatements.get(index);
	}
	
	public static MySQLScript parseScript(String script)
	{
		return new MySQLScript(script);
	}

	@Override
	public Iterator<String> iterator()
	{
		return mStatements.iterator();
	}
	
	@Override
	public String toString()
	{
		String result = "";
		
		for (String statementString : mStatements)
		{
			result += statementString + ";";
		}
		
		return result;
	}
}
