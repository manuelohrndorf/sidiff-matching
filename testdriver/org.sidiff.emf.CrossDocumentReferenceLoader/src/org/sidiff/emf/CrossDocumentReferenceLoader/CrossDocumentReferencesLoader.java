package org.sidiff.emf.CrossDocumentReferenceLoader;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.sidiff.common.emf.CrossDocumentReferenceUtil;
import org.sidiff.difference.asymmetric.AsymmetricDifference;
import org.sidiff.difference.asymmetric.AsymmetricPackage;

/**
 * This Class shows by example how resources can be loaded completely free from eProxy-URIs
 * in case the resource has so called cross document references; i.e., it is referencing other resources.
 * In this example, an asymmetric difference resource references a symmetric difference resource and the
 * differentiated ecore model resources.
 * 
 * @author mrindt
 *
 */
public class CrossDocumentReferencesLoader {

	private static String asymmPlatformResourcePath = "platform:/resource/org.sidiff.emf.CrossDocumentReferenceLoader/models/gmfgen_1.141_x_gmfgen_1.142_UUIDMatcher_lifted_post-processed.asymmetric";
	
	private static String asymmAbsoluteFileSchemaPath ="file:/home/michaela/workspace/diff2Trace/org.sidiff.emf.CrossDocumentReferenceLoader/models/gmfgen_1.141_x_gmfgen_1.142_UUIDMatcher_lifted_post-processed.asymmetric";
	private static String symmAbsoluteFileSchemaPath = "file:/home/michaela/workspace/diff2Trace/org.sidiff.emf.CrossDocumentReferenceLoader/models/gmfgen_1.141_x_gmfgen_1.142_UUIDMatcher_lifted_post-processed.symmetric";
	private static String modelAAbsoluteFileSchemaPath = "file:/home/michaela/workspace/diff2Trace/org.sidiff.emf.CrossDocumentReferenceLoader/models/gmfgen_1.141.ecore";
	private static String modelBAbsoluteFileSchemaPath = "file:/home/michaela/workspace/diff2Trace/org.sidiff.emf.CrossDocumentReferenceLoader/models/gmfgen_1.142.ecore";
	
	public AsymmetricDifference load() {
				
		// Initialize the core Package of the resource
		AsymmetricPackage.eINSTANCE.eClass();		
		
		ResourceSet resourceSet = null;
		AsymmetricDifference asymm = null;
		
		// Possibility 1
		resourceSet = possiblity1();
		
		// Possibility 2
		resourceSet = possibility2();
		
		asymm = (AsymmetricDifference) resourceSet.getResources().get(0).getContents().get(0);

		return asymm;
	}
	
	private ResourceSet possiblity1() {
		try {
			return CrossDocumentReferenceUtil.loadResourceWithCrossDocumentReferences(URI.createURI(asymmPlatformResourcePath), URI.createURI(asymmAbsoluteFileSchemaPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private ResourceSet possibility2() {
		Set<URI> crossReferencedFileURIs = new HashSet<URI>();
		crossReferencedFileURIs.add(URI.createURI(symmAbsoluteFileSchemaPath));
		crossReferencedFileURIs.add(URI.createURI(modelAAbsoluteFileSchemaPath));
		crossReferencedFileURIs.add(URI.createURI(modelBAbsoluteFileSchemaPath));
		try {
			return CrossDocumentReferenceUtil.loadResourceWithCrossDocumentReferences(URI.createURI(asymmAbsoluteFileSchemaPath), crossReferencedFileURIs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
