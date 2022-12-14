package org.jdbcdriver;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLException;
import static org.util.MetaDataConstants.*;

public class SkyflowDatabaseMetaData implements java.sql.DatabaseMetaData {
	public SkyflowConnection conn;

	public SkyflowDatabaseMetaData(SkyflowConnection skyflowConnection) {
		this.conn = skyflowConnection;
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
	public boolean allProceduresAreCallable() throws SQLException {

		return false;
	}

	@Override
	public boolean allTablesAreSelectable() throws SQLException {

		return false;
	}

	@Override
	public String getURL() throws SQLException {

		return null;
	}

	@Override
	public String getUserName() throws SQLException {

		return "Skyflow";
	}

	@Override
	public boolean isReadOnly() throws SQLException {

		return true;
	}

	@Override
	public boolean nullsAreSortedHigh() throws SQLException {

		return false;
	}

	@Override
	public boolean nullsAreSortedLow() throws SQLException {

		return false;
	}

	@Override
	public boolean nullsAreSortedAtStart() throws SQLException {

		return false;
	}

	@Override
	public boolean nullsAreSortedAtEnd() throws SQLException {

		return false;
	}

	@Override
	public String getDatabaseProductName() throws SQLException {

		return "Skyflow";
	}

	@Override
	public String getDatabaseProductVersion() throws SQLException {

		return "1.0";
	}

	@Override
	public String getDriverName() throws SQLException {

		return "SkyflowDriver";
	}

	@Override
	public String getDriverVersion() throws SQLException {

		return "1.0";
	}

	@Override
	public int getDriverMajorVersion() {

		return 1;
	}

	@Override
	public int getDriverMinorVersion() {

		return 1;
	}

	@Override
	public boolean usesLocalFiles() throws SQLException {

		return false;
	}

	@Override
	public boolean usesLocalFilePerTable() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsMixedCaseIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public boolean storesUpperCaseIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public boolean storesLowerCaseIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public boolean storesMixedCaseIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {

		return false;
	}

	@Override
	public String getIdentifierQuoteString() throws SQLException {

		return null;
	}

	@Override
	public String getSQLKeywords() throws SQLException {

		return null;
	}

	@Override
	public String getNumericFunctions() throws SQLException {

		return "ABS,ACOS,ASIN,ATAN,ATAN2,BIT_COUNT,CEILING,COS,COT,DEGREES,EXP,FLOOR,LOG,LOG10,MAX,MIN,MOD,PI,POW,"
				+ "POWER,RADIANS,RAND,ROUND,SIN,SQRT,TAN,TRUNCATE";
	}

	@Override
	public String getStringFunctions() throws SQLException {

		return "ASCII,BIN,BIT_LENGTH,CHAR,CHARACTER_LENGTH,CHAR_LENGTH,CONCAT,CONCAT_WS,CONV,ELT,EXPORT_SET,FIELD,FIND_IN_SET,HEX,INSERT,"
				+ "INSTR,LCASE,LEFT,LENGTH,LOAD_FILE,LOCATE,LOCATE,LOWER,LPAD,LTRIM,MAKE_SET,MATCH,MID,OCT,OCTET_LENGTH,ORD,POSITION,"
				+ "QUOTE,REPEAT,REPLACE,REVERSE,RIGHT,RPAD,RTRIM,SOUNDEX,SPACE,STRCMP,SUBSTRING,SUBSTRING,SUBSTRING,SUBSTRING,"
				+ "SUBSTRING_INDEX,TRIM,UCASE,UPPER";
	}

	@Override
	public String getSystemFunctions() throws SQLException {

		return "DATABASE,USER,SYSTEM_USER,SESSION_USER,PASSWORD,ENCRYPT,LAST_INSERT_ID,VERSION";
	}

	@Override
	public String getTimeDateFunctions() throws SQLException {

		return "DAYOFWEEK,WEEKDAY,DAYOFMONTH,DAYOFYEAR,MONTH,DAYNAME,MONTHNAME,QUARTER,WEEK,YEAR,HOUR,MINUTE,SECOND,PERIOD_ADD,"
				+ "PERIOD_DIFF,TO_DAYS,FROM_DAYS,DATE_FORMAT,TIME_FORMAT,CURDATE,CURRENT_DATE,CURTIME,CURRENT_TIME,NOW,SYSDATE,"
				+ "CURRENT_TIMESTAMP,UNIX_TIMESTAMP,FROM_UNIXTIME,SEC_TO_TIME,TIME_TO_SEC";
	}

	@Override
	public String getSearchStringEscape() throws SQLException {

		return "\\";
	}

	@Override
	public String getExtraNameCharacters() throws SQLException {

		return "#@";
	}

	@Override
	public boolean supportsAlterTableWithAddColumn() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsAlterTableWithDropColumn() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsColumnAliasing() throws SQLException {

		return false;
	}

	@Override
	public boolean nullPlusNonNullIsNull() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsConvert() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsConvert(int fromType, int toType) throws SQLException {

		return false;
	}

	@Override
	public boolean supportsTableCorrelationNames() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsDifferentTableCorrelationNames() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsExpressionsInOrderBy() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsOrderByUnrelated() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsGroupBy() throws SQLException {

		return true;
	}

	@Override
	public boolean supportsGroupByUnrelated() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsGroupByBeyondSelect() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsLikeEscapeClause() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsMultipleResultSets() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsMultipleTransactions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsNonNullableColumns() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsMinimumSQLGrammar() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsCoreSQLGrammar() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsExtendedSQLGrammar() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsANSI92EntryLevelSQL() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsANSI92IntermediateSQL() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsANSI92FullSQL() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsIntegrityEnhancementFacility() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsOuterJoins() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsFullOuterJoins() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsLimitedOuterJoins() throws SQLException {

		return false;
	}

	@Override
	public String getSchemaTerm() throws SQLException {

		return "schema";
	}

	@Override
	public String getProcedureTerm() throws SQLException {

		throw new SQLException("getProcedureTerm");
		// return null;
	}

	@Override
	public String getCatalogTerm() throws SQLException {

		return "database";
	}

	@Override
	public boolean isCatalogAtStart() throws SQLException {

		return false;
	}

	@Override
	public String getCatalogSeparator() throws SQLException {

		return null;
	}

	@Override
	public boolean supportsSchemasInDataManipulation() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSchemasInProcedureCalls() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSchemasInTableDefinitions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSchemasInIndexDefinitions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsCatalogsInDataManipulation() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsCatalogsInProcedureCalls() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsCatalogsInTableDefinitions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsCatalogsInIndexDefinitions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsPositionedDelete() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsPositionedUpdate() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSelectForUpdate() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsStoredProcedures() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSubqueriesInComparisons() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSubqueriesInExists() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSubqueriesInIns() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsSubqueriesInQuantifieds() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsCorrelatedSubqueries() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsUnion() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsUnionAll() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossCommit() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsOpenCursorsAcrossRollback() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossCommit() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsOpenStatementsAcrossRollback() throws SQLException {

		return false;
	}

	@Override
	public int getMaxBinaryLiteralLength() throws SQLException {

		return MAX_BINARY_LITERAL_LENGTH;
	}

	@Override
	public int getMaxCharLiteralLength() throws SQLException {

		return MAX_CHAR_LITERAL_LENGTH;
	}

	@Override
	public int getMaxColumnNameLength() throws SQLException {

		return MAX_COLUMN_NAME_LENGTH;
	}

	@Override
	public int getMaxColumnsInGroupBy() throws SQLException {

		return MAX_COLUMNS_IN_GROUPBY;
	}

	@Override
	public int getMaxColumnsInIndex() throws SQLException {

		return MAX_COLUMNS_IN_INDEX;
	}

	@Override
	public int getMaxColumnsInOrderBy() throws SQLException {

		return MAX_COLUMNS_IN_ORDERBY;
	}

	@Override
	public int getMaxColumnsInSelect() throws SQLException {

		return MAX_COLUMNS_INSELECT;
	}

	@Override
	public int getMaxColumnsInTable() throws SQLException {

		return MAX_COLUMNS_INTABLE;
	}

	@Override
	public int getMaxConnections() throws SQLException {

		return MAX_CONNECTIONS;
	}

	@Override
	public int getMaxCursorNameLength() throws SQLException {

		return MAX_CURSOR_NAME_LENGTH;
	}

	@Override
	public int getMaxIndexLength() throws SQLException {

		return MAX_INDEX_LENGTH;
	}

	@Override
	public int getMaxSchemaNameLength() throws SQLException {

		return MAX_SCHEMA_NAME_LENGTH;
	}

	@Override
	public int getMaxProcedureNameLength() throws SQLException {

		return MAX_PROCEDURE_NAME_LENGTH;
	}

	@Override
	public int getMaxCatalogNameLength() throws SQLException {

		return MAX_CATALOG_NAME_LENGTH;
	}

	@Override
	public int getMaxRowSize() throws SQLException {

		return Integer.MAX_VALUE - 8; // Max buffer size - HEADER
	}

	@Override
	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {

		return true;
	}

	@Override
	public int getMaxStatementLength() throws SQLException {

		return MAX_BUFFER_SIZE - 4; // Max buffer - header
	}

	@Override
	public int getMaxStatements() throws SQLException {

		return MAX_STATEMENTS;
	}

	@Override
	public int getMaxTableNameLength() throws SQLException {

		return MAX_TABLE_NAME_LENGTH;
	}

	@Override
	public int getMaxTablesInSelect() throws SQLException {

		return MAX_TABLES_IN_SELECT;
	}

	@Override
	public int getMaxUserNameLength() throws SQLException {

		return MAX_USER_NAME_LENGTH;
	}

	@Override
	public int getDefaultTransactionIsolation() throws SQLException {

		return java.sql.Connection.TRANSACTION_REPEATABLE_READ;
	}

	@Override
	public boolean supportsTransactions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsTransactionIsolationLevel(int level) throws SQLException {

		return false;
	}

	@Override
	public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsDataManipulationTransactionsOnly() throws SQLException {

		return false;
	}

	@Override
	public boolean dataDefinitionCausesTransactionCommit() throws SQLException {

		return false;
	}

	@Override
	public boolean dataDefinitionIgnoredInTransactions() throws SQLException {

		return false;
	}

	@Override
	public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern)
			throws SQLException {

		return null;
	}

