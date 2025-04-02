package org.sidiff.matching.api.settings;

import java.util.Set;

import org.sidiff.candidates.CandidatesUtil;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.settings.BaseSettings;
import org.sidiff.correspondences.CorrespondencesUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.IMatcher;
import org.sidiff.matching.api.util.MatchingUtils;
import org.sidiff.similarities.ISimilarities;
import org.sidiff.similaritiescalculation.ISimilaritiesCalculation;

/**
 * 
 * @author cpietsch
 *
 */
public class MatchingSettings extends BaseSettings {

	/**
	 * The Matcher for calculating correspondences.
	 */
	private IMatcher matcher;
	
	/**
	 * 
	 */
	private ICandidates candidatesService;
	
	/**
	 * 
	 */
	private ICorrespondences correspondencesService;
	
	/**
	 * 
	 */
	private ISimilarities similaritiesService;
	
	/**
	 * 
	 */
	private ISimilaritiesCalculation similaritiesCalculationService;
	
	/**
	 * default {@link MatchingSettings}
	 */
	public MatchingSettings(){
		super();
		this.matcher = MatchingUtils.getGenericMatchers().iterator().next();
		this.candidatesService = CandidatesUtil.getCandidatesServiceInstance();
		this.correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
	}
	
	public MatchingSettings(Set<String> documentTypes) {
		super();
		this.matcher = MatchingUtils.getAvailableMatchers(documentTypes).iterator().next();
		this.candidatesService = CandidatesUtil.getCandidatesServiceInstance();
		this.correspondencesService = CorrespondencesUtil.getDefaultCorrespondencesService();
	}
	
	public MatchingSettings(Scope scope, boolean validate, IMatcher matcher, ICandidates candidatesService, ICorrespondences correspondencesService) {
		super(scope, validate);
		this.matcher = matcher;
		this.candidatesService = candidatesService;
		this.correspondencesService = correspondencesService;
		
	}
	
	public MatchingSettings(Scope scope, boolean validate, IMatcher matcher, ICandidates candidatesService, ICorrespondences correspondencesService,
			ISimilarities similaritiesService, ISimilaritiesCalculation similaritiesCalculationService) {
		this(scope, validate, matcher, candidatesService, correspondencesService);
		this.similaritiesService = similaritiesService;
		this.similaritiesCalculationService = similaritiesCalculationService;
		
	}

	@Override
	public boolean validateSettings() {
		// TODO CPietsch (2016-02-07): Checks for similarity based matching settings
		return super.validateSettings()
				&& matcher != null
				&& correspondencesService != null
				&& getScope().equals(Scope.RESOURCE_SET)? matcher.isResourceSetCapable(): true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(getMatcher() != null ? "Matcher: " + getMatcher().getName() + "\n" : "none");
		result.append(getCandidatesService() != null ? "Candidates Service: " + getCandidatesService().getServiceID() + "\n" : "none");
		result.append(getCorrespondencesService() != null ? "Correspondences Service: " + getCorrespondencesService().getServiceID() + "\n" : "none");
		result.append(getSimilaritiesService() != null ? "Similarities Service: " + getCorrespondencesService().getServiceID() + "\n" : "none");
		result.append(getSimilaritiesCalculationService() != null ? "Similarities Calculation Service: " + getSimilaritiesCalculationService().getServiceID() + "\n" : "none");
		result.append(getSimilaritiesService() != null ? "Similarities Service: " + getSimilaritiesService().getServiceID() + "\n" : "none");
		
		return result.toString();
	}
	
	// ---------- Getter and Setter Methods----------
	
	/**
	 * @return The Matcher for model comparison.
	 */
	public IMatcher getMatcher() {
		return matcher;
	}
	
	/**
	 * @param matcher
	 *            The Matcher for model comparison.
	 */
	public void setMatcher(IMatcher matcher) {
		if (this.matcher == null || !this.matcher.getName().equals(matcher.getName())) {
			this.matcher = matcher;
			if(correspondencesService != null){
				matcher.setCorrespondencesService(correspondencesService);
			}
			this.notifyListeners(MatchingSettingsItem.MATCHER);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ICandidates getCandidatesService() {
		return candidatesService;
	}
	
	/**
	 * 
	 * @param candidateService
	 */
	public void setCandidatesService(ICandidates candidateService) {
		if(this.candidatesService == null || !this.candidatesService.equals(candidateService)){
			this.candidatesService = candidateService;
			this.notifyListeners(MatchingSettingsItem.CANDITATE_SERVICE);
		}
	}

	/**
	 * 
	 * @return
	 */
	public ICorrespondences getCorrespondencesService() {
		return correspondencesService;
	}
	
	/**
	 * 
	 * @param correspondencesService
	 */
	public void setCorrespondencesService(ICorrespondences correspondencesService) {
		if(this.correspondencesService == null || !this.correspondencesService.equals(correspondencesService)){
			this.correspondencesService = correspondencesService;
			if(matcher != null){
				matcher.setCorrespondencesService(correspondencesService);
			}
			this.notifyListeners(MatchingSettingsItem.CORRESPONDENCE_SERVICE);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public ISimilarities getSimilaritiesService() {
		return similaritiesService;
	}
	
	/**
	 * 
	 * @param similaritesService
	 */
	public void setSimilaritiesService(ISimilarities similaritesService) {
		if(this.similaritiesService == null || !this.similaritiesService.equals(similaritesService)){
			this.similaritiesService = similaritesService;
			this.notifyListeners(MatchingSettingsItem.SIMILARTIY_SERVICE);
		}
	}

	/**
	 * 
	 * @return
	 */
	public ISimilaritiesCalculation getSimilaritiesCalculationService() {
		return similaritiesCalculationService;
	}
	
	/**
	 * 
	 * @param similaritiesCalculationService
	 */
	public void setSimilaritiesCalculationService(ISimilaritiesCalculation similaritiesCalculationService) {
		if(this.similaritiesCalculationService == null || !this.similaritiesCalculationService.equals(similaritiesCalculationService)){
			this.similaritiesCalculationService = similaritiesCalculationService;
			this.notifyListeners(MatchingSettingsItem.SIMILARITY_CALCULATION_SERVICE);
		}
	}	
}
