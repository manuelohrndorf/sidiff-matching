package org.sidiff.matcher;


import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.candidates.ICandidates;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.extension.ITypedExtension;
import org.sidiff.common.extension.configuration.IConfigurableExtension;
import org.sidiff.common.extension.configuration.IExtensionConfiguration;
import org.sidiff.correspondences.ICorrespondences;
import org.sidiff.matcher.mode.MatcherMode;

/**
 * 
 * @author dreuling, cpietsch
 *
 */
public interface IMatcher extends ITypedExtension, IConfigurableExtension {

	Description<IMatcher> DESCRIPTION = Description.of(IMatcher.class, "org.sidiff.matcher.extensionpoint", "client", "class");

	MatcherManager MANAGER = new MatcherManager(DESCRIPTION);

	/**
	 * Returns the short name (used as a key) of the matcher.
	 * 
	 * @return the matcher short name (used as key).
	 */
	@Override
	public String getKey();
	
	/**
	 * Returns the description name of the matcher.
	 * 
	 * @return the matcher name.
	 */
	@Override
	public String getName();
	
	/**
	 * @return the document types the matcher is implemented for.
	 */
	@Override
	public Set<String> getDocumentTypes();

	/**
	 * Returns whether this matcher is principally capable of comparing two
	 * models in comparsionMode {@link Scope#RESOURCE_SET}.
	 * 
	 * @return
	 */
	public boolean isResourceSetCapable();	
	
	/**
	 * 
	 * @return
	 */
	public List<Resource> getModels();	
	
	/**
	 * Returns whether this matcher can handle (i.e. match) the given models.
	 * 
	 * @return
	 */
	public boolean canHandleModels(Collection<Resource> models);
	
	/**
	 * Calculates a matching between models. That means a
	 * Correspondence for each preserved object between models.
	 * 
	 * @param models
	 *            the models to compare
	 * @param scope
	 *            RESOURCE or RESOURCE_SET
	 */
	public void startMatching(Collection<Resource> models, Scope scope);
	
	/**
	 * Reset Results 
	 * 
	 */
	public void reset();
	
	/**
	 * Returns whether this matcher is an incremental or single one.
	 * An incremental matcher consists of several single matcher.
	 * The matching is calculated by invoking {@link #startMatching(Collection, Scope)}
	 * of each matcher in a given order.
	 * 
	 * @see {@link IncrementalMatcher}
	 * 
	 * @return
	 */
	public MatcherMode getMode();
	
	/**
	 * sets the {@link MatcherMode}
	 * 
	 * @param mode
	 */
	public void setMode(MatcherMode mode);
	
	/**
	 * 
	 * @param correspondencesService
	 */
	public void setCorrespondencesService(ICorrespondences correspondencesService);
	
	/**
	 * 
	 * @return
	 */
	public ICorrespondences getCorrespondencesService();

	/**
	 * 
	 * @param candidatesService
	 */
	public void setCandidatesService(ICandidates candidatesService);
	
	/**
	 * 
	 * @return
	 */
	public ICandidates getCandidatesService();
	
	/**
	 * {@inheritDoc}
	 * <p>The default implementation of IMatcher returns an empty configuration.</p>
	 */
	@Override
	default IExtensionConfiguration getConfiguration() {
		return IExtensionConfiguration.NULL;
	}
}
