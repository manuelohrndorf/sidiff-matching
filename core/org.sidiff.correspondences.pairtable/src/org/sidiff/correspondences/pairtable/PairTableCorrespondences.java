package org.sidiff.correspondences.pairtable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.ClassificationUtil;
import org.sidiff.common.collections.ViewUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.collections.EMFClassifiers;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.exceptions.ExternalElementException;
import org.sidiff.correspondences.exceptions.NoMatchException;
import org.sidiff.correspondences.exceptions.OverlappingMatchException;

public class PairTableCorrespondences implements ICorrespondences {
	
	//TODO VDUECK has commented fireEvents of "fireMatchRevoked and fireMatchCreated... 
	
	public static final String SERVICE_ID = "PairtableCorrespondences";

	private Resource modelA = null;
	private Resource modelB = null;
	private Map<EClass, Set<EObject>> unmatchedInA = null;
	private Set<EObject> allUnmatchedInA = null;
	private Map<EClass, Set<EObject>> unmatchedInB = null;
	private Set<EObject> allUnmatchedInB = null;
	private Map<EObject, EObject> matchedAB = null;
	private Map<EObject, EObject> matchedBA = null;

	@Override
	public void init(Collection<Resource> models)  {
		
		if (!canHandle(models)) {
			throw new UnsupportedOperationException(); // only pairwise matches
														// allowed
		}	
		
		Iterator<Resource> it = models.iterator();
		Resource inputModelA = it.next();
		Resource inputModelB = it.next();		
	

		this.modelA = inputModelA;
		this.modelB = inputModelB;

		//FIXME
		//This should be done using the current @see{ICandidates}
		this.unmatchedInA = ClassificationUtil.classifiedSets(EMFUtil.createListFromEAllContents(modelA),
				EMFClassifiers.ELEMENT_BY_CLASS);
		this.allUnmatchedInA = ViewUtil.unifiedSetView(unmatchedInA.values());
		this.unmatchedInB = ClassificationUtil.classifiedSets(EMFUtil.createListFromEAllContents(modelB),
				EMFClassifiers.ELEMENT_BY_CLASS);
		this.allUnmatchedInB = ViewUtil.unifiedSetView(unmatchedInB.values());
		this.matchedAB = new HashMap<EObject, EObject>();
		this.matchedBA = new HashMap<EObject, EObject>();
	}

	@Override
	public void addCorrespondence(EObject... elements) {
		if (elements.length != 2) {
			throw new UnsupportedOperationException(); // only pairwise matches
														// allowed
		}		
		addCorrespondence(elements[0], elements[1]);
	}
	
	public void addCorrespondence(EObject elem1, EObject elem2)  {
		if (elem1.eResource() != modelA) {
			throw new UnsupportedOperationException(); // first element is not
														// an element of the
														// first model
		}
		if (elem2.eResource() != modelB) {
			throw new UnsupportedOperationException(); // second element is not
														// an element of the
														// second model
		}

		Set<EObject> unmatchedInA = this.unmatchedInA.get(elem1.eClass());
		Set<EObject> unmatchedInB = this.unmatchedInB.get(elem2.eClass());

		if (unmatchedInA.contains(elem1) && unmatchedInB.contains(elem2)) {
			synchronized (this) {
				unmatchedInA.remove(elem1);
				unmatchedInB.remove(elem2);
				matchedAB.put(elem1, elem2);
				matchedBA.put(elem2, elem1);
			}
			// fireMatchCreated(nodeFromA, nodeFromB);
		} else {
			throw new OverlappingMatchException("Cannot match ", elem1, " and ", elem2, "\n Reason:" + elem1 + " is "
					+ ((matchedAB.get(elem1) != null) ? ("already matched with " + matchedAB.get(elem1)) : "unmatched")
					+ "\n        " + elem2 + " is "
					+ ((matchedBA.get(elem2) != null) ? ("already matched with " + matchedBA.get(elem2)) : "unmatched"));
		}
	}

	@Override
	public Collection<EObject> getCorrespondences(EObject element)  {
		if (!hasCorrespondences(element))
			return Collections.emptyList();
		if (element.eResource() == modelA) {
			return Collections.singleton(matchedAB.get(element));
		} else if (element.eResource() == modelB) {
			return Collections.singleton(matchedBA.get(element));
		} else {
			throw new ExternalElementException(); // wrong model
		}
	}

