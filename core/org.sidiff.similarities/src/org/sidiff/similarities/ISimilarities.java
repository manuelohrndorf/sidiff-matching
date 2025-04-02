package org.sidiff.similarities;

import java.util.SortedSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.service.IService;

public interface ISimilarities extends IService{

	public static final String EXTENSION_POINT_ID = "org.sidiff.similarities.extensionpoint";
	public static final String SERVICE_ID = "ISimilarities";

	public void init(Resource modelA, Resource modelB);

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
	public void setSimilarity(EObject objectA, EObject objectB, float similarity);

	/**
	 * Drops all similarities of the given object. This means object will not
	 * longer be a similar object to any other object. getSimilarityDegree of
	 * object and any other object will always be 0.
	 * 
	 * @param object
	 */
	public void dispose(EObject object);

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
	public SortedSet<ISimilarity> getSimilarities(EObject object);

	/**
	 * Determinates the Similarity of the given pair of Objects.
	 *
	 * @param objectA
	 * @param objectB
	 * @return the similarity degree between the given objects.
	 */
	public float getSimilarityDegree(EObject objectA, EObject objectB);

	/**
	 * Releases all stored information if this service. Can be used to free
	 * memory.
	 *
	 */
	public void clear();

	public String getSimilaritiesServiceID();
	public void reset();
}
