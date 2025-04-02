package org.sidiff.domain.henshin;

import java.util.HashMap;
import java.util.Map;

import org.sidiff.domain.modelloader.AbstractEMFImporter;

public class HenshinModelLoader extends AbstractEMFImporter {

	@Override
	public String getSuffix() {
		return "henshin";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	@Override
	public String getName() {
		return "Loader for Henshin models";
	}


	@Override
	public String getKey() {
		return "HenshinModelLoader";
	}
}
