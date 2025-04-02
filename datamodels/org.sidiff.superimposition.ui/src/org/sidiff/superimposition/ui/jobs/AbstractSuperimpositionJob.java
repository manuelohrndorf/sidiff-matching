package org.sidiff.superimposition.ui.jobs;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelFactory;
import org.sidiff.superimposition.presentation.SuperimpositionModelEditorPlugin;

/**
 * 
 * @author rmueller
 */
public abstract class AbstractSuperimpositionJob extends Job {

	public AbstractSuperimpositionJob(String name) {
		super(name);
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			return safeRun(monitor);
		} catch(OperationCanceledException e) {
			return Status.CANCEL_STATUS;
		} catch(Exception e) {
			return new Status(IStatus.ERROR, SuperimpositionModelEditorPlugin.ID, getName() + " failed", e);
		}
	}

	protected abstract IStatus safeRun(IProgressMonitor monitor) throws Exception;

	protected SuperimposedModel loadSuperimposedModel(SiDiffResourceSet resourceSet, URI superimposedUri, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Loading superimposed model", 1);
		SuperimposedModel superimposedModel = resourceSet.loadEObject(superimposedUri, SuperimposedModel.class);
		progress.worked(1);
		return superimposedModel;
	}

	protected SuperimposedModel loadOrCreateSuperimposedModel(SiDiffResourceSet resourceSet, URI superimposedUri, IProgressMonitor monitor) {
		if(resourceSet.getURIConverter().exists(superimposedUri, null)) {
			return loadSuperimposedModel(resourceSet, superimposedUri, monitor);
		}

		SuperimposedModel superimposedModel = SuperimpositionModelFactory.eINSTANCE.createSuperimposedModel();
		resourceSet.saveEObjectAs(superimposedModel, superimposedUri);
		return superimposedModel;
	}

	protected void saveSuperimposedModel(SiDiffResourceSet resourceSet, SuperimposedModel superimposedModel, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Saving superimposed model", 1);
		resourceSet.saveEObject(superimposedModel);
		progress.worked(1);
	}
}