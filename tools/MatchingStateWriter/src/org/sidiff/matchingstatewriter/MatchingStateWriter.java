package org.sidiff.matchingstatewriter;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.sidiff.common.emf.EMFAdapter;
import org.sidiff.common.emf.EMFUtil;
import org.sidiff.common.emf.access.EdgeSemantic;
//import org.sidiff.common.emf.access.context.Context;
//import org.sidiff.common.emf.access.context.ContextSelector;
import org.sidiff.common.emf.annotation.AnnotateableElement;
import org.sidiff.common.emf.collections.EMFComparators;
import org.sidiff.common.io.IOUtil;
import org.sidiff.common.lcs.StringLCSUtil;
import org.sidiff.common.xml.XMLParser;
import org.sidiff.core.correspondences.CorrespondencesService;

public class MatchingStateWriter {
	
	private static final Comparator<EObject> EOBJECT_COMPARATOR = EMFComparators.createObjectByAnnotationComparator("PATH");

	private static final String VALIDATION_CONTEXT = "ValidationContext";
			
	private static String SEPERATOR = "------------------------------\n";
	private String[] annotations;
//	private ContextSelector contextSelector = null;
	private String folder;
	
//	public MatchingStateWriter(String folder, String contextConfigFile){
//		this(folder);
//		contextSelector = new ContextSelector();
//		contextSelector.loadConfiguration(XMLParser.parseStream(IOUtil.getInputStream(contextConfigFile)));
//	}
	
	public MatchingStateWriter(String folder) {
		this.folder = folder;
		if (!folder.endsWith("/"))
			folder += "/";
		new File(folder).mkdirs();
	}

	public void write(CorrespondencesService service, Resource model1, Resource model2, String... annotations) throws IOException{
		this.annotations = annotations;
		
		int matchCount = 0;
		for (EObject object : service.getElementsWithCorrespondences(model1)) {
			matchCount++;
			EObject correspondence = (EObject) (service.getCorrespondences(object)).toArray()[0];

			writeFile(eObjectDescription(object), folder+"match_"+matchCount+"a.txt");
			writeFile(eObjectDescription(correspondence), folder+"match_"+matchCount+"b.txt");
		}
		int unmatchedACount = 0;
		for(EObject eObject : service.getElementsWithoutCorrespondences(model1)) {
			writeFile(eObjectDescription(eObject), folder+"unmatchedA_"+(++unmatchedACount)+".txt");
		}
		int unmatchedBCount = 0;
		for (EObject eObject : service.getElementsWithoutCorrespondences(model2)) {
			writeFile(eObjectDescription(eObject), folder+"unmatchedB_"+(++unmatchedBCount)+".txt");
		}
		createValidationReport(matchCount, unmatchedACount, unmatchedBCount);
	}
	
	private String eObjectDescription(EObject object){
		String objDes = "";		
		objDes += "Typ : " + object.eClass().getName() + "\n" + SEPERATOR;		
		objDes += addAttributes(object) + SEPERATOR;
		objDes += addAnnotations(object) + SEPERATOR;							
		objDes += addReferences(object) + SEPERATOR;
//		objDes += addContext(object) + SEPERATOR;
		return objDes;
	}
	
	
	private String addAttributes(EObject object){
		List<EAttribute> attributes = new ArrayList<EAttribute>(object.eClass().getEAllAttributes());
		
		String description = "";
		Collections.sort(attributes, EMFComparators.ATTRIBUTE_BY_NAME);
		for(EAttribute a : attributes){
			if (!a.isID() && !EMFUtil.isAnnotatedWith(a, "IGNORE_DIFF"))
				description += a.getName() + " = " + object.eGet(a) + "\n";	
		}	
		return description;
	}
	
	private String addAnnotations(EObject object){
		String description = "";
		
		AnnotateableElement ae = EMFAdapter.INSTANCE.adapt(object, AnnotateableElement.class);
		
		Arrays.sort(annotations);
		
		for(String annotation : annotations){
			description += annotation+" = " +ae.getAnnotation(annotation, String.class) + "\n";
		}
		
		return description;
	}

	
//	private String addContext(EObject object){
//		String description = "";
//		if (contextSelector!=null && contextSelector.hasContext(object.eClass(), VALIDATION_CONTEXT)) {
//			Context c = contextSelector.selectContextByName(object, VALIDATION_CONTEXT);
//			List<EObject> children = new ArrayList<EObject>(c.getContextElements());
//			Collections.sort(children, EOBJECT_COMPARATOR);
//			for(EObject child : children){
//				try{
//					description += child.eClass().getName()+"\n";
//					AnnotateableElement ae = EMFAdapter.INSTANCE.adapt(child, AnnotateableElement.class);		
//					description += ae.getAnnotation("PATH", String.class) + "\n";
//					description += addAttributes(child) + "\n";
//				} catch(NullPointerException E){				
//				}
//			}	
//		}
//		return description;
//	}
	private String addReferences(EObject object){
		List<EReference> references = new ArrayList<EReference>(object.eClass().getEAllReferences());
		Collections.sort(references, EMFComparators.REFERENCE_BY_NAME);

		String description = "";
		for(EReference r : references){
			if (EMFUtil.isAnnotatedWith(r, "IGNORE_DIFF")||EdgeSemantic.Incoming.checkSemantic(r))
				continue;
			List<EObject> children = new ArrayList<EObject>();
			EMFUtil.fillObjectListFromReference(children, object, r);
			Collections.sort(children, EOBJECT_COMPARATOR);
			for(EObject child : children){
				try{
					description += child.eClass().getName()+"\n";
					AnnotateableElement ae = EMFAdapter.INSTANCE.adapt(child, AnnotateableElement.class);		
					description += ae.getAnnotation("PATH", String.class) + "\n";
					description += addAttributes(child) + "\n";
				} catch(NullPointerException E){				
				}
			}	
		}	
		return description;		
	}
	
