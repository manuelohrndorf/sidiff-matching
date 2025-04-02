package org.sidiff.debugger.db.dumps;

import java.util.*;

public class SimilarityDevelopment
{
	private String mObjectA;
	private String mObjectB;
	private ArrayList<Float> mSimilarityValues;
	private ArrayList<Integer> mSimilarityRounds;
	
	public SimilarityDevelopment(String objectA, String objectB)
	{
		mObjectA = objectA;
		mObjectB = objectB;
		mSimilarityValues = new ArrayList<Float>();
		mSimilarityRounds = new ArrayList<Integer>();
	}
	
	public void addSimilarity(float similarityValue, int similarityRound)
	{
		mSimilarityValues.add(similarityValue);
		mSimilarityRounds.add(similarityRound);
	}
	
	public String getObjectA()
	{
		return mObjectA;
	}
	
	public String getObjectB()
	{
		return mObjectB;
	}
	
	public ArrayList<Float> getSimilaritiyValues()
	{
		return mSimilarityValues;
	}
	
	public ArrayList<Integer> getSimilaritiyRounds()
	{
		return mSimilarityRounds;
	}
}
