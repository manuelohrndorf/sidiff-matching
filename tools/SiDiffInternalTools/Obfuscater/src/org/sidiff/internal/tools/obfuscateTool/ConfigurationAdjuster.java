package org.sidiff.internal.tools.obfuscateTool;


import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.sidiff.common.io.IOUtil;
import org.sidiff.common.xml.XMLParser;
import org.sidiff.common.xml.XMLResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ConfigurationAdjuster {

	static final String COMPARE_ELEMENT_COMPAREFUNCTION = "CompareFunction";
	static final String COMPARE_ELEMENT_IF = "If";
	static final String COMPARE_ATTRIBUTE_CONDITION = "condition";
	static final String COMPARE_ATTRIBUTE_CLASS = "class";
	static final String COMPARE_ATTRIBUTE_PARAMETER = "parameter";
	static final String COMPAREFUNCTION_PREFIX = "org.sidiff.core.compare.comparefunctions.";
	static final String COMPARATOR_PREFIX = "org.sidiff.core.compare.comparefunctions.comparators.";
	static final String CONDITION_PREFIX = "rg.sidiff.core.compare.comparefunctions.conditions.";
	
	static final String MATCHING_ELEMENT_SETTINGS = "Settings";
	static final String MATCHING_ELEMENT_MATCHINGCONFIGURATION = "MatchingConfiguration";
	static final String MATCHING_ATTRIBUTE_TOPDOWNMATCHER = "topDownMatcher";
	static final String MATCHING_ATTRIBUTE_FIRSTPASSSEQUENCEMATCHER = "firstPassSequencedMatcher";
	static final String MATCHING_ATTRIBUTE_DEFAULTSEQUENCEMATCHER = "defaultSequencedMatcher";
	static final String MATCHING_ATTRIBUTE_DEFAULTTOPDOWNMATCHER = "defaultTopDownMatcher";
	static final String MATCHER_PREFIX = "org.sidiff.core.matching.matcher.";
	
	static final String UMLANNOTATIONS_ELEMENT_SYNTHETICATTRIBUTE = "SyntheticAttribute";
	static final String UMLANNOTATIONS_ATTRIBUTE_OPERATION = "operation";
	static final String ANNOTATOR_PREFIX = "org.sidiff.core.annotators.";

	public static void main(String[] args) {

		List<String> arguments =  Arrays.asList(args);
		
		for (String argument : arguments) {
				
			if (argument.contains("-UMLCompareConfiguration")) {
				
				adjustCompareConfiguration(argument.split(":")[1]);
				System.out.println("Adjust CompareConfiguration done");
			}
			if (argument.contains("-UMLMatchingConfiguration")) {
				adjustMatchingConfiguration(argument.split(":")[1]);
				System.out.println("Adjust MatchingConfiguration done");
			}
			if (argument.contains("-UMLAnnotations")) {
				adjustUMLAnnotations(argument.split(":")[1]);
				System.out.println("Adjust UMLAnnotations done");
			}
		}
	}

	private static void adjustCompareConfiguration(String filename) {

		InputStream input = IOUtil.getInputStream(filename);
		Document doc = XMLParser.parseStream(input);
		NodeList compareFunctions = doc.getElementsByTagName(COMPARE_ELEMENT_COMPAREFUNCTION);
		for (int i = 0; i < compareFunctions.getLength(); i++) {
			Node actualcompareFunction = compareFunctions.item(i);
			
			// Adjust class value#########################################################################
			Node clazz = actualcompareFunction.getAttributes().getNamedItem(COMPARE_ATTRIBUTE_CLASS);
			String oldName = clazz.getNodeValue();
			String obfuscatedName = MappingTool.getNewClassName(COMPAREFUNCTION_PREFIX + oldName);
			clazz.setNodeValue(obfuscatedName);
			// ###########################################################################################
			
			
			// Adjust parameter value#####################################################################
			Node parameter = actualcompareFunction.getAttributes().getNamedItem(COMPARE_ATTRIBUTE_PARAMETER);
			if (parameter != null) {
				String[] splittedParameter = parameter.getNodeValue().split(";");
				// Only the part in front of the first ";" has to be adjusted
				String firstPart = splittedParameter[0];
				String[] splittedFirstPart = firstPart.split("\\[");
				for (int j = 0; j < splittedFirstPart.length; j++) {
					obfuscatedName = MappingTool.getNewClassName(COMPARATOR_PREFIX + splittedFirstPart[j]);	
					if (obfuscatedName != null) {
						splittedFirstPart[j] = obfuscatedName;
					}	
				}
				// Assign the obfuscated values to splittedParameter and add the split expression ("[")
				splittedParameter[0] = "";
				for (int j = 0; j < splittedFirstPart.length; j++) {	
					splittedParameter[0] += splittedFirstPart[j];
					if (j != splittedFirstPart.length -1) {
						splittedParameter[0] += "[";
					}
				}
				// Assign the obfuscated splittedParameter to obfuscatedParameter and add the split expression (";")
				String obfuscatedParameter = "";
				for (int j = 0; j < splittedParameter.length; j++) {		
					obfuscatedParameter += splittedParameter[j];
					if (j != splittedParameter.length -1) {
						obfuscatedParameter += ";";
					}
				}	
				parameter.setNodeValue(obfuscatedParameter);
			}	
			// ###########################################################################################
		}
		
		// Adjust condition value#########################################################################
		NodeList ifConditions = doc.getElementsByTagName(COMPARE_ELEMENT_IF);
		for (int i = 0; i < ifConditions.getLength(); i++) {
			Node actualIfCondition = ifConditions.item(i);
			Node condition = actualIfCondition.getAttributes().getNamedItem(COMPARE_ATTRIBUTE_CONDITION);
			String oldName = condition.getNodeValue();
			String obfuscatedName = MappingTool.getNewClassName(CONDITION_PREFIX + oldName);
			condition.setNodeValue(obfuscatedName);
		}
		// ###########################################################################################
		
		MappingTool.writeFile(doc, filename);		
	}
	
	private static void adjustMatchingConfiguration(String filename) {
				
		InputStream input = IOUtil.getInputStream(filename);
		Document doc = XMLParser.parseStream(input);
		
		// Adjust settings ##############################################################################################
		NodeList settings = doc.getElementsByTagName(MATCHING_ELEMENT_SETTINGS);
		// first setting (only one is allowed)
		Node setting = settings.item(0);
		
		// Adjust firstPassSequencedMatcher
		Node firstPassSequencedMatcher = setting.getAttributes().getNamedItem(MATCHING_ATTRIBUTE_FIRSTPASSSEQUENCEMATCHER);
		String oldName = firstPassSequencedMatcher.getNodeValue();
		String obfuscatedName = MappingTool.getNewClassName(MATCHER_PREFIX + oldName);
		firstPassSequencedMatcher.setNodeValue(obfuscatedName);
		
		// Adjust defaultSequencedMatcher
		Node defaultSequencedMatcher = setting.getAttributes().getNamedItem(MATCHING_ATTRIBUTE_DEFAULTSEQUENCEMATCHER);
		oldName = defaultSequencedMatcher.getNodeValue();
		obfuscatedName = MappingTool.getNewClassName(MATCHER_PREFIX + oldName);
		defaultSequencedMatcher.setNodeValue(obfuscatedName);
		
		// Adjust defaultTopDownMatcher
		Node defaultTopDownMatcher = setting.getAttributes().getNamedItem(MATCHING_ATTRIBUTE_DEFAULTTOPDOWNMATCHER);
		oldName = defaultTopDownMatcher.getNodeValue();
		obfuscatedName = MappingTool.getNewClassName(MATCHER_PREFIX + oldName);
		defaultTopDownMatcher.setNodeValue(obfuscatedName);
		// ##############################################################################################################
		
		// Adjust matchingConfiguration #################################################################################
		NodeList matchingConfiguration = doc.getElementsByTagName(MATCHING_ELEMENT_MATCHINGCONFIGURATION);
		for (int i = 0; i < matchingConfiguration.getLength(); i++) {
			Node topDownMatcher = matchingConfiguration.item(i).getAttributes().getNamedItem(MATCHING_ATTRIBUTE_TOPDOWNMATCHER);
			oldName = topDownMatcher.getNodeValue();
			obfuscatedName = MappingTool.getNewClassName(MATCHER_PREFIX + oldName);
			topDownMatcher.setNodeValue(obfuscatedName);
		}
		// ##############################################################################################################
		MappingTool.writeFile(doc, filename);
	}

	private static void adjustUMLAnnotations(String filename) {
		
		XMLResolver.getInstance().includeMapping(IOUtil.readFromStream(IOUtil.getInputStream("../../org.sidiff.core.annotation.default/resource/org.sidiff.core.annotation.default.dtdmap.xml")));
		
		InputStream input = IOUtil.getInputStream(filename);
		Document doc = XMLParser.parseStream(input);
		
		// Adjust syntheticAttribute #######################################################################
		NodeList syntheticAttributes = doc.getElementsByTagName(UMLANNOTATIONS_ELEMENT_SYNTHETICATTRIBUTE);
		for (int i = 0; i < syntheticAttributes.getLength(); i++) {
			
			//Adjust operation
			Node operation = syntheticAttributes.item(i).getAttributes().getNamedItem(UMLANNOTATIONS_ATTRIBUTE_OPERATION);
			String oldName = operation.getNodeValue();
			String obfuscatedName = MappingTool.getNewClassName(ANNOTATOR_PREFIX + oldName);
			operation.setNodeValue(obfuscatedName);
		}
		// #################################################################################################
		MappingTool.writeFile(doc, filename);
	}
}