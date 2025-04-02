package org.sidiff.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.io.ResourceUtil;
import org.sidiff.common.xml.XMLParser;
import org.sidiff.common.xml.XMLResolver;
import org.sidiff.domain.util.DomainUtil;
import org.w3c.dom.Document;

public class ConfigurationLoader {

	static {
		//Init all needed stuff for parsing XML files
		ResourceUtil.registerClassLoader(ConfigurationLoader.class.getClassLoader());
		XMLResolver.getInstance();
	}

	public static Document loadConfig(String configFilePath) {
		Document doc = XMLParser.parseStream(IOUtil.getInputStream(configFilePath));
		return doc;
	}

	public static Document loadConfig(InputStream is) {
		Document doc = XMLParser.parseStream(is);
		return doc;
	}

	public static Set<URL> getAvailableConfigs(String docType, String confType) {
		Set<URL> configs = new HashSet<URL>();
		String prefix = "/" + IConfiguration.CFGFOLDER + "/";
		String suffix = ".xml";

		for (Bundle domainBundle : DomainUtil.getAvailableDomainBundles(docType)) {
			Enumeration<URL> urls = domainBundle.findEntries(prefix + confType, "*" + suffix, true);
			if (urls != null) {
				while (urls.hasMoreElements()) {
					configs.add(urls.nextElement());
				}
			}
		}
		return configs;
	}

	public static Set<Document> loadAvailableConfigs(String docType, String confType) {
		Set<Document> availableConfigs = new HashSet<Document>();
		for (URL url : getAvailableConfigs(docType, confType)) {
			try {
				InputStream in = url.openStream();
				Document doc = loadConfig(in);
				if (doc != null)
					availableConfigs.add(doc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return availableConfigs;
	}

}
