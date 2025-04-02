package org.sidiff.sysml.testdata.analyzer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.sysml.SysmlPackage;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementRelated;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.sidiff.common.emf.EMFUtil;


/*
 * Class for analyzing the sysml PP-Unit case study
 * Reports and/or summary are written to detect
 * differences between notation and model of given revisions
 * 
 * Output format is a comma seperated value file with
 * {@link delimiter} defined here.
 * 
 * @author dreuling
 */
public class SysMLAnalyzer {

	
	//Global output variables
	static String delimiter = "|";
	static String reportHeading = "XMI-ID" + delimiter + "StereoType-ID"
			+ delimiter + "ElementType" + delimiter + "ElementName" + delimiter
			+ "Undefined" + delimiter + "Global" + delimiter
			+ System.lineSeparator();
	
	static String baseFolder = "../org.sidiff.sysml.testdata/Stempelanlage/";


	//Global configuration parameters 
	static boolean writeReports = true;
	static boolean writeSummary = true;
	static boolean output = false;

	//Reports for all revisions
	static ArrayList<StringBuilder> reports = new ArrayList<StringBuilder>();
	
	//Summary of all revisions
	static StringBuilder summary = new StringBuilder();

	//Resources and folders
	static ArrayList<Resource> modelResources = new ArrayList<Resource>();
	static ArrayList<String> notationContents = new ArrayList<String>();
	static ArrayList<String> folderNames = new ArrayList<String>();

	//Differences detected between notation and model
	static Map<String, Map<String, ArrayList<String>>> differences;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//Set all names of sysml testcase accordingly
		for (int i = 0; i < 14; i++) {
			if (i != 6) {
				if (i < 10 && i != 4) {
					folderNames.add((new File(baseFolder + "Scen0" + i)
							.getAbsolutePath()) + "/");

				} else if (i == 4) {
					folderNames.add((new File(baseFolder + "Scen04a_and_b")
							.getAbsolutePath()) + "/");

				} else {
					folderNames.add((new File(baseFolder + "Scen" + i)
							.getAbsolutePath()) + "/");
				}
			}
		}

		//Add all resources
		for (String foldername : folderNames) {

			modelResources.add(loadResource(foldername + "model.uml"));
			notationContents
					.add(loadFileContent(foldername + "model.notation"));

		}

		System.out.println("Creating report(s)...");

		//Detect all differences between model and notation
		differences = analyzeModelDifferences(modelResources, notationContents);

		System.out.println("Report(s) created!");

		//Write report files
		if (writeReports) {

			for (String key : differences.keySet()) {

				StringBuilder report = createReport(differences.get(key));
				File file = new File(baseFolder + key + "/report.csv");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(report.toString());
				writer.close();
				System.out.println("Report for " + key + " written!");
			}

		}

		//Write summary file
		if (writeSummary) {

			StringBuilder report = createSummary(differences);
			File file = new File(baseFolder + "reportSummary.csv");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(report.toString());
			writer.close();
			System.out.println("Report summary written !");
		}

