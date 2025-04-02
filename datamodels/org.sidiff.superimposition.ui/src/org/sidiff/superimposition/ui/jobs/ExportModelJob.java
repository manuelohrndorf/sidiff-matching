package org.sidiff.superimposition.ui.jobs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.modelstorage.SiDiffResourceSet;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.exporter.SuperimpositionModelExporter;

/**
 * 
 * @author rmueller
 */
public final class ExportModelJob extends AbstractSuperimpositionJob {

	private URI superimposedUri;
	private SuperimposedModel superimposedModel;

	private URI outputUri;
	private Resource exportedResource;
	private boolean saveExported;

	public ExportModelJob() {
		super("Exporting Superimposition Model");
	}

	@Override
	protected IStatus safeRun(IProgressMonitor monitor) throws Exception {
		Assert.isLegal(superimposedModel != null || superimposedUri != null,
				"either superimposedModel or superimposedUri must be set");
		Assert.isLegal(outputUri != null || exportedResource != null,
				"either outputUri or exportedResource must be set");
		
		SiDiffResourceSet resourceSet = SiDiffResourceSet.create("sim");
		SubMonitor progress = SubMonitor.convert(monitor,
				60 + (superimposedModel == null ? 20 : 0) + (saveExported ? 20 : 0));
		if(superimposedModel == null) {
			superimposedModel = loadSuperimposedModel(resourceSet, superimposedUri, progress.split(20));			
		}

		if(exportedResource == null) {
			exportedResource = resourceSet.createResource(outputUri);			
		}

		SuperimpositionModelExporter exporter = new SuperimpositionModelExporter(superimposedModel);
		exporter.export(exportedResource, progress.split(60));

		if(saveExported) {
			saveExportedModel(resourceSet, exportedResource, progress.split(20));
		}

		return Status.OK_STATUS;
	}

	private void saveExportedModel(SiDiffResourceSet resourceSet, Resource resource, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Saving exported model", 1);
		resourceSet.saveResource(resource);
		progress.worked(1);
	}
	
	public ExportModelJob setSuperimposedModel(SuperimposedModel superimposedModel) {
		this.superimposedModel = superimposedModel;
		return this;
	}
	
	public ExportModelJob setSuperimposedUri(URI superimposedUri) {
		this.superimposedUri = superimposedUri;
		return this;
	}
	
	public ExportModelJob setSaveExportedResource(boolean saveExported) {
		this.saveExported = saveExported;
		return this;
	}

	public ExportModelJob setExportedResource(Resource exportedResource) {
		this.exportedResource = exportedResource;
		return this;
	}

	public ExportModelJob setOutputUri(URI outputUri) {
		this.outputUri = outputUri;
		return this;
	}
	
	public Resource getExportedResource() {
		return exportedResource;
	}
}