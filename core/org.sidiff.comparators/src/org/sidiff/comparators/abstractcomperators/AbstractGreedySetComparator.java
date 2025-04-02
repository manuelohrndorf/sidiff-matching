package org.sidiff.comparators.abstractcomperators;

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;

/**
 * marker class that defines the basic behaviour of the comparator, e.g. on what
 * kind of data structure (an element, a set of elements, a list of...) the
 * comparator will work and how to process these structures. How datastructure
 * are compared is defined in the implementations
 */
public abstract class AbstractGreedySetComparator extends AbstractSetComparator {

	@Override
	protected float calculateSetSimilarity(EObject contextElementA, EObject contextElementB,
			Collection<EObject> collectionA, Collection<EObject> collectionB) {

		SortedSet<Entry> pairs = new TreeSet<>();
		for (EObject objectA : collectionA) {
			for (EObject objectB : collectionB) {
				float sim = getRating(objectA, objectB);
				if (sim > 0.0f) {
					pairs.add(new Entry(objectA, objectB, sim));
				}
			}
		}

		float sum = 0.0f;

		// Lookup best values greedy-like
		while (!pairs.isEmpty()) {
			Entry bestEntry = pairs.last();
			sum += bestEntry.sim;

			Iterator<Entry> entryIterator = pairs.iterator();
			while (entryIterator.hasNext()) {
				Entry ent = entryIterator.next();
				if (ent.objectA.equals(bestEntry.objectA) || ent.objectB.equals(bestEntry.objectB)) {
					entryIterator.remove();
				}
			}
		}
		// normalize similarity
		return (sum / Math.max(collectionA.size(), collectionB.size()));
	}

	protected abstract float getRating(EObject a, EObject b);

	private static class Entry implements Comparable<Entry> {

		private Entry(EObject objectA, EObject objectB, float sim) {
			this.objectA = objectA;
			this.objectB = objectB;
			this.sim = sim;
		}

		private EObject objectA = null;
		private EObject objectB = null;
		private float sim = 0.0f;

		@Override
		public int compareTo(Entry o) {
			int result = Float.compare(this.sim, o.sim);
			return (result == 0) ? ((this == o) ? 0 : -1) : result;
		}

	}
}
