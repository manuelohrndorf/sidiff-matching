package org.sidiff.formula.adapter.z3.test.cases;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Set;

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

class Z3SatSolverAdapterTest {

	private static final String FORMULA_SATISFIABLE = "A and B or A and not(C)";
	private static final String FORMULA_UNSATISFIABLE = "(A or B) and (not(A) or B) and (A or not(B)) and (not(A) or not(B))";

	
	private static Formula formula_Satisfiable;
	private static Formula formula_Unsatisfiable;
	
	private static ISatSolverAdapter adapter;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String key = "org.sidiff.formula.adapter.z3.Z3SatSolverAdapter";
		adapter = ISatSolverAdapter.MANAGER.getExtension(key).orElseThrow(() -> new SatSolverAdapterNotFoundException(key));
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIsSatisfiable() {
		SatResult result = adapter.isSatisfiable(formula_Satisfiable);
		assertTrue(result.getStatus().equals(SatResult.EStatus.SATISFIABLE));
		System.out.println(result.getAssignments());
		result = adapter.isSatisfiable(formula_Unsatisfiable);
		assertTrue(result.getStatus().equals(SatResult.EStatus.UNSATISFIABLE));
	}

	@Test
	void findAllSolutions() {
		Set<SatResult> result;
		try {
			result = adapter.findAllSolutions(formula_Satisfiable, Duration.ofSeconds(60));
			System.out.println(result);
			assertTrue(!result.isEmpty());
		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}
		
	}
}
