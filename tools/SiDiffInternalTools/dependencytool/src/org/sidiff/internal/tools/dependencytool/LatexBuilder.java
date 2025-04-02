package org.sidiff.internal.tools.dependencytool;

import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class LatexBuilder {

	
	
	/**
	 * 
	 * @return LATEX-Document as String
	 */
	public StringBuffer createTEXFileSiDiffDependencies(HashMap<String, Plugin> siDiffPluginsMap) {

		StringBuffer result = new StringBuffer();

		int cols = siDiffPluginsMap.keySet().size();

		result.append("%\\begin{sidewaystable}\n{\\tiny\n\\begin{tabular}{|p{3,5cm}");

		for (int i = 0; i < cols; i++) {
			result.append("|c");
		}
		result.append("|}\n\\hline ");

		Vector<String> siDiffKeySet = new Vector<String>(siDiffPluginsMap.keySet());
		Collections.sort(siDiffKeySet);

		// for (Iterator iterator = siDiffKeySet.iterator();
		// iterator.hasNext();) {
		// String name = (String) iterator.next();
		// result.append("& \\begin{rotate}{90}"+ name.substring(11) +
		// " \\end{rotate}\n");
		// }

		for (Iterator<String> iterator = siDiffKeySet.iterator(); iterator.hasNext();) {
			String name = (String) iterator.next();
			//name = name.substring(4);

			String tep = name;
			if (name.length() > 37) {
				tep = tep.substring(0, 37) + " " + tep.substring(37);
			}
			result.append("& \\rotatebox{90}{\\parbox{4cm}{" + tep.replace("_", "\\_") + " }}\n");
		}

		result.append("\\\\" + "\n" + "\\hline\n");
		// \begin{rotate}{90} org.eclipse.equinox \end{rotate} &

		// Tabelleninhalt erstellen

		Vector<String> siDiffSet = new Vector<String>(siDiffPluginsMap.keySet());
		Collections.sort(siDiffSet);

		for (Iterator<String> iterator = siDiffSet.iterator(); iterator
				.hasNext();) {
			String name = (String) iterator.next();
			Plugin plugin = siDiffPluginsMap.get(name);

			String tmp = "";

			String[] split = name.split("\\.");

			// Falls zu lang auf 2 Zeilen verschieben
			for (int i = 0; i < split.length; i++) {

				if (tmp.equals("")) {
					tmp += split[i] + ".";
				} else {

					String proof = tmp;
					if (tmp.contains("\\newline")) {
						proof = tmp.substring(tmp.indexOf("\\newline"));
					}

					if (proof.length() + split[i].length() > 34) {
						tmp += "\\newline " + split[i] + ".";
					} else {
						tmp += split[i] + ".";
					}

				}

			}
			tmp = tmp.substring(0, tmp.length() - 1);
			result.append(tmp.replace("_", "\\_"));
			
			LinkedList<Plugin> depList = plugin.sidiffPlugins;

			// Durch die Spalten laufen
			for (Iterator<String> iterator2 = siDiffKeySet.iterator(); iterator2
					.hasNext();) {
				String s = (String) iterator2.next();

				String gridvalue = "";
				// Pr�fen ob die Spalte eine Dependency ist
				for (int k = 0; k < depList.size(); k++) {
					if (depList.get(k).name.equals(s)) {
						gridvalue = "&" + "x";
						break;
					}

				}

				if (gridvalue.equals("")) {
					gridvalue = "&";
				}
				result.append(gridvalue);
			}

			result.append("\\\\ \n\\hline\n");
		}

		result.append("\\end{tabular} }\n%\\end{sidewaystable}");

		return result;
	}

	
	/**
	 * 
	 * @return LATEX-Document as String
	 */
	public StringBuffer createTEXFileOtherDependencies(HashMap<String, Plugin> otherPluginsMap,HashMap<String, Plugin> siDiffPluginsMap ) {

		StringBuffer result = new StringBuffer();

		int cols = otherPluginsMap.keySet().size();

		result.append("%\\begin{sidewaystable}\n{\\tiny \\begin{tabular}{|p{8cm}");

		for (int i = 0; i < cols; i++) {
			result.append("|c");
		}
		result.append("|}\n\\hline\n");

		Vector<String> otherSet = new Vector<String>(otherPluginsMap.keySet());
		Collections.sort(otherSet);
		

		for (Iterator<String> iterator = otherSet.iterator(); iterator
				.hasNext();) {
			String name = (String) iterator.next();
			result.append("& \\rotatebox{90}{\\parbox{4cm}{" + name.replace("_", "\\_") + " }}\n");
		}

		result.append("\\\\" + "\n" + "\\hline\n");
		// \begin{rotate}{90} org.eclipse.equinox \end{rotate} &

		// Tabelleninhalt erstellen

		Vector<String> siDiffSet = new Vector<String>(siDiffPluginsMap.keySet());
		
		Collections.sort(siDiffSet);

		for (Iterator<String> iterator = siDiffSet.iterator(); iterator
				.hasNext();) {
			String name = (String) iterator.next();
			Plugin plugin = siDiffPluginsMap.get(name);

			result.append(name.replace("_", "\\_"));

			LinkedList<Plugin> depList = plugin.otherPlugins;

			// Durch die Spalten laufen
			for (Iterator<String> iterator2 = otherSet.iterator(); iterator2
					.hasNext();) {
				String s = (String) iterator2.next();

				String gridvalue = "";
				// Pr�fen ob die Spalte eine Dependency ist
				for (int k = 0; k < depList.size(); k++) {
					if (depList.get(k).name.equals(s)) {
						gridvalue = "&" + "x";
						break;
					}

				}

				if (gridvalue.equals("")) {
					gridvalue = "&";
				}
				result.append(gridvalue);
			}

			result.append("\\\\ \n\\hline\n");
		}

		result.append("\\end{tabular} } %\\end{sidewaystable}\n \\newpage");

		return result;
	}
	
	
	/**
	 * Exports the tex files to dependencies.tex
	 * 
	 * @param tex1 Other dependencies 
	 * @param tex2 siDiff dependencies 
	 * @param outputPath Path to latex sources
	 */
	public void exportTexFiles(String outputPath, StringBuffer... tex) {
		
		try {
			FileOutputStream f = new FileOutputStream(outputPath);

			for (StringBuffer tex1 : tex)
			for (int i = 0; i < tex1.length(); i++) {
				f.write(tex1.charAt(i));
			}

			f.close();
			// f.write(tex1+"\n"+tex2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
