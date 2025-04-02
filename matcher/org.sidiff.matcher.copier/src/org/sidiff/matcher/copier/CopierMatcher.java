package org.sidiff.matcher.copier;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.sidiff.matcher.BaseMatcher;

/**
 * <p>Concrete matcher that checks whether one element has been created by
 * copying another. If so, they are corresponding.</p>
 * <p>Note that this Matcher is not registered to the extension point, because
 * it needs to be initialized using a copier on an instance basis and using a global
 * CopierMatcher-instance might result in memory leaks as well as unexpected behavior.</p>
 * @author dreuling
 */
public class CopierMatcher extends BaseMatcher {

	private Copier copier;

	public CopierMatcher(Copier copier) {
		this.copier = Objects.requireNonNull(copier);
	}

	@Override
	protected void match() {
		Assert.isLegal(getModels().size() == 2, "This matcher only supports pairwise matching.");
		copier.forEach(getCorrespondencesService()::addCorrespondence);
	}

	@Override
	public String getName() {
		return "Copier Matcher";
	}

	@Override
	public boolean isResourceSetCapable() {
		return true;
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("This matcher matches copied model elements.");
	}

	@Override
	public Set<String> getDocumentTypes() {
		return Collections.singleton(GENERIC_TYPE);
	}
}
