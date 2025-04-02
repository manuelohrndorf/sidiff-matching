package org.sidiff.internal.tools.obfuscateTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class MappingTool {
	
	static final String ARROW = " ->";
	
	public static String getNewClassName(String oldClassName) {

		String result = null;
		try {
			String mappingFilename = "../proGuard/mapping.pro";

			// Use this construct to get the relative path
//			FileReader fileReader = new FileReader(ConfigurationAdjuster.class.getClassLoader()
//                    .getResource(mappingFilename).getPath()
//                    .replaceAll("%20", " "));
			FileReader fileReader = new FileReader(mappingFilename);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			int matches = 0;
			while ((line = reader.readLine()) != null) {
				if (line.contains(oldClassName + ARROW)) {
					matches++;
					String[] stringTokens = line.split("\\.|:");
					// If ":" is the last token use the previous one
					if (stringTokens[stringTokens.length - 1].equals(":")) {
						result = stringTokens[stringTokens.length - 1];
					}
					result = stringTokens[stringTokens.length - 1];
				}
			}
			if (matches == 0) {
				// Does not need to be an exception
				System.out.println("Warning: " + oldClassName + " could not be matched");
			} else {
				if (matches > 1) {
					throw new Exception("More than one possible match for : oldClassName");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Caught FileNotFoundException " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Caught Exception " + e.getMessage());
		}
		return result;
	}
	
	public static void writeFile(Document doc, String filename) {
				
		// Prepare the DOM document for writing
		Source source = new DOMSource(doc);

		// Prepare the output file
		File outputFile = new File(filename);
		Result result = new StreamResult(outputFile);

		// Write the DOM document to the file
		try {
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(source, result);
		} catch (TransformerException e) {
			System.err.println("Caught TransformerException " + e.getMessage());
		}
	}

}
