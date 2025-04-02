/**
 * 
 */
package org.sidiff.formula.adapter.sat4j.test.cases;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sidiff.formula.Formula;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.SatResult;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterNotFoundException;
import org.sidiff.formula.parser.FormulaParser;

/**
 * @author cpietsch
 *
 */
public class Sat4JSolverAdapterTest {
	
	private static final String FORMULA_SATISFIABLE = "A and B or A and not(C)";
	private static final String FORMULA_UNSATISFIABLE = "(A or B) and (not(A) or B) and (A or not(B)) and (not(A) or not(B))";
	private static final String FORMULA_EXCEPTIONAL = "A and not(A)";
	
	private static Formula formula_Satisfiable;
	private static Formula formula_Unsatisfiable;
	private static Formula formula_Exceptional;
	
	private static ISatSolverAdapter adapter;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String key = "org.sidiff.formula.adapter.sat4j.Sat4JSolverAdapter";
		adapter = ISatSolverAdapter.MANAGER.getExtension(key)
				.orElseThrow(() -> new SatSolverAdapterNotFoundException(key));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		formula_Satisfiable = FormulaParser.INSTANCE.parse(FORMULA_SATISFIABLE);
		formula_Unsatisfiable = FormulaParser.INSTANCE.parse(FORMULA_UNSATISFIABLE);
		formula_Exceptional = FormulaParser.INSTANCE.parse(FORMULA_EXCEPTIONAL);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsSatisfiable() {
		assertTrue(adapter.isSatisfiable(formula_Satisfiable).getStatus().equals(SatResult.EStatus.SATISFIABLE));
		assertFalse(adapter.isSatisfiable(formula_Unsatisfiable).getStatus().equals(SatResult.EStatus.UNSATISFIABLE));
	}

	@Test
	void testIsSatisfiable_RuntimeException() {
		assertThrows(RuntimeException.class, () -> {adapter.isSatisfiable(formula_Exceptional);});
	}
}