	@Override
	public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern,
			String columnNamePattern) throws SQLException {

		return null;
	}

	@Override
	public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)
			throws SQLException {

		JSONArray al = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("Table_NAME", "test");
		json.put("TABLE_TYPE", "TABLE");
		json.put("TABLE_SCHEM", "schema");
		json.put("TABLE_CAT", "catelog");
		al.put(json);
		return new SkyflowResultSet(al);
	}

	@Override
	public ResultSet getSchemas() throws SQLException {

		JSONArray al = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("TABLE_SCHEM", "schema");
		json.put("TABLE_CATALOG", "catelog");
		al.put(json);
		return new SkyflowResultSet(al);
	}

	@Override
	public ResultSet getCatalogs() throws SQLException {

		JSONArray al = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("TABLE_TYPE", "cdatabase");
		al.put(json);
		return new SkyflowResultSet(al);
	}

	@Override
	public ResultSet getTableTypes() throws SQLException {

		JSONArray al = new JSONArray();
		JSONObject json = new JSONObject();
		json.put("TABLE_TYPE", "TABLE");
		al.put(json);
		return new SkyflowResultSet(al);
	}

	@Override
	public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern)
			throws SQLException {

		throw new SQLException("getColumns");
	}

	@Override
	public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern)
			throws SQLException {

		throw new SQLException("getColumnPrivileges");
	}

	@Override
	public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern)
			throws SQLException {

		throw new SQLException("getTablePrivileges");
	}

	@Override
	public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable)
			throws SQLException {

		throw new SQLException("getBestRowIdentifier");
	}

	@Override
	public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException {

		throw new SQLException("getVersionColumns");
	}

	@Override
	public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {

		throw new SQLException("getPrimaryKeys");
	}

	@Override
	public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {

		throw new SQLException("getImportedKeys");
	}

	@Override
	public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {

		throw new SQLException("getExportedKeys");
	}

	@Override
	public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable,
			String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException {

		throw new SQLException("getCrossReference");
	}

	@Override
	public ResultSet getTypeInfo() throws SQLException {

		throw new SQLException("getTypeInfo");
	}

	@Override
	public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate)
			throws SQLException {

		throw new SQLException("getIndexInfo");
	}

	@Override
	public boolean supportsResultSetType(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {

		return false;
	}

	@Override
	public boolean ownUpdatesAreVisible(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean ownDeletesAreVisible(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean ownInsertsAreVisible(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean othersUpdatesAreVisible(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean othersDeletesAreVisible(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean othersInsertsAreVisible(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean updatesAreDetected(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean deletesAreDetected(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean insertsAreDetected(int type) throws SQLException {

		return false;
	}

	@Override
	public boolean supportsBatchUpdates() throws SQLException {

		return false;
	}

	@Override
	public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types)
			throws SQLException {

		throw new SQLException("getUDTs");
	}

	@Override
	public Connection getConnection() throws SQLException {
		return this.conn;
	}

	@Override
	public boolean supportsSavepoints() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsNamedParameters() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsMultipleOpenResults() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsGetGeneratedKeys() throws SQLException {

		return false;
	}

	@Override
	public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {

		throw new SQLException("getSuperTypes");
	}

	@Override
	public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {

		throw new SQLException("getSuperTypes");
	}

	@Override
	public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern,
			String attributeNamePattern) throws SQLException {

		throw new SQLException("getAttributes");
	}

	@Override
	public boolean supportsResultSetHoldability(int holdability) throws SQLException {

		return false;
	}

	@Override
	public int getResultSetHoldability() throws SQLException {

		return 0;
	}

	@Override
	public int getDatabaseMajorVersion() throws SQLException {

		return 1;
	}

	@Override
	public int getDatabaseMinorVersion() throws SQLException {

		return 1;
	}

	@Override
	public int getJDBCMajorVersion() throws SQLException {

		return 4;
	}

	@Override
	public int getJDBCMinorVersion() throws SQLException {

		return 2;
	}

	@Override
	public int getSQLStateType() throws SQLException {

		return java.sql.DatabaseMetaData.sqlStateSQL99;
	}

	@Override
	public boolean locatorsUpdateCopy() throws SQLException {

		return false;
	}

	@Override
	public boolean supportsStatementPooling() throws SQLException {

		return false;
	}

	@Override
	public RowIdLifetime getRowIdLifetime() throws SQLException {

		return null;
	}

	@Override
	public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {

		throw new SQLException("getSchemas");
	}

	@Override
	public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {

		return false;
	}

	@Override
	public boolean autoCommitFailureClosesAllResultSets() throws SQLException {

		return false;
	}

	@Override
	public ResultSet getClientInfoProperties() throws SQLException {

		throw new SQLException("getClientInfoProperties");
	}

	@Override
	public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern)
			throws SQLException {

		throw new SQLException("getFunctions");
	}

	@Override
	public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern,
			String columnNamePattern) throws SQLException {

		throw new SQLException("getFunctionColumns");
	}

	@Override
	public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern,
			String columnNamePattern) throws SQLException {

		throw new SQLException("getPseudoColumns");
	}

	@Override
	public boolean generatedKeyAlwaysReturned() throws SQLException {

		return false;
	}

}
