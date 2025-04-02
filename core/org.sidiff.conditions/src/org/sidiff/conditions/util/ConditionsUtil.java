package org.sidiff.conditions.util;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.sidiff.conditions.ICondition;

public class ConditionsUtil {

	public static Set<ICondition> getAvailableConditions() {
		Set<ICondition> conditions = new HashSet<ICondition>();

		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ICondition.EXTENSION_POINT_ID)) {
			try {
				ICondition conditionsExtension = (ICondition) configurationElement.createExecutableExtension("class");
				conditions.add(conditionsExtension);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conditions;
	}

	public static ICondition getCondition(String conditionsServiceID) {
		ICondition result = null;
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry().getConfigurationElementsFor(
				ICondition.EXTENSION_POINT_ID)) {
			try {
				ICondition conditionsExtension = (ICondition) configurationElement.createExecutableExtension("class");
				if (conditionsExtension.getConditionID().equals(conditionsServiceID)) {
					result = conditionsExtension;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
