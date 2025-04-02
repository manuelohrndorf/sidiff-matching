package org.sidiff.correspondences.pairtable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.emf.collections.EMFClassifiers;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.correspondences.AbstractCorrespondences;
import org.sidiff.correspondences.exceptions.ExternalElementException;
import org.sidiff.correspondences.exceptions.NoMatchException;
import org.sidiff.correspondences.exceptions.OverlappingMatchException;

public class PairTableCorrespondences extends AbstractCorrespondences {

	private Resource modelA;
	private Resource modelB;
	private Map<EClass, Set<EObject>> unmatchedInA;
	private Set<EObject> allUnmatchedInA;
	private Map<EClass, Set<EObject>> unmatchedInB;
	private Set<EObject> allUnmatchedInB;
	private Map<EObject, EObject> matchedAB;
	private Map<EObject, EObject> matchedBA;

	@Override
	public void init(Collection<Resource> models)  {
		if (!canHandle(models)) {
			throw new IllegalArgumentException("only pairwise matches allowed");
		}

		Iterator<Resource> it = models.iterator();
		this.modelA = it.next();
		this.modelB = it.next();

		//FIXME
		//This should be done using the current @see{ICandidates}
		this.unmatchedInA = CollectionUtil.asStream(modelA.getAllContents())
				.collect(Collectors.groupingBy(EMFClassifiers.ELEMENT_BY_CLASS, Collectors.toSet()));
		this.allUnmatchedInA = CollectionUtil.combineSets(unmatchedInA.values());
		this.unmatchedInB = CollectionUtil.asStream(modelB.getAllContents())
				.collect(Collectors.groupingBy(EMFClassifiers.ELEMENT_BY_CLASS, Collectors.toSet()));
		this.allUnmatchedInB = CollectionUtil.combineSets(unmatchedInB.values());
		this.matchedAB = new HashMap<>();
		this.matchedBA = new HashMap<>();
	}

	@Override
	public void addCorrespondence(List<? extends EObject> elements) {
		Assert.isLegal(elements.size() == 2, "Only pairwise matches allowed: Size " + elements.size());
		addCorrespondence(elements.get(0), elements.get(1));
	}

	public void addCorrespondence(EObject elem1, EObject elem2)  {
		if (elem1.eResource() != modelA) {
			throw new IllegalArgumentException("first element is not an element of the first model");
		}
		if (elem2.eResource() != modelB) {
			throw new IllegalArgumentException("second element is not an element of the second model");
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
		} else {
			throw new OverlappingMatchException("Cannot match " + elem1 + " and " + elem2 + "\n Reason:" + elem1 + " is "
					+ (matchedAB.get(elem1) != null ? "already matched with " + matchedAB.get(elem1) : "unmatched")
					+ "\n        " + elem2 + " is "
					+ (matchedBA.get(elem2) != null ? "already matched with " + matchedBA.get(elem2) : "unmatched"));
		}
	}

	@Override
	public Collection<EObject> getCorrespondences(EObject element)  {
		if (!hasCorrespondences(element)) {
			return Collections.emptyList();
		}
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
	public boolean isCorresponding(List<? extends EObject> elements) {
		Assert.isLegal(elements.size() == 2, "Only pairwise matches allowed: Size " + elements.size());
		return isCorresponding(elements.get(0), elements.get(1));
	}

	public boolean isCorresponding(EObject elem1, EObject elem2) {
		Resource res1 = elem1.eResource();
		Resource res2 = elem2.eResource();
		if (res1 == modelA && res2 == modelB || res1 == modelB && res2 == modelA) {
			return matchedAB.get(elem1) == elem2 || matchedBA.get(elem1) == elem2;
		} else if (res1 != modelA && res1 != modelB || res2 != modelA && res2 != modelB) {
			return EcoreUtil.getURI(elem1).equals(EcoreUtil.getURI(elem2));
		}
		return false;
	}

	@Override
	public Collection<EObject> getElementsWithCorrespondences(Resource model) {
		if (model == modelA) {
			return Collections.unmodifiableSet(matchedAB.keySet());
		} else if (model == modelB) {
			return Collections.unmodifiableSet(matchedBA.keySet());
		} else {
			throw new IllegalArgumentException("given model is not one of the compared models");
		}
	}

	@Override
	public Collection<EObject> getElementsWithoutCorrespondences(Resource model) {
		if (model == modelA) {
			return Collections.unmodifiableSet(allUnmatchedInA);
		} else if (model == modelB) {
			return Collections.unmodifiableSet(allUnmatchedInB);
		} else {
			throw new IllegalArgumentException("given model is not one of the compared models");
		}
	}

	public void removeCorrespondence(EObject elem1, EObject elem2)  {
		if (elem1.eResource() != modelA) {
			throw new IllegalArgumentException("first element is not an element of the first model");
		}
		if (elem2.eResource() != modelB) {
			throw new IllegalArgumentException("second element is not an element of the second model");
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
			throw new NoMatchException("Cannot find match between " + elem1 + " and " + elem2 + "! (" + elem1 +
					" is matched with " + matchedAB.get(elem1) + ", " + elem2 + " is matched with " + matchedBA.get(elem2) + ")");
		}
	}

	@Override
	public void removeCorrespondence(List<? extends EObject> elements) {
		Assert.isLegal(elements.size() == 2, "Only pairwise matches allowed: Size " + elements.size());
		removeCorrespondence(elements.get(0), elements.get(1));
	}

	@Override
	public void removeFromCorrespondence(EObject element) {
		//As we only support pairwise correspondences, we remove the whole correspondence itself
		if(element.eResource().equals(modelA)) {
			EObject partner = matchedAB.get(element);
			removeCorrespondence(element, partner);
		} else {
			EObject partner = matchedBA.get(element);
			removeCorrespondence(partner, element);
		}
	}

	@Override
	public void reset() {
		this.modelA = null;
		this.modelB = null;
		this.allUnmatchedInA.clear();
		this.allUnmatchedInB.clear();
		this.matchedAB.clear();
		this.matchedBA.clear();
		this.unmatchedInA.clear();
		this.unmatchedInB.clear();
	}

	@Override
	public boolean canHandle(Collection<Resource> models) {
		return models.size() <= 2;
	}
}
