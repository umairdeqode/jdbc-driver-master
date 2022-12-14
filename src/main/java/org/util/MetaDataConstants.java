package org.util;

public class MetaDataConstants {
	
	public static final int MAX_BINARY_LITERAL_LENGTH=16777208;
    public static final int MAX_CHAR_LITERAL_LENGTH=16777208;
    public static final int MAX_COLUMN_NAME_LENGTH=64;
    public static final int MAX_COLUMNS_IN_GROUPBY=64;
    public static final int MAX_COLUMNS_IN_INDEX=16;
    public static final int MAX_COLUMNS_IN_ORDERBY=64;
    public static final int MAX_COLUMNS_INSELECT=256;
    public static final int MAX_COLUMNS_INTABLE=512;
    public static final int MAX_CONNECTIONS=1;
    public static final int MAX_CURSOR_NAME_LENGTH=64;
    public static final int MAX_INDEX_LENGTH=256;
    public static final int MAX_SCHEMA_NAME_LENGTH=5;
    public static final int MAX_PROCEDURE_NAME_LENGTH=0;
    public static final int MAX_CATALOG_NAME_LENGTH=32;
    public static final int MAX_BUFFER_SIZE=65535;
    public static final int MAX_STATEMENTS=1;
    public static final int MAX_TABLE_NAME_LENGTH=64;
    public static final int MAX_TABLES_IN_SELECT=64;
    public static final int MAX_USER_NAME_LENGTH=64;
    public static final String NUMERIC_FUNCTIONS="ABS,ACOS,ASIN,ATAN,ATAN2,BIT_COUNT,CEILING,COS,COT,DEGREES,EXP,FLOOR,LOG,LOG10,MAX,MIN,MOD,PI,POW,"
			+ "POWER,RADIANS,RAND,ROUND,SIN,SQRT,TAN,TRUNCATE";
    public static final String STRING_FUNCTIONS="ASCII,BIN,BIT_LENGTH,CHAR,CHARACTER_LENGTH,CHAR_LENGTH,CONCAT,CONCAT_WS,CONV,ELT,EXPORT_SET,FIELD,FIND_IN_SET,HEX,INSERT,"
			+ "INSTR,LCASE,LEFT,LENGTH,LOAD_FILE,LOCATE,LOCATE,LOWER,LPAD,LTRIM,MAKE_SET,MATCH,MID,OCT,OCTET_LENGTH,ORD,POSITION,"
			+ "QUOTE,REPEAT,REPLACE,REVERSE,RIGHT,RPAD,RTRIM,SOUNDEX,SPACE,STRCMP,SUBSTRING,SUBSTRING,SUBSTRING,SUBSTRING,"
			+ "SUBSTRING_INDEX,TRIM,UCASE,UPPER";
    public static final String SYSTEM_FUNCTIONS="DATABASE,USER,SYSTEM_USER,SESSION_USER,PASSWORD,ENCRYPT,LAST_INSERT_ID,VERSION";
    public static final String TIME_DATE_FUNCTIONS="DAYOFWEEK,WEEKDAY,DAYOFMONTH,DAYOFYEAR,MONTH,DAYNAME,MONTHNAME,QUARTER,WEEK,YEAR,HOUR,MINUTE,SECOND,PERIOD_ADD,"
			+ "PERIOD_DIFF,TO_DAYS,FROM_DAYS,DATE_FORMAT,TIME_FORMAT,CURDATE,CURRENT_DATE,CURTIME,CURRENT_TIME,NOW,SYSDATE,"
			+ "CURRENT_TIMESTAMP,UNIX_TIMESTAMP,FROM_UNIXTIME,SEC_TO_TIME,TIME_TO_SEC";
    public static final String SCHEMA="schema";
    public static final String DATABASE="database";
    
}
