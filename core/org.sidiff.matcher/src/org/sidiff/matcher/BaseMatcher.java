package org.sidiff.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.mode.MatcherMode;

/**
 * this is the abstract base matcher for the already known matcher.
 *
 */
public abstract class BaseMatcher implements IMatcher {

	/**
	 * 
	 */
	private ICorrespondences correspondencesService;
	
	/**
	 * 
	 */
	private ICandidates candidatesService;

	/**
	 * 
	 */
	private List<Resource> models;
	
	private MatcherMode mode = MatcherMode.SINGLE;

	/**
	 * RESOURCE or RESOURCE_SET
	 */
	protected Scope scope;	
	
	@Override
	public void startMatching(Collection<Resource> models, Scope scope){
		init(models, scope);
		LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
		LogUtil.log(LogEvent.NOTICE, "--------------------------MATCHING--------------------------");
		LogUtil.log(LogEvent.NOTICE, "------------------------------------------------------------");
		LogUtil.log(LogEvent.NOTICE, "---Matcher---");
		LogUtil.log(LogEvent.NOTICE, this.getName());
		int modelnumber = 0;
		for(Resource model : models){
			modelnumber++;
			LogUtil.log(LogEvent.NOTICE, "# M" + modelnumber + " #");  
			LogUtil.log(LogEvent.NOTICE, "URI: " + model.getURI());  
			LogUtil.log(LogEvent.NOTICE, "Corresponding | Unmatched: " +
			this.getCorrespondencesService().getElementsWithCorrespondences(model).size() + " | " 
					+  this.getCorrespondencesService().getElementsWithoutCorrespondences(model).size());
		}
		LogUtil.log(LogEvent.NOTICE, "---Models---");

		match();
		LogUtil.log(LogEvent.NOTICE, "---Matching Result---");

		modelnumber = 0;
		for(Resource model : models){
			modelnumber++;
			LogUtil.log(LogEvent.NOTICE, "# M" + modelnumber + " #");  
			LogUtil.log(LogEvent.NOTICE, "URI: " + model.getURI());  
			LogUtil.log(LogEvent.NOTICE, "Corresponding | Unmatched: " +
			this.getCorrespondencesService().getElementsWithCorrespondences(model).size() + " | " 
					+  this.getCorrespondencesService().getElementsWithoutCorrespondences(model).size());
		}
	}
	
	/**
	 * 
	 */
	protected abstract void match();

	/**
	 * 
	 * @param models
	 * @param scope
	 */
	protected void init(Collection<Resource> models,  Scope scope) {
		LogUtil.log(LogEvent.DEBUG, "Initializing Matcher...");
		this.models = new ArrayList<>(models);
		this.scope = Objects.requireNonNull(scope);

		//Resolving all models, this is necessary for correct matching of reference objects
		//(e.g., Registry)
		for(Resource r : models) {
			EcoreUtil.resolveAll(r);
		}
		if(correspondencesService == null) {
			correspondencesService = ICorrespondences.MANAGER.getDefaultExtension()
					.orElseThrow(() -> new RuntimeException("No correspondences service is available"));
		}
		if(candidatesService == null) {
			candidatesService = ICandidates.MANAGER.getDefaultExtension()
					.orElseThrow(() -> new RuntimeException("No candidates service is available"));
		}

		if(getMode() == MatcherMode.SINGLE) {
			correspondencesService.init(models);
		}
		candidatesService.init(models);
		LogUtil.log(LogEvent.DEBUG, "Matcher initialized!");
	}
	
	@Override
	public void reset() {
		if(getMode() == MatcherMode.SINGLE) {
			models = null;
			if(candidatesService != null) {
				candidatesService.reset();
			}
			if(correspondencesService != null) {
				correspondencesService.reset();
			}
		} else {
			setMode(MatcherMode.SINGLE);
		}
	}

	@Override
	public boolean canHandleModels(Collection<Resource> models) {
		Set<String> docTypes = new HashSet<String>();
		for(Resource model : models) {
			if(isResourceSetCapable()) {
				docTypes.addAll(EMFModelAccess.getDocumentTypes(model, Scope.RESOURCE_SET));
			} else {
				docTypes.addAll(EMFModelAccess.getDocumentTypes(model, Scope.RESOURCE));
			}
		}
		return canHandle(docTypes);
	}
	
	@Override
	public boolean isResourceSetCapable() {
		return false;
	}	
	
	
	// ---------- Getter and Setter Methods----------
	
	@Override
	public String getKey() {
		return getClass().getSimpleName();
	}

	@Override
	public List<Resource> getModels() {
		return Collections.unmodifiableList(models);
	}	

	@Override
	public void setCorrespondencesService(ICorrespondences correspondencesService){
		this.correspondencesService = correspondencesService;
	}
	
	@Override
	public ICorrespondences getCorrespondencesService() {
		return correspondencesService;
	}

	@Override
	public void setCandidatesService(ICandidates candidatesService) {
		this.candidatesService = candidatesService;
	}
	
	@Override
	public ICandidates getCandidatesService() {
		return candidatesService;
	}

	@Override
	public MatcherMode getMode() {
		return mode;
	}

	@Override
	public void setMode(MatcherMode mode) {
		this.mode = Objects.requireNonNull(mode);
	}
}
