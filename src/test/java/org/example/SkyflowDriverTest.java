package org.example;


import org.jdbcdriver.SkyflowDriver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNull;

public class SkyflowDriverTest {

    @Test
    public void driver_works_in_normal_case() throws SQLException {

        Driver driver = new SkyflowDriver();

        try {

            Properties props = new Properties();
            props.load(new FileInputStream("/home/deq/IdeaProjects/jdbc-driver-master-nam/src/test/resources/message.properties"));
            String message;
            message = props.getProperty("filePath");
            System.out.println("Domain Url : ->"+ message);


            String dirPath = "https://sb.area51.vault.skyflowapis.dev/:";
            String vaultId = "u4882705de68469d92b5aa1d9ada9740";
            String connectionUri = "jdbc:Skyflow:" + dirPath + vaultId;
            System.out.println(connectionUri);
            Connection con = driver.connect("jdbc:Skyflow:" + dirPath + vaultId, props);

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