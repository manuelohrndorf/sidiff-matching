package org.sidiff.example.library.diff;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.sidiff.common.io.ResourceUtil;



/**
 * The activator class controls the plug-in life cycle
 * 
 * @author kehrer
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.sidiff.example.library.diff";

	// The bundle context
	private static BundleContext context=null;
	
	@Override
	public void start(BundleContext context) throws Exception {
		
		assert(Activator.context==null) : "Singelton already Initialized??!";
		Activator.context = context;
		ResourceUtil.registerClassLoader(this.getClass().getClassLoader());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		Activator.context = null;
		ResourceUtil.unregisterClassLoader(this.getClass().getClassLoader());
	}
	
	public static BundleContext getContext(){
		return Activator.context;
	}

}
