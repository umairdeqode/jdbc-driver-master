package org.jdbcdriver;

import java.nio.file.Path;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class SkyflowConnection implements java.sql.Connection {

    private Path directory;
    private String vaultId;
    private String filePath;
    private String directory1;

    SkyflowConnection(Path directory, String vaultId, String filePath) {
        this.directory = directory;
        this.vaultId = vaultId;
        this.filePath = filePath;
    }

    SkyflowConnection(String directory) {

        this.directory1 = directory;

    }

    public String getVaultId() {
        return vaultId;
    }

    public void setVaultId(String vaultId) {
        this.vaultId = vaultId;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return new SkyflowStatement(directory, vaultId, filePath);
    }

    @Override
    public PreparedStatement prepareStatement(String s) throws SQLException {
        //if(1==1){throw new SQLException("error1");}
        return null;
    }

    @Override
    public CallableStatement prepareCall(String s) throws SQLException {
        //if(1==1){throw new SQLException("error2");}
        return null;
    }

    @Override
    public String nativeSQL(String s) throws SQLException {
        //if(1==1){throw new SQLException("error3");}
        return null;
    }

    @Override
    public void setAutoCommit(boolean b) throws SQLException {
        //if(1==1){throw new SQLException("error4");}
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        return false;
    }

    @Override
    public void commit() throws SQLException {
        //if(1==1){throw new SQLException("error5");}

    }

    @Override
    public void rollback() throws SQLException {
        //if(1==1){throw new SQLException("error6");}

    }

    @Override
    public void close() throws SQLException {
        //if(1==1){throw new SQLException("error7");}

    }

    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        return new SkyflowDatabaseMetaData(this);
    }

    @Override
    public void setReadOnly(boolean b) throws SQLException {
        //if(1==1){throw new SQLException("error8");}
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return true;
    }

    @Override
    public void setCatalog(String s) throws SQLException {
        //if(1==1){throw new SQLException("error9");}
    }

    @Override
    public String getCatalog() throws SQLException {
        //if(1==1){throw new SQLException("error11");}
        return "skyflow";
    }

    @Override
    public void setTransactionIsolation(int i) throws SQLException {
        //if(1==1){throw new SQLException("error12");}
    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        return 0;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {

    }

    @Override
    public Statement createStatement(int i, int i1) throws SQLException {
        throw new SQLException("createStatement");
    }

    @Override
    public PreparedStatement prepareStatement(String s, int i, int i1) throws SQLException {
        throw new SQLException("PreparedStatement");
    }

    @Override
    public CallableStatement prepareCall(String s, int i, int i1) throws SQLException {
        throw new SQLException("CallableStatement");
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        return null;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

    }

    @Override
    public void setHoldability(int i) throws SQLException {

    }

    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        return null;
    }

    @Override
    public Savepoint setSavepoint(String s) throws SQLException {
        return null;
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        //if(1==1){throw new SQLException("error13");}

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        //if(1==1){throw new SQLException("error14");}

    }

    @Override
    public Statement createStatement(int i, int i1, int i2) throws SQLException {
        throw new SQLException("createStatement");
    }

    @Override
    public PreparedStatement prepareStatement(String s, int i, int i1, int i2) throws SQLException {
        return null;
    }

    @Override
    public CallableStatement prepareCall(String s, int i, int i1, int i2) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String s, int i) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String s, int[] ints) throws SQLException {
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String s, String[] strings) throws SQLException {
        return null;
    }

    @Override
    public Clob createClob() throws SQLException {
        return null;
    }

    @Override
    public Blob createBlob() throws SQLException {
        return null;
    }

    @Override
    public NClob createNClob() throws SQLException {
        return null;
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        return null;
    }

    @Override
    public boolean isValid(int i) throws SQLException {
        //if(1==1){throw new SQLException("error valid");}
        return false;
    }

    @Override
    public void setClientInfo(String s, String s1) throws SQLClientInfoException {

    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {

    }

    @Override
    public String getClientInfo(String s) throws SQLException {
        return null;
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        return null;
    }

    @Override
    public Array createArrayOf(String s, Object[] objects) throws SQLException {
        return null;
    }

    @Override
    public Struct createStruct(String s, Object[] objects) throws SQLException {
        return null;
    }

    @Override
    public void setSchema(String s) throws SQLException {

    }

    @Override
    public String getSchema() throws SQLException {
        return null;
    }

    @Override
    public void abort(Executor executor) throws SQLException {

    }

    @Override
    public void setNetworkTimeout(Executor executor, int i) throws SQLException {

    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        return 0;
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
