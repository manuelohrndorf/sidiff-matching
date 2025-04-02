package org.sidiff.correspondences;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.extension.AbstractExtension;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;

public abstract class AbstractCorrespondences extends AbstractExtension implements ICorrespondences {

	@Override
	public void addCorrespondence(EObject... elements) {
		addCorrespondence(Arrays.asList(elements));
	}

	@Override
	public void removeCorrespondence(EObject... elements) {
		removeCorrespondence(Arrays.asList(elements));
	}

	@Override
	public boolean isCorresponding(EObject... elements) {
		return isCorresponding(Arrays.asList(elements));
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return IExtensionConfiguration.NULL;
	}
}
