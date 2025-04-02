package org.sidiff.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.mode.MatcherMode;

/**
 * <p>Incremental matcher which must be initialized with a list of IMatchers. When
 * the matching is computed, this incremental matcher invokes all sub-matchers
 * in the order which is given by the list of matchers.</p>
 * 
 * <p>Note that this matcher is not registered via an extension point and will not
 * be shown in the UI. If the user selects more than one {@link IMatcher} in the 
 * {@link MatchingEngineWidget} this class will be created dynamically and all chosen matchers will
 * be added.</p>
 * 
 * <p>The incremental matcher overrides <code>equals</code> and <code>hashCode</code>,
 * so that two incremental matchers with the same list of sub-matchers are considered equal.</p>
 * 
 * @author kehrer
 */
public class IncrementalMatcher implements IMatcher {

	/**
	 * The list of matchers which will be executed in the order given by the
	 * List.
	 */
	private List<IMatcher> matchers;

	/**
	 * Constructs a new incremental matcher based on a list of sub-matchers.
	 * These sub-matchers will be executed in the order given by the list.
	 * 
	 * @param matchers
	 */
	public IncrementalMatcher(List<IMatcher> matchers) {
		super();
		Assert.isNotNull(matchers, "matchers must not be null");
		Assert.isLegal(matchers.size() > 1, "Incremental matchers should only be used with more than one sub-matcher");
		this.matchers = matchers;
	}

	@Override
	public void startMatching(Collection<Resource> models, Scope scope) {
		reset();
		LogUtil.log(LogEvent.NOTICE, "Starting incremental matching");

		for (int i = 0; i < matchers.size(); i++) {
			IMatcher nextMatcher = matchers.get(i);
			if (nextMatcher.canHandleModels(models)) {
				LogUtil.log(LogEvent.NOTICE, "Next matcher (" + i + "): " + nextMatcher.getName());
				nextMatcher.setMode(i > 0 ? MatcherMode.INCREMENTAL : MatcherMode.SINGLE);
				nextMatcher.startMatching(models, scope);
			} else {
				LogUtil.log(LogEvent.NOTICE, "Next matcher (" + i + "): " + nextMatcher.getName()
				+ ": Skip because cannot handle resources " + models );

			}
		}

		LogUtil.log(LogEvent.NOTICE, "Finished incremental matching");
	}

	@Override
	public void reset() {
		matchers.forEach(IMatcher::reset);	
	}

	@Override
	public boolean canHandleModels(Collection<Resource> models) {
		Set<String> docTypes = new HashSet<>();
		for(Resource model : models) {
			docTypes.addAll(EMFModelAccess.getDocumentTypes(model,
					isResourceSetCapable() ? Scope.RESOURCE_SET : Scope.RESOURCE));
		}
		return canHandle(docTypes);
	}

	@Override
	public boolean isResourceSetCapable() {
		return matchers.stream().anyMatch(IMatcher::isResourceSetCapable);
	}

	@Override
	public Set<String> getDocumentTypes() {
		return matchers.stream()
			.map(IMatcher::getDocumentTypes)
			.flatMap(Collection::stream)
			.collect(Collectors.toSet());
	}

	@Override
	public String getName() {
		return "Incremental Matcher";
	}

	@Override
	public String getKey() {
		return getClass().getName();
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This matcher incrementally invokes all sub-matchers in the order which is given by the list of matchers.");
	}

	public void setMatchers(List<IMatcher> matchers) {
		this.matchers = new ArrayList<>(matchers);
	}
	
	public List<IMatcher> getMatchers() {
		return Collections.unmodifiableList(matchers);
	}

	@Override
	public List<Resource> getModels() {
		return matchers.get(0).getModels();
	}

	@Override
	public ICorrespondences getCorrespondencesService() {
		return matchers.get(0).getCorrespondencesService();
	}

	@Override
	public ICandidates getCandidatesService() {
		return matchers.get(0).getCandidatesService();

	}

	@Override
	public void setCorrespondencesService(ICorrespondences correspondencesService) {
		for(IMatcher matcher : matchers){
			matcher.setCorrespondencesService(correspondencesService);
		}
		
	}

	@Override
	public void setCandidatesService(ICandidates candidatesService) {
		for(IMatcher matcher : matchers){
			matcher.setCandidatesService(candidatesService);
		}
	}

	@Override
	public MatcherMode getMode() {
		return MatcherMode.INCREMENTAL;
	}

	/**
	 * Not supported by the incremental matcher.
	 */
	@Override
	public void setMode(MatcherMode mode) {
		throw new UnsupportedOperationException("IncrementalMatcher does not support setMode");
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		} else if(!(obj instanceof IncrementalMatcher)) {
			return false;
		}
		return matchers.equals(((IncrementalMatcher)obj).matchers);
	}

	@Override
	public int hashCode() {
		return matchers.hashCode();
	}
	
	@Override
	public String toString() {
		return matchers.stream()
				.map(IMatcher::getName)
				.collect(Collectors.joining(", ", "IncrementalMatcher[", "]"));
	}
}
