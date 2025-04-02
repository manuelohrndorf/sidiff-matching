package org.sidiff.formula.util;

import java.util.*;
import java.util.stream.Collectors;

import org.sidiff.formula.*;

/**
 * Contains utility functions for creating formulas.
 * @author rmueller
 * @author cpietsch
 */
public class FormulaUtil {

	private FormulaUtil() {
		throw new AssertionError();
	}
	
	public static Optional<Boolean> getBooleanValue(Formula formula) {
		if(formula instanceof Variable) {
			switch(((Variable)formula).getName()) {
				case "true": return Optional.of(true);
				case "false": return Optional.of(false);
			}
		}
		return Optional.empty();
	}
	
	public static Formula createTrue() {
		return createVariable("true");
	}
	
	public static Formula createFalse() {
		return createVariable("false");
	}

	/**
	 * Creates a new {@link Variable} with the given name.
	 * @param name the name
	 * @return new Variable
	 */
	public static Variable createVariable(String name) {
		return createVariable(name, VariationType.UNDEFINED);
	}

	/**
	 * Creates a new {@link Variable} with the given name.
	 * @param name the name
	 * @param type the variation type
	 * @return new Variable
	 */
	public static Variable createVariable(String name, VariationType type) {
		Variable variable = FormulaFactory.eINSTANCE.createVariable();
		variable.setName(name);
		variable.setType(type);
		return variable;
	}
	
	/**
	 * Creates a new {@link Not} with the given inner formula.
	 * @param formula the inner formula
	 * @return new Not
	 */
	public static Not createNot(Formula formula) {
		Not not = FormulaFactory.eINSTANCE.createNot();
		not.setFormula(formula);
		return not;
	}

	/**
	 * Creates a new {@link And} with the given left and right formulas.
	 * @param left the left formula
	 * @param right the right formula
	 * @return new And
	 */
	public static And createAnd(Formula left, Formula right) {
		And and = FormulaFactory.eINSTANCE.createAnd();
		and.setLeft(left);
		and.setRight(right);
		return and;
	}
	
	/**
	 * Creates a new {@link And} with the given formulas.
	 * Returns the formula itself, if only one argument. 
	 * @param formulas formulas to concatenate, must be at least one
	 * @return new Conjunction/And
	 */
	public static Formula createAnd(Formula... formulas) {
		switch(formulas.length) {
			case 0: 
				throw new IllegalArgumentException("At least one formula required");
			case 1:
				return formulas[0];
			default:
				return createAnd(formulas[0], createAnd(Arrays.copyOfRange(formulas, 1, formulas.length)));
		}
	}

	/**
	 * Creates a new {@link Or} with the given left and right formulas.
	 * @param left the left formula
	 * @param right the right formula
	 * @return new Or
	 */
	public static Or createOr(Formula left, Formula right) {
		Or or = FormulaFactory.eINSTANCE.createOr();
		or.setLeft(left);
		or.setRight(right);
		return or;
	}
	
	/**
	 * Creates a new {@link Or} with the given formulas.
	 * Returns the formula itself, if only one argument.
	 * @param formulas to concatenate, must be at least one
	 * @return new Disjunction/Or
	 */
	public static Formula createOr(Formula... formulas) {
		switch(formulas.length) {
			case 0: 
				throw new IllegalArgumentException("At least one formula required");
			case 1:
				return formulas[0];
			default:
				return createOr(formulas[0], createOr(Arrays.copyOfRange(formulas, 1, formulas.length)));
		}
	}

	/**
	 * Creates a new {@link Xor} with the given left and right formulas.
	 * @param left the left formula
	 * @param right the right formula
	 * @return new Xor
	 */
	public static Xor createXor(Formula left, Formula right) {
		Xor xor = FormulaFactory.eINSTANCE.createXor();
		xor.setLeft(left);
		xor.setRight(right);
		return xor;
	}

	/**
	 * Creates a new {@link Implies} with the given left and right formulas.
	 * @param left the left formula
	 * @param right the right formula
	 * @return new Implies
	 */
	public static Implies createImplies(Formula left, Formula right) {
		Implies implies = FormulaFactory.eINSTANCE.createImplies();
		implies.setLeft(left);
		implies.setRight(right);
		return implies;
	}

	/**
	 * Transfers the VariationType settings from the variables of the
	 * source formula tree those of the target formula tree.
	 * @param source the source formula
	 * @param target the target formula
	 */
	public static void transferVariationType(Formula source, Formula target) {
		Map<String,VariationType> typeMap = source.getVariables().stream()
				.collect(Collectors.toMap(Variable::getName, Variable::getType, (l, r) -> l)); // merge prefers first choice
		target.getVariables().forEach(variable -> {
			VariationType replacementType = typeMap.get(variable.getName());
			if(replacementType != null) {
				variable.setType(replacementType);
			}
		});
	}
}
