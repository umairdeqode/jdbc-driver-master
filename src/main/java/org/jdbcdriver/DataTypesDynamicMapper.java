package org.jdbcdriver;

import java.util.*;
import static org.util.Constants.*;

public class DataTypesDynamicMapper {

	HashMap<String, Integer> DataTypeCodes = new HashMap<String, Integer>();

	public HashMap getDataTypeCodes() {

		DataTypeCodes.put(VARCHAR, 12);
		DataTypeCodes.put(INTEGER, 4);
		DataTypeCodes.put(FLOAT, 6);
		DataTypeCodes.put(BOOLEAN, 16);
		return DataTypeCodes;
	}

}
