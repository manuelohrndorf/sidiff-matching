package org.sidiff.tools.configmerger;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.BundleContext;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.xml.XMLDOMCreator;
import org.sidiff.common.xml.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MergeTool implements IApplication {

	private static final String COMPARE_CONFIG_NAME = ".compareconfig";
	private static final String MATCHING_CONFIG_NAME = ".matchingconfig";
	private static final String XML = ".xml";
	
	private static final String TAG_COMPARISON = "Comparison";
	private static final String TAG_SETTINGS = "Settings";
	private static final String TAG_CONFIGURATIONS = "Configurations";
	private static final String TAG_MATCHING = "Matching";
	private static final String TAG_SEQUENCE = "Sequence";
	
	private static final String TAG_CLASS = "Class";
	private static final String ATTR_NAME = "name";
	
	private static final String TAG_MATCHINGCONF = "MatchingConfiguration";
	private static final String ATTR_CLASSNAME = "className";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		assert (args.length>=2):"2+ args expected: name of the domainbundle and the sub types (e.g. org.sidiff.uml.core activities classes";
		String domainBundle = args[0];
		LogUtil.log(LogEvent.MESSAGE, "Merging configs of domain bundle: "+domainBundle);
		ArrayList<String> subTypes = new ArrayList<String>();
		for (int i=1;i<args.length;i++)
			subTypes.add(args[i]);

		File tgtCompareFile = new File(domainBundle+COMPARE_CONFIG_NAME+XML); 
		File tgtMatchingFile = new File(domainBundle+MATCHING_CONFIG_NAME+XML); 
		
		if (tgtCompareFile.exists())
			tgtCompareFile.delete();
		if (tgtMatchingFile.exists())
			tgtMatchingFile.delete();
		
		Document tgtCompareConfig = XMLDOMCreator.createDocument();
		Document tgtMatchingConfig = XMLDOMCreator.createDocument();
			
		for (String subType : subTypes) {
			LogUtil.log(LogEvent.MESSAGE, "Processing subtype: "+subType);
			
			File srcCompareFile = new File(domainBundle+COMPARE_CONFIG_NAME+"."+subType+XML);
			File srcMatchingFile = new File(domainBundle+MATCHING_CONFIG_NAME+"."+subType+XML);
			
			assert (srcCompareFile.exists()) : "no compareconfig for "+domainBundle+"\nnaming schema: basename.subtype.xml, e.g. org.sidiff.uml.core.compareconfig.activities.xml";
			assert (srcMatchingFile.exists()) : "no matchingconfig for "+domainBundle+"\nnaming schema: basename.subtype.xml, e.g. org.sidiff.uml.core.matchingconfig.activities.xml";
			
			Document srcCompareConfig = XMLParser.parseStream(IOUtil.getInputStreamFromFile(srcCompareFile.getAbsolutePath()));
			Document srcMatchingConfig = XMLParser.parseStream(IOUtil.getInputStreamFromFile(srcMatchingFile.getAbsolutePath()));
			
			mergeCompare(tgtCompareConfig, srcCompareConfig);
			mergeMatching(tgtMatchingConfig, srcMatchingConfig, subType);
		}
		
		XMLDOMCreator.writeDocument(IOUtil.getOutputStreamIntoFile(tgtCompareFile.getAbsolutePath()), tgtCompareConfig);
		XMLDOMCreator.writeDocument(IOUtil.getOutputStreamIntoFile(tgtMatchingFile.getAbsolutePath()), tgtMatchingConfig);
		
		LogUtil.log(LogEvent.MESSAGE, "Done!");
	}

	private static void mergeCompare(Document tgtCompareConfig,	Document srcCompareConfig) {
		LogUtil.log(LogEvent.MESSAGE, "Merging compare config...");
		NodeList tmp, tmp2;
		
		//Comparison Knoten anlegen
		tmp = tgtCompareConfig.getChildNodes();
		Element tgtComparision = null;
		if (tmp.getLength()==0) {
			tgtComparision = tgtCompareConfig.createElement(TAG_COMPARISON);
			tgtCompareConfig.appendChild(tgtComparision);
		}
		else tgtComparision = (Element)tmp.item(0);

		//Settings Knoten anlegen
		tmp = tgtComparision.getElementsByTagName(TAG_SETTINGS);
		tmp2 = srcCompareConfig.getElementsByTagName(TAG_SETTINGS);
		assert(tmp2.getLength()==1):"no src settings";
		Element srcSettings = (Element)tmp2.item(0);
		Element tgtSettings = null;
		if (tmp.getLength()==0) {
			tgtSettings = (Element)tgtCompareConfig.importNode(srcSettings, true);
			//tgtSettings = (Element)srcSettings.cloneNode(false);
			tgtComparision.appendChild(tgtSettings);
		} else tgtSettings = (Element)tmp.item(0);
		assert(tgtSettings.isEqualNode(srcSettings)):"different settings";
		
		//Configurations Knoten anlegen
		tmp = tgtComparision.getElementsByTagName(TAG_CONFIGURATIONS);
		tmp2 = srcCompareConfig.getElementsByTagName(TAG_CONFIGURATIONS);
		assert(tmp2.getLength()==1):"no src configurations";
		Element srcConfigurations = null;
		Element tgtConfigurations = null;
		if (tmp.getLength()==0) {
			tgtConfigurations = tgtCompareConfig.createElement(TAG_CONFIGURATIONS);
			tgtComparision.appendChild(tgtConfigurations);
		}
		else tgtConfigurations = (Element)tmp.item(0);
		
		//Configs kopieren
		tmp = srcCompareConfig.getElementsByTagName(TAG_CLASS);
		for (int i=0; i<tmp.getLength(); i++) {
			Element srcClass = (Element)tmp.item(i);
			String name = srcClass.getAttribute(ATTR_NAME);
			tmp2 = XMLParser.processXPath(tgtCompareConfig, "//"+TAG_CLASS+"[@name='"+name+"']");
			if (tmp2!=null && tmp2.getLength()>0) {
				assert(srcClass.isEqualNode(tmp2.item(0))) : "class "+name+" differs";
			} else {
				Element tgtClass = (Element)tgtCompareConfig.importNode(srcClass, true);
				tgtConfigurations.appendChild(tgtClass);
			}
		}
		
	}

	private static void mergeMatching(Document tgtMatchingConfig, Document srcMatchingConfig, String subtype) {
		LogUtil.log(LogEvent.MESSAGE, "Merging matching config...");
		NodeList tmp, tmp2;
		
		//Comparison Knoten anlegen
		tmp = tgtMatchingConfig.getChildNodes();
		Element tgtMatching = null;
		if (tmp.getLength()==0) {
			tgtMatching = tgtMatchingConfig.createElement(TAG_MATCHING);
			tgtMatchingConfig.appendChild(tgtMatching);
		}
		else tgtMatching = (Element)tmp.item(0);

		//Settings Knoten anlegen
		tmp = tgtMatching.getElementsByTagName(TAG_SETTINGS);
		tmp2 = srcMatchingConfig.getElementsByTagName(TAG_SETTINGS);
		assert(tmp2.getLength()==1):"no src settings";
		
		Element srcSettings = (Element)tmp2.item(0);
		Element tgtSettings = null;
		if (tmp.getLength()==0) {
			tgtSettings = (Element)tgtMatchingConfig.importNode(srcSettings, true);
			//tgtSettings = (Element)srcSettings.cloneNode(false);
			tgtMatching.appendChild(tgtSettings);
		} else tgtSettings = (Element)tmp.item(0);
		assert(tgtSettings.isEqualNode(srcSettings)):"different settings";
		
		//Configurations Knoten anlegen
		tmp = tgtMatching.getElementsByTagName(TAG_CONFIGURATIONS);
		tmp2 = srcMatchingConfig.getElementsByTagName(TAG_CONFIGURATIONS);
		assert(tmp2.getLength()==1):"no src configurations";
		Element srcConfigurations = null;
		Element tgtConfigurations = null;
		if (tmp.getLength()==0) {
			tgtConfigurations = tgtMatchingConfig.createElement(TAG_CONFIGURATIONS);
			tgtMatching.appendChild(tgtConfigurations);
		}
		else tgtConfigurations = (Element)tmp.item(0);
		
		//Configs kopieren
		tmp = srcMatchingConfig.getElementsByTagName(TAG_MATCHINGCONF);
		for (int i=0; i<tmp.getLength(); i++) {
			Element srcMConf = (Element)tmp.item(i);
			String name = srcMConf.getAttribute(ATTR_CLASSNAME);
			tmp2 = XMLParser.processXPath(tgtMatchingConfig, "//"+TAG_MATCHINGCONF+"[@className='"+name+"']");
			if (tmp2!=null && tmp2.getLength()>0) {
				assert(srcMConf.isEqualNode(tmp2.item(0))) : "class "+name+" differs";
			} else {
				Element tgtClass = (Element)tgtMatchingConfig.importNode(srcMConf, true);
				tgtConfigurations.appendChild(tgtClass);
			}
		}
		
		//Sequences kopieren
		tmp = tgtMatching.getElementsByTagName(TAG_SEQUENCE);
		tmp2 = XMLParser.processXPath(srcMatchingConfig, "/"+TAG_MATCHING+"/"+TAG_SEQUENCE);
		assert(tmp2.getLength()==1):"no src sequences";
		Element srcSequence = null;
		Element tgtSequence = null;
		if (tmp.getLength()==0) {
			tgtSequence = tgtMatchingConfig.createElement(TAG_SEQUENCE);
			tgtMatching.appendChild(tgtSequence);
		} else tgtSequence = (Element)tmp.item(0);
		
		tgtSequence.appendChild(tgtMatchingConfig.createComment("Sequence of "+subtype));
		Element tgtSeq = (Element)tgtMatchingConfig.importNode(tmp2.item(0), true);
		tgtSequence.appendChild(tgtSeq);
	}


	public static void start(BundleContext context){}
	public void stop(BundleContext context){}
	
	@Override
	public Object start(IApplicationContext context) throws Exception {
		main((String[])context.getArguments().get(IApplicationContext.APPLICATION_ARGS));
		return IApplication.EXIT_OK;
	}
	@Override
	public void stop() {}

}
