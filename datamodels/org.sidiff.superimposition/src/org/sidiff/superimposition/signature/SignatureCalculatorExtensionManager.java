package org.sidiff.superimposition.signature;

import java.util.Optional;

import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension.Description;
import org.sidiff.superimposition.signature.impl.DefaultSignatureCalculator;

/**
 * @author rmueller
 */
public class SignatureCalculatorExtensionManager extends ExtensionManager<ISignatureCalculator> {

	public SignatureCalculatorExtensionManager(Description<? extends ISignatureCalculator> description) {
		super(description);
	}

	@Override
	public Optional<? extends ISignatureCalculator> getDefaultExtension() {
		return getExtension(DefaultSignatureCalculator.class);
	}
}
