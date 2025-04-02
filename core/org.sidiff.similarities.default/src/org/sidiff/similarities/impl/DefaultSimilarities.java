package org.sidiff.similarities.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.adaption.AdaptedSortedSet;
import org.sidiff.common.emf.access.ExternalObjectComparison;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.ISimilarity;

public class DefaultSimilarities implements ISimilarities {

	public static final String SIMILARITIES_SERVICE_ID = "DefaultSimilarities";

	private final static Comparator<EObject> eObjectComparator = new Comparator<EObject>() {
		public int compare(EObject o1, EObject o2) {
			return o1.hashCode() - o2.hashCode();
		}
	};

	private final static SortedSet<ISimilarity> EMPTY_SORTED_SET = Collections
			.unmodifiableSortedSet(new TreeSet<ISimilarity>());

	private Resource resourceA = null;
	private Resource resourceB = null;

	// For all object of resource a there is an sorted set with all known
	// similarities according the object.
	private Map<EObject, SortedSet<SymmetricSimilarity>> simFromA = null;
	// For all object of resource b there is an sorted set with all known
	// similarities according the object.
	private Map<EObject, SortedSet<SymmetricSimilarity>> simFromB = null;

	private Map<EObject, Map<EObject, SymmetricSimilarity>> indexAB = null;

	private final static EObject getFromResource(Resource resource, EObject objectX, EObject objectY) {
		if (objectX.eResource() == resource)
			return objectX;
		if (objectY.eResource() == resource)
			return objectY;
		throw new IllegalArgumentException("Internal Error: Neither objectX (" + objectX + ") nor objectY (" + objectY
				+ ") is according to given resouce (" + resource + ")");
	}

	@Override
	public void init(Resource modelA, Resource modelB) {
		assert (modelA instanceof Resource) : "First model is not instance of Resource.";
		assert (modelB instanceof Resource) : "Second model is not instance of Resource.";
		
		this.resourceA = modelA;
		this.resourceB = modelB;
		
		// Indexes for access from a/b
		this.simFromA = new TreeMap<EObject, SortedSet<SymmetricSimilarity>>(eObjectComparator);
		this.simFromB = new TreeMap<EObject, SortedSet<SymmetricSimilarity>>(eObjectComparator);

		// Main data store
		this.indexAB = new TreeMap<EObject, Map<EObject, SymmetricSimilarity>>(eObjectComparator);
	}

	@Override
	public SortedSet<ISimilarity> getSimilarities(EObject object) {

		if (object.eResource() == this.resourceA) {
			// Get similarities from "left to right"
			if (this.simFromA.containsKey(object)) {
				return new AdaptedSortedSet<SymmetricSimilarity, ISimilarity>(this.simFromA.get(object),
						new SimilarityAdapter(SimilarityAdapter.BSIM));
			} else {
				return EMPTY_SORTED_SET;
			}
		}
		if (object.eResource() == this.resourceB) {
			// Get similarities from "right to left"
			if (this.simFromB.containsKey(object)) {
				return new AdaptedSortedSet<SymmetricSimilarity, ISimilarity>(this.simFromB.get(object),
						new SimilarityAdapter(SimilarityAdapter.ASIM));
			} else {
				return EMPTY_SORTED_SET;
			}
		}

		throw new IllegalArgumentException("unknow object " + object);
	}

	@Override
	public float getSimilarityDegree(EObject objectX, EObject objectY) {
		if ((!resourceA.equals(objectX.eResource()) && !resourceA.equals(objectY.eResource()))
				|| (!resourceB.equals(objectX.eResource()) && !resourceB.equals(objectY.eResource()))) {
			ExternalObjectComparison eoc = ExternalObjectComparison.compare(objectX, objectY, resourceA, resourceB);
			if (eoc == ExternalObjectComparison.Equal) {
				return 1f;
			} else {
				return 0f;
			}
		}

		SymmetricSimilarity similarity = gocFromIndex(objectX, objectY, false);
		if (similarity == null) {
			return 0f;
		} else {
			return similarity.getSimilarity();
		}
	}

