package org.jdbcdriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class ResultSetMetaData implements java.sql.ResultSetMetaData {
	List columnNames;
	JSONArray response = new JSONArray();
	private static final Logger logger = LogManager.getLogger(ResultSetMetaData.class);

	public ResultSetMetaData() throws SQLException {

		throw new SQLException("no value");

	}

	public ResultSetMetaData(List columnNames) {
		this.columnNames = columnNames;
		dataTypeFetch();

	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {

		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	@Override
	public int getColumnCount() throws SQLException {
		try {
			return columnNames.size();
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public boolean isAutoIncrement(int column) throws SQLException {
		return false;
	}

	@Override
	public boolean isCaseSensitive(int column) throws SQLException {

		return false;
	}

	@Override
	public boolean isSearchable(int column) throws SQLException {

		return false;
	}

	@Override
	public boolean isCurrency(int column) throws SQLException {

		return false;
	}

	@Override
	public int isNullable(int column) throws SQLException {

		return 0;
	}

	@Override
	public boolean isSigned(int column) throws SQLException {

		return false;
	}

	@Override
	public int getColumnDisplaySize(int column) throws SQLException {

		return 0;
	}

	@Override
	public String getColumnLabel(int column) throws SQLException {
		try {
			return (String) this.columnNames.get(column - 1);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getColumnName(int column) throws SQLException {
		try {
			return (String) this.columnNames.get(column - 1);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	@Override
	public String getSchemaName(int column) throws SQLException {
		return "TEST.Skyflow";
	}

	@Override
	public int getPrecision(int column) throws SQLException {

		return 0;
	}

	@Override
	public int getScale(int column) throws SQLException {

		return 0;
	}

	@Override
	public String getTableName(int column) throws SQLException {
		return "TEST.Skyflow";
	}

	@Override
	public String getCatalogName(int column) throws SQLException {
		return "TEST.Skyflow";
	}

	@Override
	public int getColumnType(int column) throws SQLException {

		try {

			DataTypesDynamicMapper dataTypesDynamicMapper = new DataTypesDynamicMapper();
			int a = (int) dataTypesDynamicMapper.getDataTypeCodes().get(getColumnTypeName(column));

			return a;
		} catch (SQLException e) {

			e.printStackTrace();
			return 12;
		}
	}

	public void dataTypeFetch() {
		HttpResponseHandler httpResponseHandler = new HttpResponseHandler();
		this.response = httpResponseHandler.sendGet();
	}

	@Override
	public String getColumnTypeName(int column) throws SQLException {

		try {
			JSONArray response1 = this.response;
			Iterator<Object> iterator = response1.iterator();
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
		} catch (Exception e) {

			e.printStackTrace();
			return "varchar";
		}
	}

	@Override
	public boolean isReadOnly(int column) throws SQLException {

		return true;
	}

	@Override
	public boolean isWritable(int column) throws SQLException {

		return false;
	}

	@Override
	public boolean isDefinitelyWritable(int column) throws SQLException {

		return false;
	}

	@Override
	public String getColumnClassName(int column) throws SQLException {

		throw new SQLException("getColumnClassName");

	}

}
