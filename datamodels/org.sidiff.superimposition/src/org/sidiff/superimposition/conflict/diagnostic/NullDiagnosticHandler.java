package org.sidiff.superimposition.conflict.diagnostic;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * A diagnostic handler that ignores all diagnostics
 * and only handles the canceled-state.
 * @author rmueller
 */
public class NullDiagnosticHandler implements IDiagnosticHandler {

	private boolean canceled = false;

	@Override
	public void handle(Diagnostic diagnostic) {
		if(diagnostic.getSeverity() == Diagnostic.CANCEL) {
			canceled = true;
		}
	}

	@Override
	public boolean isCanceled() {
		return canceled;
	}
}
