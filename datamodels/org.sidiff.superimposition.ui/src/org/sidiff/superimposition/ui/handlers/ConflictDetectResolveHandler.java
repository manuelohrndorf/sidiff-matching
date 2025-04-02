package org.sidiff.superimposition.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.sidiff.superimposition.conflict.ConflictFacade;
import org.sidiff.superimposition.conflict.ConflictFacade.Configuration;
import org.sidiff.superimposition.conflict.diagnostic.DialogDiagnosticHandler;
import org.sidiff.superimposition.conflict.diagnostic.LoggingDiagnosticHandler;
import org.sidiff.superimposition.conflict.selector.InteractiveConflictSelector;
import org.sidiff.superimposition.conflict.selector.InteractiveResolverConflictSelector;
import org.sidiff.superimposition.ui.jobs.ConflictDetectResolveJob;

/**
 * 
 * @author rmueller
 */
public class ConflictDetectResolveHandler extends AbstractSuperimpositionHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ConflictDetectResolveJob job = new ConflictDetectResolveJob(buildConfiguration());

		// TODO: Using the selected superimposed model directly does not work because the editor accesses it during the job
		//SuperimposedModel superimposedModel = getSuperimposedModel(event);
		URI superimposedUri = getSuperimposedUri(event);
		/*if(superimposedModel != null) {
			job.setSuperimposedModel(superimposedModel);
		} else */if(superimposedUri != null) {
			job.setSuperimposedUri(superimposedUri);
		} else {
			throw new IllegalArgumentException("Selection does not contain a superimposed model");
		}

		job.setSaveSuperimposedModel(true)
			.schedule();
		return null;
	}

	public Configuration buildConfiguration() {
		return ConflictFacade.config()
			.setConflictSelector(new InteractiveConflictSelector())
			.setResolverSelector(new InteractiveResolverConflictSelector())
			.addDiagnosticHandler(new DialogDiagnosticHandler())
			.addDiagnosticHandler(new LoggingDiagnosticHandler());
	}
}
