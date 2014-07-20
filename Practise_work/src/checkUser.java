package DBtests;
//import java.sql.Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

import helper.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class checkUser {
	dbConnect instancedb = new dbConnect();
	openWebsite instanceweb = new openWebsite();
	Statement stmt = null;
	Connection con = instancedb.connection;
	@Before
	public void setUp() throws Exception {
		
		instanceweb.setUp();
		instancedb.getValues();
		instancedb.createConnection();
		
	}

	@After
	public void tearDown() throws Exception {
		
		instancedb.teardown();
		instanceweb.tearDown();
		
	}

	@Test
	public void testuser() throws IOException {
		 
		   
		   //the result object will hold the output from the execution of the query
		   InputStreamReader in = new InputStreamReader(System.in);
		   BufferedReader br = new BufferedReader(in);
		   System.out.println("enter the username");
		   String usrnm = br.readLine();
		   System.out.println("enter the password");
		   String pswd = br.readLine();
		   
		   try {
			 stmt = con.createStatement();  
		     String query = "select * from userDB";
		     ResultSet result = stmt.executeQuery(query);
		     result.next();
		     String username = result.getString("Username");
	         String password = result.getString("Password");
		   
	         assertEquals(usrnm, username);
	         assertEquals("user in Database", pswd, password);
		     }
		   catch (SQLException ex) {
			     System.out.println(ex);
			   }

	}
}