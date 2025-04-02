package org.sidiff.core.configurator.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.services.ServiceHelper;
import org.sidiff.core.configurator.ConfiguratorService;

public class Activator implements BundleActivator {
	
	public static final String ITERATIVE_BUNDLE_ID = "org.sidiff.core.matching.iterative";
	public static final String DEFAULT_SIM_BUNDLE_ID = "org.sidiff.core.similaritiescalculator.default";
	
	private static BundleContext context;
	
	public static BundleContext getContext(){
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		
		Activator.context = context;
		ServiceHelper.registerService(context, ConfiguratorService.class, new ConfiguratorServiceImpl(), null, ServiceHelper.DEFAULT);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {

		Activator.context=null;
	}

}
