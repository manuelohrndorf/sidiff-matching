package org.sidiff.internal.tools.obfuscateTool;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.sidiff.common.io.IOUtil;

public class ManifestAdjuster {

	public static void main(String[] args) {
		
		//Deleting some strange characters at the end of the file
		String filename = args[0];
		InputStream input = IOUtil.getInputStream(filename);
		String inputString = IOUtil.readFromStream(input);
		String adjustetString = inputString.substring(0, inputString.length() - 3);
		try {
		IOUtil.writeToStream(adjustetString, new FileOutputStream(filename), true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}