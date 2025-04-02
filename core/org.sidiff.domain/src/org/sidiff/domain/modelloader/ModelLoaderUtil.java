package org.sidiff.domain.modelloader;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

public class ModelLoaderUtil {

	public static Set<IModelLoader> getAvailableModelLoaders() {
		Set<IModelLoader> modelloaders = new HashSet<IModelLoader>();
		for (IConfigurationElement configurationElement : Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IModelLoader.EXTENSION_POINT_ID)) {
			try {
				IModelLoader modelloader = (IModelLoader) configurationElement.createExecutableExtension("class");
				modelloaders.add(modelloader);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return modelloaders;
	}

	public static Set<IModelLoader> getUsableModelLoaders(String path) {
		Set<IModelLoader> modelloaders = new HashSet<IModelLoader>();
		Set<IModelLoader> availableModelLoaders = getAvailableModelLoaders();
		for (IModelLoader iModelLoader : availableModelLoaders) {
			if (path.endsWith(iModelLoader.getSuffix())) {
				modelloaders.add(iModelLoader);
			}
		}
		return modelloaders;
	}

	public static IModelLoader getModelLoaderByID(String modelLoaderID) {
		IModelLoader modelloader = null;
		Set<IModelLoader> availableModelLoaders = getAvailableModelLoaders();
		for (IModelLoader iModelLoader : availableModelLoaders) {
			if (iModelLoader.getModelLoaderID().equals(modelLoaderID)) {
				modelloader = iModelLoader;
			}
		}
		return modelloader;
	}

	/**
	 * This method get the first available modelloader. If there are more then
	 * one, please change your launch config or use "getModelLoaderByID"
	 * 
	 * @param suffix
	 * @return
	 */
	public static IModelLoader getUsableModelLoader(String path) {
		return getUsableModelLoaders(path).iterator().next();
	}

}
