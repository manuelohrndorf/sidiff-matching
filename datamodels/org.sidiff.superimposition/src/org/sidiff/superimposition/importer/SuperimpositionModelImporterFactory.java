package org.sidiff.superimposition.importer;

import org.sidiff.entities.importer.factory.AbstractImporterFactory;
import org.sidiff.superimposition.SuperimposedElement;
import org.sidiff.superimposition.SuperimpositionModelFactory;

/**
 * @author rmueller
 */
public class SuperimpositionModelImporterFactory extends AbstractImporterFactory<SuperimposedElement> {

	@Override
	public SuperimposedElement createElement() {
		return SuperimpositionModelFactory.eINSTANCE.createSuperimposedElement();
	}
}