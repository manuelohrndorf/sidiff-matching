package org.sidiff.matching.profiles.configuration;


import java.util.List;

import org.eclipse.emf.ecore.EPackage;

/**
 * Holds the configuration of the profiles matching service.
 * Contains all defined profiles
 * 
 * @author dreuling
 */
public class ProfileConfiguration {
	
	/**
	 * The basePackage {@link EPackage}.
	 */
	private EPackage basePackage = null;
	
	/**
	 * The defined {@link Profile} list.
	 */
	private List<Profile> profiles = null;

	/**
	 * @return the basePackage
	 */
	public EPackage getBasePackage() {
		return basePackage;
	}

	/**
	 * @param basePackage the basePackage to set
	 */
	public void setBasePackage(EPackage basePackage) {
		this.basePackage = basePackage;
	}

	/**
	 * @return the profiles
	 */
	public List<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles the profiles to set
	 */
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
	


}
