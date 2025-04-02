package org.sidiff.debugger.db;

import java.sql.*;
import java.util.*;

public class MySQLDatabase
{
	private Connection mDBConnection;
	private boolean mConnected;
	
	public MySQLDatabase()
	{
		mDBConnection = null;
		mConnected = false;
	}
	
	public void connect(String user, String password, String database, String server, int port) throws SQLException
	{
		if (mConnected) close();
		
		Properties connectionProperties = new Properties();
		connectionProperties.put("user", user);
		connectionProperties.put("password", password);
		
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		mDBConnection = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, connectionProperties);
		mConnected = true;
	}
	
	public void close() throws SQLException
	{
		if (!mConnected) throw new SQLException("MySQLDatabase: Not connected!");
		
		mDBConnection.close();
		mConnected = false;
	}
	
	public void executeScript(MySQLScript script) throws SQLException
	{
		for (String statementString : script)
		{
			PreparedStatement preparedStatement = getConnection().prepareStatement(statementString);
			preparedStatement.execute();
			preparedStatement.close();
		}
	}
	
	public boolean isConnected()
	{
		return mConnected;
	}
	
	public Connection getConnection() throws SQLException
	{
		if (!mConnected) throw new SQLException("MySQLDatabase: Not connected!");
		return mDBConnection;
	}
}
