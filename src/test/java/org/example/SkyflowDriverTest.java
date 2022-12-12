package org.example;


import org.jdbcdriver.SkyflowDriver;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertNull;

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

        try {
            String dirPath = "/home/deq/IdeaProjects/jdbc-driver-master-nam/vault:";
            String vaultId = "u4882705de68469d92b5aa1d9ada9740";
            Connection con = driver.connect("jdbc:Skyflow:" + dirPath + vaultId, null);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from template;");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }

    @Test
    public void driver_returns_with_null_for_not_Skyflow_url() throws SQLException {
        assertNull(new SkyflowDriver().connect("jdbc:xxx", null));
    }
}