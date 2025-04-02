package org.sidiff.debugger.db.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.io.ResourceUtil;
import org.sidiff.common.services.debug.SiDiffDebugger;
import org.sidiff.debugger.db.SidiffEventLogger;

public class Activator implements BundleActivator
{
	private static BundleContext context;

	static BundleContext getContext()
	{
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception
	{
		Activator.context = bundleContext;
		ResourceUtil.registerClassLoader(Activator.class.getClassLoader());
		SiDiffDebugger.addDebugger("DBDebugger", SidiffEventLogger.getInstance());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception
	{
		Activator.context = null;
	}
}
