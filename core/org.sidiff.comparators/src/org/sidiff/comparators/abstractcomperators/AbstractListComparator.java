package org.sidiff.comparators.abstractcomperators;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * marker class that defines the basic behaviour of the comparator, e.g. 
 * on what kind of data structure (an element, a set of elements, a list of...) the comparator 
 * will work and how to process these structures. How datastructure are compared is defined in the implementations  
 */
public abstract class AbstractListComparator extends AbstractCollectionComparator {

	@SuppressWarnings("unchecked")
	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA, Object elementB) {
		
		assert (elementA instanceof List && elementB instanceof List):"Elements of type List expected"; 
		
		return calculateListSimilarity(contextElementA, contextElementB, (List<EObject>)elementA, (List<EObject>)elementB);
	}
	
	protected abstract float calculateListSimilarity(EObject contextElementA, EObject contextElementB, List<EObject> listA, List<EObject> listB);
}
