package helper;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbConnect {
	public static dbConnect instance=  new dbConnect();
	    public String url;
	    public String user;
	    public String password;
	    public String driver_class;
	    public Connection connection = null;
	
	//Loading the sql server and connection to a database

    public void getValues() throws IOException{
        //enter the details for db connection
    	
      InputStreamReader in = new InputStreamReader (System.in);
 	  BufferedReader br = new BufferedReader(in);
 	  System.out.println("Enter the url:");
 	  url= br.readLine();
 	  System.out.println("Enter the user:");
 	  user = br.readLine();
 	  System.out.println("Enter the password:");
 	  password = br.readLine();
 	  System.out.println("Enter the driver_class:");
 	  driver_class= br.readLine();
    	
    }
     
    //can add @before but omit for now
    public Connection createConnection() {
		try {
            //Load MySQL Java driver    	
            Class.forName(driver_class);
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
 
        
        try {
            //Establish Java MySQL connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to the Database");
        } 
        catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }  
     
   public Connection getConnection() {
	  
      return instance.createConnection();
    }
 public void teardown() throws SQLException{
	 connection.close();
 }
    //main function to evaluate the result for success or failure, remove when linking to other code
/*public static void main(String args[]) throws IOException{
	instance.getValues();
	instance.createConnection();
	}
*/
}


