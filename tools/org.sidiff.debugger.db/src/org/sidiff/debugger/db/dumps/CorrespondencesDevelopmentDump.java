package org.sidiff.debugger.db.dumps;

import java.util.*;

public class CorrespondencesDevelopmentDump
{
	private ArrayList<CorrespondenceDevelopment> mDevelopments;
	
	public CorrespondencesDevelopmentDump()
	{
		mDevelopments = new ArrayList<CorrespondenceDevelopment>();
	}
	
	public void addCorrespondence(String objectA, String objectB, boolean correspondenceValue, int correspondenceRound)
	{
		boolean containsCorrespondenceDevelopment = false;
		
		for (CorrespondenceDevelopment correspondenceDevelopment : mDevelopments)
		{
			if (correspondenceDevelopment.getObjectA().equals(objectA) && correspondenceDevelopment.getObjectB().equals(objectB))
			{
				correspondenceDevelopment.addCorrespondence(correspondenceValue, correspondenceRound);
				containsCorrespondenceDevelopment = true;
			}
		}
		
		if (!containsCorrespondenceDevelopment)
		{
			CorrespondenceDevelopment correspondenceDevelopment = new CorrespondenceDevelopment(objectA, objectB);
			correspondenceDevelopment.addCorrespondence(false, 0);
			correspondenceDevelopment.addCorrespondence(correspondenceValue, correspondenceRound);
			mDevelopments.add(correspondenceDevelopment);
		}
	}
	
	public ArrayList<CorrespondenceDevelopment> getDevelopments()
	{
		return mDevelopments;
	}
	
	public ArrayList<CorrespondenceDevelopment> getDevelopmentsOfObjectA(String object)
	{
		ArrayList<CorrespondenceDevelopment> developmentsOfObject = new ArrayList<CorrespondenceDevelopment>();
		
		for (CorrespondenceDevelopment correspondenceDevelopment : mDevelopments)
		{
			if (correspondenceDevelopment.getObjectA().equals(object))
			{
				developmentsOfObject.add(correspondenceDevelopment);
			}
		}
		
		return developmentsOfObject;
	}
	
	public ArrayList<CorrespondenceDevelopment> getDevelopmentsOfObjectB(String object)
	{
		ArrayList<CorrespondenceDevelopment> developmentsOfObject = new ArrayList<CorrespondenceDevelopment>();
		
		for (CorrespondenceDevelopment correspondenceDevelopment : mDevelopments)
		{
			if (correspondenceDevelopment.getObjectB().equals(object))
			{
				developmentsOfObject.add(correspondenceDevelopment);
			}
		}
		
		return developmentsOfObject;
	}
}
