package org.sidiff.debugger.db.dumps;

public class Similarity
{
	private String mObjectA;
	private String mObjectB;
	private float mSimilarity;
	
	public Similarity(String objectA, String objectB, float similarity)
	{
		mObjectA = objectA;
		mObjectB = objectB;
		mSimilarity = similarity;
	}
	
	public void setSimilarity(float similarity)
	{
		mSimilarity = similarity;
	}
	
	public String getObjectA()
	{
		return mObjectA;
	}
	
	public String getObjectB()
	{
		return mObjectB;
	}
	
	public float getSimilarity()
	{
		return mSimilarity;
	}
}
