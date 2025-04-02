package org.sidiff.domain.modelloader;

import java.util.Set;
import java.util.stream.Collectors;

import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension.Description;

public class ModelLoaderManager extends ExtensionManager<IModelLoader> {

	public ModelLoaderManager(Description<? extends IModelLoader> description) {
		super(description);
	}

	public Set<IModelLoader> getUsableModelLoaders(String path) {
		return getExtensions().stream()
			.filter(loader -> path.endsWith(loader.getSuffix()))
			.collect(Collectors.toSet());
	}
}
