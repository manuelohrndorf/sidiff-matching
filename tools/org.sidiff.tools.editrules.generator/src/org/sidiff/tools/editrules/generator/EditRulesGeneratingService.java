package org.sidiff.tools.editrules.generator;

import org.eclipse.emf.ecore.resource.Resource;

public interface EditRulesGeneratingService {

	public void generate(Class<?> service, String outputFolder, Resource metaModel, String config, String workspace_loc);
}
