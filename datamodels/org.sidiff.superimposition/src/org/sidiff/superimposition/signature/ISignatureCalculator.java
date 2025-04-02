package org.sidiff.superimposition.signature;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.*;
import org.sidiff.common.extension.ExtensionManager;
import org.sidiff.common.extension.IExtension;
import org.sidiff.superimposition.signature.impl.DefaultSignatureCalculatorModelAccessor;

/**
 *
 * @author cpietsch
 *
 */
public interface ISignatureCalculator extends IExtension {

	Description<ISignatureCalculator> DESCRIPTION = Description.of(ISignatureCalculator.class,
			"org.sidiff.superimposition.signature_calculator_extension", "signature_calculator", "class");
	ExtensionManager<ISignatureCalculator> MANAGER = new SignatureCalculatorExtensionManager(DESCRIPTION);

	String calculateSignature(EObject eObject, IModelAccessor modelAccessor, IDelegator delegator);

	default String calculateSignature(EObject eObject, IModelAccessor modelAccessor) {
		return calculateSignature(eObject, modelAccessor, IDelegator.noDelegation());
	}

	default String calculateSignature(EObject eObject) {
		return calculateSignature(eObject, IModelAccessor.DEFAULT, IDelegator.noDelegation());
	}

	/**
	 * The model accessor interface abstracts the access to an EObject's properties
	 * to allow other implementations to replace or extend the default Ecore mechanism.
	 * @see #DEFAULT
	 * @author rmueller
	 */
	interface IModelAccessor {
		String getSignatureName(EObject eObject);
		EObject getContainer(EObject eObject);
		List<EObject> getReferenceTargets(EObject eObject, EReference reference);
		default EObject getReferenceTarget(EObject eObject, EReference reference) {
			Assert.isLegal(reference.getUpperBound() == 1);
			return getReferenceTargets(eObject, reference).stream().findFirst().orElse(null);
		}
		EClass getType(EObject eObject);

		/**
		 * Singleton default model accessor which supports the Ecore meta model
		 * and SuperimposedElements in a SuperimposedModel.
		 */
		IModelAccessor DEFAULT = new DefaultSignatureCalculatorModelAccessor();
	}

	/**
	 * @author rmueller
	 */
	interface IDelegator {

		String delegateCalculateSignature(EObject eObject, IModelAccessor modelAccessor);

		static IDelegator noDelegation() {
			return (eObject, modelAccessor) -> null;
		}

		static IDelegator delegateToFirstOf(List<ISignatureCalculator> calculators) {
			if (calculators.isEmpty()) {
				return noDelegation();
			}
			return (eObject, modelAccessor) -> {
				for (ISignatureCalculator calculator : calculators) {
					String signature = calculator.calculateSignature(eObject, modelAccessor, delegateToOther(calculator, calculators));
					if(signature != null && !signature.isEmpty()) {
						return signature;
					}
				}
				return null;
			};
		}

		static IDelegator delegateToOther(ISignatureCalculator calculator, List<ISignatureCalculator> calculators) {
			return delegateToFirstOf(
					calculators.stream()
						.filter(Predicate.isEqual(calculator).negate())
						.collect(Collectors.toList()));
		}
	}
}
