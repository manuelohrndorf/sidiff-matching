package org.sidiff.domain.uml2;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.domain.modelloader.AbstractEMFImporter;

public class UML2Loader extends AbstractEMFImporter {

	@Override
	public String getSuffix() {
		return "uml";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		return new HashMap<>();
	}

	@Override
	public String getName() {
		return "Loader for UML2 models";
	}

	@Override
	public String getKey() {
		return "UML2v4Loader";
	}
}
