package org.sidiff.formula.util.internal;

/**
 * <expression> ::= <formula1> { 'implies' <formula1> }
 * <formula1>	::= <formula2> { ('or' | 'xor') <formula2> }
 * <formula2> 	::= <formula3> { 'and' <formula3> }
 * <formula3> 	::= <variable> | (' <expression> ')' | 'not(' <expression> ')'
 * <variable> 	::= <letter> { <letter> | <digit> }
 * <letter>		::= 'A' | ... | 'z' | 'a' | ... | 'z'
 * <digit>		::= '0' | ... | '9'
 * @author cpietsch
 *
 */

public class FormulaParserTest {
//	
//	private static final String NEG = "not";
//	private static final String OR = "or";
//	private static final String XOR = "xor";
//	private static final String AND = "and";
//	private static final String IMPLIES = "implies";
//	private static final String OPEN_BRACKET = "(";
//	private static final String CLOSE_BRACKET = ")";
//	
//	private Tokenizer<String> tokenizer;
//	
//	private Formula expression() throws InvalidFormulaException{
//		Formula formula = this.formula1();
//		while(tokenizer.hasNext() && tokenizer.peek().equals(IMPLIES)){
//			tokenizer.next();
//			Implies implies = FormulaFactory.eINSTANCE.createImplies();
//			implies.setLeft(formula);
//			implies.setRight(this.formula1());
//			formula = implies;
//		}
//		return formula;
//	}
//	
//	private Formula formula1() throws InvalidFormulaException{
//		Formula formula = this.formula2();
//		while(tokenizer.hasNext() && (tokenizer.peek().equals(OR) || tokenizer.peek().equals(XOR))){
//			if(tokenizer.peek().equals(OR)){
//				tokenizer.next();
//				Or or = FormulaFactory.eINSTANCE.createOr();
//				or.setLeft(formula);
//				or.setRight(this.formula2());
//				formula = or;
//			}else if(tokenizer.peek().equals(XOR)){
//				tokenizer.next();
//				Xor xor = FormulaFactory.eINSTANCE.createXor();
//				xor.setLeft(formula);
//				xor.setRight(this.formula2());
//				formula = xor;
//			}
//		}
//		return formula;
//	}
//	
//	private Formula formula2() throws InvalidFormulaException{
//		Formula formula = this.formula3();
//		while(tokenizer.hasNext() && tokenizer.peek().equals(AND)){
//			tokenizer.next();
//			And and = FormulaFactory.eINSTANCE.createAnd();
//			and.setLeft(formula);
//			and.setRight(this.formula3());
//			formula = and;
//		}
//		return formula;
//	}
//	
//	private Formula formula3() throws InvalidFormulaException{
//		Formula formula = null;
//		if(tokenizer.hasNext() && tokenizer.peek().equals(NEG)){
//			tokenizer.next();
//			if(tokenizer.hasNext() && tokenizer.peek().equals(OPEN_BRACKET)) {
//				tokenizer.next();
//				Not not = FormulaFactory.eINSTANCE.createNot();
//				not.setFormula(this.expression());
//				formula = not;
//				if(tokenizer.hasNext() && tokenizer.peek().equals(CLOSE_BRACKET)){
//					tokenizer.next();
//				}else{
//					throw new InvalidFormulaException("Missing '" + CLOSE_BRACKET + "'");
//				}
//			}else {
//				throw new InvalidFormulaException("Missing '" + OPEN_BRACKET + "'");
//			}
//		} else
//		if(tokenizer.hasNext() && tokenizer.peek().equals(OPEN_BRACKET)){
//			tokenizer.next();
//			formula = this.expression();
//			if(tokenizer.hasNext() && tokenizer.peek().equals(CLOSE_BRACKET)){
//				tokenizer.next();
//			}else{
//				throw new InvalidFormulaException("Missing '" + CLOSE_BRACKET + "'");
//			}
//		}else {
//			formula = this.variable();
//		}
//		return formula;
//	}
//	
//	private Formula variable() throws InvalidFormulaException{
//		if(tokenizer.hasNext() && tokenizer.peek().matches("\\w*")){
//			Variable variable = FormulaFactory.eINSTANCE.createVariable();
//			variable.setName(tokenizer.next());
//			return variable;
//		}else{
//			throw new InvalidFormulaException("Variable expected");
//		}
//	}
//	
//	
//	public Formula parse(String s) throws InvalidFormulaException{
//		// remove any whitespace character
//		
//		String expression = s.replaceAll("\\s*\\(\\s*", " ( ");
//		expression = expression.replaceAll("\\s*\\)\\s*", " ) ");
//		expression = expression.trim();
//		expression = expression.replaceAll("\\s+", ";");
//		tokenizer = new Tokenizer<String>(expression.split(";"));
//		Formula formula = this.expression();
//
//		if(tokenizer.hasNext()) {
//			throw new InvalidFormulaException("'" + AND + "', '" + OR + "', '" + XOR + "' or '" + IMPLIES + "' " + "instead of " + tokenizer.next() + " expected");
//		}
//		
//		return formula;
//	}
//	
//	public static void main(String[] args){
//
//		String expression = "(A and B or c)";
//		System.out.println(expression);
//		FormulaParserTest parser = new FormulaParserTest();
//
//		try {
//			Formula origin_formula = parser.parse(expression);
//			List<Configuration> configs = Formula.getValidConfigurations(origin_formula);
//			int i = 1;
//			for(Configuration config : configs) {
//				try {
//					config.export("config"+i+++".cfg");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
////			Formula cnf_formula = origin_formula.cnf();
////			
////			Map<String, Set<Variable>> variables_origin = new HashMap<String, Set<Variable>>();
////			Map<String, Set<Variable>> variables_cnf = new HashMap<String, Set<Variable>>();
////			
////			for(Variable variable : origin_formula.getVariables()) {
////				if(variables_origin.get(variable.getName()) == null) {
////					Set<Variable> variables = new HashSet<Variable>();
////					variables_origin.put(variable.getName(), variables);
////				}
////				variables_origin.get(variable.getName()).add(variable);
////			}
////			
////			for(Variable variable : cnf_formula.getVariables()) {
////				if(variables_cnf.get(variable.getName()) == null) {
////					Set<Variable> variables = new HashSet<Variable>();
////					variables_cnf.put(variable.getName(), variables);
////				}
////				variables_cnf.get(variable.getName()).add(variable);
////			}
////			
////			Configuration config_origin = FormulaFactory.eINSTANCE.createConfiguration();
////			config_origin.init(origin_formula);
////			Configuration config_cnf = FormulaFactory.eINSTANCE.createConfiguration();
////			config_cnf.init(cnf_formula);
////			List<String> orderedVariables = new ArrayList<String>(variables_origin.keySet());
////			Collections.sort(orderedVariables);
////				int[] binary = new int[orderedVariables.size()];
////				for(int j = 0; j < Math.pow(2,orderedVariables.size()) ; j++) {
////					char[] binaryChar = Integer.toBinaryString(j).toCharArray();
////					for(int k = 0; k < binary.length ; k++ ) {
////						if( binaryChar.length - binary.length + k < 0) {
////							binary[k] = 0;
////						}else {
////							binary[k] = Integer.parseInt(binaryChar[binaryChar.length- binary.length + k ] + "");
////						}
////					}
////					for(int i : binary) {
////						System.out.print(i + ",");
////					}
////					System.out.print("\n");
////					for(int i = 0; i < orderedVariables.size(); i++) {
////						String var_name = orderedVariables.get(i);
////						int var_value = binary[i];
////						for(Variable variable : variables_origin.get(var_name)) {
////							config_origin.getVariableAssignments().put(variable, var_value==1? true: false);
////						}
////						for(Variable variable : variables_cnf.get(var_name)) {
////							config_cnf.getVariableAssignments().put(variable, var_value==1? true: false);
////						}
////					
////					}
////					System.out.println(origin_formula.eval(config_origin) == cnf_formula.eval(config_cnf));
////				}
//			
//	
////			System.out.println(formula.eval(config));
////			System.out.println(parser.unparse(formula));
////			System.out.println(parser.unparse(cnf_Formula));
////			System.out.println(parser.unparse(parser.associative(cnf_Formula)));
////			System.out.println(parser.unparse(formula.cnf()));
////			String cnf_DIMACS = parser._DIMACS(cnf_Formula, new HashMap<String, Integer>());
////			System.out.println("\n" + cnf_DIMACS);
////			parser.sat(cnf_DIMACS);
//		} catch (InvalidFormulaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	private class Tokenizer<T> {
//		
//		private T[] tokens;
//		private int position;
//
//		public Tokenizer(T[] tokens){
//			this.tokens = tokens;
//			this.position = -1;
//		}
//		public boolean hasNext() {
//			return position < tokens.length - 1;
//		}
//
//		public T peek(){
//			return tokens[position+1];
//		}
//		public T next() {
//			position++;
//			return tokens[position];
//		}
//		
//	}
//	
//	public String unparse(Formula formula){
//		StringBuffer buffer = new StringBuffer();
//		if(formula instanceof Variable){
//			buffer.append(((Variable)formula).getName());
//		}else if(formula instanceof Not){
//			buffer.append("not( " + unparse(((Not)formula).getFormula()) + " )");
//		}else if(formula instanceof BinaryFormula){
//			BinaryFormula binaryFormula = (BinaryFormula) formula;
//			boolean bracketed = binaryFormula.eContainer() != null && binaryFormula.eContainer() instanceof Formula && !(binaryFormula.eContainer() instanceof Not)
//					&& ((Formula) binaryFormula.eContainer()).getPriority() < binaryFormula.getPriority() ? true
//							: false;
//			if(bracketed) buffer.append("( ");
//			EClass eClass = formula.eClass();
//			buffer.append(unparse(binaryFormula.getLeft()));
//			buffer.append(" " + eClass.getName().toLowerCase() + " ");
//			buffer.append(unparse(binaryFormula.getRight()));
//			if(bracketed) buffer.append(" )");
//		}
//		return buffer.toString();
//	}
//	
//	public Formula cnf(Formula formula) {
//		return distributiveOr(xor(deMorgan(implies(formula))));
//	}
//	
//	public Formula tautology(Formula formula) {
//		//TODO
//		return null;
//	}
//	
//	public Formula implies(Formula formula) {
//		if(formula instanceof Implies) {
//			Implies implies = (Implies) formula;
//			Or or = FormulaFactory.eINSTANCE.createOr();
//			Not notLeft = FormulaFactory.eINSTANCE.createNot();
//			notLeft.setFormula(implies(implies.getLeft()));
//			or.setLeft(notLeft);
//			or.setRight(implies(implies.getRight()));
//			return or;
//		}else if(formula instanceof And || formula instanceof Or || formula instanceof Xor) {
//			BinaryFormula binaryFormula = (BinaryFormula) formula;
//			BinaryFormula binaryFormula_ = (BinaryFormula) FormulaFactory.eINSTANCE.create(formula.eClass());
//			binaryFormula_.setLeft(implies(binaryFormula.getLeft()));
//			binaryFormula_.setRight(implies(binaryFormula.getRight()));
//			return binaryFormula_;
//		}else if(formula instanceof Not) {
//			Not not = (Not) formula;
//			Not not_ = FormulaFactory.eINSTANCE.createNot();
//			not_.setFormula(implies(not.getFormula()));
//			return not_;
//		}else {
//			return EcoreUtil.copy(formula);
//		}
//	}
//	
//	public Formula xor(Formula formula) {
//		if(formula instanceof Xor) {
//			Xor xor = (Xor) formula;
//			Or or = FormulaFactory.eINSTANCE.createOr();
//			Formula left = xor(xor.getLeft());
//			Formula right = xor(xor.getRight());
//			Not notLeft = FormulaFactory.eINSTANCE.createNot();
//			notLeft.setFormula(EcoreUtil.copy(left));
//			Not notRight = FormulaFactory.eINSTANCE.createNot();
//			notRight.setFormula(EcoreUtil.copy(right));
//			And andLeft = FormulaFactory.eINSTANCE.createAnd();
//			andLeft.setLeft(notLeft);
//			andLeft.setRight(right);
//			
//			And andRight = FormulaFactory.eINSTANCE.createAnd();
//			andRight.setLeft(left);
//			andRight.setRight(notRight);
//			
//			or.setLeft(andLeft);
//			or.setRight(andRight);
//			
//			return or;
//		}else if(formula instanceof Implies || formula instanceof Or || formula instanceof And) {
//			BinaryFormula binaryFormula = (BinaryFormula) formula;
//			BinaryFormula binaryFormula_ = (BinaryFormula) FormulaFactory.eINSTANCE.create(formula.eClass());
//			binaryFormula_.setLeft(xor(binaryFormula.getLeft()));
//			binaryFormula_.setRight(xor(binaryFormula.getRight()));
//			return binaryFormula_;
//		}else if(formula instanceof Not) {
//			Not not = (Not) formula;
//			Not not_ = FormulaFactory.eINSTANCE.createNot();
//			not_.setFormula(xor(not.getFormula()));
//			return not_;
//		}else {
//			return EcoreUtil.copy(formula);
//		}
//	}
//	
//	public Formula deMorgan(Formula formula) {
//		if(formula instanceof Not) {
//			Not not = (Not) formula;
//			if(not.getFormula() instanceof And) {
//				And and = (And) not.getFormula();
//				Or or = FormulaFactory.eINSTANCE.createOr();
//				Not notLeft = FormulaFactory.eINSTANCE.createNot();
//				notLeft.setFormula(deMorgan(and.getLeft()));
//				or.setLeft(notLeft);
//				Not notRight = FormulaFactory.eINSTANCE.createNot();
//				notRight.setFormula(deMorgan(and.getRight()));
//				or.setRight(notRight);
//				return deMorgan(or);
//			}else if(not.getFormula() instanceof Or) {
//				Or or = (Or) not.getFormula();
//				And and = FormulaFactory.eINSTANCE.createAnd();
//				Not notLeft = FormulaFactory.eINSTANCE.createNot();
//				notLeft.setFormula(deMorgan(or.getLeft()));
//				and.setLeft(notLeft);
//				Not notRight = FormulaFactory.eINSTANCE.createNot();
//				notRight.setFormula(deMorgan(or.getRight()));
//				and.setRight(notRight);
//				return deMorgan(and);
//			}else{
//				Not not_ = EcoreUtil.copy(not);
//				not_.setFormula(deMorgan(not.getFormula()));
//				return not_;
//			}
//		}else if(formula instanceof BinaryFormula) {
//			BinaryFormula binaryFormula = (BinaryFormula) formula;
//			BinaryFormula binaryFormula_ = (BinaryFormula) FormulaFactory.eINSTANCE.create(formula.eClass());
//			binaryFormula_.setLeft(deMorgan(binaryFormula.getLeft()));
//			binaryFormula_.setRight(deMorgan(binaryFormula.getRight()));
//			return binaryFormula_;
//		}else {
//			return EcoreUtil.copy(formula);
//		}
//	}
//	
//	public Formula distributiveOr(Formula formula) {
//		if(formula instanceof Or) {
//			Or or = (Or) formula;
//			if(or.getLeft() instanceof And) {
//				And orLeft = (And) or.getLeft();
//				
//				Formula andLeft = distributiveOr(orLeft.getLeft());
//				Formula andRight = distributiveOr(orLeft.getRight());
//				
//				Or or1 = FormulaFactory.eINSTANCE.createOr();
//				
//				or1.setLeft(andLeft);
//				or1.setRight(distributiveOr(or.getRight()));
//				
//				Or or2 = FormulaFactory.eINSTANCE.createOr();
//				
//				or2.setLeft(andRight);
//				or2.setRight(distributiveOr(or.getRight()));
//				
//				And and = FormulaFactory.eINSTANCE.createAnd();
//				and.setLeft(or1);
//				and.setRight(or2);
//				
//				return distributiveOr(and);
//			}else if(or.getRight() instanceof And) {
//				And orRight = (And) or.getRight();
//				
//				Formula andLeft = distributiveOr(orRight.getLeft());
//				Formula andRight = distributiveOr(orRight.getRight());
//				
//				Or or1 = FormulaFactory.eINSTANCE.createOr();
//				
//				or1.setLeft(distributiveOr(or.getLeft()));
//				or1.setRight(andLeft);
//				
//				Or or2 = FormulaFactory.eINSTANCE.createOr();
//				
//				or2.setLeft(distributiveOr(or.getLeft()));
//				or2.setRight(andRight);;
//				
//				And and = FormulaFactory.eINSTANCE.createAnd();
//				and.setLeft(or1);
//				and.setRight(or2);
//				
//				return distributiveOr(and);
//			}else {
//				Or or_ = FormulaFactory.eINSTANCE.createOr();
//				or_.setLeft(distributiveOr(or.getLeft()));
//				or_.setRight(distributiveOr(or.getRight()));
//				
//					return or_;
//				
//			}
//	
//		}else if(formula instanceof Xor || formula instanceof And) {
//			BinaryFormula binaryFormula = (BinaryFormula) formula;
//			BinaryFormula binaryFormula_ = EcoreUtil.copy(binaryFormula);
//			binaryFormula_.setLeft(distributiveOr(binaryFormula.getLeft()));
//			binaryFormula_.setRight(distributiveOr(binaryFormula.getRight()));
//			return binaryFormula_;
//		}else if(formula instanceof Implies) {
//			Implies implies = (Implies) formula;
//			Implies implies_ = EcoreUtil.copy(implies);
//			implies_.setLeft(distributiveOr(implies.getLeft()));
//			implies_.setRight(distributiveOr(implies.getRight()));
//			return implies_;
//		}else if(formula instanceof Not){
//			Not not = (Not) formula;
//			Not not_ = EcoreUtil.copy(not);
//			not_.setFormula(distributiveOr(not.getFormula()));
//			return not_;
//		}else {
//				return EcoreUtil.copy(formula);
//		}
//	}
//	
//	public Formula distributiveAnd(Formula formula) {
//		if(formula instanceof And) {
//			And and = (And) formula;
//			if(and.getLeft() instanceof Or) {
//				Or andLeft = (Or) and.getLeft();
//				
//				Formula orLeft = distributiveAnd(andLeft.getLeft());
//				Formula orRight = distributiveAnd(andLeft.getRight());
//				
//				And and1 = FormulaFactory.eINSTANCE.createAnd();
//				
//				and1.setLeft(orLeft);
//				and1.setRight(distributiveAnd(and.getRight()));
//				
//				And and2 = FormulaFactory.eINSTANCE.createAnd();
//				
//				and2.setLeft(orRight);
//				and2.setRight(distributiveAnd(and.getRight()));
//				
//				Or or = FormulaFactory.eINSTANCE.createOr();
//				or.setLeft(and1);
//				or.setRight(and2);
//				
//				return distributiveAnd(or);
//			}else if(and.getRight() instanceof Or) {
//				Or andRight = (Or) and.getRight();
//				
//				Formula orLeft = distributiveAnd(andRight.getLeft());
//				Formula orRight = distributiveAnd(andRight.getRight());
//				
//				And and1 = FormulaFactory.eINSTANCE.createAnd();
//				
//				and1.setLeft(distributiveAnd(and.getLeft()));
//				and1.setRight(orLeft);
//				
//				And and2 = FormulaFactory.eINSTANCE.createAnd();
//				
//				and2.setLeft(distributiveAnd(and.getLeft()));
//				and2.setRight(orRight);;
//				
//				Or or = FormulaFactory.eINSTANCE.createOr();
//				or.setLeft(and1);
//				or.setRight(and2);
//				
//				return distributiveAnd(or);
//			}else {
//				And and_ = FormulaFactory.eINSTANCE.createAnd();
//				and_.setLeft(distributiveAnd(and.getLeft()));
//				and_.setRight(distributiveAnd(and.getRight()));
//				return and_;
//			}
//	
//		}else if(formula instanceof Or){
//			Or or = (Or) formula;
//			Or or_ = EcoreUtil.copy(or);
//			or_.setLeft(distributiveAnd(or.getLeft()));
//			or_.setRight(distributiveAnd(or.getRight()));
//			return or_;
//		}else if(formula instanceof Xor) {
//			Xor xor = (Xor) formula;
//			Xor xor_ = EcoreUtil.copy(xor);
//			xor_.setLeft(distributiveAnd(xor.getLeft()));
//			xor_.setRight(distributiveAnd(xor.getRight()));
//			return xor_;
//		}else if(formula instanceof Implies) {
//			Implies implies = (Implies) formula;
//			Implies implies_ = EcoreUtil.copy(implies);
//			implies_.setLeft(distributiveAnd(implies.getLeft()));
//			implies_.setRight(distributiveAnd(implies.getRight()));
//			return implies_;
//		}else if(formula instanceof Not){
//			Not not = (Not) formula;
//			Not not_ = EcoreUtil.copy(not);
//			not_.setFormula(distributiveAnd(not.getFormula()));
//			return not_;
//		}else {
//				return EcoreUtil.copy(formula);
//		}
//	}
//	
//	public String _DIMACS(Formula cnf_Formula, Map<String, Integer> variables) {
//		String cnf_DIMACS = "";
//		if(cnf_Formula instanceof And) {
//			And and = (And) cnf_Formula;
//			String left = _DIMACS(and.getLeft(), variables);
//			String right = _DIMACS(and.getRight(), variables);
//			cnf_DIMACS += left;
//			if(and.getLeft() instanceof Or) {
//				cnf_DIMACS +="0\n";
//			}
//			cnf_DIMACS += right;
//			if(and.getRight() instanceof Or) {
//				cnf_DIMACS += "0\n";
//			}
//		}else if(cnf_Formula instanceof Or) {
//			Or or = (Or) cnf_Formula;
//			String left = _DIMACS(or.getLeft(), variables);
//			String right = _DIMACS(or.getRight(), variables);
//			
//			cnf_DIMACS += " " + left + " " + right + " "; 
//		}else if(cnf_Formula instanceof Not) {
//			Not not = (Not) cnf_Formula;
//			String formula = _DIMACS(not.getFormula(), variables);
//			cnf_DIMACS += "-" + formula;
//		}else {
//			Variable var = (Variable) cnf_Formula;
//			if(!variables.containsKey(var.getName())) {
//				variables.put(var.getName(), variables.size()+1);
//			}
//			
//			cnf_DIMACS += variables.get(var.getName());
//		}
//		
//		return cnf_DIMACS;
//	}
//	
//	public Formula associative(Formula formula) {
//		if(formula instanceof BinaryFormula) {
//			List<Formula> associativeFormulas = getAssociativeFormulas(formula, formula.eClass());
//			
//			BinaryFormula binaryFormula = (BinaryFormula) FormulaFactory.eINSTANCE.create(formula.eClass());
//			Formula sortedFormula = binaryFormula;
//			for(int i = 0; i<associativeFormulas.size()-1; i++) {
//	
//				binaryFormula.setLeft(associative(associativeFormulas.get(i)));
//				
//				if(i<associativeFormulas.size()-2) {
//				BinaryFormula nestedBinaryFormula = (BinaryFormula) FormulaFactory.eINSTANCE.create(formula.eClass());
//					
//				binaryFormula.setRight(nestedBinaryFormula);
//				binaryFormula = nestedBinaryFormula;
//				}else {
//					binaryFormula.setRight(associative(associativeFormulas.get(++i)));
//				}
//					
//			}
//			
//			return sortedFormula;
//		}else if(formula instanceof UnaryFormula) {
//			UnaryFormula unaryFormula = (UnaryFormula) FormulaFactory.eINSTANCE.create(formula.eClass());
//			unaryFormula.setFormula(associative(((UnaryFormula) formula).getFormula()));
//			return unaryFormula;
//		}else {
//			Variable variable = (Variable) EcoreUtil.copy(formula);
//			return variable;
//		}
//
//	}
//	
//	public List<Formula> getAssociativeFormulas(Formula formula, EClass eClass){
//		List<Formula> associativeFormulas = new ArrayList<Formula>();
//		if(formula instanceof BinaryFormula && formula.eClass().equals(eClass)) {
//			BinaryFormula binaryFormula = (BinaryFormula) formula;
//			associativeFormulas.addAll(getAssociativeFormulas(binaryFormula.getLeft(), eClass));
//			associativeFormulas.addAll(getAssociativeFormulas(binaryFormula.getRight(), eClass));
//		}else {
//			associativeFormulas.add(formula);
//		}
//		return associativeFormulas;
//	}
//	
//	public Formula associative2(Formula formula) {
//		
//		List<Or> maxterms = getMaxterms(formula);
//		
//		
//		And and = FormulaFactory.eINSTANCE.createAnd();
//		Formula sortedFormula = and;
//		for(int i = 0; i<maxterms.size()-1; i++) {
//
//			and.setLeft(maxterms.get(i));
//			
//			if(i<maxterms.size()-2) {
//			And nestedAnd = FormulaFactory.eINSTANCE.createAnd();
//				
//			and.setRight(nestedAnd);
//			and = nestedAnd;
//			}else {
//				and.setRight(maxterms.get(++i));
//			}
//				
//		}
//		
//		return sortedFormula;
//	}
//	
//	public List<Or> getMaxterms(Formula formula){
//		List<Or> maxterms = new ArrayList<Or>();
//		if(formula instanceof And) {
//			And and = (And) formula;
//			maxterms.addAll(getMaxterms(and.getLeft()));
//			maxterms.addAll(getMaxterms(and.getRight()));
//		}else {
//			maxterms.add((Or) formula);
//		}
//		return maxterms;
//	}
//	
//	public void sat(String cnf_DIMACS) {
//		
//		String[] or_clauses = cnf_DIMACS.replace("\n", "").split("0");
//		int[][] or_clauses_int = new int[or_clauses.length][];
//		for(int i = 0; i < or_clauses.length; i++) {
//			String or_clause = or_clauses[i].trim();
//			String[] vars = or_clause.split(" ");
//			int[] or_clause_int = new int[vars.length];
//			for(int j = 0 ; j < vars.length; j++) {
//				or_clause_int[j] = Integer.parseInt(vars[j].trim());
//			}
//			or_clauses_int[i] = or_clause_int;
//		}
//		final int MAXVAR = 1000000;
//		final int NBCLAUSES = 500000;
//
//		ISolver solver = SolverFactory.newDefault();
//
//		// prepare the solver to accept MAXVAR variables. MANDATORY for MAXSAT solving
//		solver.newVar(MAXVAR);
//		solver.setExpectedNumberOfClauses(NBCLAUSES);
//		// Feed the solver using Dimacs format, using arrays of int
//		// (best option to avoid dependencies on SAT4J IVecInt)
//		for (int i=0;i<or_clauses_int.length;i++) {
//		  // the clause should not contain a 0, only integer (positive or negative)
//		  // with absolute values less or equal to MAXVAR
//		  // e.g. int [] clause = {1, -3, 7}; is fine
//		  // while int [] clause = {1, -3, 7, 0}; is not fine 
//		  try {
//			solver.addClause(new VecInt(or_clauses_int[i]));
//		} catch (ContradictionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // adapt Array to IVecInt
//		}
//        // CNF filename is given on the command line 
//        try {
//            IProblem problem = solver;
//            if (problem.isSatisfiable()) {
//                System.out.println("Satisfiable !");
//            } else {
//                System.out.println("Unsatisfiable !");
//            }
//        } catch (TimeoutException e) {
//            System.out.println("Timeout, sorry!");      
//        }
//    
//	}
	
}
