package org.sidiff.candidates.type;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This implementation of the TypeCandidates assumes that no two model elements may be candidates
 * to each other, if they are originating from the same model. This may be used in versioning but
 * therefore cannot be used for intra model clone detection.
 * @author dreuling
 *
 */
public class InterModelTypeCandidates extends TypeCandidates {

	@Override
	public boolean isCandidate(Collection<EObject> candidates) {
		Assert.isLegal(!candidates.isEmpty());
		Iterator<EObject> it = candidates.iterator();
		EObject candidate = it.next();

		//first check resource
		Resource originatingModel = candidate.eResource();
		for(; it.hasNext(); ){
			if(it.next().eResource().equals(originatingModel)) {
				return false;				
			}
		}

		Set<EObject> cands = new HashSet<>(candidates);
		cands.remove(candidate);
		
		//then type
		return getCandidates(candidate).containsAll(cands);
	}

	@Override
	public Collection<EObject> getCandidates(EObject element) {
		Resource originatingModel = element.eResource();
		EClass elementType = element.eClass();

		return getCandidates().entrySet().stream()
			.filter(candidate -> !candidate.getKey().equals(originatingModel))
			.map(candidate -> candidate.getValue().getObjects(elementType))
			.flatMap(Collection::stream)
			.collect(Collectors.toSet());
	}

	@Override
	public String getKey() {
		return "InterModelTypeCandidates";
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This implementation of the TypeCandidates assumes that no two model elements may be candidates" + 
				" to each other, if they are originating from the same model.");
	}
}
