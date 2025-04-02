package org.sidiff.candidates.type;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.AbstractCandidates;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.common.emf.collections.EMFClassifiers;

public abstract class TypeCandidates extends AbstractCandidates {

	private final Map<Resource,ValueMap<EClass, EObject>> candidates = new HashMap<>();

	@Override
	public void init(Collection<Resource> models) {
		reset();

		for (Resource resource : models) {
			Map<EClass, Set<EObject>> typeMap;
			List<EObject> allElements = CollectionUtil.asStream(resource.getAllContents()).collect(Collectors.toList());
			typeMap = CollectionUtil.groupSet(allElements, EMFClassifiers.ELEMENT_BY_CLASS);
			ValueMap<EClass, EObject> types = new ValueMap<>();
			for(EClass type : typeMap.keySet()) {
				for(EObject obj : typeMap.get(type)) {
					types.put(obj, type);
				}
			}
			this.candidates.put(resource, types);
		}
	}

	@Override
	public void reset() {
		this.candidates.clear();
	}

	@Override
	public boolean hasCandidates(EObject element) throws Exception {
		return !getCandidates(element).isEmpty();
	}

	@Override
	public void addCandidate(EObject candidate) {
		Resource originatingModel = candidate.eResource();
		EClass candidateType = candidate.eClass();
		this.candidates.get(originatingModel).put(candidate, candidateType);		
	}

	@Override
	public void removeCandidate(EObject candidate) {
		Resource originatingModel = candidate.eResource();
		this.candidates.get(originatingModel).containsObject(candidate);
		this.candidates.get(originatingModel).removeObject(candidate);		
	}

	protected Map<Resource, ValueMap<EClass, EObject>> getCandidates() {
		return Collections.unmodifiableMap(candidates);
	}
}
