package org.sidiff.matching.profiles.configuration;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * Class for profiles configurable in configuration file
 * 
 * @author dreuling
 */
public class Profile {

	/**
	 * The profileName {@link String}.
	 */
	private String profileName = null;

	/**
	 * The stereoPackage {@link EPackage}.
	 */
	private EPackage stereoPackage = null;

	/**
	 * The List of used stereoTypes {@link EClass}.
	 */
	private List<EClass> stereoTypes = new ArrayList<EClass>();

	/**
	 * The List of used baseTypes {@link EClass}.
	 */
	private List<EClass> baseTypes = new ArrayList<EClass>();

	/**
	 * The List of {@link EReference} between {@see stereoType} and {@see
	 * baseType} .
	 */
	private List<EReference> baseReferences = new ArrayList<EReference>();

	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * @param profileName
	 *            the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	/**
	 * @return the stereoPackage
	 */
	public EPackage getStereoPackage() {
		return stereoPackage;
	}

	/**
	 * @return the stereoTypes
	 */
	public List<EClass> getStereoTypes() {
		return stereoTypes;
	}

	/**
	 * @return the baseTypes
	 */
	public List<EClass> getBaseTypes() {
		return baseTypes;
	}

	/**
	 * @return the baseReferences
	 */
	public List<EReference> getBaseReferences() {
		return baseReferences;
	}

	/**
	 * @param stereoPackage
	 *            the stereoPackage to set
	 */
	public void setStereoPackage(EPackage stereoPackage) {
		this.stereoPackage = stereoPackage;
	}

	/**
	 * @param stereoTypes
	 *            the stereoTypes to set
	 */
	public void setStereoTypes(List<EClass> stereoTypes) {
		this.stereoTypes = stereoTypes;
	}

	/**
	 * @param stereoType
	 *            the stereoType to add to the list of stereotypes
	 */
	public void addStereoType(EClass stereoType) {

		this.stereoTypes.add(stereoType);
	}

	/**
	 * @param baseTypes
	 *            the baseTypes to set
	 */
	public void setBaseTypes(List<EClass> baseTypes) {
		this.baseTypes = baseTypes;
	}

	/**
	 * @param baseType
	 *            the baseType to add to the list of basetypes
	 */
	public void addBaseType(EClass baseType) {

		this.baseTypes.add(baseType);
	}

	/**
	 * @param baseReferences
	 *            the baseReferences to set
	 */
	public void setBaseReferences(List<EReference> baseReferences) {
		this.baseReferences = baseReferences;
	}

	/**
	 * @param baseReference
	 *            the baseReference to add to the list of baseReferences
	 */
	public void addBaseReference(EReference baseReference) {

		this.baseReferences.add(baseReference);

	}

}
