package org.sidiff.debugger.db;

import java.io.*;
import org.sidiff.common.io.IOUtil;
import org.sidiff.debugger.db.dumps.*;
import org.w3c.dom.*;


public class DebuggerUtil
{
	public static String readFileIntoString(InputStream inputStream) throws IOException
	{
        StringBuffer data = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        
        String line = null;
        
        while ((line = reader.readLine()) != null)
        {
            data.append(line + "\n");
        }
        
        reader.close();
        
        return data.toString();
    }
	
	public static void writeStringToFile(OutputStream outputStream, String data) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		writer.write(data);
		writer.close();
	}
	
	public static DebuggerConfig readConfig(Document doc) throws IOException
	{
		Element root = doc.getDocumentElement();
		
		NodeList databaseList = root.getElementsByTagName("database");
		NodeList exportList = root.getElementsByTagName("export");
		
		if (databaseList.getLength() == 0) return null;
		
		Element database = (Element) databaseList.item(0);
		
		String server = database.getAttribute("server");
		int port = Integer.parseInt(database.getAttribute("port"));
		String name = database.getAttribute("name");
		String user = database.getAttribute("user");
		String password = database.getAttribute("password");
		String autoreset = database.getAttribute("autoreset");
		
		DebuggerConfig config = null;
		
		if (exportList.getLength() != 0)
		{
			Element export = (Element) exportList.item(0);
			
			String directory = export.getAttribute("directory");
			String mode = export.getAttribute("mode");
			String object = export.getAttribute("object");
			String resource = export.getAttribute("resource");
			
			config = new DebuggerConfig(autoreset.equals("true"),
			                            server,
			                            port,
			                            name,
			                            user,
			                            password,
			                            directory,
			                            mode,
			                            object,
			                            resource);
		}
		else
		{
			config = new DebuggerConfig(autoreset.equals("true"),
                                        server,
                                        port,
                                        name,
                                        user,
                                        password);
		}
		
		return config;
	}
	
	public static MySQLScript readCreateTablesScript() throws IOException
	{
		return new MySQLScript(readFileIntoString(IOUtil.getInputStream("create.sql")));
	}
	
	public static MySQLScript readDropTablesScript() throws IOException
	{
		return new MySQLScript(readFileIntoString(IOUtil.getInputStream("drop.sql")));
	}
	
	public static boolean roundDumpSimilaritiesAIsPartOfB(RoundDump roundDumpA, RoundDump roundDumpB)
	{
		boolean aIsPartOfB = true;
		
		for (Similarity similarityA : roundDumpA.getSimilarities())
		{
			boolean similarityFound = false;
			
			for (Similarity similarityB : roundDumpB.getSimilarities())
			{
				if (similarityA.getObjectA().equals(similarityB.getObjectA()) &&
				    similarityA.getObjectB().equals(similarityB.getObjectB()) &&
				    similarityA.getSimilarity() == similarityB.getSimilarity())
				{
					similarityFound = true;
				}
			}
			
			if (!similarityFound)
			{
				aIsPartOfB = false;
			}
		}
		
		return aIsPartOfB;
	}
	
	public static boolean roundDumpCorrespondencesAIsPartOfB(RoundDump roundDumpA, RoundDump roundDumpB)
	{
 		boolean aIsPartOfB = true;
		
		for (Correspondence similarityA : roundDumpA.getCorrespondences())
		{
			boolean correspondenceFound = false;
			
			for (Correspondence similarityB : roundDumpB.getCorrespondences())
			{
				if (similarityA.getObjectA().equals(similarityB.getObjectA()) &&
				    similarityA.getObjectB().equals(similarityB.getObjectB()))
				{
					correspondenceFound = true;
				}
			}
			
			if (!correspondenceFound)
			{
				aIsPartOfB = false;
			}
		}
		
		return aIsPartOfB;
	}
	
	public static String createSimilaritiesDevelopmentExport(SimilaritiesDevelopmentDump similaritiesDevelopment, String object, String resource)
	{
		StringBuffer buffer = new StringBuffer();
		
		if (resource.equals("A"))
		{
			for (SimilarityDevelopment similarityDevelopment : similaritiesDevelopment.getDevelopmentsOfObjectA(object))
			{
				buffer.append(similarityDevelopment.getObjectB());
				
				for (float similarityValue : similarityDevelopment.getSimilaritiyValues())
				{
					buffer.append(";");
					buffer.append(String.valueOf(similarityValue));
				}
				
				buffer.append(System.getProperty("line.separator"));
			}
		}
		else if (resource.equals("B"))
		{
			for (SimilarityDevelopment similarityDevelopment : similaritiesDevelopment.getDevelopmentsOfObjectB(object))
			{
				buffer.append(similarityDevelopment.getObjectA());
				
				for (float similarityValue : similarityDevelopment.getSimilaritiyValues())
				{
					buffer.append(";");
					buffer.append(String.valueOf(similarityValue));
				}
				
				buffer.append(System.getProperty("line.separator"));
			}
		}
		
		return buffer.toString();
	}
	
	public static String createCorrespondencesDevelopmentExport(CorrespondencesDevelopmentDump correspondencesDevelopment, String object, String resource)
	{
		StringBuffer buffer = new StringBuffer();
		
		if (resource.equals("A"))
		{
			for (CorrespondenceDevelopment correspondenceDevelopment : correspondencesDevelopment.getDevelopmentsOfObjectA(object))
			{
				buffer.append(correspondenceDevelopment.getObjectB());
				
				for (boolean correspondenceValue : correspondenceDevelopment.getCorrespondenceValues())
				{
					buffer.append(";");
					buffer.append(String.valueOf(correspondenceValue ? 1 : 0));
				}
				
				buffer.append(System.getProperty("line.separator"));
			}
		}
		else if (resource.equals("B"))
		{
			for (CorrespondenceDevelopment correspondenceDevelopment : correspondencesDevelopment.getDevelopmentsOfObjectB(object))
			{
				buffer.append(correspondenceDevelopment.getObjectA());
				
				for (boolean correspondenceValue : correspondenceDevelopment.getCorrespondenceValues())
				{
					buffer.append(";");
					buffer.append(String.valueOf(correspondenceValue ? 1 : 0));
				}
				
				buffer.append(System.getProperty("line.separator"));
			}
		}
		
		return buffer.toString();
	}
	
	public final static String conc(final String... items){
		
		final StringBuffer buffer = new StringBuffer();
		
		for (String item : items)
		{
			buffer.append(item);
		}
		
		return buffer.toString();
		
	}
}
