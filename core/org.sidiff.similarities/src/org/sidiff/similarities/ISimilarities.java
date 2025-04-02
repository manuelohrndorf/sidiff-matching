package org.sidiff.similarities;

import java.util.SortedSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;

public interface ISimilarities extends IExtension {

	Description<ISimilarities> DESCRIPTION = Description.of(ISimilarities.class, "org.sidiff.similarities.extensionpoint", "client", "class");

	ExtensionManager<ISimilarities> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));


	void init(Resource modelA, Resource modelB);

	/**
	 * Sets the (symmetric) similarity of the objects. This means specially:
	 * 
	 * getSimilarityDegree of a,b = getSimilarityDegree of b,a = similarity
	 * 
	 * @param objectA
	 *            object "a".
	 * @param objectB
	 *            object "b".
	 * @param similarity
	 *            the similarity between objects a and b.
	 */
	void setSimilarity(EObject objectA, EObject objectB, float similarity);

	/**
	 * Drops all similarities of the given object. This means object will not
	 * longer be a similar object to any other object. getSimilarityDegree of
	 * object and any other object will always be 0.
	 * 
	 * @param object
	 */
	void dispose(EObject object);

	/**
	 * Determinates the Similarities of the given Objects. The result is a
	 * sorted sorted from highest to lowest similarity.
	 * 
	 * @see Similarity
	 * 
	 * @param object
	 *            Object for that similarities has to be determinated.
	 * @return sorted set of similarities.
	 */
	SortedSet<ISimilarity> getSimilarities(EObject object);

	/**
	 * Determinates the Similarity of the given pair of Objects.
	 *
	 * @param objectA
	 * @param objectB
	 * @return the similarity degree between the given objects.
	 */
	float getSimilarityDegree(EObject objectA, EObject objectB);

	/**
	 * Releases all stored information if this service. Can be used to free
	 * memory.
	 *
	 */
	void reset();
}
