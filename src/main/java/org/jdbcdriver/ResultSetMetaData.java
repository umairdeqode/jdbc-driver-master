package org.jdbcdriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;


public class ResultSetMetaData implements java.sql.ResultSetMetaData {


    private static final Logger logger = LogManager.getLogger(ResultSetMetaData.class);
    List columnNames;

    //ArrayList<String> A;


    public ResultSetMetaData() throws SQLException {

        /*
         * this.A =new ArrayList<String>();
         *
         * this.A.add(null); this.A.add("id1"); this.A.add("id2"); this.A.add("id3");
         * this.A.add("name"); this.A.add("name2"); this.A.add("skyflow_id");
         */
        throw new SQLException("no value");

    }


    public ResultSetMetaData(List columnNames) {
        this.columnNames = columnNames;

    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getColumnCount() throws SQLException {
        // TODO Auto-generated method stub
        return columnNames.size();
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        // TODO Auto-generated method stub
        //throw new SQLException("getColumnLabel");
        return (String) this.columnNames.get(column - 1);
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        // TODO Auto-generated method stub
        //throw new SQLException("getColumnName");
        return (String) this.columnNames.get(column - 1);
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        // TODO Auto-generated method stub
        //throw new SQLException("getSchemaName");
        return "TEST.Skyflow";
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getScale(int column) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getTableName(int column) throws SQLException {
        // TODO Auto-generated method stub
        //throw new SQLException("getTableName");
        return "TEST.Skyflow";
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        // TODO Auto-generated method stub
        //throw new SQLException("getCatalogName");
        return "TEST.Skyflow";
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        // TODO Auto-generated method stub
        //throw new SQLException("getColumnType");
        return (Integer) new DataTypesDynamicMapper().getDataTypeCodes().get(getColumnTypeName(column));
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        // TODO Auto-generated method stub

        HttpResponseHandler httpResponseHandler = new HttpResponseHandler();
        JSONArray response = httpResponseHandler.sendGet();
        Iterator<Object> iterator = response.iterator();
        do {
            JSONObject obj = (JSONObject) iterator.next();
            String skyflowDatatype = obj.get("datatype").toString();
            if (skyflowDatatype.toLowerCase().contains("int")) {
                return "Integer";
            } else if (skyflowDatatype.toLowerCase().contains("bool")) {
                return "Boolean";
            } else if (skyflowDatatype.toLowerCase().contains("float")) {
                return "Float";
            } else {
                return "Varchar";
            }
        } while (iterator.hasNext());
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        // TODO Auto-generated method stub
        throw new SQLException("getColumnClassName");
        //return null;
    }

}
