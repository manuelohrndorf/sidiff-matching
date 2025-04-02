package org.sidiff.configuration;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.sidiff.common.collections.ValueMap;
import org.w3c.dom.Document;

public class ConfigurationManagement {
	
	private ValueMap<String,Document> availableConfigurations = new ValueMap<>();
	
	private String docType;

	public ConfigurationManagement(String docType) {
		this.docType = docType;
	}
	
	public static ConfigurationManagement getInstance(String docType){
		return new ConfigurationManagement(docType);
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
	
	private void loadConfigs(String type) throws IOException {
		Set<Document> docs = ConfigurationLoader.loadAvailableConfigs(docType, type);
		for(Document doc : docs){
			availableConfigurations.put(doc, type);
		}
	}

	public Document getRandomConfiguration(String type) throws IOException{	
		if(!availableConfigurations.containsValue(type)){
			loadConfigs(type);
		}
		return availableConfigurations.getObjects(type).stream().findFirst().orElse(null);
	}
	
}
