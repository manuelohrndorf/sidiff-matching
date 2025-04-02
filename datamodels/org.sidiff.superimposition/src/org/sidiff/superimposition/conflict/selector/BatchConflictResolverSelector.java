package org.sidiff.superimposition.conflict.selector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.conflict.resolver.IConflictResolver;
import org.sidiff.superimposition.conflict.resolver.IConflictResolver.Mode;

/**
 * A conflict resolver selector that selects only batch conflict resolvers has a map
 * of conflict ID to resolver keys, throwing an exception if a choice is ambiguous.
 * @author rmueller
 */
public class BatchConflictResolverSelector implements IConflictResolverSelector {

	private Map<String,List<String>> resolverMappings = new HashMap<>();

	@Override
	public List<IConflictResolver> selectResolvers(Conflict conflict, Collection<IConflictResolver> resolvers) {
		List<IConflictResolver> batchResolvers = resolvers.stream()
				.filter(r -> r.getMode() == Mode.BATCH).collect(Collectors.toList());
		if(batchResolvers.size() <= 1) {
			return batchResolvers;
		}

		List<String> resolverKeys = resolverMappings.get(conflict.getId());
		if(resolverKeys != null) {
			return resolverKeys.stream()
					.map(key -> batchResolvers.stream().filter(r -> r.getKey() == key).findFirst())
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
		}

		throw new AssertionError(
			"Multiple batch conflict resolvers are available to resolve " + conflict.getId() + ": "
				+ resolvers.stream().map(IConflictResolver::getKey).collect(Collectors.joining(", ")) + ". "
				+ "Set the resolver mappings of the BatchConflictResolverSelector to choose a resolver.");
	}

	public void addResolverMapping(String conflictId, String resolverKey) {
		List<String> keys = resolverMappings.computeIfAbsent(conflictId, unused -> new ArrayList<>());
		if(!keys.contains(resolverKey)) {
			keys.add(resolverKey);
		}
	}

	public void removeResolverMapping(String conflictId, String resolverKey) {
		List<String> keys = resolverMappings.get(conflictId);
		if(keys != null) {
			keys.remove(resolverKey);
			if(keys.isEmpty()) {
				resolverMappings.remove(conflictId);
			}
		}
	}
}
