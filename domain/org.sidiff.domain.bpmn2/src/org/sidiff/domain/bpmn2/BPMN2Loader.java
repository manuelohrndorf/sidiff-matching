package org.sidiff.domain.bpmn2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.domain.modelloader.XSLTImporter;

public class BPMN2Loader extends XSLTImporter {

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
	public String getKey() {
		return "BPMN2Loader";
	}
}
