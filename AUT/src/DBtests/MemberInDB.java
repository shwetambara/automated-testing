package DBtests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MemberInDB {

 private WebDriver driver = null;
 private Connection conn = null;
 private Statement stmt = null;
 String baseUrl;

 @Before
 public void setUp() throws Exception {

   driver = new FirefoxDriver();
   baseUrl = "http://www.randomexample.com";
   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 }

 @Test
 public void testMembership() throws SQLException, ClassNotFoundException {
   
   Class.forName("com.mysql.jdbc.Driver");
   
   String url = "jdbc:mysql://localhost/shweta";
 
   conn = DriverManager.getConnection(url, "root", "check*123#");
   // Create statement object which would be used in writing DDL and DML SQL statement
   stmt = conn.createStatement();
   
   //the result object will hold the output from the execution of the query
   
   try {
     String query = "select * from userDB";
     ResultSet result = stmt.executeQuery(query);
 
   while(result.next())
   {
    	 String username = result.getString("Username");
         String password = result.getString("Password");
         // print them on the console
         System.out.println("username :" + username);
         System.out.println("password: " + password);
         System.out.println();
     } 
     
   } 
   
   catch (SQLException ex) {
     System.out.println(ex);
   }
   
   finally {
     conn.close();
   }

 }

 @After
 public void tearDown() throws Exception {
   // close the driver
   driver.close();
 }

}