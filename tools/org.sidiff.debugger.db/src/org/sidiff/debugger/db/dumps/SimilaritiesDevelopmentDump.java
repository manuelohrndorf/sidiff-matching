package org.sidiff.debugger.db.dumps;

import java.util.*;


public class SimilaritiesDevelopmentDump
{
	private ArrayList<SimilarityDevelopment> mDevelopments;
	
	public SimilaritiesDevelopmentDump()
	{
		mDevelopments = new ArrayList<SimilarityDevelopment>();
	}
	
	public void addSimilarity(String objectA, String objectB, float similarityValue, int similarityRound)
	{
		boolean containsSimilarityDevelopment = false;
		
		for (SimilarityDevelopment similarityDevelopment : mDevelopments)
		{
			if (similarityDevelopment.getObjectA().equals(objectA) && similarityDevelopment.getObjectB().equals(objectB))
			{
				similarityDevelopment.addSimilarity(similarityValue, similarityRound);
				containsSimilarityDevelopment = true;
			}
		}
		
		if (!containsSimilarityDevelopment)
		{
			SimilarityDevelopment similarityDevelopment = new SimilarityDevelopment(objectA, objectB);
			similarityDevelopment.addSimilarity(0, 0);
			similarityDevelopment.addSimilarity(similarityValue, similarityRound);
			mDevelopments.add(similarityDevelopment);
		}
	}
	
	public ArrayList<SimilarityDevelopment> getDevelopments()
	{
		return mDevelopments;
	}
	
	public ArrayList<SimilarityDevelopment> getDevelopmentsOfObjectA(String object)
	{
		ArrayList<SimilarityDevelopment> developmentsOfObject = new ArrayList<SimilarityDevelopment>();
		
		for (SimilarityDevelopment similarityDevelopment : mDevelopments)
		{
			if (similarityDevelopment.getObjectA().equals(object))
			{
				developmentsOfObject.add(similarityDevelopment);
			}
		}
		
		return developmentsOfObject;
	}
	
	public ArrayList<SimilarityDevelopment> getDevelopmentsOfObjectB(String object)
	{
		ArrayList<SimilarityDevelopment> developmentsOfObject = new ArrayList<SimilarityDevelopment>();
		
		for (SimilarityDevelopment similarityDevelopment : mDevelopments)
		{
			if (similarityDevelopment.getObjectB().equals(object))
			{
				developmentsOfObject.add(similarityDevelopment);
			}
		}
		
		return developmentsOfObject;
	}
}
