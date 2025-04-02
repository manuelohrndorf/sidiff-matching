package org.sidiff.superimposition.conflict.selector.internal;

import java.util.ArrayList;
import java.util.List;

import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.conflict.detector.IConflictDetector;
import org.sidiff.superimposition.conflict.selector.IConflictDetectorSelector;

/**
 * @author rmueller
 */
public final class AllConflictDetectorSelector implements IConflictDetectorSelector {

	@Override
	public List<IConflictDetector> selectDetectors(ConflictSet conflictSet) {
		return new ArrayList<>(IConflictDetector.MANAGER.getExtensions(conflictSet.getContext().getDocType(), true));
	}
}
