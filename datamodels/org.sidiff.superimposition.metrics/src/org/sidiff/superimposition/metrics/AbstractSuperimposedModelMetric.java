package org.sidiff.superimposition.metrics;

import org.sidiff.common.emf.metrics.defaults.AbstractModelElementMetric;
import org.sidiff.superimposition.SuperimposedModel;

public abstract class AbstractSuperimposedModelMetric extends AbstractModelElementMetric<SuperimposedModel> {

	public AbstractSuperimposedModelMetric() {
		super(SuperimposedModel.class);
	}
}
