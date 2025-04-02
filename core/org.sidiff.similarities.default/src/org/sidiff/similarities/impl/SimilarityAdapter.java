package org.sidiff.similarities.impl;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.adaption.ContentAdapter;
import org.sidiff.common.util.StringUtil;
import org.sidiff.similarities.ISimilarity;

public class SimilarityAdapter implements ContentAdapter<SymmetricSimilarity, ISimilarity> {

	public static final int ASIM = 0;
	public static final int BSIM = 1;

	private int adapterMode = -1;

	public SimilarityAdapter(int mode) {
		this.adapterMode = mode;
	}

	@Override
	public ISimilarity adapt(SymmetricSimilarity adaptable) {
		return new SimilarityWrapper(adaptable);
	}

	@Override
	public SymmetricSimilarity unadapt(ISimilarity adapted) {
		return null;
	}

	public class SimilarityWrapper implements ISimilarity {

		private SymmetricSimilarity adaptable = null;

		public SimilarityWrapper(SymmetricSimilarity adaptable) {
			this.adaptable = adaptable;
		}

		@Override
		public EObject getObject() {
			switch (adapterMode) {
			case ASIM:
				return adaptable.getElementB();
			case BSIM:
				return adaptable.getElementA();
			default:
				throw new IllegalStateException();
			}
		}

		@Override
		public EObject getSimilarObject() {
			switch (adapterMode) {
			case ASIM:
				return adaptable.getElementA();
			case BSIM:
				return adaptable.getElementB();
			default:
				throw new IllegalStateException();
			}
		}

		@Override
		public float getSimilarity() {
			return adaptable.getSimilarity();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ISimilarity) {
				return ((ISimilarity) obj).getSimilarity() == getSimilarity() && ((ISimilarity) obj).getSimilarObject() == getSimilarObject();
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			
			String result = null;
			switch (adapterMode) {
			case ASIM:
				// B->A
				result= "SIM AB ["+StringUtil.resolve(adaptable.getElementB())+" -- "+getSimilarity()+" --> "+StringUtil.resolve(getSimilarObject())+"]";
				break;
			case BSIM:
				// A->B
				result= "SIM BA ["+StringUtil.resolve(adaptable.getElementA())+" -- "+getSimilarity()+" --> "+StringUtil.resolve(getSimilarObject())+"]";
				break;
			default:
				throw new IllegalStateException();
			}
			return result;
		}
		
	}

}
