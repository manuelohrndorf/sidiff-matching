package org.sidiff.internal.tools.dependencytool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.uml2.uml.Model;

import att.grappa.Graph;

/**
 * Main Class for reading plugins and their dependencies to other Plugins
 * written in the Meta-inf.mf a Eclipse PlugIn Project.
 * 
 * @author Schneider
 * 
 */
public class DependencyCreator {

	// Path to plugin Folders
	public static String inputPath = "";

	// Path to resource folder
	public static String resourcePath = "";

	// Path to output folder
	public static String outputPath = "";

	public static String removeFromTable = "removeFromTable.txt";

	public static String removeFromGraph = "removeFromGraph.txt";

	public static String dependencyTable = "dependencyTable.tex";

	public static String dependencyGraph = "dependencyGraph.txt";
	
	public static String dependencyModel = "dependencyModel.uml";

	public static String emptyModel = "empty.uml";

	public static String MANIFEST = "META-INF" + File.separator + "MANIFEST.MF";
	
	public static String DESCRIPTION_TXT = "description.txt";

	// HashMaps holds the Plugins wit key plugin name
	HashMap<String, Plugin> siDiffPluginsMap = new HashMap<String, Plugin>();
	HashMap<String, Plugin> otherPluginsMap = new HashMap<String, Plugin>();

	public void start() {

		readPluginNames();
		createDescriptions();

		LatexBuilder lb = new LatexBuilder();

		removePackages(removeFromTable);

		StringBuffer a = lb.createTEXFileOtherDependencies(otherPluginsMap,
				siDiffPluginsMap);
		StringBuffer b = lb.createTEXFileSiDiffDependencies(siDiffPluginsMap);

		lb.exportTexFiles(outputPath + File.separator + dependencyTable, a,b);

		UMLBuilder ub = new UMLBuilder();
		org.eclipse.uml2.uml.Package m = ub.createClassDiagram(siDiffPluginsMap);
		
		removePackages(removeFromGraph);

		GrappaBuilder gb = new GrappaBuilder();
		Graph graph = gb.createGraphvizGraph(siDiffPluginsMap);
		gb.exportGrappaFile(graph, outputPath + File.separator
				+ dependencyGraph);
		
	}

	/**
	 * reads the foldernames from InputPath Dirctory and interpretates them as
	 * plugin-names
	 */
	public void readPluginNames() {

		// reads Plugin Names
		File dir = new File(inputPath);

		File[] files = dir.listFiles();
		Arrays.sort(files);

		for (int i = 0; i < files.length; i++) {
			if (new File(files[i].getAbsolutePath() + File.separator
					+ MANIFEST).exists())
				siDiffPluginsMap.put(files[i].getName(), new Plugin(files[i].getName()));
			else
				System.out.println("Not a bundle: " + files[i].getName());
		}

	}

	/**
	 * Removes the readed Plugins in datamodel specified in the overgiven file
	 * (one plugin per line)
	 * 
	 * @param filename
	 *            txt file from output directory
	 */
	public void removePackages(String filename) {

		try {

			FileReader fileReader = new FileReader(resourcePath
					+ File.separator + filename);
			BufferedReader br = new BufferedReader(fileReader);
			String zeile;

			List<String> del = new ArrayList<String>();

			while ((zeile = br.readLine()) != null) {
				for (String pluginName : siDiffPluginsMap.keySet()) {
					Plugin p = siDiffPluginsMap.get(pluginName);
					p.removeDependencies(zeile);
				}

				for (String pluginName : siDiffPluginsMap.keySet()) {
					if (pluginName.matches(zeile))
						del.add(pluginName);
				}
				for (String pluginName : otherPluginsMap.keySet()) {
					if (pluginName.matches(zeile))
						del.add(pluginName);
				}

			}

			for (String pluginName : del) {
				siDiffPluginsMap.remove(pluginName);
				otherPluginsMap.remove(pluginName);
			}

			fileReader.close();

		}

		catch (Exception e) {
			System.out.println(e);

		}

	}

