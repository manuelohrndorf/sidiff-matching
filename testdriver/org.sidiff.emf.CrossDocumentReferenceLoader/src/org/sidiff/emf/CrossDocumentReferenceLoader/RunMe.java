package org.sidiff.emf.CrossDocumentReferenceLoader;

import org.sidiff.difference.asymmetric.AsymmetricDifference;

public class RunMe {

	public static void main(String[] args) {
		
		
		// Loading the existing model
		CrossDocumentReferencesLoader loader = new CrossDocumentReferencesLoader();
	    AsymmetricDifference asymdiff = loader.load();
	    // Accessing the model information
	    asymdiff.getSymmetricDifference();
	    
	    // Result: The symmetricDifference should not be eProxyURI anymore

	}

}
