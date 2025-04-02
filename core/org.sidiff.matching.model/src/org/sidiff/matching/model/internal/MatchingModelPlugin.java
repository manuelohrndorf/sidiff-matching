package org.sidiff.matching.model.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.matching.model.Correspondence;
import org.sidiff.matching.model.Matching;
import org.sidiff.matching.model.util.CorrespondenceStringResolver;
import org.sidiff.matching.model.util.MatchingStringResolver;

public class MatchingModelPlugin extends EMFPlugin implements BundleActivator {

	private static MatchingModelPlugin INSTANCE;
	private static EclipsePlugin plugin;

	public MatchingModelPlugin() {
		super(new ResourceLocator [] {});
	}
	
	public static MatchingModelPlugin getInstance(){
		return INSTANCE;
	}

	private static final Map<String, String> URIMAP = new HashMap<String, String>();

	static {
		URIMAP.put("http://www.sidiff.org/org.sidiff.core.correspondences.model","platform:/resource/org.sidiff.core.correspondences.model/model/MatchingModel.ecore");
	}

	@Override
	public void start(BundleContext context) throws Exception {
		INSTANCE = this;

		StringUtil.addStringResolver(new MatchingStringResolver());
		StringUtil.addStringResolver(new CorrespondenceStringResolver());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		StringUtil.removeStringResolver(Matching.class);
		StringUtil.removeStringResolver(Correspondence.class);
	}

	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	public static class GmdPluginImpl extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public GmdPluginImpl() {
			super();
	
			// Remember the static instance.
			//
			plugin = this;
		}
	}
}
