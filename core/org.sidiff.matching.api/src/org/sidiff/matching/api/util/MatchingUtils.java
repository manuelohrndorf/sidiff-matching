package org.sidiff.matching.api.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.EMFStorage;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.MatcherUtil;

/**
 * Utility functions which are made publicly available to any clients using the
 * SiDiff framework. UI components of the SiDiff IDE should, if required, also
 * use these utility functions, and not the internal functions of the respective
 * engines.
 * 
 * @author kehrer, mohrndorf, cpietsch
 */
public class MatchingUtils {
	
	/**
	 * Load EMF resource.
	 * 
	 * @param path
	 *            The EMF-file path.
	 * @return The loaded EMF-object.
	 */
	public static Resource loadModel(String path) {
		return EMFStorage.eLoad(EMFStorage.pathToUri(path)).eResource();
	}
	
	/**
	 * Find all available matchers matching the document types of the given models.
	 * 
	 * @param modelA
	 *            Model A of the comparison.
	 * @param modelB
	 *            Model B of the comparison.
	 * @return All available matchers matching the document types of the given models.
	 */
	public static List<IMatcher> getAvailableMatchers(Resource modelA, Resource modelB) {
		return MatcherUtil.getAvailableMatchers(Arrays.asList(modelA,modelB));
	}
	
	/**
	 * Find all available matchers matching the given document types.
	 * 
	 * @param documentTypes
	 * 			
	 * @return All available matchers matching the given document types.
	 * @see LiftingFacade#getDocumentType(Resource)
	 */
	public static List<IMatcher> getAvailableMatchers(Set<String> documentTypes) {
		return MatcherUtil.getAvailableMatchers(documentTypes);
	}
	
	/**
	 * Find all generic matchers.
	 * 
	 * @return All generic matchers.
	 */
	public static List<IMatcher> getGenericMatchers() {
		return MatcherUtil.getGenericMatchers();
	}
	
	/**
	 * Get matcher by its key name.
	 * 
	 * @param key
	 *            The key name of the matcher.
	 * @param modelA
	 *            Model A of the comparison.
	 * @param modelB
	 *            Model B of the comparison.
	 * @return The matcher with the key name; null otherwise.
	 * @see IMatcher#getKey()
	 */
	public static IMatcher getMatcherByKey(String key) {
		return MatcherUtil.getMatcher(key);
	}
}
