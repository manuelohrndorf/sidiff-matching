package org.sidiff.domain.uml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.sidiff.domain.modelloader.XSLTImporter;

public class RationalEMXLoader extends XSLTImporter {
	
	private static final Map<String, String> URIMAP = new HashMap<String, String>();
	static {
		URIMAP.put("http://www.sidiff.org/org.sidiff.uml.model",
				"platform:/resource/org.sidiff.uml.model/model/UMLModel.ecore");
		// URIMAP.put("http://www.sidiff.org/org.sidiff.uml.model/classes","platform:/resource/org.sidiff.uml.model/model/UMLModel.ecore#//classes");
		// URIMAP.put("http://www.sidiff.org/org.sidiff.uml.model/core","platform:/resource/org.sidiff.uml.model/model/UMLModel.ecore#//core");
	}

	@Override
	public String getSuffix() {
		return "emx";
	}

	@Override
	public Set<String> getMagicKeys() {
		return Collections.singleton(".*com\\.ibm\\.xtools\\.uml\\.msl\\.model.*7\\.0\\.0.*");
	}

	@Override
	public String getXSLTName() {
		return "importRationalEMX.xslt";
	}

	@Override
	public String getXSLTDescription() {
		return "EMX-File (Rational Software Modeler 7.0.0)";
	}

	@Override
	public Map<String, String> getSchemaLocationMappings() {
		return URIMAP;
	}

	@Override
	public String getKey() {
		return "RationalEMXLoader";
	}
}
