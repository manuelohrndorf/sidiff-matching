package org.sidiff.comparators.abstractcomperators;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;


/**
 * marker class that defines the basic behaviour of the comparator, e.g. 
 * on what kind of data structure (an element, a set of elements, a list of...) the comparator 
 * will work and how to process these structures. How datastructure are compared is defined in the implementations  
 */
public abstract class AbstractElementComparator extends AbstractSingleComparator {


	@SuppressWarnings("unchecked")
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA, Object elementB) {
		
		assert (elementA instanceof Collection && elementB instanceof Collection) : "Elements of type Collection expected";
		assert (((Collection)elementA).size()==1 && ((Collection)elementA).toArray()[0] instanceof EObject) : "Collection with exact one EObject expected!";
		assert (((Collection)elementB).size()==1 && ((Collection)elementB).toArray()[0] instanceof EObject) : "Collection with exact one EObject expected!";		
		
		return calculateElementSimilarity(contextElementA, contextElementB, ((Collection<EObject>)elementA).iterator().next(), ((Collection<EObject>) elementB).iterator().next());
	}

	protected abstract float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA, EObject elementB);

}
