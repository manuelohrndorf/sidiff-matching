package org.sidiff.superimposition.conflict.selector;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.ConflictSeverity;

/**
 * <p>A basic {@link IConflictSelector} that uses a {@link Predicate} to filter
 * the Conflicts, then a {@link Comparator} to order them, and afterwards
 * limits the number of conflicts.</p>
 * <p>The default basic conflict selector selects all conflicts with {@link ConflictSeverity#ERROR},
 * uses the ordering of the conflict set, and does not limit the conflicts.</p>
 * @author rmueller
 */
public class BasicConflictSelector implements IConflictSelector {

	/**
	 * Value to not limit the selected conflicts.
	 */
	public static final long UNLIMITED = -1;

	private Predicate<Conflict> filter = conflict -> conflict.getSeverity() == ConflictSeverity.ERROR;
	private Comparator<Conflict> comparator = null;
	private long limit = UNLIMITED;

	/**
	 * Creates a new basic conflict selector.
	 */
	public BasicConflictSelector() {
	}

	/**
	 * Creates a new basic conflict selector with natural order and no limit.
	 * @param filter a predicate to filter the conflicts
	 */
	public BasicConflictSelector(Predicate<Conflict> filter) {
		this();
		setFilter(filter);
	}

	/**
	 * Creates a new basic conflict selector with no limit.
	 * @param filter a predicate to filter the conflicts
	 * @param comparator comparator to sort the conflicts, may be <code>null</code>
	 */
	public BasicConflictSelector(Predicate<Conflict> filter, Comparator<Conflict> comparator) {
		this(filter);
		setComparator(comparator);
	}

	/**
	 * Creates a new basic conflict selector.
	 * @param filter a predicate to filter the conflicts
	 * @param comparator comparator to sort the conflicts, may be <code>null</code>
	 * @param limit maximum number of selected conflicts, may be {@link #UNLIMITED}
	 */
	public BasicConflictSelector(Predicate<Conflict> filter, Comparator<Conflict> comparator, long limit) {
		this(filter, comparator);
		setLimit(limit);
	}

	@Override
	public List<Conflict> selectConflicts(ConflictSet conflictSet) {
		Stream<Conflict> conflicts = conflictSet.getConflicts().stream().filter(filter);
		Comparator<Conflict> comparator = getComparator();
		if(comparator != null) {
			conflicts = conflicts.sorted(comparator);
		}
		long limit = getLimit();
		if(limit > UNLIMITED) {
			conflicts = conflicts.limit(getLimit());
		}
		return conflicts.collect(Collectors.toList());
	}

	public Predicate<Conflict> getFilter() {
		return filter;
	}

	public void setFilter(Predicate<Conflict> filter) {
		this.filter = Objects.requireNonNull(filter, "filter must not be null");
	}

	public Comparator<Conflict> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<Conflict> comparator) {
		this.comparator = comparator;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		if(limit < UNLIMITED) {
			throw new IllegalArgumentException("invalid limit: " + limit);
		}
		this.limit = limit;
	}
}
