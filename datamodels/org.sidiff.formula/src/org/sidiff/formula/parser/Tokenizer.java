package org.sidiff.formula.parser;

public class Tokenizer<T> {
	
	private T[] tokens;
	private int position;

	public Tokenizer(T[] tokens){
		this.tokens = tokens;
		this.position = -1;
	}
	public boolean hasNext() {
		return position < tokens.length - 1;
	}

	public T peek(){
		return tokens[position+1];
	}
	public T next() {
		position++;
		return tokens[position];
	}
	
}
