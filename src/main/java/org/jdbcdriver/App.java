package org.jdbcdriver;


import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        try {


        //Connection conn = DriverManager.getConnection("jdbc:Skyflow:/home/deq/Downloads/Skyflow-jdbcdriver/Skyflow-jdbc-driver-example-master/src/main/resources");
        Connection conn = DriverManager.getConnection("jdbc:skyflow:/home/deq/Downloads/Skyflow-jdbcdriver/skyflow-jdbc-driver-master");
        //Statement stmt = conn.createStatement();
        //Boolean rs = stmt.execute("select 'keep alive';");
        //ResultSet rs1=stmt.getResultSet();
        		 //System.out.println(rs);
        //		  rs1.getMetaData();
        //  while (rs1.next())System.out.println(rs1.getString(1) + " - " + rs1.getString(2)+ " - " + rs1.getString(3));
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