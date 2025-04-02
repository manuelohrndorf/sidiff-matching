package org.sidiff.superimposition.ui.jobs;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.entities.util.EntitiesUtil;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.importer.SuperimpositionModelImporter;

/**
 * 
 * @author rmueller
 */
public class ImportModelsJob extends AbstractSuperimpositionJob {

	private URI superimposedUri;
	private Collection<URI> modelUris;

	public ImportModelsJob(URI superimposedUri, Collection<URI> modelUris) {
		super("Importing Models");
		this.superimposedUri = superimposedUri;
		this.modelUris = modelUris;
	}

	@Override
	protected IStatus safeRun(IProgressMonitor monitor) throws Exception {
		SubMonitor progress = SubMonitor.convert(monitor, modelUris.size()+2);
		SiDiffResourceSet resourceSet = SiDiffResourceSet.create("sim");
		SuperimposedModel superimposedModel = loadOrCreateSuperimposedModel(resourceSet, superimposedUri, progress.split(1));
		SuperimpositionModelImporter importer = new SuperimpositionModelImporter();
		importer.init(superimposedModel);
		for(URI uri : modelUris) {
			Resource resource = resourceSet.getResource(uri, true);
			importer.importResource(resource, EntitiesUtil.createModelAnnotation(uri));
			progress.worked(1);
		}
		saveSuperimposedModel(resourceSet, superimposedModel, progress.split(1));
		return Status.OK_STATUS;
	}
}