	/**
	 * Creates the dependencies for all SiDiffPlugins (not Other Plugins)
	 */
	public void createDescriptions() {
		// Creates Dependencies for each plugin in sidiffpluginsmap
		Set<String> keySet = siDiffPluginsMap.keySet();
		int i = 0;

		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			i++;
			String[] dependencies = parseDependencies(loadMetaInf(key));
			fillOtherPluginsMap(dependencies);
			createDependenciesForSinglePlugin(key, dependencies);

		}
	}

	/**
	 * Use for one single Meta-Inf file to parse out its dependencies
	 * 
	 * @param metaInf
	 *            as String
	 * @return String Array with dependency names parsed out of the META-INF
	 *         file
	 */
	public String[] parseDependencies(String metaInf) {

		boolean noRequires = false;
		boolean noImports = false;
		// Den passenden Teil von rausschneiden (Require Bundles)

		ArrayList<String> dependencies = new ArrayList<String>();
		
		int beginIndex = metaInf.indexOf("Require-Bundle") + 15;
		int endIndex = metaInf.lastIndexOf("bundle-version");

		if (beginIndex == 14 || endIndex == -1) {
			noRequires = true;
		}

		if (!noRequires) {
			String tmp = metaInf.substring(beginIndex, endIndex);

			String[] split = tmp.split(",");

			for (int i = 0; i < split.length; i++) {

				while (split[i].startsWith(" ")) {
					split[i] = split[i].substring(1);
				}

				String[] line = split[i].split(";");
				dependencies.add(line[0].trim());

			}
		}
		// Den 2.Teil rausschneiden (Import Packages)

		beginIndex = metaInf.indexOf("Import-Package") + 15;
		endIndex = metaInf.lastIndexOf(";version");

		if (beginIndex == 14 || endIndex == -1) {
			noImports = true;
		}


		if (!noImports) {
			String tmp = metaInf.substring(beginIndex, endIndex);

			String[] split = tmp.split(",");

			for (int i = 0; i < split.length; i++) {

				while (split[i].startsWith(" ")) {
					split[i] = split[i].substring(1);
				}

				String[] line = split[i].split(";");
				dependencies.add(line[0].trim());
				
			}
		}

		if (noRequires && noImports)
			return new String[0];
		
		return (String[])dependencies.toArray(new String[]{});

	}

	// Helper Methods

	/**
	 * returns the content of a META-INF as String by given
	 * foldername(pluginname e.g. org.sidiff.core.test)
	 */
	public String loadMetaInf(String folder) {

		String path = inputPath + File.separator + folder + File.separator
				+ MANIFEST;

		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader br = new BufferedReader(fileReader);
			StringBuffer lesepuffer = new StringBuffer();
			String zeile;

			while ((zeile = br.readLine()) != null)
				lesepuffer.append(zeile + "\n");

			fileReader.close();
			return new String(lesepuffer);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * returns the content of a description.txt as String by given
	 * foldername(pluginname e.g. org.sidiff.core.test)
	 */
	public String loadDescription(String folder) {

		String path = inputPath + File.separator + folder + File.separator
				+ DESCRIPTION_TXT;

		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader br = new BufferedReader(fileReader);
			StringBuffer lesepuffer = new StringBuffer();
			String zeile;

			while ((zeile = br.readLine()) != null)
				lesepuffer.append(zeile + "\n");

			fileReader.close();
			return new String(lesepuffer);
		} catch (FileNotFoundException e) {
			return "?\nno description available\n";
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Proofs if the given plugins exits in the otherpluginsmap If not exists
	 * creates a new entry into the Hashmap
	 * 
	 * @param dependencies
	 *            plugin names as String Array
	 */
	public void fillOtherPluginsMap(String[] dependencies) {

		for (int i = 0; i < dependencies.length; i++) {
			String p = dependencies[i];

			if (!siDiffPluginsMap.containsKey(p)) {
				if (!otherPluginsMap.containsKey(p)) {
					otherPluginsMap.put(p, new Plugin(p));
				}
			}
		}

	}

	/**
	 * Adds the dependencies to the List in the Plugin Object. Proofs if to add
	 * a SiDiff Plugin or an other Plugin
	 * 
	 * @param pluginName
	 *            name of the SiDiff Plugin
	 * @param dependencies
	 *            dependencies of the given plugin
	 */
	public void createDependenciesForSinglePlugin(String pluginName, String[] dependencies) {
		//System.out.println(pluginName);
		if (siDiffPluginsMap.containsKey(pluginName)) {
			Plugin plugin = siDiffPluginsMap.get(pluginName);
			for (int i = 0; i < dependencies.length; i++) {
				String depend = dependencies[i];
				//System.out.println("\t" + depend);
				if (siDiffPluginsMap.containsKey(depend)) {
					Plugin dep = siDiffPluginsMap.get(depend);
					plugin.sidiffPlugins.add(dep);
				} else {
					Plugin dep = otherPluginsMap.get(depend);
					plugin.otherPlugins.add(dep);
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 *            0: input folder(plugins) <br>
	 *            1: output folder(latex)
	 * 
	 */
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0] != null) {
				inputPath = args[0];
			}
			if (args.length > 1) {
				if (args[1] != null) {
					resourcePath = args[1];
				}
			}
			if (args.length > 2) {
				if (args[2] != null) {
					outputPath = args[2];
				}
			}
		}
		new DependencyCreator().start();
	}

}
