package org.sidiff.comparators;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class ComparatorUtil {

	public static Set<IComparator> getAvailableComparators() {
		Set<IComparator> result = new HashSet<IComparator>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				IComparator.EXTENSION_POINT_ID)) {
			try {
				IComparator comparatorExtension = (IComparator) configurationElement.createExecutableExtension("class");
				result.add(comparatorExtension);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static IComparator getComparator(String comparatorfunctionID) {
		IComparator result = null;
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				IComparator.EXTENSION_POINT_ID)) {
			try {
				IComparator comparatorExtension = (IComparator) configurationElement.createExecutableExtension("class");
				if (comparatorExtension.getComparatorID().equals(comparatorfunctionID)) {
					result = comparatorExtension;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
