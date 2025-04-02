package org.sidiff.similaritiescalculation;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.configuration.IConfigurationCapable;
import org.sidiff.service.IService;

public interface ISimilaritiesCalculation extends IService,IConfigurationCapable {

	public static final String extensionPointID = "org.sidiff.similaritiescalculation.extensionpoint";

	public void calculateSimilarities(Collection<EObject> objects);

	public void calculateSimilarities(EObject elem1, EObject elem2);

	void init(Collection<Resource> models);
	
	void reset();
}
