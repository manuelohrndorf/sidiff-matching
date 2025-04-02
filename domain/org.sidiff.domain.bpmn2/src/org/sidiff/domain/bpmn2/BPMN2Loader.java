package org.sidiff.domain.bpmn2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.io.IOUtil;
import org.sidiff.domain.modelloader.XSLTImporter;


public class BPMN2Loader extends XSLTImporter {
	
	public static final String MODEL_LOADER_ID = "BPMN2Loader";
	
	@Override
	public String getSuffix() {
		return "bpmn";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

	@Override
	public Set<String> getMagicKeys() {
		return Collections
				.singleton("(?=.*http://www.omg.org/spec/BPMN/20100524/MODEL)(?!.*Signavio Process Editor).*");
	}

	@Override
	public String getXSLTName() {
		return "BPMN20-ToXMI_withoutDiagramm.xslt";
	}

	@Override
	public String getXSLTDescription() {
		return "Removes the unnecessary Diagram Elements";
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
