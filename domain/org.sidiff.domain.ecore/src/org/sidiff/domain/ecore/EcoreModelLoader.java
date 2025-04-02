package org.sidiff.domain.ecore;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.domain.modelloader.AbstractEMFImporter;

public class EcoreModelLoader extends AbstractEMFImporter {

	@Override
	public String getSuffix() {
		return "ecore";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		return new HashMap<>();
	}

	@Override
	public String getName() {
		return "Loader for Ecore models";
	}

	@Override
	public String getKey() {
		return "EcoreModelLoader";
	}
}
