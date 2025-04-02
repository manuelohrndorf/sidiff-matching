package org.sidiff.superimposition.conflict.diagnostic;

import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;

/**
 * A diagnostic handler that opens a blocking dialog for
 * all errors and warnings, and allows the user to cancel the job.
 * @author rmueller
 */
public class DialogDiagnosticHandler implements IDiagnosticHandler {

	private boolean canceled = false;

	@Override
	public void handle(Diagnostic diagnostic) {
		if(diagnostic.getSeverity() == Diagnostic.CANCEL) {
			canceled = true;
		} else if(diagnostic.getSeverity() == Diagnostic.ERROR || diagnostic.getSeverity() == Diagnostic.WARNING) {
			Display.getDefault().syncExec(() -> {
				if(DiagnosticDialog.openProblem(Display.getDefault().getActiveShell(), "An error occurred",
						"A problem occurred during conflict detector/resolution. "
						+ "Continue by pressing OK, or cancel by closing this dialog.", diagnostic) == Dialog.CANCEL) {
					canceled = true;
				}
			});
		}
	}

	@Override
	public boolean isCanceled() {
		return canceled;
	}
}
