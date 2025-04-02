package org.sidiff.superimposition.exporter;

import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Reference;
import org.sidiff.entities.exporter.EntitiesExporter;
import org.sidiff.entities.exporter.annotations.IAnnotationsExporter;
import org.sidiff.entities.exporter.filter.DefaultExporterFilter;
import org.sidiff.entities.exporter.filter.IExporterFilter;
import org.sidiff.superimposition.SuperimposedModel;

/**
 * The Superimposition Model Exporter exports a {@link SuperimposedModel},
 * creating instances of all the superimposed elements, as well as their
 * attributes and references. It also optionally exports the annotations using
 * an {@link org.sidiff.entities.exporter.annotations.AnnotationsExporter AnnotationsExporter}.
 * @author rmueller
 */
public class SuperimpositionModelExporter extends EntitiesExporter {

	private SuperimposedModel superimposedModel;
	private IAnnotationsExporter annotationsExporter;
	private IExporterFilter filter;

	public SuperimpositionModelExporter(SuperimposedModel superimposedModel) {
		this.superimposedModel = Objects.requireNonNull(superimposedModel, "superimposedModel is null");
	}

	public void setAnnotationsExporter(IAnnotationsExporter annotationsExporter) {
		this.annotationsExporter = annotationsExporter;
	}
	
	public IAnnotationsExporter getAnnotationsExporter() {
		return annotationsExporter;
	}

	public void setFilter(IExporterFilter filter) {
		this.filter = Objects.requireNonNull(filter, "filter is null");
	}

	public IExporterFilter getFilter() {
		if(filter == null) {
			filter = new DefaultExporterFilter();
		}
		return filter;
	}

	protected Stream<EObject> exportModel(IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Exporting model", 10);
		superimposedModel.getEntities(getFilter()).forEach(entity -> {
			if(entity instanceof Element) {
				exportElement((Element)entity);
			} else if(entity instanceof Reference) {
				exportReference((Reference)entity);
			} else if(entity instanceof Attribute) {
				exportAttribute((Attribute)entity);
			}
		});
		progress.worked(1);
		
		return createAllEntities(progress.split(9));
	}

	protected void exportAnnotations(IProgressMonitor monitor) {
		if(annotationsExporter != null) {
			annotationsExporter.exportAnnotations(getExportedObjectsMap());
		}
	}

	public void export(Resource resource, IProgressMonitor monitor) {
		SubMonitor progress = SubMonitor.convert(monitor, "Exporting model and annotations", 10);
		clearAllEntities();
		exportModel(progress.split(9)).forEach(resource.getContents()::add);
		exportAnnotations(progress.split(1));
	}
}
