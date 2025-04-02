package org.sidiff.similaritiescalculation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class SimilaritiesCalculationUtil {

	private static ISimilaritiesCalculation instance = null;

	public static Set<ISimilaritiesCalculation> getAvailableISimilaritiesCalculationServices() {
		Set<ISimilaritiesCalculation> similaritiesCalculationServices = new HashSet<ISimilaritiesCalculation>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ISimilaritiesCalculation.extensionPointID)) {
			try {
				ISimilaritiesCalculation similaritiesCalculationService = (ISimilaritiesCalculation) configurationElement
						.createExecutableExtension("class");
				similaritiesCalculationServices.add(similaritiesCalculationService);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return similaritiesCalculationServices;
	}

	public static ISimilaritiesCalculation getSimilaritiesCalculationServiceInstance() {
		if (instance != null) {
			return instance;
		} else {
			instance = getAvailableISimilaritiesCalculationServices().iterator().next();
		}
		return instance;
	}
}
