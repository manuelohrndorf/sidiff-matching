package org.sidiff.internal.tools.obfuscateTool;

import java.io.InputStream;

import org.sidiff.common.io.IOUtil;
import org.sidiff.common.xml.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PluginAdjuster {
	
	static final String PLUGIN_ELEMENT_EXTENSION = "extension";
	static final String PLUGIN_ELEMENT_RUN = "run";
	static final String PLUGIN_ATTRIBUTE_ID = "id";
	static final String PLUGIN_ATTRIBUTE_CLASS = "class";
	
	public static void main(String[] args) {
		
		adjustPlugin(args[0]);
	}
	
	private static void adjustPlugin(String filename) {
		
		InputStream input = IOUtil.getInputStream(filename);
		Document doc = XMLParser.parseStream(input);
		NodeList pluginExtensions = doc.getElementsByTagName(PLUGIN_ELEMENT_EXTENSION);
		for (int i = 0; i < pluginExtensions.getLength(); i++) {
			Node actualPluginExtension = pluginExtensions.item(i);

			// Adjust id value ########################################################################
			Node id = actualPluginExtension.getAttributes().getNamedItem(PLUGIN_ATTRIBUTE_ID);
			String oldName = id.getNodeValue();
			String obfuscatedName = MappingTool.getNewClassName(oldName);
			// Getting the prefix of the full-qualified class name
			String[] split = oldName.split("\\.");
			int endIndex = oldName.length() - split[split.length -1].length();
			String prefix = oldName.substring(0, endIndex);
			id.setNodeValue(prefix + obfuscatedName);
			// ########################################################################################
		}
		
		NodeList pluginRuns = doc.getElementsByTagName(PLUGIN_ELEMENT_RUN);
		for (int i = 0; i < pluginRuns.getLength(); i++) {
			Node actualpluginRun = pluginRuns.item(i);

			// Adjust class value######################################################################
			Node clazz = actualpluginRun.getAttributes().getNamedItem(PLUGIN_ATTRIBUTE_CLASS);
			String oldName = clazz.getNodeValue();
			String obfuscatedName = MappingTool.getNewClassName(oldName);
			// Getting the prefix of the full-qualified class name
			String[] split = oldName.split("\\.");
			int endIndex = oldName.length() - split[split.length -1].length();
			String prefix = oldName.substring(0, endIndex);
			clazz.setNodeValue(prefix + obfuscatedName);	
			// ########################################################################################
		}
		MappingTool.writeFile(doc, filename);	
	}
}
