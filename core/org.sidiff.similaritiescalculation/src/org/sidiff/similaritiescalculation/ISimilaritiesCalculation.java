package org.sidiff.similaritiescalculation;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.configuration.IConfigurableExtension;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.similarities.ISimilarities;

public interface ISimilaritiesCalculation extends IConfigurableExtension {

	Description<ISimilaritiesCalculation> DESCRIPTION = Description.of(
			ISimilaritiesCalculation.class, "org.sidiff.similaritiescalculation.extensionpoint", "client", "class");

	ExtensionManager<ISimilaritiesCalculation> MANAGER = new ExtensionManager<>(new NoExtensionManagerStorage<>(DESCRIPTION));

	void init(Collection<Resource> models, ICorrespondences correspondences, ICandidates candidates) throws IOException;
	void reset();

	void calculateSimilarities(Collection<EObject> objects);
	void calculateSimilarities(EObject elem1, EObject elem2);

	ISimilarities getSimilarities();
}
