package org.sidiff.similarities;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class SimilaritiesServiceUtil {

	static ISimilarities instance = null;

	public static Set<ISimilarities> getAvailableSimilaritiesService() {
		Set<ISimilarities> similaritiesServices = new HashSet<ISimilarities>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ISimilarities.EXTENSION_POINT_ID)) {
			try {
				ISimilarities similaritiesServiceExtension = (ISimilarities) configurationElement
						.createExecutableExtension("class");
				similaritiesServices.add(similaritiesServiceExtension);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return similaritiesServices;
	}

	public static ISimilarities getAvailableSimilaritiesService(String similaritiesServiceID) {
		ISimilarities similaritiesService = null;
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ISimilarities.EXTENSION_POINT_ID)) {
			try {
				ISimilarities similaritiesServiceExtension = (ISimilarities) configurationElement
						.createExecutableExtension("class");
				if (similaritiesServiceExtension.getSimilaritiesServiceID().equals(similaritiesServiceID)) {
					similaritiesService = similaritiesServiceExtension;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return similaritiesService;
	}
	
	public static void setSimilaritiesServiceInstance(ISimilarities ssi) {
		instance = ssi;
	}
	
	public static ISimilarities getSimilaritiesServiceInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = getAvailableSimilaritiesService().iterator().next();
		}
		return instance;
	}

}
