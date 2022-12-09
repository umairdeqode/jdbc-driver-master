package org.jdbcdriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import org.json.JSONArray;

//import com.google.gson.JsonArray;

public class SkyflowStatement implements Statement {

	private Path directory;
	private String vaultId;

	private String filePath;
	String str;
	//private int i;
	SkyflowStatement(Path directory,String vaultId,String filePath) {
		this.directory = directory;
		this.vaultId = vaultId;
		this.filePath = filePath;
		//this.i=0;
  }

	private String directory;
	private int i;
	SkyflowStatement(String directory) {
		this.directory = directory;
		this.i=0;
		this.str ="select * from template;";
	}
	
	public SkyflowStatement() {
		this.str ="select * from template;";
		// TODO Auto-generated constructor stub
	}
	
	public String sendString() {
		return this.str;

	}

	@Override
	public ResultSet executeQuery(String s)  throws SQLException{

		if(1==0){
			throw new SQLException(s);}

		str=s;

		if( ! s.contains("from")){
			return new SkyflowResultSet();
		}
		HttpResponseHandler httpResponseHandler = new HttpResponseHandler();
		try {
			JSONArray response= httpResponseHandler.SendPost(s,this.vaultId,this.filePath);
			return new SkyflowResultSet(response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return null;
	}

	private String getFileName(String sqlExpression) throws SQLException {
		sqlExpression = sqlExpression.trim();
		if (sqlExpression.isEmpty()) throw new SQLException("Empty sql expression");

		String[] parts = sqlExpression.split(" +");
		String fileName = parts[parts.length - 1];
		if (fileName.endsWith(";")) fileName = fileName.substring(0, fileName.length() - 1);

		return fileName;
	}

	@Override
	public int executeUpdate(String s) throws SQLException {
		return 0;
	}

	@Override
	public void close() throws SQLException {

	}

	@Override
	public int getMaxFieldSize() throws SQLException {
		return 0;
	}

	@Override
	public void setMaxFieldSize(int i) throws SQLException {

	}

	@Override
	public int getMaxRows() throws SQLException {
		return 0;
	}

	@Override
	public void setMaxRows(int i) throws SQLException {

	}

	@Override
	public void setEscapeProcessing(boolean b) throws SQLException {

	}

	@Override
	public int getQueryTimeout() throws SQLException {
		return 0;
	}

	@Override
	public void setQueryTimeout(int i) throws SQLException {

	}

	@Override
	public void cancel() throws SQLException {

	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {

	}

	@Override
	public void setCursorName(String s) throws SQLException {

	}

	@Override
	public boolean execute(String s) throws SQLException {
		this.str=s;

		if(! s.contains("from")){
			this.str ="select * from template;";
			//throw new SQLException(s);
		}
		//throw new SQLException("error1");
		return true;
	}

	@Override
	public ResultSet getResultSet() throws SQLException {
		return executeQuery(this.str);
	}

	@Override
	public int getUpdateCount() throws SQLException {
		return 0;
	}

	@Override
	public boolean getMoreResults() throws SQLException {
		return false;
	}

	@Override
	public void setFetchDirection(int i) throws SQLException {

	}

	@Override
	public int getFetchDirection() throws SQLException {
		return 0;
	}

	@Override
	public void setFetchSize(int i) throws SQLException {

	}

	@Override
	public int getFetchSize() throws SQLException {
		return 0;
	}

	@Override
	public int getResultSetConcurrency() throws SQLException {
		return 0;
	}

	@Override
	public int getResultSetType() throws SQLException {
		return 0;
	}

	@Override
	public void addBatch(String s) throws SQLException {

	}

	@Override
	public void clearBatch() throws SQLException {

	}

	@Override
	public int[] executeBatch() throws SQLException {
		return new int[0];
	}

	@Override
	public Connection getConnection() throws SQLException {
		return null;
	}

	@Override
	public boolean getMoreResults(int i) throws SQLException {
		return false;
	}

	@Override
	public ResultSet getGeneratedKeys() throws SQLException {
		return null;
	}

	@Override
	public int executeUpdate(String s, int i) throws SQLException {
		return 0;
	}

	@Override
	public int executeUpdate(String s, int[] ints) throws SQLException {
		return 0;
	}

	@Override
	public int executeUpdate(String s, String[] strings) throws SQLException {
		return 0;
	}

	@Override
	public boolean execute(String s, int i) throws SQLException {
		throw new SQLException("error2");
		//return false;
	}

	@Override
	public boolean execute(String s, int[] ints) throws SQLException {
		throw new SQLException("error3");
		//return false;
	}

	@Override
	public boolean execute(String s, String[] strings) throws SQLException {
		throw new SQLException("error4");
		//return false;
	}

	@Override
	public int getResultSetHoldability() throws SQLException {
		return 0;
	}

	@Override
	public boolean isClosed() throws SQLException {
		return false;
	}

	@Override
	public void setPoolable(boolean b) throws SQLException {

	}

	@Override
	public boolean isPoolable() throws SQLException {
		return false;
	}

	@Override
	public void closeOnCompletion() throws SQLException {

	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> aClass) throws SQLException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> aClass) throws SQLException {
		return false;
	}
}
