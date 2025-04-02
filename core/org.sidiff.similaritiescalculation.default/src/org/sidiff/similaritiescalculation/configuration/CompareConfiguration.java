package org.sidiff.similaritiescalculation.configuration;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.sidiff.common.emf.EMFMetaObjectExtender;
import org.sidiff.common.exceptions.SiDiffRuntimeException;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.comparefunctions.util.CompareFunctionUtil;
import org.sidiff.similaritiescalculation.DefaultSimilaritiesCalculation;

/**
 * Hold the configuration for the similarity calculation.
 *
 */
public class CompareConfiguration {

	public final static float EPSILON = 0.0001f;

	private DefaultSimilaritiesCalculation similaritiesCalculation;
	private EPackage ePackage;
	private boolean normalizeWeights = true;

	private EMFMetaObjectExtender<TypeConfiguration> typeConfigurations;

	public CompareConfiguration(DefaultSimilaritiesCalculation similaritiesCalculation, EPackage ePackage) {
		this.similaritiesCalculation = Objects.requireNonNull(similaritiesCalculation);
		this.ePackage = Objects.requireNonNull(ePackage);
		this.typeConfigurations = new EMFMetaObjectExtender<>(ePackage);
	}

	public TypeConfiguration getTypeConfiguration(EClass eClass) {
		TypeConfiguration typeconfig = typeConfigurations.getDataByMetaObject(eClass);
		if (typeconfig != null) {
			return typeconfig;
		}
		for (EClass eSuperType : eClass.getESuperTypes()) {
			try {
				if (!eSuperType.isInterface()) {
					return getTypeConfiguration(eSuperType);
				}
			} catch (Exception e) {
			}
		}
		throw new SiDiffRuntimeException("\nNo Configuration found for " + eClass.getName());
	}

	TypeConfiguration addTypeConfiguration(TypeConfiguration configuration) {
		float sum = CompareFunctionUtil.computeSumOfWeights(configuration.getCompareFunctions());
		// Warnings
		assert(isNormalizeWeights() || ((Math.abs((sum - 1.0f)) > CompareConfiguration.EPSILON)
				? LogUtil.log(LogEvent.WARNING, "No normalization: Sum of weight (then) isn't 1.0(" + sum + ") (Type: "
						+ configuration.getType().getName() + ")")
				: true));
		return typeConfigurations.putData(configuration.getType(), configuration);

	}

	public EPackage getConfiguredEPackage() {
		return ePackage;
	}

	public boolean isNormalizeWeights() {
		return normalizeWeights;
	}

	void setNormalizeWeights(boolean normalizeWeights) {
		this.normalizeWeights = normalizeWeights;
	}

	public DefaultSimilaritiesCalculation getSimilaritiesCalculation() {
		return similaritiesCalculation;
	}
}
