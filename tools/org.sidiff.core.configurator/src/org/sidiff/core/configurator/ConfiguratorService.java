package org.sidiff.core.configurator;

import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.services.Service;
import org.w3c.dom.Document;

public interface ConfiguratorService extends Service {
	
	public Document configureService(Class<?> service, EPackage... rootPackages);
	
}
