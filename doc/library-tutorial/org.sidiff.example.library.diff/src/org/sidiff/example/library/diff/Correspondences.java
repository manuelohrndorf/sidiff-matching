package org.sidiff.example.library.diff;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.collections.ViewUtil;
import org.sidiff.common.emf.collections.EMFSelectors;
import org.sidiff.common.util.StringUtil;
import org.sidiff.core.correspondences.CorrespondencesService;

public class Correspondences {

	private CorrespondencesService correspondences = null;
	private Resource modelA=null;
	private Resource modelB=null;
	
	Correspondences(CorrespondencesService cservice,Resource modelA,Resource modelB) {
	
		assert(cservice!=null&&modelA!=null&&modelB!=null&&modelA!=modelB) : "Internal Error: Invalid constructor arguments!";
		
		this.correspondences= cservice;
		this.modelA=modelA;
		this.modelB=modelB;
	}

	/**
	 * This function returns the set of objects from left or right file for which there
	 * are corresponding matching objects in right or left file.
	 * 
	 * @return Returns the set of objects from left or right file for which
	 *         there are corresponding matching objects in right file.
	 */
	public Iterable<EObject> getMatchedFrom(Resource model) {
		
		assert(model==modelA||model==modelB) : "Invalid Argument: Unrelated Resource!";
		
		return correspondences.getElementsWithCorrespondences(model);
	}

	/**
	 * This function returns the set of objects of type classType from right
	 * file for which there are corresponding matching objects in left file.
	 * 
	 * @param classType
	 *            Type of the class for which the matching objects are required.
	 * @return set of objects of type classType from right file for which there
	 *         are corresponding matching objects in left file.
	 */
	public Iterable<EObject> getMatchedFrom(Resource model, EClass eclass) {
		
		assert(model==modelA||model==modelB) : "Invalid Argument: Unrelated Resource!";
		assert(eclass!=null) : "Invalid Argument: class cannot be null";
		
		return ViewUtil.filteredCollectionView(
				this.correspondences.getElementsWithCorrespondences(model),
				EMFSelectors.byClass(eclass),
				true);
	}

	/**
	 * This function takes the object from right file and returns the matching
	 * partner from left file.
	 * 
	 * @param objectFromB
	 *            The object from right file for which matching partner from
	 *            left file is required.
	 * @return Returns the corresponding matching partner.
	 */
	public EObject getPartner(EObject object) {
		
		assert(object.eResource()==modelA||object.eResource()==modelB) : "Invalid Argument: Unrelated object!";
		
		EObject result = null;

		Collection<EObject> correspondingElements = this.correspondences.getCorrespondences(object);
		
		assert(correspondingElements.isEmpty()||correspondingElements.size()==1) : 
			("More then one corresponding Element!\n"+object+"->"+StringUtil.resolve(correspondingElements));
		
		if(!correspondingElements.isEmpty()){
			result= correspondingElements.iterator().next();
		}
		return result;
	}

	/**
	 * This function returns the set of objects from left file for which there
	 * are no corresponding matching objects in right file.
	 * 
	 * @return Returns the set of objects from left file for which there are no
	 *         corresponding matching objects in right file.
	 */
	public Iterable<EObject> getUnmatchedFrom(Resource model) {
		
		assert(model==modelA||model==modelB) : "Invalid Argument: Unrelated Resource!";
		
		return correspondences.getElementsWithoutCorrespondences(model);
	}

	/**
	 * This function returns the set of objects of type classType from right
	 * file for which there are no corresponding matching objects in left file.
	 * 
	 * @param eclass
	 *            Type of the class for which the non matching objects are
	 *            required.
	 * @return set of objects of type classType from right file for which there
	 *         are no corresponding matching objects in left file.
	 */
	public Iterable<EObject> getUnmatchedFrom(Resource model, EClass eclass) {
		
		assert(model==modelA||model==modelB) : "Invalid Argument: Unrelated Resource!";
		assert(eclass!=null) : "Invalid Argument: class cannot be null";
		
		
		return ViewUtil.filteredCollectionView(
				this.correspondences.getElementsWithoutCorrespondences(model),
				EMFSelectors.byClass(eclass),
				true);
	}

	/**
	 * This function accepts two objects, returns the status of comparison.
	 * 
	 * @param objectFromA
	 *            The object from left or right file for which we want to know whether it
	 *            got a matching partner or not.
	 * @param objectFromB
	 *            The object from right or left file for which we want to know whether
	 *            it got a matching partner or not.
	 * @return Returns "true" if the objectFromA and objectFromB are the
	 *         matching partners. Otherwise "false".
	 */
	public boolean isMatched(EObject objectX, EObject objectY) {
		
		assert(((objectX.eResource()==modelA&&objectY.eResource()==modelB)
		      ||(objectY.eResource()==modelA&&objectX.eResource()==modelB))) : "Invalid Argument: Unrelated object or same Resource!";
		
		return this.correspondences.isCorresponding(objectX,objectY);
	}

	/**
	 * This function indicates whether the passed object got a coressponding
	 * matching partner or not.
	 * 
	 * @param eObject
	 *            The object from left/right file for which we want to know
	 *            whether it got a matching partner or not.
	 * @return Returns "true" if the eObject has the coressponding
	 *         matching partners. Otherwise "false".
	 */
	public boolean hasMatch(EObject eObject) {

		assert(eObject.eResource()==modelA||eObject.eResource()==modelB) : "Invalid Argument: Unrelated object!";
		
		return this.correspondences.hasCorrespondences(eObject);
	}

	public int matched() {
		
		assert(this.correspondences.getElementsWithCorrespondences(modelA).size()
			 ==this.correspondences.getElementsWithCorrespondences(modelB).size()) : "Unequal matchsize!";
		
		return this.correspondences.getElementsWithCorrespondences(modelA).size();
	}

	public int unmatchedIn(Resource model) {
		
		assert(model==modelA||model==modelB) : "Invalid Argument: Unrelated Resource!";
		
		return this.correspondences.getElementsWithoutCorrespondences(model).size();
	}

	/**
	 * Releases all allocated Resources adjunct to the Matching.
	 */
	public void dispose() {
		
		this.correspondences=null;
		this.modelA=null;
		this.modelB=null;
		System.gc();
	}
}