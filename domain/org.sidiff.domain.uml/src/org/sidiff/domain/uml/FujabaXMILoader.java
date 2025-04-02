package org.sidiff.domain.uml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.io.IOUtil;
import org.sidiff.domain.modelloader.XSLTImporter;

public class FujabaXMILoader extends XSLTImporter {
	public static final String MODEL_LOADER_ID = "FujabaXMILoader";

	private static final Map<String, String> URIMAP = new HashMap<String, String>();

	static {
		URIMAP.put("http://www.sidiff.org/org.sidiff.uml.model",
				"platform:/resource/org.domainservice.uml/model/UMLModel.ecore");
		// URIMAP.put("http://www.sidiff.org/org.sidiff.uml.model/classes","platform:/resource/org.sidiff.uml.model/model/UMLModel.ecore#//classes");
		// URIMAP.put("http://www.sidiff.org/org.sidiff.uml.model/core","platform:/resource/org.sidiff.uml.model/model/UMLModel.ecore#//core");
	}

	@Override
	public String getSuffix() {
		return "xmi";
	}

	@Override
	public Set<String> getMagicKeys() {
		return Collections.singleton(".*Fujaba.*");
	}

	@Override
	public String getXSLTName() {
		return "importFujabaXMI.xslt";
	}

	@Override
	public String getXSLTDescription() {
		return "XMI-File (exported from Fujaba 4.3.x)";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		return URIMAP;
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
