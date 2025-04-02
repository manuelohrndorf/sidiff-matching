package org.sidiff.comparefunctions.util;

import java.util.Collection;

import org.sidiff.comparefunctions.ICompareFunction;

public class CompareFunctionUtil {

	private CompareFunctionUtil() {
		throw new AssertionError();
	}

	public static float computeSumOfWeights(Collection<? extends ICompareFunction> functions) {
		float sumWeights = 0.0f;
		for (ICompareFunction function : functions) {
			sumWeights += function.getWeight();
		}
		return sumWeights;
	}
}
