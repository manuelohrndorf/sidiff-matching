package org.sidiff.formula.adapter;

import java.util.*;

import org.sidiff.formula.Formula;

/**
 *
 * @author cpietsch
 *
 */
public class SatResult {

	/**
	 * The {@link EStatus}
	 */
	private EStatus status;

	/**
	 * The {@link Formula} that is checked
	 */
	private Formula formula;

	/**
	 * The variable assignments for satisfied formulas
	 */
	private Map<String, String> assignments;

	public SatResult(EStatus status, Formula formula, Map<String, String> assignments) {
		this.status = Objects.requireNonNull(status);
		this.formula = Objects.requireNonNull(formula);
		this.assignments = new LinkedHashMap<>(assignments);
	}

	public SatResult(EStatus status, Formula formula) {
		this(status, formula, Collections.emptyMap());
	}

	public EStatus getStatus() {
		return status;
	}

	public Formula getFormula() {
		return formula;
	}

	public Map<String, String> getAssignments() {
		return Collections.unmodifiableMap(assignments);
	}

	public enum EStatus {
		SATISFIABLE,
		TIMEOUT,
		UNSATISFIABLE,
		ERROR,
		UNKNOWN
	}

	@Override
	public String toString() {
		return status + ": " + assignments;
	}
}
