package org.jdbcdriver;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args ) throws SQLException {
        try {

        Connection conn = DriverManager.getConnection("jdbc:skyflow:/home/deq/Downloads/Skyflow-jdbcdriver/skyflow-jdbc-driver-master");
        ResultSet rs = conn.getMetaData().getSchemas();
        while (rs.next()) {
            String schema = rs.getString("TABLE_SCHEM");
            String catalog = rs.getString("TABLE_CATALOG");
            System.out.println(schema);
          }
        }
      catch(Exception e){
  		System.out.println("Exception in main");
  		e.printStackTrace();
      }
    }
}