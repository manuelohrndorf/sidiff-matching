package org.sidiff.debugger.db.dumps;

import java.util.*;

public class RoundDump
{
	private ArrayList<Similarity> mSimilarities;
	private ArrayList<Correspondence> mCorrespondences;
	
	public RoundDump()
	{
		mSimilarities = new ArrayList<Similarity>();
		mCorrespondences = new ArrayList<Correspondence>();
	}
	
	public void setSimilarity(String objectA, String objectB, float similarityValue)
	{
		boolean containsSimilarity = false;

		for (Similarity similarity : mSimilarities)
		{
			if (similarity.getObjectA().equals(objectA) && similarity.getObjectB().equals(objectB))
			{
				containsSimilarity = true;
				similarity.setSimilarity(similarityValue);
			}
		}
		
		if (!containsSimilarity)
		{
			mSimilarities.add(new Similarity(objectA, objectB, similarityValue));
		}
	}
	
	public void setCorrespondence(String objectA, String objectB, boolean correspondenceValue)
	{
		boolean containsCorrespondence = false;

		for (Correspondence correspondence : mCorrespondences)
		{
			if (correspondence.getObjectA().equals(objectA) && correspondence.getObjectB().equals(objectB))
			{
				containsCorrespondence = true;
				
				if (!correspondenceValue)
				{
					mCorrespondences.remove(correspondence);
				}
			}
		}
		
		if (!containsCorrespondence && correspondenceValue)
		{
			mCorrespondences.add(new Correspondence(objectA, objectB));
		}
	}
	
	public void finalize()
	{
		// remove correspondences from the similarities
		for (Correspondence correspondence : mCorrespondences)
		{
			for (Similarity similarity : mSimilarities)
			{
				if (similarity.getObjectA().equals(correspondence.getObjectA()) && similarity.getObjectB().equals(correspondence.getObjectB()))
				{
					mSimilarities.remove(similarity);
				}
			}
		}
	}
	
	public ArrayList<Similarity> getSimilarities()
	{
		return mSimilarities;
	}
	
	public ArrayList<Correspondence> getCorrespondences()
	{
		return mCorrespondences;
	}
}
