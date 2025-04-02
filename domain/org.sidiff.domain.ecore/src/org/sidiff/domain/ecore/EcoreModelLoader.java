package org.sidiff.domain.ecore;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.io.IOUtil;
import org.sidiff.domain.modelloader.AbstractEMFImporter;

public class EcoreModelLoader extends AbstractEMFImporter {

	public static final String MODEL_LOADER_ID = "EcoreModelLoader";

	@Override
	public String getSuffix() {
		return "ecore";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	@Override
	public String getLoaderDescription() {
		return "Loader for Ecore models";
	}


	@Override
	public String getModelLoaderID() {
		return MODEL_LOADER_ID;
	}

	@Override
	public void loadModel(Resource res, String path) {
		parse(res, IOUtil.getInputStream(path));
	}

}
