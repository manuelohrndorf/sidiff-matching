package org.sidiff.tools.editrules.generator.util;

import org.eclipse.emf.henshin.model.TransformationSystem;

public class TSFilenamePair {
	
	private String outputFileName = null;
	private TransformationSystem trafo = null;
	
	public TSFilenamePair(String outputFileName, TransformationSystem trafo) {
		this.outputFileName = outputFileName;
		this.trafo = trafo;
	}
	
	public String getOutputFileName() {
		return outputFileName;
	}

	public TransformationSystem getTrafo() {
		return trafo;
	}

}
