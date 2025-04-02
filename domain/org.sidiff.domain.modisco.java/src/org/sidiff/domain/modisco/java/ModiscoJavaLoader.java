package org.sidiff.domain.modisco.java;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.domain.modelloader.AbstractEMFImporter;

public class ModiscoJavaLoader extends AbstractEMFImporter {

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
	public String getName() {
		return "Loader for Modisco Java models";
	}

	@Override
	public String getKey() {
		return "ModiscoJavaLoader";
	}
}
