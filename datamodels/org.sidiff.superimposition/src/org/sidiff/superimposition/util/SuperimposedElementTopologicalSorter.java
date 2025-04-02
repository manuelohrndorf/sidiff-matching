package org.sidiff.superimposition.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.sidiff.common.collections.TopologicalSorter;
import org.sidiff.entities.Reference;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * Sorts SuperimposedElements according to their containments, root elements first.
 * @author rmueller
 */
public class SuperimposedElementTopologicalSorter extends TopologicalSorter<SuperimposedElement> {

	private static final Function<SuperimposedElement, Stream<SuperimposedElement>> SUCCESSORS =
			element -> element.getOutgoings().parallelStream()
				.filter(Reference::isContainment)
				.map(Reference::getTarget).map(SuperimposedElement.class::cast);

	protected SuperimposedElementTopologicalSorter(Collection<SuperimposedElement> vertices) {
		super(vertices, SUCCESSORS, false);
	}

	public static List<SuperimposedElement> sort(Collection<SuperimposedElement> vertices) {
		return new SuperimposedElementTopologicalSorter(vertices).sort();
	}
}
