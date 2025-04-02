package org.sidiff.superimposition.conflict.diagnostic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.Diagnostic;

/**
 * A composite diagnostic handler which delegates to other diagnostic handlers.
 * It is canceled, when any of the delegates is canceled.
 * @author rmueller
 */
public class CompositeDiagnosticHandler implements IDiagnosticHandler {

	private List<IDiagnosticHandler> handlers = new ArrayList<>();

	public CompositeDiagnosticHandler(IDiagnosticHandler ...handlers) {
		Assert.isLegal(handlers.length > 1, "At least two handlers must be specified");
		for(IDiagnosticHandler handler : handlers) {
			addHandler(handler);
		}
	}

	public CompositeDiagnosticHandler(Collection<? extends IDiagnosticHandler> handlers) {
		Assert.isLegal(handlers.size() > 1, "At least two handlers must be specified");
		for(IDiagnosticHandler handler : handlers) {
			addHandler(handler);
		}
	}

	public void addHandler(IDiagnosticHandler handler) {
		handlers.add(Objects.requireNonNull(handler, "handler must not be null"));
	}

	public void removeHandler(IDiagnosticHandler handler) {
		handlers.remove(Objects.requireNonNull(handler, "handler must not be null"));
	}

	@Override
	public void handle(Diagnostic diagnostic) {
		for(IDiagnosticHandler handler : handlers) {
			handler.handle(diagnostic);
		}
	}

	@Override
	public boolean isCanceled() {
		return handlers.stream().anyMatch(IDiagnosticHandler::isCanceled);
	}
}
