package org.sidiff.superimposition.conflict.selector;

import java.util.Collection;

/**
 * Utility functions for {@link IConflictSelector}.
 * @author rmueller
 */
public class ConflictSelectorUtil {

	/**
	 * Creates a default {@link BasicConflictSelector} that uses a
	 * {@link ConflictPattern} to filter conflicts.
	 * @param conflictIds the supported conflicts
	 * @return conflict selector
	 */
	public static BasicConflictSelector createPatternBasedSelector(Collection<String> conflictIds) {
		ConflictPattern pattern = new ConflictPattern(conflictIds);
		BasicConflictSelector selector = new BasicConflictSelector();
		selector.setFilter(selector.getFilter().and(conflict -> pattern.matches(conflict.getId())));
		return selector;
	}
}
