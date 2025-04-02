package org.sidiff.similarities.impl;

import org.sidiff.similarities.ISimilarity;
import org.sidiff.similarities.impl.internal.SymmetricSimilarityAdapter;
import org.sidiff.similarities.impl.internal.SymmetricSimilarityAdapter.Mode;

public class SimilarityAdapterFactory {

	private SimilarityAdapterFactory() {
		throw new AssertionError();
	}

	public static ISimilarity createFromAtoB(SymmetricSimilarity adaptable) {
		return new SymmetricSimilarityAdapter(adaptable, Mode.AtoB);
	}

	public static ISimilarity createFromBtoA(SymmetricSimilarity adaptable) {
		return new SymmetricSimilarityAdapter(adaptable, Mode.BtoA);
	}
}
