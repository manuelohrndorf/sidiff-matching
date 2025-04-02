package org.sidiff.imotep.tools.pcsimplifier;

import java.util.AbstractMap;
import java.util.ArrayList;

public class LogParser {

	private static ArrayList<AbstractMap.SimpleEntry<EXP, String>> tokens = new ArrayList<AbstractMap.SimpleEntry<EXP, String>>();
	
	public static enum EXP{
		
		Identifier,OParanthesis,CParanthesis,And,Or,Not
		
	}
	
	public static void generateTokens(String logExp){
		
		StringBuilder builder = new StringBuilder(logExp);
		while(builder.length() != 0){
			if(builder.charAt(0) == ' '){
				builder.deleteCharAt(0);
			}
			else if(builder.charAt(0) == '\n'){
				builder.deleteCharAt(0);
			}
			else if(builder.charAt(0) == '('){
				AbstractMap.SimpleEntry<LogParser.EXP, String> e = new AbstractMap.SimpleEntry<LogParser.EXP,String>(EXP.OParanthesis,null);
				tokens.add(e);
				builder.deleteCharAt(0);
			}
			else if(builder.charAt(0) == ')'){
				AbstractMap.SimpleEntry<LogParser.EXP, String> e = new AbstractMap.SimpleEntry<LogParser.EXP,String>(EXP.CParanthesis,null);
				tokens.add(e);
				builder.deleteCharAt(0);
			}else if(builder.substring(0, 2).equals("or")){
				AbstractMap.SimpleEntry<LogParser.EXP, String> e = new AbstractMap.SimpleEntry<LogParser.EXP,String>(EXP.Or,null);
				tokens.add(e);
				builder.delete(0, 2);
			}else if(builder.substring(0, 3).equals("and")){
				AbstractMap.SimpleEntry<LogParser.EXP, String> e = new AbstractMap.SimpleEntry<LogParser.EXP,String>(EXP.And,null);
				tokens.add(e);
				builder.delete(0, 3);
			}else if(builder.substring(0, 3).equals("not")){
				AbstractMap.SimpleEntry<LogParser.EXP, String> e = new AbstractMap.SimpleEntry<LogParser.EXP,String>(EXP.Not,null);
				tokens.add(e);
				builder.delete(0, 3);
			}else{
				for(int i = 0; i < builder.length();i++){
					char c = builder.charAt(i);
					if((c == '(') || (c == ')') || (c == ' ')){
						AbstractMap.SimpleEntry<LogParser.EXP, String> e = new AbstractMap.SimpleEntry<LogParser.EXP,String>(EXP.Identifier,builder.substring(0, i));
						tokens.add(e);
						builder.delete(0, i);
						break;
					}
				}
			}
		}
	}
	
	private static LogTree constructTree(ArrayList<AbstractMap.SimpleEntry<EXP,String>> list){
		
		LogTree result = new LogTree();
		
		if(list.get(0).getKey() == EXP.Identifier){
			result.setExpression(list.get(0).getValue());
		}else if(list.get(0).getKey() == EXP.OParanthesis){
			if(list.get(1).getKey() == EXP.And)
				result.setExpression("&&");
			else if(list.get(1).getKey() == EXP.Or)
				result.setExpression("||");
			else if(list.get(1).getKey() == EXP.Not)
				result.setExpression("!");
			ArrayList<ArrayList<AbstractMap.SimpleEntry<EXP, String>>> childlists = splitTokens(list);
			for(ArrayList<AbstractMap.SimpleEntry<EXP, String>> l : childlists){
				result.addChild(constructTree(l));
			}
		}
		
		return result;
		
	}
	
	private static ArrayList<ArrayList<AbstractMap.SimpleEntry<EXP, String>>> splitTokens(ArrayList<AbstractMap.SimpleEntry<EXP,String>> list){
		
		ArrayList<ArrayList<AbstractMap.SimpleEntry<EXP, String>>> result = new ArrayList<ArrayList<AbstractMap.SimpleEntry<EXP, String>>>();
		
		if(list.get(0).getKey() == EXP.OParanthesis){
			list.remove(0);
			list.remove(list.size()-1);
		}
		
		for(int i = 0; i < list.size();i++){
			if(list.get(i).getKey() == EXP.Identifier){
				ArrayList<AbstractMap.SimpleEntry<EXP, String>> newList = new ArrayList<AbstractMap.SimpleEntry<EXP, String>>();
				newList.add(list.get(i));
				result.add(newList);
			}else if(list.get(i).getKey() == EXP.OParanthesis){
				int openParen = 0;
				ArrayList<AbstractMap.SimpleEntry<EXP, String>> newList = new ArrayList<AbstractMap.SimpleEntry<EXP, String>>();
				for(int j = i; j < list.size(); j++){
					newList.add(list.get(j));
					if(list.get(j).getKey() == EXP.OParanthesis)
						openParen++;
					else if(list.get(j).getKey() == EXP.CParanthesis)
						openParen--;
					if(openParen == 0){
						i = j;
						break;
					}
				}
				result.add(newList);
			}
		}
		
		return result;
	}
	
	public static String parse(String logExp){	
		
		generateTokens(logExp);
		LogTree tree = constructTree(tokens);
		String result = tree.toString();
		return result;
	}

}
