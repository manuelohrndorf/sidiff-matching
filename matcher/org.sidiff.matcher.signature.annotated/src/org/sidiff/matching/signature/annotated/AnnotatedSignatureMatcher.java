package org.sidiff.matching.signature.annotated;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.annotation.IAnnotation;
import org.sidiff.common.collections.ValueMap;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.access.EMFModelAccess;
import org.sidiff.common.emf.access.Scope;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.common.logging.LogEvent;
import org.sidiff.common.logging.LogUtil;
import org.sidiff.matcher.SignatureBasedMatcher;
import org.sidiff.matcher.mode.MatcherMode;

public class AnnotatedSignatureMatcher extends SignatureBasedMatcher<String> implements MatchingContext {

	private String signatureKey = MatchingContext.PATH_ANNOTATION;
	private IAnnotation annotationService = null;

	@Override
	protected void init(Collection<Resource> models, Scope scope) {
		super.init(models, scope);
		if(!initAnnotation(models.iterator().next())) {
			throw new UnsupportedOperationException("Annotation configuration not set or could not be loaded/found.");			
		}
	}
	
	@Override
	public void reset() {
		super.reset();
		if(this.annotationService != null) {
			this.annotationService.reset();
		}
	}
	
	@Override
	protected ValueMap<String, EObject> calculateSignatures(Resource model) {
		this.annotationService.annotate(model);
		SignatureValueHarvester sigHarvesterModel = new SignatureValueHarvester(signatureKey);
		EMFModelAccess.traverse(model, sigHarvesterModel);
		return sigHarvesterModel.getAllSigValues();
	}

	@Override
	protected void matchSignatures() {
		Assert.isTrue(getModels().size() == 2, "At this point we only support pairwise matching");
		Resource modelA = getModels().get(0);
		Resource modelB = getModels().get(1);
		ValueMap<String, EObject> sigValuesA = this.getSignatures().get(modelA);
		ValueMap<String, EObject> sigValuesB = this.getSignatures().get(modelB);

		int matchesBefore = getCorrespondencesService().getElementsWithCorrespondences(modelA).size();
		int matchesLeftA = getCorrespondencesService().getElementsWithoutCorrespondences(modelA).size();
		int matchesLeftB = getCorrespondencesService().getElementsWithoutCorrespondences(modelB).size();

		LogUtil.log(LogEvent.NOTICE, "Matchings so far : " + matchesBefore + " - " + "There are still " + matchesLeftA
				+ "/" + matchesLeftB + " unmatched elements left.");

		LogUtil.log(LogEvent.NOTICE, "Run Matching for Signature with Key= " + signatureKey);			

		cleanUpSigValues(sigValuesA, sigValuesB);

		SignatureValueMatcher sigMatcher = new SignatureValueMatcher(this, sigValuesA, sigValuesB);

		assert (LogUtil.log(LogEvent.DEBUG, sigValuesA.getValuedObjects().size() + " signed Objects with "
				+ sigValuesA.getValues().size() + " different Signatures from Model A will be regarded."));
		assert (LogUtil.log(LogEvent.DEBUG, sigValuesB.getValuedObjects().size() + " signed Objects with "
				+ sigValuesB.getValues().size() + " different Signatures from Model B will be regarded."));

		// Die reihenfolge der (Eltern/Kind)objektverarbeitung ist
		// entscheidend,
		// um ggf. uneindeutigkeiten aufloesen zu koennen! -> Top-Down
		EMFModelAccess.traverse(modelB, sigMatcher);
		int matchesBehindA = getCorrespondencesService().getElementsWithCorrespondences(modelA).size();
		// Prinzipell koennten jetzt dinge eindeutig sein, die vorher
		// uneindeutig waren!
		EMFModelAccess.traverse(modelB, sigMatcher);
		int matchesBehindB = getCorrespondencesService().getElementsWithCorrespondences(modelA).size();

		LogUtil.log(LogEvent.NOTICE, "Matching for " + signatureKey + " completed! "
				+ (matchesBehindB - matchesBefore) + " matches found. " + (matchesBehindB - matchesBehindA)
				+ " of them by postiteration.\n" + "There are still "
				+ getCorrespondencesService().getElementsWithoutCorrespondences(modelA).size() + "/"
				+ getCorrespondencesService().getElementsWithoutCorrespondences(modelB).size()
				+ " unmatched elements left.");

		matchesBefore = getCorrespondencesService().getElementsWithCorrespondences(modelA).size();

		LogUtil.log(LogEvent.NOTICE, "Signature Matching completed! ");
	}

