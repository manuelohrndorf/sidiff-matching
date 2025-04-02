package org.sidiff.domain.petrinet;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.io.IOUtil;
import org.sidiff.domain.modelloader.AbstractEMFImporter;


public class PetrinetLoader extends AbstractEMFImporter  {
	
	public static final String MODEL_LOADER_ID = "PetrinetLoader";
	
	@Override
	public String getModelLoaderID() {
		return MODEL_LOADER_ID;
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
	public String getLoaderDescription() {
		return "Loader for Petrinet models";
	}
	
	public static String getModelLoaderId() {
		return MODEL_LOADER_ID;
	}

	@Override
	public void loadModel(Resource res, String path) {
		parse(res, IOUtil.getInputStream(path));		
	}
}
