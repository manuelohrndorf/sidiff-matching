package org.sidiff.superimposition.metrics.defaults;

import java.util.Collections;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.sidiff.common.emf.metrics.IMetricValueAcceptor;
import org.sidiff.entities.Element;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.metrics.AbstractSuperimposedModelMetric;

public class ElementTypeCounting extends AbstractSuperimposedModelMetric {

	@Override
	protected void doCalculate(SuperimposedModel context, IMetricValueAcceptor acceptor, IProgressMonitor monitor) {
		context.getElements().stream()
			.collect(Collectors.groupingBy(Element::getType, Collectors.counting()))
			.entrySet().stream().forEach(entry -> acceptor.accept(Collections.singleton(entry.getKey()), entry.getValue()));
	}
}
