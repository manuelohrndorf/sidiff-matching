package org.sidiff.matching.profiles;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.io.ResourceUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.util.StringUtil;
import org.sidiff.configuration.IConfigurationCapable;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.BaseMatcher;
import org.sidiff.matching.profiles.configuration.Profile;
import org.sidiff.matching.profiles.configuration.ProfileConfiguration;
import org.sidiff.matching.profiles.configuration.XMLConfigurationHandler;
import org.w3c.dom.Document;


public class ProfilesMatching extends BaseMatcher implements IConfigurationCapable{


	/**
	 *  Each {@link Profile} is defined through this configuration
	 */
	private ProfileConfiguration profileConfiguration = null;
	private Document config = null;
	
	public static final String CFG_TYPE = "profile";
	
	// Used resources
	private Resource resourceA = null;
	private Resource resourceB = null;

	// Shortcut to needed Services (valid after initialization)
	private ICorrespondences correspondencesService = null;


	@Override
	public void match() {
		
		assert(getModels().size()==2) : "The matcher only supports pairwise matching.";
		resourceA = getModels().toArray(new Resource[]{})[0];
		resourceB = getModels().toArray(new Resource[]{})[1];
		assert(resourceA != null && resourceB != null) : "Missing Model! (invalid initializion)";

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
			Map<EObject, EObject> profileMapA = new HashMap<EObject, EObject>();
			Map<EObject, EObject> profileMapB = new HashMap<EObject, EObject>();

			/*
			 * 
			 * Build maps between baseTypes and stereotypes for both resources
			 * Should be faster in long term runs if this map is used instead of
			 * iterating over all objects again Map is constructed like :
			 * StereoType -> BaseType
			 */

			Iterator<EObject> itA = this.resourceA.getAllContents();
			while (itA.hasNext()) {

				// Iterate through all elements of resource
				EObject obj = itA.next();

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
			}

			Iterator<EObject> itB = this.resourceB.getAllContents();
			while (itB.hasNext()) {

				// Iterate through all elements of resource
				EObject obj = itB.next();

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
			}

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
				if (correspondencesService.hasCorrespondences(baseTypeA)) {

					// Get corresponding element
					EObject baseTypeB = correspondencesService.getCorrespondences(baseTypeA).iterator().next();

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
							if (!correspondencesService.hasCorrespondences(stereoTypeA)
									&& !correspondencesService.hasCorrespondences(stereoTypeB)
									&& (stereoTypeA.eClass().equals(stereoTypeB.eClass()))) {
								// Add correspondence between stereotypes
								correspondencesService.addCorrespondence(stereoTypeA, stereoTypeB);
								// Sending match event

								// TODO VDUECK FireEvent
								// this.serviceContext.fireEvent(new
								// MatchingEvent(this,MatchingEvent.MATCH_CREATED_EVENT,stereoTypeA,stereoTypeB));

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
	public String getDescription() {
		return "Matching Service for profile models";
	}

	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		docTypes.add(UMLPackage.eNS_URI);
		return docTypes;
	}

	@Override
	public String getName() {
		return "UML Profiles Matcher";
	}



	@Override
	public void configure(Document configuration) {
		ResourceUtil.registerClassLoader(this.getClass().getClassLoader());
		XMLConfigurationHandler confighandler = new XMLConfigurationHandler();
		profileConfiguration = confighandler.parseProfileConfiguration(configuration);

		if (profileConfiguration == null) {
			throw new IllegalArgumentException(
					"Invalid configuration Data " + StringUtil.resolve(configuration));
		}
		
	}



	@Override
	public void configure() {
		if(this.config != null){
			 this.configure(this.config);
		}
	}



	@Override
	public String getSubfolderName() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Document getConfiguration() {
		return config;
	}



	@Override
	public void setConfiguration(Document configuration) {
		this.config = configuration;
		this.configure();
	}
	
	
}
