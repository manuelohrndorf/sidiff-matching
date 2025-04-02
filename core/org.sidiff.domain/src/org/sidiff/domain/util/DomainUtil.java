package org.sidiff.domain.util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class DomainUtil {

	public static final String EXTENSION_POINT_ID = "org.sidiff.domain.extensionpoint";
	public static final String ATTRIBUTE_NSURI = "nsUri";

	public static Set<Bundle> getAvailableDomainBundles(String docType) {
		Set<Bundle> bundles = new HashSet<Bundle>();
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID)) {
			if(Objects.equals(configurationElement.getAttribute(ATTRIBUTE_NSURI), docType)) {
				String pluginID = configurationElement.getContributor().getName();			
				bundles.add(Platform.getBundle(pluginID));
			}
		}
		return bundles;
	}
}
