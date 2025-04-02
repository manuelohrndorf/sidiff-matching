package org.sidiff.similarities.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.access.ExternalObjectComparison;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similarities.ISimilarity;

public class DefaultSimilarities implements ISimilarities {

	private final static Comparator<EObject> eObjectComparator = Comparator.comparingInt(Object::hashCode);

	private Resource resourceA = null;
	private Resource resourceB = null;

	// For all object of resource a there is an sorted set with all known
	// similarities according the object.
	private final Map<EObject, SortedSet<SymmetricSimilarity>> simFromA = new TreeMap<>(eObjectComparator);
	// For all object of resource b there is an sorted set with all known
	// similarities according the object.
	private final Map<EObject, SortedSet<SymmetricSimilarity>> simFromB = new TreeMap<>(eObjectComparator);

	private final Map<EObject, Map<EObject, SymmetricSimilarity>> indexAB = new TreeMap<>(eObjectComparator);

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
		reset();
		this.resourceA = modelA;
		this.resourceB = modelB;
	}

	@Override
	public SortedSet<ISimilarity> getSimilarities(EObject object) {
		if (object.eResource() == this.resourceA) {
			// Get similarities from "left to right"
			return simFromA.getOrDefault(object, Collections.emptySortedSet()).stream()
				.map(SimilarityAdapterFactory::createFromAtoB)
				.collect(Collectors.toCollection(TreeSet::new));
		}
		if (object.eResource() == this.resourceB) {
			// Get similarities from "right to left"
			return simFromB.getOrDefault(object, Collections.emptySortedSet()).stream()
					.map(SimilarityAdapterFactory::createFromBtoA)
					.collect(Collectors.toCollection(TreeSet::new));
		}

		throw new IllegalArgumentException("Object is not contained in either resource: " + object);
	}

	@Override
	public float getSimilarityDegree(EObject objectX, EObject objectY) {
		if ((!resourceA.equals(objectX.eResource()) && !resourceA.equals(objectY.eResource()))
				|| (!resourceB.equals(objectX.eResource()) && !resourceB.equals(objectY.eResource()))) {
			ExternalObjectComparison eoc = ExternalObjectComparison.compare(objectX, objectY, resourceA, resourceB);
			if (eoc == ExternalObjectComparison.Equal) {
				return 1f;
			}
			return 0f;
		}

		SymmetricSimilarity similarity = gocFromIndex(objectX, objectY, false);
		if (similarity == null) {
			return 0f;
		}
		return similarity.getSimilarity();
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
				indexB = new TreeMap<>(eObjectComparator);
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
	public void reset() {
		resourceA = null;
		resourceB = null;
		simFromA.clear();
		simFromB.clear();
		indexAB.clear();
	}

	@Override
	public String getKey() {
		return "DefaultSimilarities";
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("The default Similarities Service.");
	}
}
