package org.sidiff.superimposition.emf.doctype;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.doctype.IDocumentTypeResolver;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.SuperimpositionModelPackage;

public class SuperimposedModelDocumentTypeResolver implements IDocumentTypeResolver {

	@Override
	public List<String> resolve(Resource resource) {
		EObject object = resource.getContents().get(0);
		if(object instanceof SuperimposedModel) {
			return ((SuperimposedModel)object).getDocType();
		}
		return null;
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(SuperimpositionModelPackage.eNS_URI);
	}
}