	private void writeFile(String write, String filename) throws IOException {
		new File(filename).createNewFile();
		OutputStream stream = IOUtil.getOutputStreamIntoFile(filename);

		try {
			Writer mout = new OutputStreamWriter(stream);
			mout.write(write);
			mout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private float compareFiles(String file1, String file2) {
		if (file1.equals(file2))
			return 1f;
		int linelength = file1.indexOf("\n");
		if (file2.indexOf("\n")!=linelength || !file1.substring(0,linelength).equals(file2.substring(0,linelength)))
			return 0f;
		return StringLCSUtil.compareStringConsideringCase(file1, file2);
	}
	
	private String extractPath(String fileContent) {
		String[] lines = fileContent.split("\n");
		for (String line : lines) {
			if (line.startsWith("PATH = ")) {
				return line.substring("PATH = ".length());
			}
		}
		return "{?"+lines[0].substring(6)+"?}";
	}
	
	private void createValidationReport(int matchCount, int unmatchedACount, int unmatchedBCount) throws IOException {
		StringBuffer report = new StringBuffer();
		ArrayList<String> allCands;
		String checkMatchesScript = "#!/bin/sh\n";
		
		float threshold = 0.95f;
		int ok = 0;
		report.append("Use sh checkmatch.sh [nr] to check a match.\n");
		report.append("Use sh diff.sh [nr] [nr] to compare candidates.\n"+SEPERATOR);
		report.append("Checking matches:\n"+SEPERATOR);
		for (int i=1; i<=matchCount; i++) {
			String file1 = IOUtil.readFromStream(IOUtil.getInputStreamFromFile(folder+"match_"+i+"a.txt"));
			String file2 = IOUtil.readFromStream(IOUtil.getInputStreamFromFile(folder+"match_"+i+"b.txt"));
			float lcs = compareFiles(file1, file2);
			if (lcs == 1f) {
				ok++;
			} else {
				report.append("match "+i+" has changes: \t");
				report.append("lcs = "+lcs+" \t"+extractPath(file1)+" -> "+extractPath(file2)+"\n");
				checkMatchesScript += "echo \"Showing match "+i+" ("+lcs+")\"\n";
				checkMatchesScript += "sh checkmatch.sh "+i+"\n";
			}
		}
		report.append("summary: "+ok+" of "+matchCount+" machtes have been ok. ("+(((float)ok)/matchCount)*100f+"%)\n");
		report.append(SEPERATOR);
		
		
		
		report.append("Comparing unmatched elements of 1st model with unmatched of 2nd model (threshold = "+threshold+"):\n"+SEPERATOR);
		
		String noCands = "";
		for (int i=1; i<=unmatchedACount; i++) {
			allCands = new ArrayList<String>();
			int cands = 0;
			String theCands = "";
			String file1 = IOUtil.readFromStream(IOUtil.getInputStreamFromFile(folder+"unmatchedA_"+i+".txt"));
			for (int j=1; j<=unmatchedBCount; j++) {
				String file2 = IOUtil.readFromStream(IOUtil.getInputStreamFromFile(folder+"unmatchedB_"+j+".txt"));
				float lcs = compareFiles(file1, file2);
				String c = lcs+": "+extractPath(file2)+" unmatchedB_"+j+"\n";
				if (lcs>0)
					allCands.add(c);
				if (lcs>=threshold) {
					cands++;
					theCands += ("   "+c);
				}
			}
			if (cands>0) {
				report.append("\n"+extractPath(file1)+" (unmatchedA_"+i+") has "+cands+" candidates:\n");
				report.append(theCands);
			} else if (!allCands.isEmpty()){
				noCands += "\n"+extractPath(file1)+" (allCandsA_"+i+")";
			}
			if (!allCands.isEmpty()) {
				Collections.sort(allCands);
				StringBuffer allCandsSB = new StringBuffer("Candidates of "+extractPath(file1)+" (unmatchedA_"+i+")\n"+SEPERATOR);
				for (String s: allCands)
					allCandsSB.append(s);
				writeFile(allCandsSB.toString(), folder+"allCandsA_"+i+".txt");
			}
		}
		if ("".equals(noCands)) {
			noCands = "  none";
		}
		report.append("\n");
		report.append("\n"+SEPERATOR+"\n");
		report.append("Unmatched elements of the 1st model without candidates above the threshold of "+threshold+": \n");
		report.append(noCands+"\n\n");
		
		writeFile(report.toString(), folder+"report.txt");
		
		String diffTool = "meld";
		String check = "#!/bin/sh\n"+
						diffTool+" match_$1a.txt match_$1b.txt";
		writeFile(check, folder+"checkmatch.sh");
		
		String cand = "#!/bin/sh\n"+
			diffTool+" unmatchedA_$1.txt unmatchedB_$2.txt";
		writeFile(cand, folder+"diff.sh");

		writeFile(checkMatchesScript, folder+"allMatches.sh");
		
	}
	
}
