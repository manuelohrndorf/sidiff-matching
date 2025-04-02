package org.sidiff.similarities;

import java.util.Objects;

public abstract class AbstractSimilarity implements ISimilarity {

	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if(!(obj instanceof ISimilarity)) {
			return false;
		}
		return ((ISimilarity) obj).getSimilarity() == getSimilarity()
				&& ((ISimilarity) obj).getSimilarObject() == getSimilarObject();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSimilarity(), getSimilarObject());
	}

	@Override
	public int compareTo(ISimilarity o) {
		return Float.compare(getSimilarity(), o.getSimilarity());
	}
}
