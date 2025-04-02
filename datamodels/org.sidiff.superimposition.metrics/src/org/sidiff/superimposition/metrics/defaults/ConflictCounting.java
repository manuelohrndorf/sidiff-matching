package org.sidiff.superimposition.metrics.defaults;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.sidiff.common.emf.metrics.IMetricValueAcceptor;
import org.sidiff.entities.exporter.filter.DefaultExporterFilter;
import org.sidiff.superimposition.Conflict;
import org.sidiff.superimposition.ConflictSet;
import org.sidiff.superimposition.SuperimposedModel;
import org.sidiff.superimposition.conflict.detector.IConflictDetector;
import org.sidiff.superimposition.metrics.AbstractSuperimposedModelMetric;

public class ConflictCounting extends AbstractSuperimposedModelMetric {

	@Override
	protected void doCalculate(SuperimposedModel context, IMetricValueAcceptor acceptor, IProgressMonitor monitor) {
		List<IConflictDetector> detectors = IConflictDetector.MANAGER.getSortedExtensions();
		SubMonitor progress = SubMonitor.convert(monitor, detectors.size());
		ConflictSet conflictSet = context.createConflictSet(new DefaultExporterFilter());
		for(IConflictDetector detector : detectors) {
			detector.detectConflicts(conflictSet, progress.split(1));
		}
		conflictSet.getConflicts().stream()
			.collect(Collectors.groupingBy(Conflict::getId, Collectors.counting()))
			.entrySet().stream().forEach(entry -> acceptor.accept(Collections.singleton(entry.getKey()), entry.getValue()));
	}
}
