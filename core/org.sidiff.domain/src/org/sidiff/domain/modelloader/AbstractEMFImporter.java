package org.sidiff.domain.modelloader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * This loader imports native EMF models. The models are basically
 * copied during import. The Loader is used to register the URI mappings
 * and to support the loading of files with a suffix different than ".xmi"
 * 
 * @author wenzel
 *
 */
public abstract class AbstractEMFImporter implements IModelLoader {

	@Override
	public void parse(Resource resource, InputStream data) throws IOException {
		resource.load(data, null);
	}

	@Override
	public Set<String> getMagicKeys() {
		return Collections.singleton(".*");
	}
}
