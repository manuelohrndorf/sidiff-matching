package org.sidiff.comparators.abstractcomperators;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.collections.CollectionUtil;


/**
 * marker class that defines the basic behaviour of the comparator, e.g. 
 * on what kind of data structure (an element, a set of elements, a list of...) the comparator 
 * will work and how to process these structures. How datastructure are compared is defined in the implementations  
 */
public abstract class AbstractElementComparator extends AbstractSingleComparator {

	@Override
	protected float calculateSimilarity(EObject contextElementA, EObject contextElementB, Object elementA, Object elementB) {
		
		List<EObject> objectA = CollectionUtil.getValues(elementA, EObject.class);
		List<EObject> objectB = CollectionUtil.getValues(elementB, EObject.class);
		assert (objectA.size() == 1) : "Collection with exact one EObject expected!";
		assert (objectB.size() == 1) : "Collection with exact one EObject expected!";
		
		return calculateElementSimilarity(contextElementA, contextElementB, objectA.get(0), objectB.get(0));
	}

	protected abstract float calculateElementSimilarity(EObject contextElementA, EObject contextElementB, EObject elementA, EObject elementB);

}