	@Override
	public void match(Object matcher, EObject objectA, EObject objectB) {
		String objectAsig = EMFAdapter.INSTANCE.adapt(objectA, AnnotateableElement.class)
				.getAnnotation(signatureKey, String.class);
		assert (LogUtil.log(LogEvent.DEBUG, "Matching ", objectA, " with", objectB, " based on Signature '",
				objectAsig, " '"));

		getCorrespondencesService().addCorrespondence(objectA, objectB);
		getCandidatesService().removeCandidate(objectA);
		getCandidatesService().removeCandidate(objectB);
	}

	@Override
	public boolean isMatchPermitted(EObject objectA, EObject objectB) {
		if(getMode().equals(MatcherMode.SINGLE)) {
			return !getCorrespondencesService().hasCorrespondences(objectA)
					&& !getCorrespondencesService().hasCorrespondences(objectB)
					&& getCandidatesService().isCandidate(objectA, objectB);
		}
		return getCandidatesService().isCandidate(objectA, objectB);
	}

	@Override
	public boolean hasMatched(EObject objectA, EObject objectB) {
		return getCorrespondencesService().isCorresponding(objectA, objectB);
	}

	@Override
	public boolean hasMatch(EObject object) {
		return getCorrespondencesService().hasCorrespondences(object);
	}


	@Override
	public Optional<String> getDescription() {
		return Optional.of("This matcher matches by signatures. These signatures have to be annotated to the elements");
	}

	
	@Override
	public String getName() {
		return "Annotated Signature Matcher";
	}	

	@Override
	protected boolean allowsAmbiguousSignature() {		
		//We allow this as we try to get unambiguous ones in the matching phase
		return true;
	}

	@Override
	public boolean canHandleModels(Collection<Resource> models) {
		//FIXME this matcher should be more generic!
		return models.size() == 2
				&& super.canHandleModels(models)
				&& this.initAnnotation(models.iterator().next());
	}

	private boolean initAnnotation(Resource model) {
		if(annotationService == null) {
			annotationService = IAnnotation.MANAGER.getDefaultExtension().orElse(null);
		}
		if(annotationService != null) {
			try {
				annotationService.init(model);
			} catch (IOException e) {
				LogUtil.log(LogEvent.WARNING, "Could not initialize annotation service", e);
				annotationService = null;
			}
		}
		return annotationService != null;	
	}
	
	private void cleanUpSigValues(ValueMap<String, EObject> sigValuesA, ValueMap<String, EObject> sigValuesB) {
		if(this.getMode().equals(MatcherMode.SINGLE)) {
			Collection<EObject> elementsWithCorrespondencesA = getCorrespondencesService().getElementsWithCorrespondences(
					sigValuesA.getValuedObjects().iterator().next().eResource());
			for (EObject eObject : elementsWithCorrespondencesA) {
				if (sigValuesA.containsObject(eObject)) {
					sigValuesA.removeObject(eObject);
				}
			}

			Collection<EObject> elementsWithCorrespondencesB = getCorrespondencesService().getElementsWithCorrespondences(
					sigValuesB.getValuedObjects().iterator().next().eResource());
			for (EObject eObject : elementsWithCorrespondencesB) {
				if (sigValuesB.containsObject(eObject)) {
					sigValuesB.removeObject(eObject);
				}
			}
		}
	}
	
	// ---------- Getter and Setter Methods----------
	
	public void setSignatureKey(String newSig) {
		this.signatureKey = newSig;
	}

	public void unsetSignatures() {
		this.signatureKey = null;
	}
	
	public IAnnotation getAnnotationService() {
		return annotationService;
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(GENERIC_TYPE);
	}
}
