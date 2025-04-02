package org.sidiff.superimposition.conflict.diagnostic;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.sidiff.superimposition.SuperimpositionModelPlugin;

/**
 * A diagnostic handler that collects all diagnostics into
 * a single BasicDiagnostic, accessed via {@link #getDiagnostic()}.
 * @author rmueller
 */
public class CollectingDiagnosticHandler implements IDiagnosticHandler {

	private BasicDiagnostic containerDiagnostic;

	/**
	 * Creates a new collecting diagnostic handler.
	 * @param containerMessage the message for the container diagnostic
	 */
	public CollectingDiagnosticHandler(String containerMessage) {
		containerDiagnostic = new BasicDiagnostic(SuperimpositionModelPlugin.ID, 0, containerMessage, null);
	}
	
	@Override
	public void handle(Diagnostic diagnostic) {
		containerDiagnostic.add(diagnostic);
	}

	public BasicDiagnostic getDiagnostic() {
		return containerDiagnostic;
	}
	
	@Override
	public boolean isCanceled() {
		return containerDiagnostic.getSeverity() == Diagnostic.CANCEL;
	}
}
