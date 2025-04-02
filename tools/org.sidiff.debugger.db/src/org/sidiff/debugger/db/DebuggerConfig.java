package org.sidiff.debugger.db;

public class DebuggerConfig
{
	private boolean mDatabaseAutoReset;
	private String mDatabaseServer;
	private int mDatabasePort;
	private String mDatabaseName;
	private String mDatabaseUser;
	private String mDatabasePassword;
	
	private String mExportDirectory;
	private String mExportMode;
	private String mExportObject;
	private String mExportResource;
	
	public DebuggerConfig(boolean databaseAutoReset,
	                      String databaseServer,
	                      int databasePort,
	                      String databaseName,
	                      String databaseUser,
	                      String databasePassword)
	{
		mDatabaseAutoReset = databaseAutoReset;
		mDatabaseServer = databaseServer;
		mDatabasePort = databasePort;
		mDatabaseName = databaseName;
		mDatabaseUser = databaseUser;
		mDatabasePassword = databasePassword;
		
		mExportDirectory = "";
		mExportMode = "";
		mExportObject = "";
		mExportResource = "";
	}
	
	public DebuggerConfig(boolean databaseAutoReset,
                          String databaseServer,
                          int databasePort,
                          String databaseName,
                          String databaseUser,
                          String databasePassword,
                          String exportDirectory,
                          String exportMode,
                          String exportObject,
                          String exportResource)
	{
		mDatabaseAutoReset = databaseAutoReset;
		mDatabaseServer = databaseServer;
		mDatabasePort = databasePort;
		mDatabaseName = databaseName;
		mDatabaseUser = databaseUser;
		mDatabasePassword = databasePassword;
		
		mExportDirectory = exportDirectory;
		mExportMode = exportMode;
		mExportObject = exportObject;
		mExportResource = exportResource;
	}
	
	public boolean getDatabaseAutoReset()
	{
		return mDatabaseAutoReset;
	}
	
	public String getDatabaseServer()
	{
		return mDatabaseServer;
	}
	
	public int getDatabasePort()
	{
		return mDatabasePort;
	}
	
	public String getDatabaseName()
	{
		return mDatabaseName;
	}

	public String getDatabaseUser()
	{
		return mDatabaseUser;
	}
	
	public String getDatabasePassword()
	{
		return mDatabasePassword;
	}
	
	public String getExportDirectory()
	{
		return mExportDirectory;
	}
	
	public String getExportMode()
	{
		return mExportMode;
	}
	
	public String getExportObject()
	{
		return mExportObject;
	}
	
	public String getExportResource()
	{
		return mExportResource;
	}
	
	public void setDatabaseAutoReset(boolean databaseAutoReset)
	{
		mDatabaseAutoReset = databaseAutoReset;
	}
	
	public void setDatabaseServer(String databaseServer)
	{
		mDatabaseName = databaseServer;
	}
	
	public void setDatabasePort(int databasePort)
	{
		mDatabasePort = databasePort;
	}
	
	public void setDatabaseName(String databaseName)
	{
		mDatabaseName = databaseName;
	}

	public void setDatabaseUser(String databaseUser)
	{
		mDatabaseUser = databaseUser;
	}

	public void setDatabasePassword(String databasePassword)
	{
		mDatabasePassword = databasePassword;
	}
	
	public void setExportMode(String exportMode)
	{
		mExportMode = exportMode;
	}
	
	public void setExportObject(String exportObject)
	{
		mExportObject = exportObject;
	}
	
	public void setExportResource(String exportResource)
	{
		mExportResource = exportResource;
	}
	
	public void setExportDirectory(String exportDirectory)
	{
		mExportDirectory = exportDirectory;
	}
}
