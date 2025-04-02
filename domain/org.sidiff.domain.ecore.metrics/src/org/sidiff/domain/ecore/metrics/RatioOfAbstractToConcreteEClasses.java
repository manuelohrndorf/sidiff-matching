package org.sidiff.domain.ecore.metrics;

import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.emf.metrics.IMetricValueAcceptor;
import org.sidiff.common.emf.metrics.defaults.AbstractResourceMetric;

public class RatioOfAbstractToConcreteEClasses extends AbstractResourceMetric {

	@Override
	protected void doCalculate(Resource resource, IMetricValueAcceptor acceptor, IProgressMonitor monitor) {
		Map<Boolean,Long> classCounts =
			CollectionUtil.asStream(resource.getAllContents())
				.filter(EClass.class::isInstance)
				.map(EClass.class::cast)
				.collect(Collectors.groupingBy(EClass::isAbstract, Collectors.counting()));
		acceptor.accept(classCounts.getOrDefault(true, 0L) / (double)classCounts.getOrDefault(false, 0L));		
	}
}