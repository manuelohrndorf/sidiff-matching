package org.sidiff.domain.uml.metrics;

import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.emf.metrics.IMetricValueAcceptor;
import org.sidiff.common.emf.metrics.defaults.AbstractResourceMetric;

public class RatioOfAbstractToConcreteClasses extends AbstractResourceMetric {

	@Override
	protected void doCalculate(Resource resource, IMetricValueAcceptor acceptor, IProgressMonitor monitor) {
		Map<Boolean,Long> classCounts =
			CollectionUtil.asStream(resource.getAllContents())
				.filter(org.eclipse.uml2.uml.Class.class::isInstance)
				.map(org.eclipse.uml2.uml.Class.class::cast)
				.collect(Collectors.groupingBy(org.eclipse.uml2.uml.Class::isAbstract, Collectors.counting()));
		acceptor.accept(classCounts.getOrDefault(true, 0L) / (double)classCounts.getOrDefault(false, 0L));		
	}
}