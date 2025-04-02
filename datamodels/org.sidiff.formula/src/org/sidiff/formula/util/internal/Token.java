package org.sidiff.formula.util.internal;

public class Token {

	public static final int EPSILON = 0;
	public static final int AND = 1;
	public static final int OR = 2;
	public static final int NOT= 3;
	public static final int IMPLIES = 4;
	public static final int XOR = 5;
	public static final int OPEN_BRACKET = 6;
	public static final int CLOSE_BRACKET = 7;
	public static final int VARIABLE = 8;
	
	public final int token;
	public final String sequence;
	
	
	public Token(int token, String sequence) {
		this.token = token;
		this.sequence = sequence;
	}

}
