package org.sidiff.similarities;

import org.eclipse.emf.ecore.EObject;

public interface ISimilarity extends Comparable<ISimilarity> {

	/**
	 * Returns the object for which this similarity was computed.
	 * 
	 * @return the Similar Object
	 */
	public EObject getObject();

	/**
	 * Returns the similar object according to this Similarity.
	 * 
	 * @return the Similar Object
	 */
	public EObject getSimilarObject();

	/**
	 * The similarity degree according to this Similarity and the similar
	 * object.
	 * 
	 * @return the similarity degree.
	 */
	public float getSimilarity();
}
