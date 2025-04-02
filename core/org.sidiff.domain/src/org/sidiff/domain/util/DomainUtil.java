package org.sidiff.domain.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.sidiff.domain.IDomain;

public class DomainUtil {
	

	public static Set<Bundle> getAvailableDomainBundles(String docType) {
		Set<Bundle> bundles = new HashSet<Bundle>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				IDomain.EXTENSION_POINT_ID)) {

			String nsUri = configurationElement.getAttribute("nsUri");
			if(nsUri.equals(docType)){				
				String pluginID = configurationElement.getContributor().getName();			
				Bundle bundle = Platform.getBundle(pluginID);
				bundles.add(bundle);
			}
		}
		return bundles;
	}
	
}