	@Override
	public boolean hasCorrespondences(EObject element) {
		if (element.eResource() == modelA) {
			return matchedAB.containsKey(element);
		} else if (element.eResource() == modelB) {
			return matchedBA.containsKey(element);
		} else {
			 LogUtil.log(LogEvent.ERROR,
			 "Requesting correspondence of an element which is not part of the managed resources:",element);
			 throw new ExternalElementException(); // wrong model
		}
	}

	@Override
	public boolean isCorresponding(EObject... elements) {
		if (elements.length != 2) {
			throw new UnsupportedOperationException(); // only pairwise matches
														// allowed
		}		
		return isCorresponding(elements[0], elements[1]);
	}
	

		
	public boolean isCorresponding(EObject elem1, EObject elem2) {

		if ((elem1.eResource() == modelA && elem2.eResource() == modelB)
				|| (elem1.eResource() == modelB && elem2.eResource() == modelA)) {
			return matchedAB.get(elem1) == elem2 || matchedBA.get(elem1) == elem2;
		} else if ((elem1.eResource() != modelA && elem1.eResource() != modelB)
				|| (elem2.eResource() != modelA && elem2.eResource() != modelB)) {
			return EMFUtil.getEObjectURI(elem1).equals(EMFUtil.getEObjectURI(elem2));
		} else
			return false;
	}

	@Override
	public Collection<EObject> getElementsWithCorrespondences(Resource model) {
		if (model == modelA) {
			return Collections.unmodifiableSet(matchedAB.keySet());
		} else if (model == modelB) {
			return Collections.unmodifiableSet(matchedBA.keySet());
		} else {
			throw new UnsupportedOperationException("given model is not one of the compared models");
		}
	}

	@Override
	public Collection<EObject> getElementsWithoutCorrespondences(Resource model) {
		if (model == modelA) {
			return Collections.unmodifiableSet(allUnmatchedInA);
		} else if (model == modelB) {
			return Collections.unmodifiableSet(allUnmatchedInB);
		} else {
			throw new UnsupportedOperationException(); // given model is not one
														// of the compared
														// models
		}
	}

	
	
	public void removeCorrespondence(EObject elem1, EObject elem2)  {
		if (elem1.eResource() != modelA) {
			throw new UnsupportedOperationException(); // first element is not
														// an element of the
														// first model
		}
		if (elem2.eResource() != modelB) {
			throw new UnsupportedOperationException(); // second element is not
														// an element of the
														// second model
		}
		if (matchedAB.get(elem1) == elem2 && matchedBA.get(elem2) == elem1) {
			Set<EObject> unmatchedInA = this.unmatchedInA.get(elem1.eClass());
			Set<EObject> unmatchedInB = this.unmatchedInB.get(elem2.eClass());
			synchronized (this) {
				matchedAB.remove(elem1);
				matchedBA.remove(elem2);
				unmatchedInA.add(elem1);
				unmatchedInB.add(elem2);
			}
		} else {
			throw new NoMatchException("Cannot find match between ", elem1, " and ", elem2, "! (", elem1,
					" is matched with ", matchedAB.get(elem1), ", ", elem2, " is matched with ", matchedBA.get(elem2),
					")");
		}
	}

	@Override
	public void removeCorrespondence(EObject... elements) {
		if (elements.length != 2) {
			throw new UnsupportedOperationException(); // only pairwise matches
														// allowed
		}
		removeCorrespondence(elements[0], elements[1]);
	}
	
		

	@Override
	public void removeFromCorrespondence(EObject element) {
		
		//As we only support pairwise correspondences, we remove the whole correspondence itself
		if(element.eResource().equals(modelA)){
			EObject partner = matchedAB.get(element);
			removeCorrespondence(element, partner);			
		}
		else{
			EObject partner = matchedBA.get(element);
			removeCorrespondence(partner,element);			
			
		}	

		
	}

	
	
	@Override
	public String getServiceID() {
		return SERVICE_ID;
	}

	@Override
	public void reset() {
		this.modelA = null;
		this.modelB=null;
		this.allUnmatchedInA.clear(); 
		this.allUnmatchedInB.clear(); 
		this.matchedAB.clear();
		this.matchedBA.clear(); 
		this.unmatchedInA.clear();
		this.unmatchedInB.clear();
		
	}

	@Override
	public String getDescription() {
		return "This is the standard implementation of the CorrespondenceService.";
	}

	@Override
	public boolean canHandle(Collection<Resource> models) {
		if(models.size() > 2)
			return false;
		return true;
	}

}
