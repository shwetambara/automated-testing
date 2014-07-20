package DBtests;

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
	ScreenshotOnFailure instancesc = new ScreenshotOnFailure();
	logindetails instancelg = new logindetails();
	
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
		instancesc.takeScreenshotonFailure();
		instancedb.teardown();
		instanceweb.tearDown();
		
	}

	@Test
	public void testuser() throws IOException {
		  
		instancelg.login();
		   
		   try {
			 stmt = con.createStatement();  
		     String query = "select * from userDB";
		     ResultSet result = stmt.executeQuery(query);
		     if(result.next())
		     {
		    	 while(result.next()){
		    		 String username = result.getString("Username");
			         String password = result.getString("Password"); 
			         assertEquals(instancelg.usrnm, username);
			         assertEquals("user in Database", instancelg.pswd, password);
		    	 }
		    result.close();
		     }
		     
		   }
		   catch (SQLException ex) {
			     System.out.println(ex);
			   }
		  
	         
		    
		  

	}
}