/**
 * 
 */
package org.sidiff.tools.idfixer;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.common.services.ServiceContext;
import org.sidiff.core.correspondences.CorrespondencesService;
import org.sidiff.tools.IdFixerService;

public class IdFixerServiceImpl implements IdFixerService {

	// Context of the IDFixer
	private ServiceContext serviceContext = null;

	// Resources used
	private Resource resourceA = null;
	private Resource resourceB = null;

	// Correspondences used
	private CorrespondencesService correspondencesService = null;

	@Override
	public void initialize(ServiceContext serviceContext, Object... params) {
		assert (this.serviceContext == null && correspondencesService == null
				&& resourceA == null && resourceB == null) : "Illegal initializion state!";
		assert (serviceContext != null) : "UUID-Fixer has to be initialized with valid ServiceContext (null)";
		assert (params.length == 2 && params[0] instanceof Resource && params[1] instanceof Resource) : "UUID-Fixer has to be initialized with two resources!";

		// Prepare local fields
		this.resourceA = (Resource) params[0];
		this.resourceB = (Resource) params[1];

		// Get Context
		this.serviceContext = serviceContext;

		// Fetch needed Services from Context
		this.correspondencesService = serviceContext
				.getService(CorrespondencesService.class);
	}

	/**
	 * Fixes the IDs of an element based on correspondences between two elements
	 * and overwrites the old ID with new one.
	 * 
	 * Example: 
	 * The executed matching defines the following correspondence
	 * because of the iterative matcher
	 * ElementA(ID:2) <-> ElementB(ID:3) 
	 * The ID of the left hand element (here 2) is used to overwrite 
	 * the the ID of the right hand element (here 3). The final result looks like: 
	 * ElementA(ID:2) <-> ElementB(ID:2)
	 * 
	 */

	public void fixIDs() {
		assert (serviceContext != null && correspondencesService != null) : "Invalid Initializion!";
		assert (resourceA != null && resourceB != null) : "Missing Model! (invalid initializion)";

		LogUtil.log(LogEvent.NOTICE, "Fixing IDs of matched elements...");

		int ctr = 0;

		// Get all elements of resouceA
		Iterator<EObject> iterator = this.resourceA.getAllContents();
		while (iterator.hasNext()) {
			EObject objA = iterator.next();
			// Get ID of current element
			String xmiIDA = EMFUtil.getEObjectID(objA);
			if (!xmiIDA.equals(null)) {
				// If the preceeded matching has found a correspondence for
				// current element the corresponding element is used as target
				if (this.correspondencesService.hasCorrespondences(objA)) {
					EObject objB = this.correspondencesService
							.getCorrespondences(objA).iterator().next();

					// Get ID of corresponding element
					String xmiIDB = EMFUtil.getEObjectID(objB);

					// If corresponding elements differ in their ID
					// the ID of the element of resourceB is overwritten
					// with the ID of the element of resourceA
					if (!xmiIDA.equals(xmiIDB)) {
						((XMIResource) this.resourceB).setID(objB, xmiIDA);
						LogUtil.log(LogEvent.DEBUG, "Changed ID: " + xmiIDB
								+ " -> " + xmiIDA);
						ctr++;
					}

				}
			}
		}

		// Save changed resourceB
		try {
			this.resourceB.save(Collections.EMPTY_MAP);

		} catch (IOException e) {

			e.printStackTrace();
		}

		LogUtil.log(LogEvent.NOTICE,
				"Fixing of IDs done!" + System.lineSeparator() + "Fixed " + ctr
						+ " IDs.");

	}

}
