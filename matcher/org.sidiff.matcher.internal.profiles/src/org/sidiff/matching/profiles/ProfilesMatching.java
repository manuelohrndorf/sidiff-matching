package org.sidiff.matching.profiles;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.extension.configuration.BasicExtensionConfiguration;
import org.sidiff.common.extension.configuration.ConfigurationOption;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.common.io.ResourceUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.configuration.ConfigurationManagement;
import org.sidiff.configuration.IConfiguration;
import org.sidiff.matcher.BaseMatcher;
import org.sidiff.matching.profiles.configuration.Profile;
import org.sidiff.matching.profiles.configuration.ProfileConfiguration;
import org.sidiff.matching.profiles.configuration.XMLConfigurationHandler;
import org.w3c.dom.Document;


public class ProfilesMatching extends BaseMatcher {

	/**
	 *  Each {@link Profile} is defined through this configuration
	 */
	private ProfileConfiguration profileConfiguration;

	private ConfigurationOption<Document> profileConfigDocument;
	private IExtensionConfiguration configuration;

	public ProfilesMatching() {
		profileConfigDocument = ConfigurationOption.builder(Document.class).key("configDocument").build();
		configuration = new BasicExtensionConfiguration(Collections.singleton(profileConfigDocument)); 
	}
	
	@Override
	protected void init(Collection<Resource> models, Scope scope) {
		super.init(models, scope);
		if(!profileConfigDocument.isSet()) {
			try {
				profileConfigDocument.setValue(ConfigurationManagement.getInstance(UMLPackage.eNS_URI)
						.getRandomConfiguration(IConfiguration.CONFIG_TYPE_PROFILE));
			} catch (IOException e) {
				// profileConfigDocument remains unset
				LogUtil.log(LogEvent.ERROR, "Could not load default profile configuration", e);
			}
		}
		if(profileConfigDocument.isSet()) {
			configure(profileConfigDocument.getValue());
		}
		if(profileConfiguration == null) {
			throw new RuntimeException("No profile matching configuration is available");
		}
	}

	@Override
	public void match() {
		Assert.isLegal(getModels().size() == 2, "This matcher only supports pairwise matching.");
		Resource resourceA = getModels().get(0);
		Resource resourceB = getModels().get(1);

		LogUtil.log(LogEvent.NOTICE, "Matching  all defined profiles...");

		// Iterating over all defined profiles
		for (Profile profile : this.profileConfiguration.getProfiles()) {

			LogUtil.log(LogEvent.NOTICE, "Matching profile [" + profile.getProfileName() + "]...");

			LogUtil.log(LogEvent.NOTICE, "Trying to match following stereotypes: ");
			String stereoTypeNames = "";
			for (EClass stereoType : profile.getStereoTypes()) {
				stereoTypeNames += stereoType.getName() + "  ";
			}
			LogUtil.log(LogEvent.NOTICE, stereoTypeNames);

			// Create maps for used profile elements
			Map<EObject, EObject> profileMapA = new HashMap<>();
			Map<EObject, EObject> profileMapB = new HashMap<>();

			/*
			 * 
			 * Build maps between baseTypes and stereotypes for both resources
			 * Should be faster in long term runs if this map is used instead of
			 * iterating over all objects again Map is constructed like :
			 * StereoType -> BaseType
			 */

			resourceA.getAllContents().forEachRemaining(obj -> {
				for (int i = 0; i < profile.getStereoTypes().size(); i++) {

					// Get stereoType
					EClass stereoType = profile.getStereoTypes().get(i);

					// If current element is a stereotype
					if (obj.eClass().equals(stereoType)) {

						// Get Reference to baseType
						EReference baseRef = profile.getBaseReferences().get(i);
						// Call Reference for the object itself
						EObject baseType = (EObject) obj.eGet(baseRef);

						// Add StereoType and corresponding BaseType to Map
						profileMapA.put(obj, baseType);
					}
				}
			});

			resourceB.getAllContents().forEachRemaining(obj -> {
				for (int i = 0; i < profile.getStereoTypes().size(); i++) {

					// Get stereoType
					EClass stereoType = profile.getStereoTypes().get(i);

					// If current element is a stereotype
					if (obj.eClass().equals(stereoType)) {

						// Get Reference to baseType
						EReference baseRef = profile.getBaseReferences().get(i);

						// Call Reference for the object itself
						EObject baseType = (EObject) obj.eGet(baseRef);

						// Add StereoType and corresponding BaseType to Map
						profileMapB.put(obj, baseType);
					}
				}
			});

			/*
			 * Create correspondences / matchings between stereotype elements
			 * The created correspondences are based on the correspondences
			 * between the corresponding basetype elements
			 */

			// Counting new correspondences
			int ctr = 0;

			// Iterate over all stereotypes of ResourceA
			for (EObject stereoType : profileMapA.keySet()) {

				// Get stereotype and corresponding basetype
				EObject stereoTypeA = stereoType;
				EObject baseTypeA = profileMapA.get(stereoType);

				// If basetype has correspondence to another element
				if (getCorrespondencesService().hasCorrespondences(baseTypeA)) {

					// Get corresponding element
					EObject baseTypeB = getCorrespondencesService().getCorrespondences(baseTypeA).iterator().next();

					// Iterate over all stereotypes of ResourceB
					for (EObject key : profileMapB.keySet()) {

						// The current corresponding element is contained as
						// value in the map of ResourceB
						if (profileMapB.get(key).equals(baseTypeB)) {

							// Get stereotype
							EObject stereoTypeB = key;

							// If stereotype of ResourceA and ResourceB
							// do not already own a correspondence
							// and stereoTypeA and stereoTypeB are of the same
							// type
							if (!getCorrespondencesService().hasCorrespondences(stereoTypeA)
									&& !getCorrespondencesService().hasCorrespondences(stereoTypeB)
									&& (stereoTypeA.eClass().equals(stereoTypeB.eClass()))) {
								// Add correspondence between stereotypes
								getCorrespondencesService().addCorrespondence(stereoTypeA, stereoTypeB);

								LogUtil.log(LogEvent.DEBUG,
										"Matched: " + stereoTypeA.getClass().getSimpleName().replace("Impl", "") + "("
												+ EMFUtil.getEObjectID(stereoTypeA) + ")" + " <-> "
												+ stereoTypeB.getClass().getSimpleName().replace("Impl", "") + "("
												+ EMFUtil.getEObjectID(stereoTypeB) + ")");
								ctr++;
							}
						}
					}
				}
			}
			LogUtil.log(LogEvent.NOTICE, "Profile Matching for [" + profile.getProfileName() + "] done!"
					+ System.lineSeparator() + "Matched " + ctr + " stereotypes additionally.");
		}
		LogUtil.log(LogEvent.NOTICE, "Profile Matching done!");
	}
	

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Matching Service for UML profile models");
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(UMLPackage.eNS_URI);
	}

	@Override
	public String getName() {
		return "UML Profiles Matcher";
	}

	protected void configure(Document configuration) {
		try {
			ResourceUtil.registerClassLoader(getClass().getClassLoader());
			XMLConfigurationHandler confighandler = new XMLConfigurationHandler();
			profileConfiguration = confighandler.parseProfileConfiguration(configuration);			
		} finally {
			ResourceUtil.unregisterClassLoader(getClass().getClassLoader());			
		}

		if (profileConfiguration == null) {
			throw new IllegalArgumentException(
					"Invalid configuration Data " + StringUtil.resolve(configuration));
		}		
	}

	@Override
	public IExtensionConfiguration getConfiguration() {
		return configuration;
	}
}
