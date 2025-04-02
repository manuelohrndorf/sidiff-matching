package org.sidiff.imotep.tools.pcsimplifier;

import java.util.ArrayList;

public class LogTree {

	private String expression;
	private ArrayList<LogTree> children;
	private LogTree parent;
	
	public LogTree(){
		super();
		this.expression = null;
		this.children = new ArrayList<LogTree>();
		this.parent = null;
	}
	
	public LogTree(String exp, LogTree par){
		super();
		this.expression = exp;
		this.children = new ArrayList<LogTree>();
		this.parent = par;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public ArrayList<LogTree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<LogTree> children) {
		this.children = children;
	}
	
	public void addChild(LogTree child){
		this.children.add(child);
	}

	public LogTree getParent() {
		return parent;
	}

	public void setParent(LogTree parent) {
		this.parent = parent;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder("");
		if(this.getExpression().equals("&&") || this.getExpression().equals("||")){
			builder.append("(");
			builder.append(this.getChildren().get(0).toString());
			for(int i = 1; i < this.getChildren().size(); i++){
				builder.append(" ");
				builder.append(this.getExpression());
				builder.append(" ");
				builder.append(this.getChildren().get(i).toString());
			}
			builder.append(")");
		}else if(this.getExpression().contentEquals("!")){
			builder.append("!");
			if(this.getChildren().size() > 1){
				builder.append("(");
				builder.append(this.getChildren().get(0).toString());
				for(int i = 1; i < this.getChildren().size(); i++){
				builder.append(" ");
				builder.append(this.getChildren().get(i).toString());
				}
				builder.append(")");
			}else
				builder.append(this.getChildren().get(0).toString());
		}else{
			builder.append(this.getExpression());
		}
		
		return builder.toString();
	}
}
