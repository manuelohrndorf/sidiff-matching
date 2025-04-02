/**
 */
package org.sidiff.formula;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.sidiff.formula.FormulaFactory
 * @model kind="package"
 * @generated
 */
public interface FormulaPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c), Christopher Pietsch, Software Engineering Group, University of Siegen 2017 all rights reserved";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "formula";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.sidiff.org/formula/model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "formula";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FormulaPackage eINSTANCE = org.sidiff.formula.impl.FormulaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.FormulaImpl <em>Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.FormulaImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getFormula()
	 * @generated
	 */
	int FORMULA = 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA__VARIABLES = 0;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA__SAT_SOLVER_ADAPTER = 1;

	/**
	 * The number of structural features of the '<em>Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___EVAL__CONFIGURATION = 0;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___EQUIVALENT = 1;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___DE_MORGAN = 2;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___DISTRIBUTIVE__OPERATOR = 3;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___ASSOCIATIVE = 4;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___SIMPLIFY = 5;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___CNF = 6;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___DNF = 7;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___GET_PRIORITY = 8;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___GET_VALID_CONFIGURATIONS__INT = 9;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS = 10;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA___IS_SATISFIABLE = 11;

	/**
	 * The number of operations of the '<em>Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_OPERATION_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.BinaryFormulaImpl <em>Binary Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.BinaryFormulaImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getBinaryFormula()
	 * @generated
	 */
	int BINARY_FORMULA = 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA__VARIABLES = FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA__SAT_SOLVER_ADAPTER = FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA__LEFT = FORMULA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA__RIGHT = FORMULA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Binary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA_FEATURE_COUNT = FORMULA_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___EVAL__CONFIGURATION = FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___EQUIVALENT = FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___DE_MORGAN = FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___DISTRIBUTIVE__OPERATOR = FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___ASSOCIATIVE = FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___SIMPLIFY = FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___CNF = FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___DNF = FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___GET_PRIORITY = FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___GET_VALID_CONFIGURATIONS__INT = FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS = FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA___IS_SATISFIABLE = FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>Binary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_FORMULA_OPERATION_COUNT = FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.UnaryFormulaImpl <em>Unary Formula</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.UnaryFormulaImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getUnaryFormula()
	 * @generated
	 */
	int UNARY_FORMULA = 2;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA__VARIABLES = FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA__SAT_SOLVER_ADAPTER = FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA__FORMULA = FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA_FEATURE_COUNT = FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___EVAL__CONFIGURATION = FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___EQUIVALENT = FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___DE_MORGAN = FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___DISTRIBUTIVE__OPERATOR = FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___ASSOCIATIVE = FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___SIMPLIFY = FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___CNF = FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___DNF = FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___GET_PRIORITY = FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___GET_VALID_CONFIGURATIONS__INT = FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS = FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA___IS_SATISFIABLE = FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>Unary Formula</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_FORMULA_OPERATION_COUNT = FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.VariableImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VARIABLES = FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__SAT_SOLVER_ADAPTER = FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = FORMULA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__PRIORITY = FORMULA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = FORMULA_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = FORMULA_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___EVAL__CONFIGURATION = FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___EQUIVALENT = FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___DE_MORGAN = FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___DISTRIBUTIVE__OPERATOR = FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___ASSOCIATIVE = FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___SIMPLIFY = FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___CNF = FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___DNF = FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___GET_PRIORITY = FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___GET_VALID_CONFIGURATIONS__INT = FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___GET_ASSOCIATIVE_FORMULAS__ECLASS = FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE___IS_SATISFIABLE = FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.NotImpl <em>Not</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.NotImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 4;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__VARIABLES = UNARY_FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__SAT_SOLVER_ADAPTER = UNARY_FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__FORMULA = UNARY_FORMULA__FORMULA;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT__PRIORITY = UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = UNARY_FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___EVAL__CONFIGURATION = UNARY_FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___EQUIVALENT = UNARY_FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___DE_MORGAN = UNARY_FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___DISTRIBUTIVE__OPERATOR = UNARY_FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___ASSOCIATIVE = UNARY_FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___SIMPLIFY = UNARY_FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___CNF = UNARY_FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___DNF = UNARY_FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___GET_PRIORITY = UNARY_FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___GET_VALID_CONFIGURATIONS__INT = UNARY_FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___GET_ASSOCIATIVE_FORMULAS__ECLASS = UNARY_FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT___IS_SATISFIABLE = UNARY_FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>Not</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_OPERATION_COUNT = UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.AndImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 5;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__VARIABLES = BINARY_FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__SAT_SOLVER_ADAPTER = BINARY_FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__PRIORITY = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___EVAL__CONFIGURATION = BINARY_FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___EQUIVALENT = BINARY_FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___DE_MORGAN = BINARY_FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___DISTRIBUTIVE__OPERATOR = BINARY_FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___ASSOCIATIVE = BINARY_FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___SIMPLIFY = BINARY_FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___CNF = BINARY_FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___DNF = BINARY_FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___GET_PRIORITY = BINARY_FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___GET_VALID_CONFIGURATIONS__INT = BINARY_FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___GET_ASSOCIATIVE_FORMULAS__ECLASS = BINARY_FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND___IS_SATISFIABLE = BINARY_FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.OrImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getOr()
	 * @generated
	 */
	int OR = 6;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__VARIABLES = BINARY_FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__SAT_SOLVER_ADAPTER = BINARY_FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__PRIORITY = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___EVAL__CONFIGURATION = BINARY_FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___EQUIVALENT = BINARY_FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___DE_MORGAN = BINARY_FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___DISTRIBUTIVE__OPERATOR = BINARY_FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___ASSOCIATIVE = BINARY_FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___SIMPLIFY = BINARY_FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___CNF = BINARY_FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___DNF = BINARY_FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___GET_PRIORITY = BINARY_FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___GET_VALID_CONFIGURATIONS__INT = BINARY_FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___GET_ASSOCIATIVE_FORMULAS__ECLASS = BINARY_FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR___IS_SATISFIABLE = BINARY_FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.XorImpl <em>Xor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.XorImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getXor()
	 * @generated
	 */
	int XOR = 7;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__VARIABLES = BINARY_FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__SAT_SOLVER_ADAPTER = BINARY_FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR__PRIORITY = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___EVAL__CONFIGURATION = BINARY_FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___EQUIVALENT = BINARY_FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___DE_MORGAN = BINARY_FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___DISTRIBUTIVE__OPERATOR = BINARY_FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___ASSOCIATIVE = BINARY_FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___SIMPLIFY = BINARY_FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___CNF = BINARY_FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___DNF = BINARY_FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___GET_PRIORITY = BINARY_FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___GET_VALID_CONFIGURATIONS__INT = BINARY_FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___GET_ASSOCIATIVE_FORMULAS__ECLASS = BINARY_FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR___IS_SATISFIABLE = BINARY_FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>Xor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.ImpliesImpl <em>Implies</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.ImpliesImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getImplies()
	 * @generated
	 */
	int IMPLIES = 8;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__VARIABLES = BINARY_FORMULA__VARIABLES;

	/**
	 * The feature id for the '<em><b>Sat Solver Adapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__SAT_SOLVER_ADAPTER = BINARY_FORMULA__SAT_SOLVER_ADAPTER;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__LEFT = BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__RIGHT = BINARY_FORMULA__RIGHT;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES__PRIORITY = BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Implies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_FEATURE_COUNT = BINARY_FORMULA_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Eval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___EVAL__CONFIGURATION = BINARY_FORMULA___EVAL__CONFIGURATION;

	/**
	 * The operation id for the '<em>Equivalent</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___EQUIVALENT = BINARY_FORMULA___EQUIVALENT;

	/**
	 * The operation id for the '<em>De Morgan</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___DE_MORGAN = BINARY_FORMULA___DE_MORGAN;

	/**
	 * The operation id for the '<em>Distributive</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___DISTRIBUTIVE__OPERATOR = BINARY_FORMULA___DISTRIBUTIVE__OPERATOR;

	/**
	 * The operation id for the '<em>Associative</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___ASSOCIATIVE = BINARY_FORMULA___ASSOCIATIVE;

	/**
	 * The operation id for the '<em>Simplify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___SIMPLIFY = BINARY_FORMULA___SIMPLIFY;

	/**
	 * The operation id for the '<em>Cnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___CNF = BINARY_FORMULA___CNF;

	/**
	 * The operation id for the '<em>Dnf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___DNF = BINARY_FORMULA___DNF;

	/**
	 * The operation id for the '<em>Get Priority</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___GET_PRIORITY = BINARY_FORMULA___GET_PRIORITY;

	/**
	 * The operation id for the '<em>Get Valid Configurations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___GET_VALID_CONFIGURATIONS__INT = BINARY_FORMULA___GET_VALID_CONFIGURATIONS__INT;

	/**
	 * The operation id for the '<em>Get Associative Formulas</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___GET_ASSOCIATIVE_FORMULAS__ECLASS = BINARY_FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS;

	/**
	 * The operation id for the '<em>Is Satisfiable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES___IS_SATISFIABLE = BINARY_FORMULA___IS_SATISFIABLE;

	/**
	 * The number of operations of the '<em>Implies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_OPERATION_COUNT = BINARY_FORMULA_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.ConfigurationImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Variable Assignments</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__VARIABLE_ASSIGNMENTS = 0;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION___INIT__FORMULA = 0;

	/**
	 * The operation id for the '<em>Export</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION___EXPORT = 1;

	/**
	 * The number of operations of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.sidiff.formula.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.impl.VariableAssignmentImpl
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 10;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.sidiff.formula.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.Operator
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 11;


	/**
	 * The meta object id for the '{@link org.sidiff.formula.VariationType <em>Variation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.VariationType
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getVariationType()
	 * @generated
	 */
	int VARIATION_TYPE = 12;

	/**
	 * The meta object id for the '<em>ISat Solver Adapter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.adapter.ISatSolverAdapter
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getISatSolverAdapter()
	 * @generated
	 */
	int ISAT_SOLVER_ADAPTER = 13;


	/**
	 * The meta object id for the '<em>Sat Result</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.adapter.SatResult
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getSatResult()
	 * @generated
	 */
	int SAT_RESULT = 14;


	/**
	 * The meta object id for the '<em>Sat Solver Adapter Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.sidiff.formula.adapter.exceptions.SatSolverAdapterException
	 * @see org.sidiff.formula.impl.FormulaPackageImpl#getSatSolverAdapterException()
	 * @generated
	 */
	int SAT_SOLVER_ADAPTER_EXCEPTION = 15;


	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.Formula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula</em>'.
	 * @see org.sidiff.formula.Formula
	 * @generated
	 */
	EClass getFormula();

	/**
	 * Returns the meta object for the reference list '{@link org.sidiff.formula.Formula#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.sidiff.formula.Formula#getVariables()
	 * @see #getFormula()
	 * @generated
	 */
	EReference getFormula_Variables();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Formula#getSatSolverAdapter <em>Sat Solver Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sat Solver Adapter</em>'.
	 * @see org.sidiff.formula.Formula#getSatSolverAdapter()
	 * @see #getFormula()
	 * @generated
	 */
	EAttribute getFormula_SatSolverAdapter();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#eval(org.sidiff.formula.Configuration) <em>Eval</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Eval</em>' operation.
	 * @see org.sidiff.formula.Formula#eval(org.sidiff.formula.Configuration)
	 * @generated
	 */
	EOperation getFormula__Eval__Configuration();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#deMorgan() <em>De Morgan</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>De Morgan</em>' operation.
	 * @see org.sidiff.formula.Formula#deMorgan()
	 * @generated
	 */
	EOperation getFormula__DeMorgan();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#distributive(org.sidiff.formula.Operator) <em>Distributive</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Distributive</em>' operation.
	 * @see org.sidiff.formula.Formula#distributive(org.sidiff.formula.Operator)
	 * @generated
	 */
	EOperation getFormula__Distributive__Operator();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#associative() <em>Associative</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Associative</em>' operation.
	 * @see org.sidiff.formula.Formula#associative()
	 * @generated
	 */
	EOperation getFormula__Associative();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#simplify() <em>Simplify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Simplify</em>' operation.
	 * @see org.sidiff.formula.Formula#simplify()
	 * @generated
	 */
	EOperation getFormula__Simplify();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#cnf() <em>Cnf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Cnf</em>' operation.
	 * @see org.sidiff.formula.Formula#cnf()
	 * @generated
	 */
	EOperation getFormula__Cnf();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#dnf() <em>Dnf</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Dnf</em>' operation.
	 * @see org.sidiff.formula.Formula#dnf()
	 * @generated
	 */
	EOperation getFormula__Dnf();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#getPriority() <em>Get Priority</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Priority</em>' operation.
	 * @see org.sidiff.formula.Formula#getPriority()
	 * @generated
	 */
	EOperation getFormula__GetPriority();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#getValidConfigurations(int) <em>Get Valid Configurations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Valid Configurations</em>' operation.
	 * @see org.sidiff.formula.Formula#getValidConfigurations(int)
	 * @generated
	 */
	EOperation getFormula__GetValidConfigurations__int();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#getAssociativeFormulas(org.eclipse.emf.ecore.EClass) <em>Get Associative Formulas</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Associative Formulas</em>' operation.
	 * @see org.sidiff.formula.Formula#getAssociativeFormulas(org.eclipse.emf.ecore.EClass)
	 * @generated
	 */
	EOperation getFormula__GetAssociativeFormulas__EClass();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#isSatisfiable() <em>Is Satisfiable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Satisfiable</em>' operation.
	 * @see org.sidiff.formula.Formula#isSatisfiable()
	 * @generated
	 */
	EOperation getFormula__IsSatisfiable();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Formula#equivalent() <em>Equivalent</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Equivalent</em>' operation.
	 * @see org.sidiff.formula.Formula#equivalent()
	 * @generated
	 */
	EOperation getFormula__Equivalent();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.BinaryFormula <em>Binary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Formula</em>'.
	 * @see org.sidiff.formula.BinaryFormula
	 * @generated
	 */
	EClass getBinaryFormula();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.formula.BinaryFormula#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.sidiff.formula.BinaryFormula#getLeft()
	 * @see #getBinaryFormula()
	 * @generated
	 */
	EReference getBinaryFormula_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.formula.BinaryFormula#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.sidiff.formula.BinaryFormula#getRight()
	 * @see #getBinaryFormula()
	 * @generated
	 */
	EReference getBinaryFormula_Right();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.UnaryFormula <em>Unary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Formula</em>'.
	 * @see org.sidiff.formula.UnaryFormula
	 * @generated
	 */
	EClass getUnaryFormula();

	/**
	 * Returns the meta object for the containment reference '{@link org.sidiff.formula.UnaryFormula#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Formula</em>'.
	 * @see org.sidiff.formula.UnaryFormula#getFormula()
	 * @see #getUnaryFormula()
	 * @generated
	 */
	EReference getUnaryFormula_Formula();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.sidiff.formula.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.sidiff.formula.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Variable#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.sidiff.formula.Variable#getPriority()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Priority();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.sidiff.formula.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Type();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not</em>'.
	 * @see org.sidiff.formula.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Not#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.sidiff.formula.Not#getPriority()
	 * @see #getNot()
	 * @generated
	 */
	EAttribute getNot_Priority();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see org.sidiff.formula.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.And#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.sidiff.formula.And#getPriority()
	 * @see #getAnd()
	 * @generated
	 */
	EAttribute getAnd_Priority();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see org.sidiff.formula.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Or#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.sidiff.formula.Or#getPriority()
	 * @see #getOr()
	 * @generated
	 */
	EAttribute getOr_Priority();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.Xor <em>Xor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor</em>'.
	 * @see org.sidiff.formula.Xor
	 * @generated
	 */
	EClass getXor();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Xor#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.sidiff.formula.Xor#getPriority()
	 * @see #getXor()
	 * @generated
	 */
	EAttribute getXor_Priority();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.Implies <em>Implies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implies</em>'.
	 * @see org.sidiff.formula.Implies
	 * @generated
	 */
	EClass getImplies();

	/**
	 * Returns the meta object for the attribute '{@link org.sidiff.formula.Implies#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.sidiff.formula.Implies#getPriority()
	 * @see #getImplies()
	 * @generated
	 */
	EAttribute getImplies_Priority();

	/**
	 * Returns the meta object for class '{@link org.sidiff.formula.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.sidiff.formula.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the map '{@link org.sidiff.formula.Configuration#getVariableAssignments <em>Variable Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Variable Assignments</em>'.
	 * @see org.sidiff.formula.Configuration#getVariableAssignments()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_VariableAssignments();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Configuration#init(org.sidiff.formula.Formula) <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see org.sidiff.formula.Configuration#init(org.sidiff.formula.Formula)
	 * @generated
	 */
	EOperation getConfiguration__Init__Formula();

	/**
	 * Returns the meta object for the '{@link org.sidiff.formula.Configuration#export() <em>Export</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Export</em>' operation.
	 * @see org.sidiff.formula.Configuration#export()
	 * @generated
	 */
	EOperation getConfiguration__Export();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.sidiff.formula.Variable" keyRequired="true"
	 *        valueDefault="false" valueDataType="org.eclipse.emf.ecore.EBooleanObject" valueRequired="true"
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EAttribute getVariableAssignment_Value();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.formula.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator</em>'.
	 * @see org.sidiff.formula.Operator
	 * @generated
	 */
	EEnum getOperator();

	/**
	 * Returns the meta object for enum '{@link org.sidiff.formula.VariationType <em>Variation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variation Type</em>'.
	 * @see org.sidiff.formula.VariationType
	 * @generated
	 */
	EEnum getVariationType();

	/**
	 * Returns the meta object for data type '{@link org.sidiff.formula.adapter.ISatSolverAdapter <em>ISat Solver Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ISat Solver Adapter</em>'.
	 * @see org.sidiff.formula.adapter.ISatSolverAdapter
	 * @model instanceClass="org.sidiff.formula.adapter.ISatSolverAdapter"
	 * @generated
	 */
	EDataType getISatSolverAdapter();

	/**
	 * Returns the meta object for data type '{@link org.sidiff.formula.adapter.SatResult <em>Sat Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Sat Result</em>'.
	 * @see org.sidiff.formula.adapter.SatResult
	 * @model instanceClass="org.sidiff.formula.adapter.SatResult"
	 * @generated
	 */
	EDataType getSatResult();

	/**
	 * Returns the meta object for data type '{@link org.sidiff.formula.adapter.exceptions.SatSolverAdapterException <em>Sat Solver Adapter Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Sat Solver Adapter Exception</em>'.
	 * @see org.sidiff.formula.adapter.exceptions.SatSolverAdapterException
	 * @model instanceClass="org.sidiff.formula.adapter.exceptions.SatSolverAdapterException" serializeable="false"
	 * @generated
	 */
	EDataType getSatSolverAdapterException();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FormulaFactory getFormulaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.FormulaImpl <em>Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.FormulaImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getFormula()
		 * @generated
		 */
		EClass FORMULA = eINSTANCE.getFormula();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULA__VARIABLES = eINSTANCE.getFormula_Variables();

		/**
		 * The meta object literal for the '<em><b>Sat Solver Adapter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMULA__SAT_SOLVER_ADAPTER = eINSTANCE.getFormula_SatSolverAdapter();

		/**
		 * The meta object literal for the '<em><b>Eval</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___EVAL__CONFIGURATION = eINSTANCE.getFormula__Eval__Configuration();

		/**
		 * The meta object literal for the '<em><b>De Morgan</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___DE_MORGAN = eINSTANCE.getFormula__DeMorgan();

		/**
		 * The meta object literal for the '<em><b>Distributive</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___DISTRIBUTIVE__OPERATOR = eINSTANCE.getFormula__Distributive__Operator();

		/**
		 * The meta object literal for the '<em><b>Associative</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___ASSOCIATIVE = eINSTANCE.getFormula__Associative();

		/**
		 * The meta object literal for the '<em><b>Simplify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___SIMPLIFY = eINSTANCE.getFormula__Simplify();

		/**
		 * The meta object literal for the '<em><b>Cnf</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___CNF = eINSTANCE.getFormula__Cnf();

		/**
		 * The meta object literal for the '<em><b>Dnf</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___DNF = eINSTANCE.getFormula__Dnf();

		/**
		 * The meta object literal for the '<em><b>Get Priority</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___GET_PRIORITY = eINSTANCE.getFormula__GetPriority();

		/**
		 * The meta object literal for the '<em><b>Get Valid Configurations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___GET_VALID_CONFIGURATIONS__INT = eINSTANCE.getFormula__GetValidConfigurations__int();

		/**
		 * The meta object literal for the '<em><b>Get Associative Formulas</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___GET_ASSOCIATIVE_FORMULAS__ECLASS = eINSTANCE.getFormula__GetAssociativeFormulas__EClass();

		/**
		 * The meta object literal for the '<em><b>Is Satisfiable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___IS_SATISFIABLE = eINSTANCE.getFormula__IsSatisfiable();

		/**
		 * The meta object literal for the '<em><b>Equivalent</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FORMULA___EQUIVALENT = eINSTANCE.getFormula__Equivalent();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.BinaryFormulaImpl <em>Binary Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.BinaryFormulaImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getBinaryFormula()
		 * @generated
		 */
		EClass BINARY_FORMULA = eINSTANCE.getBinaryFormula();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_FORMULA__LEFT = eINSTANCE.getBinaryFormula_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_FORMULA__RIGHT = eINSTANCE.getBinaryFormula_Right();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.UnaryFormulaImpl <em>Unary Formula</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.UnaryFormulaImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getUnaryFormula()
		 * @generated
		 */
		EClass UNARY_FORMULA = eINSTANCE.getUnaryFormula();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_FORMULA__FORMULA = eINSTANCE.getUnaryFormula_Formula();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.VariableImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__PRIORITY = eINSTANCE.getVariable_Priority();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__TYPE = eINSTANCE.getVariable_Type();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.NotImpl <em>Not</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.NotImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOT__PRIORITY = eINSTANCE.getNot_Priority();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.AndImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AND__PRIORITY = eINSTANCE.getAnd_Priority();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.OrImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OR__PRIORITY = eINSTANCE.getOr_Priority();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.XorImpl <em>Xor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.XorImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getXor()
		 * @generated
		 */
		EClass XOR = eINSTANCE.getXor();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XOR__PRIORITY = eINSTANCE.getXor_Priority();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.ImpliesImpl <em>Implies</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.ImpliesImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getImplies()
		 * @generated
		 */
		EClass IMPLIES = eINSTANCE.getImplies();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLIES__PRIORITY = eINSTANCE.getImplies_Priority();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.ConfigurationImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Variable Assignments</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__VARIABLE_ASSIGNMENTS = eINSTANCE.getConfiguration_VariableAssignments();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFIGURATION___INIT__FORMULA = eINSTANCE.getConfiguration__Init__Formula();

		/**
		 * The meta object literal for the '<em><b>Export</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONFIGURATION___EXPORT = eINSTANCE.getConfiguration__Export();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.impl.VariableAssignmentImpl
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__KEY = eINSTANCE.getVariableAssignment_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getVariableAssignment_Value();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.Operator <em>Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.Operator
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getOperator()
		 * @generated
		 */
		EEnum OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '{@link org.sidiff.formula.VariationType <em>Variation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.VariationType
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getVariationType()
		 * @generated
		 */
		EEnum VARIATION_TYPE = eINSTANCE.getVariationType();

		/**
		 * The meta object literal for the '<em>ISat Solver Adapter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.adapter.ISatSolverAdapter
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getISatSolverAdapter()
		 * @generated
		 */
		EDataType ISAT_SOLVER_ADAPTER = eINSTANCE.getISatSolverAdapter();

		/**
		 * The meta object literal for the '<em>Sat Result</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.adapter.SatResult
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getSatResult()
		 * @generated
		 */
		EDataType SAT_RESULT = eINSTANCE.getSatResult();

		/**
		 * The meta object literal for the '<em>Sat Solver Adapter Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.sidiff.formula.adapter.exceptions.SatSolverAdapterException
		 * @see org.sidiff.formula.impl.FormulaPackageImpl#getSatSolverAdapterException()
		 * @generated
		 */
		EDataType SAT_SOLVER_ADAPTER_EXCEPTION = eINSTANCE.getSatSolverAdapterException();

	}

} //FormulaPackage
