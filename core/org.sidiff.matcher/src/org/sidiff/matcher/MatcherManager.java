package org.sidiff.matcher;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.extension.IExtension.Description;
import org.sidiff.common.extension.storage.NoExtensionManagerStorage;
import org.sidiff.common.extension.TypedExtensionManager;

public class MatcherManager extends TypedExtensionManager<IMatcher> {

	public MatcherManager(Description<? extends IMatcher> description) {
		super(new NoExtensionManagerStorage<>(description));
	}

	/**
	 * Returns the available matchers for the document types of the given models.
	 * 
	 * @param models
	 * @return
	 */
	public List<IMatcher> getMatchers(Collection<Resource> models) {
		return getExtensions().stream()
				.filter(matcher -> matcher.canHandleModels(models))
				.collect(Collectors.toList());
	}

	/**
	 * Returns the default matcher for the document types of the given models.
	 * (not finished yet)
	 * 
	 * @param models
	 * @return
	 */
	public Optional<IMatcher> getDefaultMatcher(Collection<Resource> models) {
		return getMatchers(models).stream().findFirst();
	}
}
