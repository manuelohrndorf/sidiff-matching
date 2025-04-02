package org.sidiff.internal.tools.dependencytool;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

import att.grappa.Edge;
import att.grappa.Graph;
import att.grappa.Node;

/**
 * Class for building and exporting an Graphviz Graph with the siDiff
 * Dependencies Graphviz output has to be compiled to get a picture (gif, jpg
 * etc)
 * 
 * @author Schneider
 * 
 */
public class GrappaBuilder {

	/**
	 * Builds a Dependency Graph for Plugins in Graphviz notation.
	 * 
	 * @param siDiffPluginsMap
	 * @return Grappa Graph (Graphviz)
	 */
	public Graph createGraphvizGraph(HashMap<String, Plugin> siDiffPluginsMap) {

		HashMap<String, Node> nodeMap = new HashMap<String, Node>();
		Graph graph = new Graph("Dependencies");
		graph.setAttribute("ranksep", "2.5");
		graph.setAttribute("ratio", "auto");

		Vector<String> keySet = new Vector<String>(siDiffPluginsMap.keySet());

		// Knoten erstellen
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String plugin = iterator.next();
			Node n = new Node(graph, plugin);
			nodeMap.put(plugin, n);
		}

		// Kanten erstellen
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String plugin = (String) iterator.next();
			Node parentNode = nodeMap.get(plugin);

			Plugin p = siDiffPluginsMap.get(plugin);
			LinkedList<Plugin> dependencyList = p.sidiffPlugins;

			for (Iterator<Plugin> iterator2 = dependencyList.iterator(); iterator2
					.hasNext();) {
				Plugin plugin2 = (Plugin) iterator2.next();
				Node childNode = nodeMap.get(plugin2.name);
				new Edge(graph, parentNode, childNode);
			}

		}

		return graph;
	}

	/**
	 * Exports the given Grappa Graph to a Graphviz File
	 * 
	 * @param graph
	 *            Grappa graph
	 * @param outputPath
	 *            Path to latex sources
	 */
	public void exportGrappaFile(Graph graph, String outputPath) {

		FileOutputStream f;
		try {
			f = new FileOutputStream(outputPath);
			graph.printGraph(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
