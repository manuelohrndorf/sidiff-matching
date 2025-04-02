package org.sidiff.internal.tools.dependencytool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Plugin with its dependencies
 * 
 * @author Schneider
 *
 */
public class Plugin {

	String name;
	
	LinkedList<Plugin> sidiffPlugins=new LinkedList<Plugin>();
	
	LinkedList<Plugin> otherPlugins=new LinkedList<Plugin>();
	
	public Plugin(String name){
		this.name=name;
	}
	
	@Override
	public boolean equals(Object obj) {
			Plugin b=(Plugin) obj;
		
			if(b.name.equalsIgnoreCase(this.name))
				return true;
			return false;
	}
	
	/**
	 * overrided to debugging/testing
	 * 
	 */
	@Override
	public String toString() {
		String result=name+": \nSiDiffPlugins:\n";
		
		for (int i = 0; i < sidiffPlugins.size(); i++) {
			Plugin p=sidiffPlugins.get(i);
			result+=p.name+"\n";
		}
		
		result+="OtherPlugins:\n";
		
		for (int i = 0; i < otherPlugins.size(); i++) {
			Plugin p=otherPlugins.get(i);
			result+=p.name+"\n";
		}
		
		
		return result;
	}

	public void removeDependencies(String regex) {
		List<Plugin> del = new ArrayList<Plugin>();

		for (Plugin p : sidiffPlugins) {
			if (p.name.matches(regex))
				del.add(p);
		}
		for (Plugin p : del)
			sidiffPlugins.remove(p);
		
		del = new ArrayList<Plugin>();
		for (Plugin p : otherPlugins) {
			if (p.name.matches(regex))
				del.add(p);
		}
		for (Plugin p : del)
			otherPlugins.remove(p);
	}

}
