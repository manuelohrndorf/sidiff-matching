package org.sidiff.comparators.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.sidiff.comparators.abstractcomperators.AbstractElementComparator;

public class ECFeatureMap extends AbstractElementComparator {

	@Override
	protected float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA,
			EObject elementB) {

		int counter = 0;

		FeatureMap elemA = (FeatureMap) elementA;
		FeatureMap elemB = (FeatureMap) elementB;

		int sizeA = elemA.size();
		int sizeB = elemB.size();

		Iterator<Entry> iteratorA = elemA.iterator();
		while (iteratorA.hasNext()) {
			FeatureMap.Entry entry = iteratorA.next();

			Iterator<Entry> iteratorB = elemB.iterator();
			while (iteratorB.hasNext()) {
				FeatureMap.Entry entry2 = iteratorB.next();

				if (entry.equals(entry2)) {
					counter++;
				}
			}
		}
		if (counter == 0) {
			return 0;
		}
		return counter / (float)Math.max(sizeA, sizeB);

	}
}
