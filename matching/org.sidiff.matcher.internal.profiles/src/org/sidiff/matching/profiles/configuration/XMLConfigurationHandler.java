package org.sidiff.matching.profiles.configuration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.sidiff.common.emf.access.EMFMetaAccess;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLConfigurationHandler {

	// Constants - Tags and Attributes

	private static final String ELEM_SETTINGS = "Settings";
	private static final String ATT_SETTINGS_BASEPACKAGE = "basePackage";

	private static final String ELEM_PROFILES = "Profile";
	private static final String ATT_PROFILE_NAME = "name";
	private static final String ATT_PROFILE_STEREOPACKAGE = "stereoPackage";

	private static final String ELEM_STEREOTYPES = "StereoType";
	private static final String ATT_STEREOTYPES_NAME = "name";

	// The global profile configuration element
	ProfileConfiguration configuration = new ProfileConfiguration();

	// The profiles
	List<Profile> profiles = new ArrayList<Profile>();

	// The temporal variable
	private String basePackage = null;

	/**
	 * Parse the XML file to the global {@link Profile}.
	 * 
	 * @param Document
	 *            XML configuration document
	 * @return The new global profile configuration element.
	 */
	public ProfileConfiguration parseProfileConfiguration(Document xmlConfig) {

		parseSettings(xmlConfig.getElementsByTagName(ELEM_SETTINGS).item(0));
		parseProfiles(xmlConfig.getElementsByTagName(ELEM_PROFILES));

		writeProfileConfiguration();

		return configuration;
	}

	/**
	 * Process the settings.
	 * 
	 * @param settings
	 *            The settings node.
	 */
	private void parseSettings(Node settings) {

		NamedNodeMap attributes = settings.getAttributes();
		basePackage = this.getValue(attributes, ATT_SETTINGS_BASEPACKAGE);
	}

	/**
	 * Process the defined profiles.
	 * 
	 * @param profileNodes
	 *            The profiles nodes.
	 */
	private void parseProfiles(NodeList profileNodes) {

		for (int i = 0; i < profileNodes.getLength(); i++) {

			Node profileNode = profileNodes.item(i);
			NamedNodeMap attributes = profileNode.getAttributes();
			String profileName = getValue(attributes, ATT_PROFILE_NAME);
			String stereoPackage = getValue(attributes,
					ATT_PROFILE_STEREOPACKAGE);

			Element profileElement = (Element) profileNode;
			List<String> stereoTypes = parseStereoTypes(profileElement
					.getElementsByTagName(ELEM_STEREOTYPES));

			createProfile(profileName, stereoPackage, stereoTypes);

			profileName = null;
			stereoPackage = null;
			stereoTypes.clear();

		}

	}

	/**
	 * Process the used stereotypes. If none are given in configuration, all
	 * will be processed
	 * 
	 * @param stereoTypeNodes
	 *            The stereotypes node list.
	 * 
	 * @return stereoTypes The stereotypes list
	 * 
	 */
	private List<String> parseStereoTypes(NodeList stereoTypeNodes) {

		List<String> stereoTypes = new ArrayList<String>();

		for (int i = 0; i < stereoTypeNodes.getLength(); i++) {

			Node stereoTypeNode = stereoTypeNodes.item(i);
			NamedNodeMap attributes = stereoTypeNode.getAttributes();

			String stereoType = String.valueOf(this.getValue(attributes,
					ATT_STEREOTYPES_NAME));

			stereoTypes.add(stereoType);

		}

		return stereoTypes;

	}

	/**
	 * Create an profile according to given parameters All elements are casted
	 * accordingly
	 * 
	 * @param profileName
	 *            The name of the profile
	 * @param stereoPackage
	 *            The stereoPackage of the profile
	 * @param stereoTypes
	 *            The list of stereotypes
	 */
	private void createProfile(String profileName, String stereoPackage,
			List<String> stereoTypes) {

		// Create new profile
		Profile profile = new Profile();

		// Set ProfileName
		profile.setProfileName(profileName);

		profile.setStereoPackage(EPackage.Registry.INSTANCE
				.getEPackage(stereoPackage));

		// Get all stereoTypes of current profile
		EList<EClassifier> allStereoTypes = EMFMetaAccess
				.getAllMetaClassesForPackage(stereoPackage);

		// Iterate over all stereoTypes
		for (EClassifier classifier : allStereoTypes) {

			if (classifier instanceof EClass) {
				// Get stereoType Class
				EClass stereoType = (EClass) classifier;

				// Test if stereotype is contained in configuration
				// or no stereotype is configured at all, then all will be used
				if (stereoTypes.size() == 0
						|| (stereoTypes.indexOf(stereoType.getName()) != -1 && stereoType
								.equals((EClass) EMFMetaAccess.getMetaObjectByNameRecursively(profile
										.getStereoPackage().getNsURI(), stereoTypes
										.get(stereoTypes.indexOf(stereoType
												.getName())))))) {
					// Get all baseReferences of stereoType
					List<EStructuralFeature> allBaseReferences = EMFMetaAccess
							.getEStructuralFeaturesByRegEx(stereoType,
									"^(base)_\\w+", true);
					for (EStructuralFeature baseReference : allBaseReferences) {

						// Add stereoType and its corresponding baseType and
						// baseReference
						profile.addStereoType(stereoType);
						profile.addBaseReference((EReference) baseReference);
						profile.addBaseType((EClass) baseReference.getEType());

					}
				}
			}
		}

		this.profiles.add(profile);

	}

	/**
	 * Write all temporal variables to the global profile configuration element
	 */
	private void writeProfileConfiguration() {

		// Register used base package
		configuration.setBasePackage(EPackage.Registry.INSTANCE
				.getEPackage(this.basePackage));

		// Add all defined profiles to configuration
		configuration.setProfiles(this.profiles);

	}

	/**
	 * Get a specific attribute value from attribute map.
	 * 
	 * @param attributes
	 *            The attribute map.
	 * @param attributeName
	 *            The attribute's name whose value to get.
	 * @return If attribute exists the attribute's value, otherwise
	 *         <code>null</code>.
	 */
	private String getValue(NamedNodeMap attributes, String attributeName) {

		Node node = attributes.getNamedItem(attributeName);
		return (node != null) ? node.getNodeValue() : null;
	}

}
