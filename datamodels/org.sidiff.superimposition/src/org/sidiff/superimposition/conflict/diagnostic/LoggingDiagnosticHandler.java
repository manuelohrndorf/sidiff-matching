package org.sidiff.superimposition.conflict.diagnostic;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.superimposition.SuperimpositionModelPlugin;

/**
 * A diagnostic handler that logs all diagnostics to the console
 * using the plugin logger.
 * @author rmueller
 */
public class LoggingDiagnosticHandler implements IDiagnosticHandler {

	private boolean canceled = false;

	@Override
	public void handle(Diagnostic diagnostic) {
		SuperimpositionModelPlugin.getPlugin().log(BasicDiagnostic.toIStatus(diagnostic));
		if(diagnostic.getSeverity() == Diagnostic.CANCEL) {
			canceled = true;
		}
	}

	@Override
	public boolean isCanceled() {
		return canceled;
	}
}
