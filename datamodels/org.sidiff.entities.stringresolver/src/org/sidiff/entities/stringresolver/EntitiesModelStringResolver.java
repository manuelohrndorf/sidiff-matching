package org.sidiff.entities.stringresolver;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.stringresolver.AbstractStringResolver;
import org.sidiff.entities.Entity;
import org.sidiff.entities.IdentifiableEntity;

/**
 * An {@link IStringResolver} for {@link Entity Entities}.
 * @author rmueller
 */
public class EntitiesModelStringResolver extends AbstractStringResolver {

	@Override
	public String resolve(EObject eObject) {
		if (eObject instanceof Entity) {
			return ((Entity)eObject).getSignature();
		}
		return EMFUtil.getEObjectSignatureName(eObject);
	}

	@Override
	public String resolveQualified(EObject eObject) {
		if(eObject instanceof IdentifiableEntity) {
			return resolve(eObject) + "." + ((IdentifiableEntity)eObject).getUuid();
		}
		return resolve(eObject);
	}
}
