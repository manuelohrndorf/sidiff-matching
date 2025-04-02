package org.sidiff.matcher;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.collections.ValueMap;

public abstract class LocalSignatureMatcher extends SignatureBasedMatcher<String> {	

	@Override
	protected ValueMap<String, EObject> calculateSignatures(Resource model) {
		
		ValueMap<String, EObject> idMap = new ValueMap<>();
		for (EObject currentObject : CollectionUtil.asIterable(model.getAllContents())) {
			//Only do this for unmatched elements
			if(!getCorrespondencesService().hasCorrespondences(currentObject)){
				String id = getElementSignature(currentObject);
				if (id != null) {
					//At this point we add all elements (even in case of ambiguous signatures)
					idMap.put(currentObject, id);
				}	
			}
		}
		// If we do not want ambiguous signatures, we remove them now
		if(!allowsAmbiguousSignature()){
			for(String ambiguousID : idMap.getFilledValues(2)){
				idMap.remove(ambiguousID);
			}
		}
		return idMap;
		
	}

	@Override
	protected void matchSignatures() {
		//We use the "first" ValueMap as starting point.
		ValueMap<String, EObject> correspondenceMap = new ValueMap<>();
		Resource firstResource = getModels().get(0);
		correspondenceMap.insert(getSignatures().get(firstResource));
		for(Resource res : getSignatures().keySet()) {
			if(!res.equals(firstResource)) {
				correspondenceMap.insert(getSignatures().get(res));				
			}
		}

		//Now all corresponding elements (minimum 2) are mapped to the same value
		for(String id : correspondenceMap.getFilledValues(2)) {
			List<EObject> allCandidates = correspondenceMap.getObjects(id);
			if(considerCandidatesOnly()) {
				//Now we prune all candidates which would penalize the correspondence in size
				//TODO DR: This is just one optimization criteria, this needs to be configurable!
				ValueMap<Integer, EObject> numberOfCandidatesMap = new ValueMap<>();			
				for(EObject candidate : allCandidates) {
					Set<EObject> otherCandidates = new HashSet<>();
					otherCandidates.addAll(allCandidates);
					otherCandidates.remove(candidate);					
					int numberOfOtherCandidates = 0;
					for(EObject otherCandidate : otherCandidates) {
						if(getCandidatesService().getCandidates(candidate).contains(otherCandidate)) {
							numberOfOtherCandidates++;							
						}
					}
					numberOfCandidatesMap.put(candidate, numberOfOtherCandidates);
				}
				//As long this is no correspondence regarding the current @see{ICandidates}
				//remove the element with the minimum candidates
				while(!allCandidates.isEmpty() && !getCandidatesService().isCandidate(allCandidates)){
					int minimum = Collections.min(numberOfCandidatesMap.getValues());
					//Remove randomly one
					EObject cand = numberOfCandidatesMap.getObjects(minimum).iterator().next();
					correspondenceMap.removeObject(cand);
					numberOfCandidatesMap.removeObject(cand);
				}
			}
			//We may have a correspondence
			if(allCandidates.size() >= 2) {
				getCorrespondencesService().addCorrespondence(allCandidates);
				allCandidates.forEach(getCandidatesService()::removeCandidate);
			}
		}
		
	}
	
	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(GENERIC_TYPE);
	}

	@Override
	protected boolean allowsAmbiguousSignature() {
		return false;
	}
	
	protected abstract String getElementSignature(EObject element);
	
	protected abstract boolean considerCandidatesOnly();
}
