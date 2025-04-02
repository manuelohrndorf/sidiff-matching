package org.sidiff.entities.importer.signature;

import org.sidiff.entities.Attribute;
import org.sidiff.entities.Element;
import org.sidiff.entities.Entity;
import org.sidiff.entities.Reference;

/**
 * <p>Abstract importer signature resolver that resolves signatures
 * for references and attributes by using the signatures of the
 * respective elements and the reference/attribute type.</p>
 * <p>{@link #computeSignature(Element)} should be implemented to
 * generate the signature for elements.</p>
 * @author rmueller
 */
public abstract class AbstractImporterSignatureResolver implements IImporterSignatureResolver {

	@Override
	public String computeSignature(Entity entity) {
		if(entity instanceof Element) {
			return computeSignature((Element)entity);
		} else if(entity instanceof Reference) {
			Reference reference = (Reference)entity;
			return String.format("%s/%s/%s",
					reference.getSource().getSignature(),
					reference.getType().getName(),
					reference.getTarget().getSignature());
		} else if(entity instanceof Attribute) {
			Attribute attribute = (Attribute)entity;
			return String.format("%s/%s/%s",
					attribute.getContainer().getSignature(),
					attribute.getType().getName(),
					attribute.getValue());
		}
		throw new AssertionError("entity: " + entity);
	}

	/**
	 * Computes and returns a signature for the element.
	 * @param element the element
	 * @return signature
	 */
	public abstract String computeSignature(Element element);
}
