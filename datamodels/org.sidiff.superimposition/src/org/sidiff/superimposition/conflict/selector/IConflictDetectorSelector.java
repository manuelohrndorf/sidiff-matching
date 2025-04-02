package org.sidiff.superimposition.conflict.selector;

import java.util.List;

import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.conflict.detector.IConflictDetector;
import org.sidiff.superimposition.conflict.selector.internal.AllConflictDetectorSelector;

/**
 * <p>A conflict detector selector determines which of the supported {@link IConflictDetector}s
 * are used to detect conflicts.</p>
 * @author rmueller
 */
public interface IConflictDetectorSelector {

	/**
	 * Singleton conflict detector selector which selects all available detectors
	 * that support the document types.
	 */
	IConflictDetectorSelector ALL = new AllConflictDetectorSelector();

	/**
	 * <p>Returns, in order, the conflict detectors that should be
	 * used to detect conflicts in the given conflict set, given all supported detectors.</p>
	 * <p>All returned conflict detectors are used in order.</p>
	 * @param conflictSet the conflictSet
	 * @param detectors all detectors supporting the conflict set
	 */
	List<IConflictDetector> selectDetectors(ConflictSet conflictSet);
}

