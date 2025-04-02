package org.sidiff.debugger.db.dumps;

public class Correspondence
{
	private String mObjectA;
	private String mObjectB;
	
	public Correspondence(String objectA, String objectB)
	{
		mObjectA = objectA;
		mObjectB = objectB;
	}
	
	public String getObjectA()
	{
		return mObjectA;
	}
	
	public String getObjectB()
	{
		return mObjectB;
	}
}
