package org.sidiff.formula.parser.tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sidiff.formula.And;
import org.sidiff.formula.Configuration;
import org.sidiff.formula.Formula;
import org.sidiff.formula.FormulaPackage;
import org.sidiff.formula.Implies;
import org.sidiff.formula.Not;
import org.sidiff.formula.Or;
import org.sidiff.formula.Variable;
import org.sidiff.formula.Xor;
import org.sidiff.formula.adapter.ISatSolverAdapter;
import org.sidiff.formula.adapter.exceptions.SatSolverAdapterNotFoundException;
import org.sidiff.formula.exception.InvalidFormulaException;
import org.sidiff.formula.parser.FormulaParser;

public class FormulaParserTest {
	
	private static final String FORMULA_WELLFORMED = "A and (B or C) implies not(D) xor (E and not(F))";
	
	private static final String FORMULA_ILLFORMED = "A and B or (C implies not(B) and A";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FormulaPackage.eINSTANCE.eClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParse() {
		
		try {
			Formula formula = FormulaParser.INSTANCE.parse(FORMULA_WELLFORMED);
			if(formula instanceof Implies) {
				Implies implies = (Implies) formula;
				if(implies.getLeft() instanceof And && implies.getRight() instanceof Xor) {
					And and = (And) implies.getLeft();
					if(and.getLeft() instanceof Variable && and.getRight() instanceof Or) {
						Variable v = (Variable) and.getLeft();
						assertTrue(v.getName().equals("A"));
						Or or = (Or) and.getRight();
						if(or.getLeft() instanceof Variable && or.getRight() instanceof Variable) {
							Variable vl = (Variable) or.getLeft();
							Variable vr = (Variable) or.getRight();
							assertTrue(vl.getName().equals("B") && vr.getName().equals("C"));
						}else {
							fail();
						}
					}else {
						fail();
					}
							
					Xor xor = (Xor) implies.getRight();
					
					if(xor.getLeft() instanceof Not && xor.getRight() instanceof And) {
						Not not = (Not) xor.getLeft();
						if(not.getFormula() instanceof Variable) {
							Variable v = (Variable) not.getFormula();
							assertTrue(v.getName().equals("D"));
						}else {
							fail();
						}
						
						And and_ = (And) xor.getRight();
						if(and_.getLeft() instanceof Variable && and_.getRight() instanceof Not) {
							Variable v = (Variable) and_.getLeft();
							assertTrue(v.getName().equals("E"));
							
							Not not_ = (Not) and_.getRight();
							if(not_.getFormula() instanceof Variable) {
								Variable v_ = (Variable) not_.getFormula();
								assertTrue(v_.getName().equals("F"));
							}else {
								fail();
							}
						}else {
							fail();
						}
					}else {
						fail();
					}
				}else {
					fail();
				}
			}

		} catch (InvalidFormulaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testParse_InvalidFormulaException() {
		assertThrows(InvalidFormulaException.class, () -> {FormulaParser.INSTANCE.parse(FORMULA_ILLFORMED);});
	}
	
	@Test
	public void testTemp() {
		Formula formula;
		try {
			formula = FormulaParser.INSTANCE.parse(FORMULA_WELLFORMED);
			try {
				String key = "org.sidiff.formula.adapter.z3.Z3SatSolverAdapter";
				formula.setSatSolverAdapter(ISatSolverAdapter.MANAGER.getExtension(key).orElseThrow(() -> new SatSolverAdapterNotFoundException(key)));
			} catch (SatSolverAdapterNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Configuration> sat_Configs = formula.getValidConfigurations(60);
			
			formula.setSatSolverAdapter(null);
			List<Configuration> eval_Configs = formula.getValidConfigurations(60);
			
			assertTrue(sat_Configs.size() == eval_Configs.size());
		} catch (InvalidFormulaException e) {
			fail();
			e.printStackTrace();
		}
		
	}

}
