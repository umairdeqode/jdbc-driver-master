package org.jdbcdriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.util.Constants.CREDENTIALS_FILE_NAME;

public class SkyflowDriver implements Driver {
	private static final Driver INSTANCE = new SkyflowDriver();
	//public static String credsPath = null;
	private static boolean registered;
	public SkyflowDriver() {}

	@Override
	public Connection connect(String s, Properties properties) throws SQLException {
		//throw new SQLException(s);

		  String vaultId;
		  String credsPath;

		  String[] parts = s.split(":");
		  
		  if (parts.length < 2 || !parts[0].toLowerCase().equals("jdbc") ||
		  !parts[1].toLowerCase().equals("skyflow")) return null;

		  if(parts.length<4) throw new SQLException("Vault Id is not passed or incorrect");
		  else vaultId = parts[3];

		  String directory = parts[2];
		  System.out.println("dir ->" + directory);
		  System.out.println("vaultId ->"+ vaultId);

		  Path path = Paths.get(directory).toAbsolutePath();
		  //System.out.println(path.toString());


		  if (!Files.isDirectory(path)) throw new SQLException("'" + path + "' is not a directory");
		  credsPath = directory;
		System.out.println(path.toString()+CREDENTIALS_FILE_NAME);

		boolean flag= new File(path.toString()+CREDENTIALS_FILE_NAME).isFile();
		if(flag == false) throw new SQLException("Credentials file does not exists.");
		  
		return new SkyflowConnection(path,vaultId,credsPath);
		 
	}

	@Override
	public boolean acceptsURL(String s) throws SQLException {
		return true;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String s, Properties properties) throws SQLException {
		return new DriverPropertyInfo[0];
	}

	@Override
	public int getMajorVersion() {
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		return true;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public static synchronized Driver load() {
		if (!registered) {
			registered = true;
			try {
				DriverManager.registerDriver(INSTANCE);
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

		return INSTANCE;
	}

	static {
		load();
	}
}
