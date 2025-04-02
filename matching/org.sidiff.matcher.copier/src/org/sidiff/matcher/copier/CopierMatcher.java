package org.sidiff.matcher.copier;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.matcher.BaseMatcher;

/**
 * Concrete matcher stub that checks whether one element has
 * been created by copying another. If so, they are corresponding.
 * 
 * @author dreuling
 */
public class CopierMatcher extends BaseMatcher {
	
	private Copier copier;
	
	/**
	 * Initialize copier.
	 */
	public void setCopier(Copier copier) {
		this.copier = copier;
	}
	
	
	@Override
	protected void match() {
		
		if (getModels().size() != 2) {
			throw new UnsupportedOperationException(); // only two (copied) models allowed
		}		
		
		if (this.copier == null) {
			throw new UnsupportedOperationException(); // We need a copier first.
		}
		
		//We assume only two models 
		Iterator<Resource> it = getModels().iterator();
		Resource modelA = it.next();
		Resource modelB = it.next();
				
		//Match elements
		if(scope.equals(Scope.RESOURCE_SET)){
				for(Resource rA : modelA.getResourceSet().getResources()){
					for (EObject objA : EMFUtil.getAllContentAsIterable(rA)) {
						for(Resource rB : modelB.getResourceSet().getResources()){
							for (EObject objB : EMFUtil.getAllContentAsIterable(rB)) {
								if(this.getCandidatesService().isCandidate(objA,objB) && areCopies(objA, objB))
									this.getCorrespondencesService().addCorrespondence(objA,objB);
							}
					}
				}
			}			
		}
		else{
			for (EObject objA : EMFUtil.getAllContentAsIterable(modelA)) {
				for (EObject objB : EMFUtil.getAllContentAsIterable(modelB)) {
					if(this.getCandidatesService().isCandidate(objA,objB) && areCopies(objA, objB))
						this.getCorrespondencesService().addCorrespondence(objA,objB);
				}
			}
		}
	}
	
	private boolean areCopies(EObject elementA, EObject elementB){		
		
		// Both EObjects are corresponding if elementB has been created through copying elementA or vice versa.			
		EObject BfromA = this.copier.get(elementA);
		EObject AfromB = this.copier.get(elementB);		
		
		return ((BfromA != null && BfromA.equals(elementB)) ||
				(AfromB != null && AfromB.equals(elementA)));		
	}
	
	
	@Override
	public String getName() {
		return "Copier Matcher";
	}
	

	@Override
	public boolean isResourceSetCapable() {
		// is resourceSetCapable
		return true;
	}	
	

	@Override
	public String getDescription() {
		return "This matcher matches copied model elements.";
	}


	@Override
	public Set<String> getDocumentTypes() {
		Set<String> docTypes = new HashSet<String>();
		docTypes.add(EMFModelAccess.GENERIC_DOCUMENT_TYPE);
		return docTypes;
	}
}

