package org.sidiff.similarities.impl;

import java.util.TreeSet;

public class SyncronizedSimilaritySet extends TreeSet<SymmetricSimilarity> {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(SymmetricSimilarity e) {
		e.addSyncronizedContainer(this);
		return super.add(e);
	}

	@Override
	public boolean remove(Object o) {
		if(o instanceof SymmetricSimilarity){
			((SymmetricSimilarity)o).removeSyncronizedContainer(this);
		}
		return super.remove(o);
	}

	public void changeAnnounce(SymmetricSimilarity content) {
		super.remove(content);
	}

	public void changePerformed(SymmetricSimilarity content) {
		super.add(content);
	}

	

}
