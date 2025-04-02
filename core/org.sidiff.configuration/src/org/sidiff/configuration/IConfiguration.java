package org.sidiff.configuration;

public interface IConfiguration {

	String PLUGIN_ID = "org.sidiff.configuration";

	String FOLDER_CONFIGS ="configs";
	String FOLDER_DEFINITIONS ="definitions";
	String FOLDER_MAPPINGS ="mappings";

	String CONFIG_TYPE_ANNOTATION = "annotation";
	String CONFIG_TYPE_COMPARE = "compare";
	String CONFIG_TYPE_ERGENERATION = "ergeneration";
	String CONFIG_TYPE_MATCHING = "matching";
	String CONFIG_TYPE_PROFILE = "profile";
}
