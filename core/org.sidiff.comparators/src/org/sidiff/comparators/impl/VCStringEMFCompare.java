package org.sidiff.comparators.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractValueComparator;

//TODO research copyright (HIWI, PP)
/**
 * The suggested string similarity measure by Xing/Stroulia
 * 
 * This code is blatantly stolen from
 * org.eclipse.emf.compare.match.internal.statistic.NameSimilarity
 * 
 */
public class VCStringEMFCompare extends AbstractValueComparator {

	private boolean ci = false;

	@Override
	public void init(String parameter) {
		// case sensitivity ? default: case-sensitive
		if (parameter.equals("ci")) {
			this.ci = true;
		}
	}

	/**
	 * This method returns a {@link List} of {@link String}s called "pairs". For
	 * example,
	 * 
	 * <pre>
	 * pairs(&quot;MyString&quot;)
	 * </pre>
	 * 
	 * returns ["My","yS","St","tr","ri","in","ng"]
	 * 
	 * @param source
	 *            The {@link String} to process.
	 * @return A {@link List} of {@link String} corresponding to the possibles
	 *         pairs of the source one.
	 */
	private static List<String> pairs(String source) {
		final List<String> result = new ArrayList<>();
		if (source != null) {
			final int length = source.length();
			for (int i = 0; i < length - 1; i++) {
				result.add(source.substring(i, i + 2));
			}
		}
		return result;
	}

	/**
	 * Return a metric result about name similarity. It compares 2 strings and
	 * return a double comprised between 0 and 1. The greater this metric, the
	 * more equal the strings are.
	 * 
	 * @param str1
	 *            First of the two {@link String}s to compare.
	 * @param str2
	 *            Second of the two {@link String}s to compare.
	 * @return A metric result about name similarity (0 &lt;= value &lt;= 1).
	 */
	private float emfNameComparison(String str1, String str2) {
		float result = 0f;
		final float almostEquals = 0.999999f;
		if (str1 != null && str2 != null) {
			if (str1.equals(str2)) {
				result = 1f;
			} else if (str1.length() <= 2 && str2.length() <= 2) {
				int equalChars = 0;
				final char[] str1Value = str1.toCharArray();
				final char[] str2Value = str2.toCharArray();
				for (int i = 0; i < Math.min(str1Value.length, str2Value.length); i++) {
					if (str1Value[i] == str2Value[i]) {
						equalChars++;
					}
				}
				if (str1Value.length != str2Value.length) {
					result = (float) equalChars / (float) (str1Value.length + str2Value.length);
				} else {
					result = equalChars * 2f / (str1Value.length + str2Value.length);
				}
			} else if (str1.length() != 1 && str2.length() != 1) {
				final String string1 = str1.toLowerCase();
				final String string2 = str2.toLowerCase();

				final List<String> pairs1 = pairs(string1);
				final List<String> pairs2 = pairs(string2);

				final float union = pairs1.size() + pairs2.size();
				pairs1.retainAll(pairs2);
				final int inter = pairs1.size();

				result = inter * 2f / union;
				if (result > 1) {
					result = 1f;
				} else if (result > almostEquals) {
					result = almostEquals;
				}
			}
		}
		return result;

	}

	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object objectA, Object objectB) {
		String stringA = (String)objectA;
		String stringB = (String)objectB;
		if(ci) {
			stringA = stringA.toLowerCase();
			stringB = stringB.toLowerCase();
		}
		return emfNameComparison(stringA, stringB);
	}
}
