package org.sidiff.domain.uml2;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.io.IOUtil;
import org.sidiff.domain.modelloader.AbstractEMFImporter;

public class UML2Loader extends AbstractEMFImporter {
	public static final String MODEL_LOADER_ID = "UML2v4Loader";

	@Override
	public String getSuffix() {
		return "uml";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	@Override
	public String getLoaderDescription() {
		return "Loader for UML2 models";
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
