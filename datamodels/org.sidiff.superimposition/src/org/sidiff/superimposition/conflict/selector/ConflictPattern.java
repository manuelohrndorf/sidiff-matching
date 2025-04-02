package org.sidiff.superimposition.conflict.selector;

import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>A Conflict Pattern matches Conflict IDs using <code>*</code> as a wildcard,
 * and is compiled to a RegEx {@link Pattern} for matching.</p>
 * <p>Examples:</p>
 * <ul>
 * <li><code>*</code></li>
 * <li><code>Ecore.*</code></li>
 * <li><code>*.EAttribute.*</code></li>
 * </ul>
 * @author rmueller
 */
public class ConflictPattern {

	private Collection<String> supportedConflicts;
	private Pattern pattern;

	public ConflictPattern(Collection<String> supportedConflicts) {
		this.supportedConflicts = Collections.unmodifiableCollection(supportedConflicts);
		if(supportedConflicts.isEmpty()) {
			this.pattern = Pattern.compile(".^"); // match nothing
		} else {
			this.pattern = Pattern.compile(
				getSupportedConflicts().stream()
					.map(ConflictPattern::conflictPatternToRegex)
					.collect(Collectors.joining("|")));
		}
	}

	public Collection<String> getSupportedConflicts() {
		return supportedConflicts;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public boolean matches(String conflictId) {
		return getPattern().matcher(conflictId).matches();
	}

	private static String conflictPatternToRegex(String conflictPattern) {
		StringBuilder result = new StringBuilder();
		int start = 0;
		int end = 0;
		while(end < conflictPattern.length()) {
			// Wildcards in the pattern are replaced by the RegEx .*
			// while the rest of the pattern is matched literally
			if(conflictPattern.charAt(end) == '*') {
				// Append literal pattern preceding the wildcard (if present)
				if(start < end) {
					result.append(Pattern.quote(conflictPattern.substring(start, end)));
				}
				// Append wildcard if last character wasn't a wildcard already
				if(result.length() == 0 || result.charAt(result.length()-1) != '*') {
					result.append(".*");
				}
				end++;
				start = end;
			} else {
				// All other characters are skipped
				end++;
			}
		}
		// Append last literal pattern (if present)
		if(start < end) {
			result.append(Pattern.quote(conflictPattern.substring(start, end)));
		}
		return result.toString();
	}
}
