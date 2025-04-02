package org.sidiff.superimposition.importer.visitor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.sidiff.entities.Annotation;
import org.sidiff.entities.Element;
import org.sidiff.entities.importer.visitor.AnnotatingImporterVisitor;
import org.sidiff.superimposition.SuperimposedElement;

/**
 * An {@link AnnotatingImporterVisitor} that additionally initializes
 * {@link SuperimposedElement#getObjectAnnotations()} with all EObjects and the annotation.
 * @author rmueller
 */
public class SuperimpositionAnnotatingImporterVisitor extends AnnotatingImporterVisitor {

	public SuperimpositionAnnotatingImporterVisitor(Annotation annotation) {
		super(annotation);
	}

	@Override
	public void visitElement(Element element) {
		super.visitElement(element);
		if(element instanceof SuperimposedElement) {
			SuperimposedElement superimposedElement = (SuperimposedElement)element;
			for(EObject object : superimposedElement.getObjects()) {
				EList<Annotation> list = superimposedElement.getObjectAnnotations().get(object);
				if(list == null) {
					list = new UniqueEList<>();
					list.add(getAnnotation());					
					superimposedElement.getObjectAnnotations().put(object, list);
				} else {
					list.add(getAnnotation());					
				}
			}
		}
	}
}
