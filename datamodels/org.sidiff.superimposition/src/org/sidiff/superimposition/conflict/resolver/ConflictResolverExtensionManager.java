package org.sidiff.superimposition.conflict.resolver;

import java.util.Collection;
import java.util.stream.Collectors;

import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension.Description;
import org.sidiff.superimposition.Conflict;

/**
 * @author rmueller
 */
public class ConflictResolverExtensionManager extends ExtensionManager<IConflictResolver> {

	public ConflictResolverExtensionManager(Description<? extends IConflictResolver> description) {
		super(description);
	}

	public Collection<IConflictResolver> getConflictResolvers(Conflict conflict) {
		return getExtensions().stream()
				.filter(detector -> detector.canHandle(conflict))
				.collect(Collectors.toList());
	}
}
