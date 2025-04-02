package org.sidiff.similarities.impl.internal;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.similarities.AbstractSimilarity;
import org.sidiff.similarities.ISimilarity;
import org.sidiff.similarities.impl.SymmetricSimilarity;

public class SymmetricSimilarityAdapter extends AbstractSimilarity {

	public static enum Mode {
		/**
		 * A to B / left to right
		 */
		AtoB,
		
		/**
		 * B to A / right to left
		 */
		BtoA
	}

	private SymmetricSimilarity adaptable;
	private Mode mode;

	public SymmetricSimilarityAdapter(SymmetricSimilarity adaptable, Mode mode) {
		this.adaptable = Objects.requireNonNull(adaptable);
		this.mode = Objects.requireNonNull(mode);
	}

	@Override
	public EObject getObject() {
		switch (mode) {
			case BtoA: return adaptable.getElementB();
			case AtoB: return adaptable.getElementA();
		}
		throw new AssertionError();
	}

	@Override
	public EObject getSimilarObject() {
		switch (mode) {
			case BtoA: return adaptable.getElementA();
			case AtoB: return adaptable.getElementB();
		}
		throw new AssertionError();
	}

	@Override
	public float getSimilarity() {
		return adaptable.getSimilarity();
	}

	@Override
	public String toString() {
		return "Similarity " + mode + " [" + StringUtil.resolve(getObject())
			+ " -- " + getSimilarity() + " --> " + StringUtil.resolve(getSimilarObject()) + "]";
	}

	@Override
	public int compareTo(ISimilarity o) {
		return Float.compare(this.getSimilarity(), o.getSimilarity());
	}
}
