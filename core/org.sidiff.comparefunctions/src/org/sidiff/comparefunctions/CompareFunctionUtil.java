package org.sidiff.comparefunctions;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class CompareFunctionUtil {
	public static Set<ICompareFunction> getAvailableCompareFunction() {
		Set<ICompareFunction> comparefunctions = new HashSet<ICompareFunction>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ICompareFunction.EXTENSION_POINT_ID)) {
			try {
				ICompareFunction comparefunctionExtension = (ICompareFunction) configurationElement
						.createExecutableExtension("class");
				comparefunctions.add(comparefunctionExtension);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return comparefunctions;
	}

	public static ICompareFunction getCompareFunction(String comparefunctionID) {
		ICompareFunction result = null;
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ICompareFunction.EXTENSION_POINT_ID)) {
			try {
				ICompareFunction comparefunctionExtension = (ICompareFunction) configurationElement
						.createExecutableExtension("class");
				if (comparefunctionExtension.getCompareFunctionID().equals(comparefunctionID)) {
					result = comparefunctionExtension;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
