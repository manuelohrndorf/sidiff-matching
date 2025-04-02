package org.sidiff.superimposition.conflict.selector;

import java.util.Collection;
import java.util.List;

import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.conflict.resolver.IConflictResolver;

/**
 * <p>A conflict resolver selector determines which of the supported {@link IConflictResolver}s
 * are used to resolve a conflict.</p>
 * @author rmueller
 */
public interface IConflictResolverSelector {

	/**
	 * <p>Returns, in order, the conflict resolver that should be
	 * used to resolve the given conflict, given all supported resolvers.</p>
	 * <p>The conflict resolvers will be used in order, stopping after the first
	 * successful resolution, or cancellation.</p>
	 * @param conflict the conflict
	 * @param resolvers all resolvers supporting this conflict
	 * @return resolvers to be used
	 */
	List<IConflictResolver> selectResolvers(Conflict conflict, Collection<IConflictResolver> resolvers);
}
