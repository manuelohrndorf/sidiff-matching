package org.sidiff.superimposition.signature.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.superimposition.signature.ISignatureCalculator;

/**
 * Signature calculator which uses the extrinsic XMI ID as signature.
 * If no ID is available, a random one is generated.
 * @author dreuling
 *
 */
public class XMIIDSignatureCalculator implements ISignatureCalculator {

	@Override
	public String calculateSignature(EObject eObject, IModelAccessor modelAccessor, IDelegator delegator) {
		String xmiID = EMFUtil.getXmiId(eObject);

		//If there is no ID, we just randomly generate a new one
		if(xmiID == null) {
			xmiID = EcoreUtil.generateUUID();
		}
		return xmiID;
	}

	@Override
	public String getKey() {
		return "XMIID";
	}

	@Override
	public String getName() {
		return "XMI-ID Signature Calculator";
	}
}
