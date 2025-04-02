package org.sidiff.matching.api.settings;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.emf.settings.BaseSettings;
import org.sidiff.common.extension.IExtension;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.correspondences.matchingmodel.MatchingModelCorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matcher.IncrementalMatcher;

/**
 * 
 * @author cpietsch
 * @see MatchingSettingsItem
 */
public class MatchingSettings extends BaseSettings {

	private static final String PLUGIN_ID = "org.sidiff.matching.api";

	/**
	 * The Matcher for calculating correspondences.
	 */
	private IMatcher matcher;
	private ICandidates candidatesService;
	private ICorrespondences correspondencesService;

	public MatchingSettings() {
		super();
	}

	/**
	 * @deprecated Use the empty constructor and initDefaults instead.
	 */
	public MatchingSettings(Scope scope, boolean validate, IMatcher matcher,
			ICandidates candidatesService, ICorrespondences correspondencesService) {

		super(scope, validate);
		this.matcher = matcher;
		this.candidatesService = candidatesService;
		this.correspondencesService = correspondencesService;
	}

	@Override
	public void initDefaults(Set<String> documentTypes) {
		super.initDefaults(documentTypes);

		if(matcher == null || !matcher.canHandle(documentTypes)) {
			setMatcher(getDefaultMatcher(documentTypes));
		}

		if(candidatesService == null) {
			setCandidatesService(getDefaultCandidatesService(documentTypes));
		}

		if(correspondencesService == null) {
			setCorrespondencesService(getDefaultCorrespondencesService(documentTypes));
		}
	}

	protected IMatcher getDefaultMatcher(Set<String> documentTypes) {
		if(documentTypes.isEmpty()) {
			return IMatcher.MANAGER.getDefaultExtension().orElseThrow(
					() -> new IllegalStateException("No generic matcher is available"));
		}
		return IMatcher.MANAGER.getDefaultExtension(documentTypes).orElseThrow(
				() -> new IllegalStateException("No matcher is available for the document types " + documentTypes));
	}

	protected ICandidates getDefaultCandidatesService(Set<String> documentTypes) {
		return ICandidates.MANAGER.getDefaultExtension().orElseThrow(
				() -> new IllegalStateException("No candidates service is available"));
	}

	protected ICorrespondences getDefaultCorrespondencesService(Set<String> documentTypes) {
		return ICorrespondences.MANAGER.getExtension(MatchingModelCorrespondences.class).orElseThrow(
				() -> new IllegalStateException("MatchingModelCorrespondences service is available"));
	}

	@Override
	public void validate(MultiStatus multiStatus) {
		super.validate(multiStatus);

		if(matcher == null) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Matcher is not set.", null));
		} else if(getScope() != null && getScope().equals(Scope.RESOURCE_SET) && !matcher.isResourceSetCapable()) {
			multiStatus.add(new Status(IStatus.ERROR, PLUGIN_ID, 0, "Selected Matcher " + matcher.getName()
				+ " does not support ResourceSet-Scope, please change the Matcher or Scope!", null));
		}

		if(candidatesService == null) {
			multiStatus.add(new Status(Diagnostic.ERROR, PLUGIN_ID, 0, "Candidates Service is not set.", null));
		}

		if(correspondencesService == null) {
			multiStatus.add(new Status(Diagnostic.ERROR, PLUGIN_ID, 0, "Correspondences Service is not set.", null));
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\n"
			+ "MatchingSettings["
			+ "Matcher: " + toString(getMatcher()) + ", "
			+ "Candidates Service: " + toString(getCandidatesService()) + ", "
			+ "Correspondences Service: " + toString(getCorrespondencesService()) + "]";
	}

	@Override
	protected String toStringImpl(Object object) {
		if(object instanceof IncrementalMatcher) {
			return object.toString(); // also print the sub-matchers
		}
		if(object instanceof IExtension) {
			return ((IExtension)object).getName();
		}
		return super.toStringImpl(object);
	}

	// ---------- Getter and Setter Methods----------

	/**
	 * @return The Matcher for model comparison.
	 * @see MatchingSettingsItem#MATCHER
	 */
	public IMatcher getMatcher() {
		return matcher;
	}

	/**
	 * @param matcher The Matcher for model comparison.
	 * @see MatchingSettingsItem#MATCHER
	 */
	public void setMatcher(IMatcher matcher) {
		if (!Objects.equals(this.matcher, matcher)) {
			this.matcher = matcher;
			if(this.matcher != null) {
				this.matcher.setCorrespondencesService(this.correspondencesService);
				this.matcher.setCandidatesService(this.candidatesService);
			}
			notifyListeners(MatchingSettingsItem.MATCHER);
		}
	}

	/**
	 * 
	 * @return
	 * @see MatchingSettingsItem#CANDITATE_SERVICE
	 */
	public ICandidates getCandidatesService() {
		return candidatesService;
	}

	/**
	 * 
	 * @param candidateService
	 * @see MatchingSettingsItem#CANDITATE_SERVICE
	 */
	public void setCandidatesService(ICandidates candidateService) {
		if (!Objects.equals(this.candidatesService, candidateService)) {
			this.candidatesService = candidateService;
			if(this.matcher != null) {
				this.matcher.setCandidatesService(candidateService);
			}
			notifyListeners(MatchingSettingsItem.CANDITATE_SERVICE);
		}
	}

	/**
	 * 
	 * @return
	 * @see MatchingSettingsItem#CORRESPONDENCE_SERVICE
	 */
	public ICorrespondences getCorrespondencesService() {
		return correspondencesService;
	}

	/**
	 * 
	 * @param correspondencesService
	 * @see MatchingSettingsItem#CORRESPONDENCE_SERVICE
	 */
	public void setCorrespondencesService(ICorrespondences correspondencesService) {
		if (!Objects.equals(this.correspondencesService, correspondencesService)) {
			this.correspondencesService = correspondencesService;
			if(this.matcher != null) {
				this.matcher.setCorrespondencesService(correspondencesService);
			}
			notifyListeners(MatchingSettingsItem.CORRESPONDENCE_SERVICE);
		}
	}


	public static MatchingSettings defaultSettings() {
		return defaultSettings(Collections.emptySet());
	}

	public static MatchingSettings defaultSettings(Set<String> documentTypes) {
		MatchingSettings settings = new MatchingSettings();
		settings.initDefaults(documentTypes);
		return settings;
	}
}
