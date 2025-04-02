package org.sidiff.debugger.db.dumps;

import java.util.ArrayList;

public class CorrespondenceDevelopment
{
	private String mObjectA;
	private String mObjectB;
	private ArrayList<Boolean> mCorrespondenceValues;
	private ArrayList<Integer> mCorrespondenceRounds;
	
	public CorrespondenceDevelopment(String objectA, String objectB)
	{
		mObjectA = objectA;
		mObjectB = objectB;
		mCorrespondenceValues = new ArrayList<Boolean>();
		mCorrespondenceRounds = new ArrayList<Integer>();
	}
	
	public void addCorrespondence(boolean correspondenceValue, int correspondenceRound)
	{
		mCorrespondenceValues.add(correspondenceValue);
		mCorrespondenceRounds.add(correspondenceRound);
	}
	
	public String getObjectA()
	{
		return mObjectA;
	}
	
	public String getObjectB()
	{
		return mObjectB;
	}
	
	public ArrayList<Boolean> getCorrespondenceValues()
	{
		return mCorrespondenceValues;
	}
	
	public ArrayList<Integer> getCorrespondenceRound()
	{
		return mCorrespondenceRounds;
	}
}
