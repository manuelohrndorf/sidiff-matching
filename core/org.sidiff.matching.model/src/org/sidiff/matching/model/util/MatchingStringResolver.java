package org.sidiff.matching.model.util;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.sidiff.common.collections.CollectionUtil;
import org.sidiff.common.stringresolver.StringResolver;
import org.sidiff.common.stringresolver.StringUtil;
import org.sidiff.matching.model.Matching;

/**
 * Erzeugt eine String-Repraesentation eines Matchings
 */
public class MatchingStringResolver implements StringResolver {

	@Override
	public Class<?> dedicatedClass() {
		return Matching.class;
	}

	@Override
	public String resolve(Object obj) {
		StringBuilder result = new StringBuilder();
		Matching matching = (Matching) obj;
		int depth = CorrespondenceModelStringUtil.computeDepth((EObject) obj);

		List<EObject> matchedA =
			CollectionUtil.asStream(matching.getEResourceA().getAllContents())
				.filter(eObject -> !matching.getUnmatchedA().contains(eObject))
				.collect(Collectors.toList());
		List<EObject> matchedB =
			CollectionUtil.asStream(matching.getEResourceB().getAllContents())
				.filter(eObject -> !matching.getUnmatchedB().contains(eObject))
				.collect(Collectors.toList());

		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");

		StringUtil.appendIndentation(result, depth, true);
		result.append("Begin of Matching between ");
		result.append(matching.getUriA());
		result.append(" and ");
		result.append(matching.getUriB());

		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");

		StringUtil.appendIndentation(result, depth, true);
		result.append("Unmatched nodes in A: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matching.getUnmatchedA());
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Unmatched nodes in B: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matching.getUnmatchedB());
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Matched nodes in A: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matchedA);
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Matched nodes in B: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matchedB);
		StringUtil.appendIndentation(result, depth, true);

		StringUtil.appendIndentation(result, depth, true);
		result.append("Correspondences: ");
		CorrespondenceModelStringUtil.appendSomething(result, depth, matching.getCorrespondences());

		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");
		StringUtil.appendIndentation(result, depth, true);
		result.append("End of Matching");
		StringUtil.appendIndentation(result, depth, true);
		result.append("----------------------------------------------------------------------------------------------------");

		return result.toString();
	}

}