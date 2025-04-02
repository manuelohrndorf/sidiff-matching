package org.sidiff.domain.modelloader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.xml.XMLTransformer;

/**
 * Abstract Loader for all XSLT based Imports. Subclasses has to provide the
 * XSLT Style sheet.
 * 
 * @author Maik Schmidt
 */
public abstract class XSLTImporter implements IModelLoader {

	public final static String USE_TEMPFILE_FOR_TRANSFORMATION = "USE_TEMPFILE";

	@Override
	public String getName() {
		return "Generic XSLT importer for '" + getXSLTDescription() + "'";
	}

	/**
	 * Gets the description of the XSLT-Script
	 * 
	 * @return The description as {@link String}
	 */
	public abstract String getXSLTDescription();

	/**
	 * Gets the absolute path of the XSLT-Script
	 * @return The absolute path as {@link String} 
	 */
	public abstract String getXSLTName();

	@Override
	public void parse(Resource resource, InputStream datastream) throws IOException {
		InputStream emfStream = null;
		try (InputStream xsltdata = Files.newInputStream(Paths.get(getXSLTName()))) {
			Map<?,?> options = getLoadOptions();
			if(options.containsKey(USE_TEMPFILE_FOR_TRANSFORMATION)
					&& options.get(USE_TEMPFILE_FOR_TRANSFORMATION)==Boolean.TRUE){
				emfStream = XMLTransformer.transformUsingTempfile(datastream, xsltdata);
			} else {
				emfStream = XMLTransformer.transform(datastream, xsltdata);
			}
			resource.load(emfStream, options);
		} finally {
			if(emfStream != null) {
				emfStream.close();
			}
		}
	}

	/**
	 * Concrete Loaded can define their loading options here. E.g. Map options =
	 * new HashMap(); options.put(XMLResource.OPTION_USE_DEPRECATED_METHODS,
	 * false);
	 * 
	 * Attention: keep OPTION_USE_DEPRECATED_METHODS being activated reason:
	 * JavaDoc says: if you use this option the SAX parser used for parsing
	 * documents must be namespace-aware [...] The default parser implementation
	 * is not namespace-aware.
	 * 
	 * @return a map with options or an empty map
	 */
	public Map<?,?> getLoadOptions() {
		return new HashMap<>();
	}

}
