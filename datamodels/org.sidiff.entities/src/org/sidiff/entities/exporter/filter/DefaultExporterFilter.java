package org.sidiff.entities.exporter.filter;

import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;

/**
 * The default exporter filter accepts all entities, 
 * except all dynamic ecore objects (e.g., EGenericType instances used
 * for delegating references to EClassifier instances).
 * Neither outgoing nor incoming references are followed.
 * @author rmueller
 * @author Dennis Reuling
 */
public class DefaultExporterFilter implements IExporterFilter {

	@Override
	public boolean isExported(Entity entity) {
		if(entity instanceof Element) {
			Element element = (Element)entity;
			if(element.getObject() != null) {
				return !EMFUtil.isDynamic(element.getObject());
			}
		} else if(entity instanceof Reference) {
			Reference ref = (Reference)entity;
			return isExported(ref.getSource()) && isExported(ref.getTarget());
		} else if(entity instanceof Attribute) {
			Attribute attr = (Attribute)entity;
			return isExported(attr.getContainer());
		}
		return true;
	}

	@Override
	public boolean followOutgoing(Reference reference) {
		return false;
	}

	@Override
	public boolean followIncoming(Reference reference) {
		return false;
	}
}
