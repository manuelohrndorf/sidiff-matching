package org.sidiff.domain.petrinet;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.domain.modelloader.AbstractEMFImporter;

public class PetrinetLoader extends AbstractEMFImporter  {

	@Override
	public String getKey() {
		return "PetrinetLoader";
	}

	@Override
	public String getSuffix() {
		return "petrinet";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	@Override
	public String getName() {
		return "Loader for Petrinet models";
	}
}