		//Write analyze to standard output
		if (output) {

			System.out.print(createOutput(differences));
		}

	}

	
	/*
	 * Helper method for loading resource
	 * 
	 * @param filename Filename of resource to load
	 * @return resource Resource for given filename
	 * 
	 */
	public static Resource loadResource(String filename) {

		SysmlPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("uml", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(URI.createURI(filename), true);
		return resource;
	}

	/*
	 * Helper method for loading file content as concatenated string
	 * 
	 * @param path File path of resource 
	 * @return string String containing contents of resource for given file path
	 * 
	 */
	public static String loadFileContent(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return Charset.defaultCharset().decode(ByteBuffer.wrap(encoded))
				.toString();
	}

	/*
	 * Analyze differences between model and notation 
	 * 
	 * @param modelResources ArrayList of all resources to analyze
	 * @param notationContents ArrayList of all Strings containing the content of the corresponding notation file
	 * @return differences All found differences between model and notation
	 * 
	 */
	public static Map<String, Map<String, ArrayList<String>>> analyzeModelDifferences(
			ArrayList<Resource> modelResources,
			ArrayList<String> notationContents) {

		//Create differences map for all revision
		Map<String, Map<String, ArrayList<String>>> differences = new TreeMap<>();
		
		//Iterate over all given resources
		for (int z = 0; z < modelResources.size(); z++) {

			//Create difference map for one revision
			Map<String, ArrayList<String>> diffElements = new TreeMap<>();

			// Get all included objects of UML model
			TreeIterator<EObject> ti = modelResources.get(z).getAllContents();
			while (ti.hasNext()) {
				EObject eo = ti.next();
				String xmiID = new String();
				String refID = new String();
				String objectName = new String();
				String name = new String();
				boolean undefined = false;
				boolean global = false;

				objectName = eo.getClass().getSimpleName().replace("Impl", "");

				// Test for all stereotypes and set parameters/values
				if (eo instanceof Block) {
					xmiID = EMFUtil.getXmiId(eo);
					refID = EMFUtil.getXmiId(((Block) eo).getBase_Class());
					name = ((Block) eo).getBase_Class().getQualifiedName();
					undefined = true;
					global = false;
				} else if (eo instanceof ConstraintBlock) {
					xmiID = EMFUtil.getXmiId(eo);

					refID = EMFUtil.getXmiId(((ConstraintBlock) eo)
							.getBase_Class());
					name = ((ConstraintBlock) eo).getBase_Class()
							.getQualifiedName();
					undefined = true;
					global = false;

				} else if (eo instanceof Requirement) {
					xmiID = EMFUtil.getXmiId(eo);
					refID = EMFUtil
							.getXmiId(((Requirement) eo).getBase_Class());
					name = ((Requirement) eo).getBase_Class()
							.getQualifiedName();
					undefined = true;
					global = false;

				} else if (eo instanceof RequirementRelated) {
					xmiID = EMFUtil.getXmiId(eo);
					refID = EMFUtil.getXmiId(((RequirementRelated) eo)
							.getBase_NamedElement());
					name = ((RequirementRelated) eo).getBase_NamedElement()
							.getQualifiedName();
					undefined = true;
					global = false;

				} else if (eo instanceof FlowPort) {
					xmiID = EMFUtil.getXmiId(eo);
					refID = EMFUtil.getXmiId(((FlowPort) eo).getBase_Port());
					name = ((FlowPort) eo).getBase_Port().getQualifiedName();
					undefined = true;
					global = false;

				} else if (eo instanceof Satisfy) {
					xmiID = EMFUtil.getXmiId(eo);
					refID = EMFUtil.getXmiId(((Satisfy) eo)
							.getBase_Abstraction());
					name = ((Satisfy) eo).getBase_Abstraction()
							.getQualifiedName();
					undefined = true;
					global = false;

				}

				ArrayList<String> values = new ArrayList<>();

				//If model element not contained in notation
				//Add first all stereotypes
				if (notationContents.get(z).indexOf(refID) == -1) {
					
					values.add(xmiID);
					values.add(objectName);
					values.add(name);

					values.add(String.valueOf(undefined));
					values.add(String.valueOf(global));

					//If element is unique / not already contained in difference
					if (!diffElements.containsKey(refID)) {

						diffElements.put(refID, values);
					}
				}

			}

			// Get all included objects of UML model
			TreeIterator<EObject> ti2 = modelResources.get(z).getAllContents();
			while (ti2.hasNext()) {
				EObject eo = ti2.next();
				String xmiID = new String();
				String refID = new String("");
				String objectName = new String();
				String name = new String();
				boolean undefined = false;
				boolean global = false;
				boolean blacklist = false;

				objectName = eo.getClass().getSimpleName().replace("Impl", "");

				// Important types of/in diagram
				if (eo instanceof Pseudostate || eo instanceof FinalState
						|| eo instanceof State || eo instanceof Transition
						|| eo instanceof StateMachine
						|| eo instanceof Operation || eo instanceof Constraint
						|| eo instanceof Association
						|| eo instanceof Generalization
						|| eo instanceof Package || eo instanceof Region
						|| eo instanceof Enumeration || eo instanceof Port
						|| eo instanceof Abstraction
						|| eo instanceof Model) {

					xmiID = EMFUtil.getXmiId(eo);
					
					//Define if element is "important" or just "globally defined"
					if (eo instanceof NamedElement) {
						NamedElement ne = (NamedElement) eo;
						name = ne.getQualifiedName();
					} else
						name = "";

					if (eo instanceof Constraint) {
						if (name == null || name == "null" || name == "")
							blacklist = true;
						undefined = false;
						global = true;
					} else {
						undefined = true;
						global = false;

					}
				}

				ArrayList<String> values = new ArrayList<>();
				
				//If model element not contained in notation
				//Now add all remaining elements
				if (notationContents.get(z).indexOf(xmiID) == -1 && !blacklist) {

					values.add(refID);
					values.add(objectName);
					values.add(name);

					values.add(String.valueOf(undefined));
					values.add(String.valueOf(global));

					if (!diffElements.containsKey(xmiID)) {

						diffElements.put(xmiID, values);
					}
				}
				blacklist = false;

			}

			//Build the difference map for all revisions
			if (z < 9 && z != 4) {
				if (z >= 6)
					differences.put("Scen0" + (z + 1), diffElements);

				else
					differences.put("Scen0" + z, diffElements);
			} else if (z == 4)
				differences.put("Scen0" + "4a_and_b", diffElements);
			else
				differences.put("Scen" + (z + 1), diffElements);

			System.out.println("Created report " + z);

		}

		return differences;

	}

	/*
	 * Helper method for creating a report
	 * 
	 * @param differences Differences of one revision
	 * @return StringBuilder StringBuilder containing the report
	 * 
	 */
	public static StringBuilder createReport(
			Map<String, ArrayList<String>> diffElements) {

		StringBuilder reportOutput = new StringBuilder();

		// Create heading row
		reportOutput.append(reportHeading);

		// Create value rows
		for (String key : diffElements.keySet()) {

			reportOutput.append(key + delimiter);
			for (String value : diffElements.get(key)) {

				reportOutput.append(value + delimiter);
			}

			reportOutput.append(System.lineSeparator());

		}

		return reportOutput;

	}
	/*
	 * Helper method for creating a summary of all revisions
	 * 
	 * @param differences Differences of all revisions
	 * @return StringBuilder StringBuilder containing the summary
	 * 
	 */
	public static StringBuilder createSummary(
			Map<String, Map<String, ArrayList<String>>> differences) {

		StringBuilder summaryOutput = new StringBuilder();
		ArrayList<String> summaryHeading = new ArrayList<String>();

		// Create heading row
		summaryHeading.add("Undefined");
		summaryHeading.add("Global");

		for (String key : differences.keySet()) {

			Map<String, ArrayList<String>> diffElements = differences.get(key);

			for (String eleKey : diffElements.keySet()) {

				ArrayList<String> values = diffElements.get(eleKey);

				if (summaryHeading.indexOf(values.get(1)) == -1) {
					summaryHeading.add(values.get(1));

				}
			}
		}
		summaryOutput.append(delimiter);
		for (String st : summaryHeading) {
			summaryOutput.append(st);
			summaryOutput.append(delimiter);
		}

		summaryOutput.append(System.lineSeparator());

		// Creating value rows
		for (String key : differences.keySet()) {

			int undefinedCtr = 0;
			int globalCtr = 0;

			ArrayList<Integer> summaryCounter = new ArrayList<Integer>();

			summaryOutput.append(key + delimiter);

			Map<String, ArrayList<String>> diffElements = differences.get(key);

			for (int columnCtr = 0; columnCtr < summaryHeading.size() - 2; columnCtr++) {

				int elementctr = 0;

				for (String eleKey : diffElements.keySet()) {

					ArrayList<String> values = diffElements.get(eleKey);

					if (values.get(1).equals(summaryHeading.get(columnCtr + 2)))
						elementctr++;

				}
				summaryCounter.add(elementctr);

			}

			for (String eleKey : diffElements.keySet()) {

				ArrayList<String> values = diffElements.get(eleKey);

				if (values.get(3).equals("true"))
					undefinedCtr++;

				if (values.get(4).equals("true"))
					globalCtr++;
			}

			summaryOutput.append(undefinedCtr + delimiter);
			summaryOutput.append(globalCtr + delimiter);

			for (int j = 0; j < summaryCounter.size(); j++) {

				summaryOutput.append(summaryCounter.get(j));
				summaryOutput.append(delimiter);

			}

			summaryOutput.append(System.lineSeparator());

		}

		return summaryOutput;

	}
	/*
	 * Helper method for creating a standard output of analysis
	 * 
	 * @param differences Differences of all revisions
	 * @return StringBuilder StringBuilder containing the output
	 * 
	 */
	public static StringBuilder createOutput(
			Map<String, Map<String, ArrayList<String>>> differences) {

		StringBuilder output = new StringBuilder();
		output.append("++++++++++++++++++++++++++");
		output.append(System.lineSeparator());
		output.append("Reports for SysML Testdata");
		output.append(System.lineSeparator());

		for (String key : differences.keySet()) {

			Integer undefinedElements = 0;
			Integer globalElements = 0;

			output.append("-----------Report for " + key + "------------");
			output.append(System.lineSeparator());

			Map<String, ArrayList<String>> diffElements = differences.get(key);

			for (String key2 : diffElements.keySet()) {

				output.append(key2);

				for (String value : diffElements.get(key2)) {

					output.append(", " + value);
				}
				if (diffElements.get(key2).get(3) == "true")
					undefinedElements++;
				if (diffElements.get(key2).get(4) == "true")
					globalElements++;
				output.append(System.lineSeparator());

			}
			output.append(System.lineSeparator());
			output.append("Total: " + diffElements.size() + " elements, "
					+ "Undefined: " + undefinedElements + " , Global: "
					+ globalElements);
			output.append(System.lineSeparator());
			output.append(System.lineSeparator());
		}
		output.append("++++++++++++++++++++++++++");
		return output;

	}
}