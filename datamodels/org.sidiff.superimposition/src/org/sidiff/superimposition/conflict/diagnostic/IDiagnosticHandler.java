package org.sidiff.superimposition.conflict.diagnostic;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.superimposition.SuperimpositionModelPlugin;

/**
 * A diagnostic handler handles diagnostics produced by the conflict
 * detectors and resolvers. The handler also stores a canceled-state.
 * @author rmueller
 */
public interface IDiagnosticHandler {

	/**
	 * Handles the diagnostics. Stores whether the diagnostic indicates cancellation.
	 * @param diagnostic the diagnostic
	 */
	void handle(Diagnostic diagnostic);

	/**
	 * Returns whether the current process was canceled.
	 * @return <code>true</code> if canceled, <code>false</code> otherwise
	 */
	boolean isCanceled();

	/**
	 * Convenience method, equivalent to
	 * <code>handle(new BasicDiagnostic(severity, SuperimpositionModelPlugin.ID, 0, message, data));</code>
	 * @param severity the severity
	 * @param message the message
	 * @param data optional attached objects
	 */
	default void handle(int severity, String message, Object ...data) {
		handle(new BasicDiagnostic(severity, SuperimpositionModelPlugin.ID, 0, message, data));
	}

	/**
	 * Wraps the given handlers into a single handler that calls all.
	 * @param handlers the handlers
	 * @return handler that delegates to all handlers of the collection
	 */
	static IDiagnosticHandler wrap(Collection<? extends IDiagnosticHandler> handlers) {
		switch(handlers.size()) {
			case 0:
				return new NullDiagnosticHandler();
			case 1:
				return handlers.stream().findAny().get();
			default:
				return new CompositeDiagnosticHandler(handlers);
		}
	}
}
