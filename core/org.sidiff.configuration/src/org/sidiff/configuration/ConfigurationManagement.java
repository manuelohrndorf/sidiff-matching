package org.sidiff.configuration;

import java.util.HashSet;
import java.util.Set;

import org.sidiff.common.collections.ValueMap;
import org.w3c.dom.Document;

public class ConfigurationManagement {
	
	private ValueMap<String,Document> availableConfigurations = new 
			ValueMap<String, Document>();
	private static String docT;
	
	private static ConfigurationManagement instance;
	
	public ConfigurationManagement(String docType) {
		docT = docType;
	}
	
	public static ConfigurationManagement getInstance(String docType){
		if(instance == null || !docType.equals(docT))
			instance = new ConfigurationManagement(docType);
		return instance;
	}
	
	public ValueMap<String, Document> getAvailableConfigurations(){
		return this.availableConfigurations;
	}
	
	public Set<Document> getAvailableConfigurations(String type){
		Set<Document> docs = new HashSet<Document>();
		if(availableConfigurations.containsValue(type)){
			for(Document doc : this.availableConfigurations.getObjects(type)){
				docs.add(doc);
			}
		}
		return docs;
	}
	
	private void loadConfigs(String type){
		Set<Document> docs = ConfigurationLoader.loadAvailableConfigs(docT, type);
		for(Document doc : docs){
			availableConfigurations.put(doc, type);
		}
	}
	public Document getRandomConfiguration(String type){	
		if(!availableConfigurations.containsValue(type)){
			loadConfigs(type);
		}
		if(availableConfigurations.getObjects(type).size() > 0)
			return availableConfigurations.getObjects(type).iterator().next();
		else
			return null;
	}
	
}
