package org.sidiff.domain.bpmn2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.domain.modelloader.XSLTImporter;

public class SignavioLoader extends XSLTImporter {

	public static final String MODEL_LOADER_ID = "SignavioLoader";

	@Override
	public String getSuffix() {
		return "bpmn";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		return new HashMap<>();
	}

	@Override
	public Set<String> getMagicKeys() {
		return Collections
				.singleton("(?=.*http://www.omg.org/spec/BPMN/20100524/MODEL)(?=.*Signavio Process Editor).*");
	}

	@Override
	public String getXSLTName() {
		return "BPMN20-ToXMI_signavio.xslt";
	}

	@Override
	public String getXSLTDescription() {
		return "signavio import";
	}


	@Override
	public String getKey() {
		return "SignavioLoader";
	}
}
