package org.sidiff.domain.modisco.java;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.common.emf.modelstorage.AbstractEMFImporter;

public class ModiscoJavaLoader extends AbstractEMFImporter{

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	@Override
	public String getSuffix() {
		return "xmi";
	}

	@Override
	public String getLoaderDescription() {
		return "Loader for Modisco Java models";
	}
}
