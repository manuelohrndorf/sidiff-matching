package org.sidiff.superimposition.conflict.selector;

import java.util.List;

import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;

/**
 * <p>A conflict selector determines, which {@link Conflict}s from a {@link ConflictSet}
 * should be resolved by a conflict resolver, as well as their order.</p>
 * @author rmueller
 */
public interface IConflictSelector {

	/**
	 * Returns, in order, the conflicts that should be resolved.
	 * @param conflictSet conflict set containing conflicts
	 * @return list of the conflicts that should be resolved
	 */
	List<Conflict> selectConflicts(ConflictSet conflictSet);
}
