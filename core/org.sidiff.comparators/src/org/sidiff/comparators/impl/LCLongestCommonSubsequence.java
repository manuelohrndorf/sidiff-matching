package org.sidiff.comparators.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;
import org.sidiff.comparators.abstractcomperators.AbstractListComparator;
import org.sidiff.comparators.abstractcomperators.AbstractSingleComparator;

/**
 * This comparator compares two aligned list based on an
 * LongestCommonSubsequence-algorithm. The condition whether a sequence is
 * discontinued or not is made based on the inner comparator and a threshold. If
 * the similarity-value calculated by the inner comparator is below the
 * threshold, the sequence is deemed as interrupted.
 * 
 * The parameter of this comparefunction specifies at position
 * <ul>
 * <li>0: The inner comparator and it's configuration
 * <li>1: The threshold for LCS-calculation
 * </ul>
 * 
 * The following example-configuration shows how to use the
 * LCLongestCommonSubsequence comparator in combination with ECMatched. The
 * ordered children of the dedicated class are compared based on whether they
 * are already matched or not. <br>
 * <br>
 *
 * &lt;CompareFunction class="ChildrenCF" weight="1"
 * parameter="LCLongestCommonSubsequence[ECMatched;1f]"/&gt;
 * 
 * @see org.sidiff.core.comparators.comparefunctions.comparators.ECMatched
 * 
 * @author Pit Pietsch
 */
public class LCLongestCommonSubsequence extends AbstractListComparator {
	public static final String COMPARATOR_ID = "LCLongestCommonSubsequence";
	/**
	 * The inner comparator.
	 */
	private AbstractSingleComparator comparator = null;

	/**
	 * The threshold for the LCS-calculation.
	 */
	private float threshold = -1f;

	/**
	 * init.
	 * 
	 * @param dedicatedClass
	 *            the Class this comparator is used on
	 * @param parameter
	 *            the parameter for this comparator
	 */
	@Override
	public void init(EClass dedicatedClass, EClass targetClass, String parameter) {
		super.init(dedicatedClass, targetClass, parameter);

		// first parameter: comparator
		comparator = (AbstractSingleComparator) loadComparator(paramItems[0], dedicatedClass, targetClass,
				AbstractElementComparator.class);

		// second parameter: cfThreshold
		this.threshold = Float.parseFloat(paramItems[1]) * (-1.0f);
	}

	/**
	 * 
	 * @see org.sidiff.core.comparators.abstractcomparators.AbstractListComparator#compare(java.util.List,
	 *      java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected float calculateListSimilarity(EObject contextElementA, EObject contextElementB, List<EObject> listA,
			List<EObject> listB) {

		int n = listA.size();
		int m = listB.size();
		int max = m + n;
		ArrayList<EObject>[] commonSubSeq = new ArrayList[2 * max + 1];
		for (int i = 0; i < commonSubSeq.length; i++) {
			commonSubSeq[i] = new ArrayList<EObject>();
		}
		// enthält den jeweiligen am weitesten reichenden Endpunkt für die
		// Diagonale
		// und wird dynamisch berechnet
		int[] v = new int[2 * max + 1];
		v[1 + max] = 0;
		// Greedy Algorithmus, anfangend bei einem 0-Pfad wird der kuerzeste Weg
		// gesucht
		for (int d = 0; d <= max; d++) {
			// Ein d-Pfad kann nur ueber Diagonalen von -d, -d+2... d-2, d
			// laufen
			for (int k = -d; k <= d; k = k + 2) {
				int oldDiag = 0;
				int x;
				int y;
				if (k == -d || (k != d && v[(k - 1) + max] < v[k + 1 + max])) {
					// nach unten gehen
					oldDiag = k + 1;
					x = v[k + 1 + max];
				} else {
					// nach rechts gehen
					oldDiag = k - 1;
					x = v[k - 1 + max] + 1;
				}
				// y lässt sich aus x und k berechnen
				y = x - k;
				// Die Diagonale wir weitmöglichst durchlaufen (wird auch Snake
				// genannt)
				ArrayList<EObject> snake = new ArrayList<EObject>();
				while (x < n && y < m && comparator.compare(contextElementA, contextElementB,
						Collections.singleton(listA.get(x)), Collections.singleton(listB.get(y))) >= threshold) {
					snake.add(listA.get(x));
					snake.add(listB.get(y));
					x = x + 1;
					y = y + 1;
				}
				// v aktualisieren
				v[k + max] = x;

				// in commonSubSeq jeweils die Diagonalenpunkte merken,
				// um später die LCS zu bestimmen
				commonSubSeq[k + max].clear();
				commonSubSeq[k + max].addAll(commonSubSeq[oldDiag + max]);
				commonSubSeq[k + max].addAll(snake);

				// Ziel erreicht??
				if (x >= n && y >= m) {

					float lcs = 0;

					Object[] objSequence = commonSubSeq[k + max].toArray();
					for (int i = 0; i < objSequence.length; i += 2) {
						lcs += comparator.compare(contextElementA, contextElementB,
								Collections.singleton(objSequence[i]), Collections.singleton(objSequence[i + 1]));
					}

					return lcs / (objSequence.length / 2);
				}
			}
		}

		return -1;
	}

	@Override
	public String getComparatorID() {
		return COMPARATOR_ID;
	}

	@Override
	public String getDescription() {
		return "This comparator compares two aligned list based on an LongestCommonSubsequence-algorithm. "
				+ "The condition whether a sequence is discontinued or not is made based on the inner"
				+ " comparator and a threshold. If the similarity-value calculated by the inner comparator "
				+ " is below the threshold, the sequence is deemed as interrupted.";
	}
}
