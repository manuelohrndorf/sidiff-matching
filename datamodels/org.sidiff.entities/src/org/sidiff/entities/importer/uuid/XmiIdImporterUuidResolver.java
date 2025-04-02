package org.sidiff.entities.importer.uuid;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.entities.Element;
import org.sidiff.entities.IdentifiableEntity;

/**
 * <p>Importer UUID resolver that uses the <code>xmi:id</code> of the
 * object of {@link Element}s (if present) and otherwise generates new UUIDs.</p>
 * <p>The resolver optionally sets the <code>xmi:id</code> of the object
 * to a generated UUID, if no <code>xmi:id</code> is set.
 * Note that this requires that the resource containing the object be
 * saved after importing or else the objects cannot be resolved later.</p>
 * @author rmueller
 */
public class XmiIdImporterUuidResolver implements IImporterUuidResolver {

	private boolean setXmiIds;

	/**
	 * Creates a new UUID resolver.
	 * @param setXmiIds whether to set the <code>xmi:id</code> of the objects,
	 * to a generated UUID when no <code>xmi:id</code> is available
	 */
	public XmiIdImporterUuidResolver(boolean setXmiIds) {
		this.setXmiIds = setXmiIds;
	}

	@Override
	public String computeUuid(IdentifiableEntity entity) {
		String xmiId = null;
		if(entity instanceof Element) {
			xmiId = EMFUtil.getXmiId(((Element)entity).getObject());
		}
		if(xmiId == null) {
			xmiId = EcoreUtil.generateUUID();
			if(setXmiIds && entity instanceof Element && !((Element)entity).isExternal()) {
				EMFUtil.setXmiId(((Element)entity).getObject(), xmiId);
			}
		}
		return xmiId;
	}
}
