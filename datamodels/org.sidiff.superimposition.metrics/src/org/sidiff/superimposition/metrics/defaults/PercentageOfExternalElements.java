package org.sidiff.superimposition.metrics.defaults;

import org.eclipse.core.runtime.IProgressMonitor;
import org.sidiff.common.emf.metrics.IMetricValueAcceptor;
import org.sidiff.entities.Element;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.metrics.AbstractSuperimposedModelMetric;

public class PercentageOfExternalElements extends AbstractSuperimposedModelMetric {

	@Override
	protected void doCalculate(SuperimposedModel context, IMetricValueAcceptor acceptor, IProgressMonitor monitor) {
		long numExternal = context.getElements().stream().filter(Element::isExternal).count();
		acceptor.accept(numExternal / (double)context.getElements().size());
	}
}
