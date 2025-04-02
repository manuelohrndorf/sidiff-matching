package org.sidiff.comparators.abstractcomperators;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * marker class that defines the basic behaviour of the comparator, e.g. on what
 * kind of data structure (an element, a set of elements, a list of...) the
 * comparator will work and how to process these structures. How datastructure
 * are compared is defined in the implementations
 */
public abstract class AbstractSetComparator extends AbstractCollectionComparator {

	@SuppressWarnings("unchecked")
	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA,
			Object elementB) {

		assert (elementA instanceof Collection && elementB instanceof Collection) : "Elements of type Collection expected";

		return calculateSetSimilarity(contextElementA, contextElementB, (Collection<EObject>) elementA,
				(Collection<EObject>) elementB);
	}

	protected abstract float calculateSetSimilarity(EObject contextElementA, EObject contextElementB,
			Collection<EObject> collectionA, Collection<EObject> collectionB);
}
