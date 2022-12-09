package org.example;


import org.jdbcdriver.SkyflowDriver;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkyflowDriverTest {

	@Test
	public void driver_works_in_normal_case() throws SQLException {
		//String resourceName = "test01.csv";
//
//		ClassLoader classLoader = getClass().getClassLoader();
//		String path = classLoader.getResource(resourceName).getPath();
//
//		String parent = Paths.get(path).getParent().toAbsolutePath().toString();

		Driver driver = new SkyflowDriver();

		try{
			    //:u4882705de68469d92b5aa1d9ada9740
			    String dirPath = "/home/deq/IdeaProjects/jdbc-driver-master/vault:";
				String vaultId = "u4882705de68469d92b5aa1d9ada9740";
				Connection con = driver.connect("jdbc:Skyflow:"+ dirPath + vaultId, null);
				Statement stmt = con.createStatement();
			//	ResultSet rs = stmt.executeQuery("select * from template;");
			ResultSet rs = stmt.executeQuery("select * from template;");
				 rs.getMetaData();
		while (rs.next())System.out.println(rs.getString(1) + " - " + rs.getString(2)+ " - " + rs.getString(3));

		}catch(Exception e) {
			e.printStackTrace();
		};
	}

	@Test
	public void driver_returns_with_null_for_not_Skyflow_url() throws SQLException {
		assertNull(new SkyflowDriver().connect("jdbc:xxx", null));
	}
}