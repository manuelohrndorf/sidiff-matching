package org.sidiff.similaritiescalculation.configuration;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.emf.EMFMetaObjectExtender;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.similaritiescalculation.DefaultSimilaritiesCalculation;

/**
 * Hold the configuration for the similarity calculation.
 *
 */
public class CompareConfiguration {

	public final static float EPSILON = 0.0001f;

	private EPackage ePackage = null;
	private boolean normalizeWeights = true;

	private EMFMetaObjectExtender<TypeConfiguration> typeConfigurations = null;

	public CompareConfiguration(EPackage ePackage) {

		if (ePackage != null) {
			this.ePackage = ePackage;
			this.typeConfigurations = new EMFMetaObjectExtender<TypeConfiguration>(ePackage);
		} else {
			throw new IllegalArgumentException("Package cannot be null!");
		}
	}

	public TypeConfiguration getTypeConfiguration(EClass eClass) {

		TypeConfiguration typeconfig = this.typeConfigurations.getDataByMetaObject(eClass);
		if (typeconfig != null) {
			return typeconfig;
		} else {
			// assert(LogUtil.log(LogEvent.DEBUG, "No configuration found for
			// '"+eClass.getName()+"'"));
			for (EClass eSuperType : eClass.getESuperTypes()) {
				try {
					if (!eSuperType.isInterface()) {
						// assert(LogUtil.log(LogEvent.DEBUG, "lookup superclass
						// '"+eClass.getName()+"->"+eSuperType+"'"));
						return getTypeConfiguration(eSuperType);
					}
				} catch (/* SiDiffRuntimeException */ Exception e) {
				}
			}
			throw new SiDiffRuntimeException(this, "\nNo Configuration found for " + eClass.getName());
		}
	}

	TypeConfiguration addTypeConfiguration(TypeConfiguration configuration) {
		float sum = DefaultSimilaritiesCalculation.computeSumOfWeights(configuration.getCompareFunctions());
		// Warnings
		assert(isNormalizeWeights() || ((Math.abs((sum - 1.0f)) > CompareConfiguration.EPSILON)
				? LogUtil.log(LogEvent.WARNING, "No normalization: Sum of weight (then) isn't 1.0(" + sum + ") (Type: "
						+ configuration.getType().getName() + ")")
				: true));
		return this.typeConfigurations.putData(configuration.getType(), configuration);

	}

	public EPackage getConfiguredEPackage() {

		return this.ePackage;
	}

	public boolean isNormalizeWeights() {

		return this.normalizeWeights;
	}

	void setNormalizeWeights(boolean normalizeWeights) {

		this.normalizeWeights = normalizeWeights;
	}

}
