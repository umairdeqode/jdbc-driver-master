package org.jdbcdriver;

import java.util.*;

public class DataTypesDynamicMapper {
	
	HashMap<String, Integer> DataTypeCodes;
	public HashMap getDataTypeCodes() {
		DataTypeCodes=new HashMap<String, Integer>();
		DataTypeCodes.put("Varchar", 12);
		DataTypeCodes.put("Integer", 4);
		DataTypeCodes.put("Float", 6);
		DataTypeCodes.put("Boolean", 16);
		DataTypeCodes.put("Date", 91);
		DataTypeCodes.put("Time", 92);
		//DataTypeCodes.put("", null);
		//DataTypeCodes.put("", null);
		return DataTypeCodes;
	}
	
}