	@Override
	public void setSimilarity(EObject objectX, EObject objectY, float similarityValue) {

		if (similarityValue > 0.0f) {
			SymmetricSimilarity similarity = gocFromIndex(objectX, objectY, true);
			float oldValue = similarity.getSimilarity();
			similarity.setSimilarity(similarityValue);
			if (Float.isNaN(oldValue)) {// Its a new Similarity

				SortedSet<SymmetricSimilarity> sortedSetA = this.simFromA.get(similarity.getElementA());
				if (sortedSetA == null) {
					sortedSetA = new SyncronizedSimilaritySet();
					this.simFromA.put(similarity.getElementA(), sortedSetA);
				}
				sortedSetA.add(similarity);

				SortedSet<SymmetricSimilarity> sortedSetB = this.simFromB.get(similarity.getElementB());
				if (sortedSetB == null) {
					sortedSetB = new SyncronizedSimilaritySet();
					this.simFromB.put(similarity.getElementB(), sortedSetB);
				}
				sortedSetB.add(similarity);
			}
		} else { // Similarity=0 -> No entry / remove existing entry
			SymmetricSimilarity similarity = gocFromIndex(objectX, objectY, false);
			if (similarity != null) {
				simFromA.get(similarity.getElementA()).remove(similarity);
				simFromB.get(similarity.getElementB()).remove(similarity);
			}
		}
	}

	@Override
	public void dispose(EObject object) {

		assert (object.eResource() == this.resourceA || object.eResource() == this.resourceB) : "Invalid Object!";

		Set<SymmetricSimilarity> sims = null;
		if (object.eResource() == this.resourceA) {
			// Resource A
			sims = simFromA.remove(object);
			if (sims != null) {
				for (SymmetricSimilarity sim : sims) {
					Set<SymmetricSimilarity> sB = simFromB.get(sim.getElementB());
					if (sB != null)
						sB.remove(sim);
				}
			} else {
				// Nothing to remove
				return;
			}
		}

		if (object.eResource() == this.resourceB) {
			// Resource B
			sims = simFromB.remove(object);
			if (sims != null) {
				for (SymmetricSimilarity sim : sims) {
					Set<SymmetricSimilarity> sA = simFromA.get(sim.getElementA());
					if (sA != null)
						sA.remove(sim);
				}
			} else {
				// Nothing to remove
				return;
			}
		}

		for (SymmetricSimilarity sim : sims) {
			Map<EObject, SymmetricSimilarity> indexB = indexAB.get(sim.getElementA());
			// indexB cannot be null!
			indexB.remove(sim.getElementB());
		}

	}

	private SymmetricSimilarity gocFromIndex(EObject objectX, EObject objectY, boolean create) {

		EObject objectA = getFromResource(this.resourceA, objectX, objectY);
		Map<EObject, SymmetricSimilarity> indexB = this.indexAB.get(objectA);

		if (indexB == null) {
			if (create) {
				indexB = new TreeMap<EObject, SymmetricSimilarity>(eObjectComparator);
				indexAB.put(objectA, indexB);
			} else {
				return null;
			}
		}

		EObject objectB = getFromResource(this.resourceB, objectY, objectX);
		SymmetricSimilarity index = indexB.get(objectB);

		if (index == null) {
			if (create) {
				index = new SymmetricSimilarity(objectA, objectB);
				indexB.put(objectB, index);
			} else {
				return null;
			}
		}

		return index;
	}

	@Override
	public void clear() {
		resourceA = null;
		resourceB = null;
		simFromA.clear();
		simFromB.clear();
		indexAB.clear();

	}

	@Override
	public String getSimilaritiesServiceID() {
		return SIMILARITIES_SERVICE_ID;
	}

	@Override
	public void reset() {
		clear();
	}
	@Override
	public String getDescription() {
		return "Default SimilaritiesService";
	}
	@Override
	public String getServiceID() {
		return "DefaultSimilaritiesService";
	}

}
