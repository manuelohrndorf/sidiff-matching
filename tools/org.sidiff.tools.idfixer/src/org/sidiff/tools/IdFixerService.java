/**
 * 
 */
package org.sidiff.tools;

import org.sidiff.common.services.ContextSensitiveService;
import org.sidiff.common.services.Service;

/**
 * This class implements the core algorithm for ID fixing based on correspondences.
 * It can be used for fixing the UUIDs of elements 
 * 
 * This service requires:
 * - a correspondences service
 * 
 * @author dreuling
 */

public interface IdFixerService extends ContextSensitiveService, Service {

	public void fixIDs();
	

}
