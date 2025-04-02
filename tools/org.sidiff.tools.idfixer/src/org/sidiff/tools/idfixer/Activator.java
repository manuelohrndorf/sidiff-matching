package org.sidiff.tools.idfixer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.services.ServiceHelper;
import org.sidiff.tools.IdFixerService;


public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		ServiceHelper.registerService(context, IdFixerService.class, new IdFixerServiceImpl(), null, null);
	}

	public void stop(BundleContext context) throws Exception {
	}

}
