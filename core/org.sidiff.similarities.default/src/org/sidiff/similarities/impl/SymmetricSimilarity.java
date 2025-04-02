package org.sidiff.similarities.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

public class SymmetricSimilarity implements Comparable<SymmetricSimilarity>{
	
	private EObject elementA = null;
	private EObject elementB = null;
	private float similarity= Float.NaN;
	
	public SymmetricSimilarity(EObject elementA,EObject elementB) {
		
		this.elementA = elementA;
		this.elementB = elementB;
	}
	
	public EObject getElementA(){
		return this.elementA;
	}
	
	public EObject getElementB(){
		return this.elementB;
	}
	
	public float getSimilarity(){
		return this.similarity;
	}
	
	public void setSimilarity(float similarity){

		this.fireChangeAnnounce();
		this.similarity= similarity;
		this.fireChangePerformed();
	}	
	
	@Override
	public int compareTo(SymmetricSimilarity o) {
		int result = Float.compare(o.similarity,this.similarity);
		return (result!=0)? result : o.hashCode()-this.hashCode();
	}
	
	private List<SyncronizedSimilaritySet> syncronizedContainers = null;
	
	public void addSyncronizedContainer(SyncronizedSimilaritySet container) {

		if(syncronizedContainers==null){
			this.syncronizedContainers = new LinkedList<SyncronizedSimilaritySet>();
		}
		this.syncronizedContainers.add(container);
	}
	
	public boolean removeSyncronizedContainer(SyncronizedSimilaritySet container) {
		if(syncronizedContainers!=null){
			return this.syncronizedContainers.remove(container);
		} else {
			return false;
		}
	}
	
	public void fireChangeAnnounce(){
		if(syncronizedContainers!=null){
			for(SyncronizedSimilaritySet container : this.syncronizedContainers){
				container.changeAnnounce(this);
			}
		}
	}
	
	public void fireChangePerformed(){
		if(syncronizedContainers!=null){
			for(SyncronizedSimilaritySet container : this.syncronizedContainers){
				container.changePerformed(this);
			}
		}
	}
}
