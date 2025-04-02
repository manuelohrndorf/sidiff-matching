package org.sidiff.domain.uml.metrics;

import java.util.Collections;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.UMLPackage;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.metrics.IMetricValueAcceptor;
import org.sidiff.common.emf.metrics.defaults.AbstractResourceMetric;

public class NumberOfElementsAndProperties extends AbstractResourceMetric {

	@Override
	protected void doCalculate(Resource context, IMetricValueAcceptor acceptor, IProgressMonitor monitor) {
		CollectionUtil.asStream(context.getAllContents())
			.filter(o -> !EMFUtil.isDynamic(o))
			.collect(Collectors.groupingBy(this::classify, Collectors.counting()))
			.forEach((key, value) -> acceptor.accept(Collections.singleton(key), value));
	}

	protected String classify(EObject obj) {
		EClass eClass = obj.eClass();
		if(eClass == UMLPackage.Literals.CLASS
			|| eClass == UMLPackage.Literals.PACKAGE
			|| eClass == UMLPackage.Literals.DATA_TYPE
			|| eClass == UMLPackage.Literals.PRIMITIVE_TYPE
			|| eClass == UMLPackage.Literals.ENUMERATION) {
			return "Element";
		}
		return "Property";
	}
}
