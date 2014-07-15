package DBtests;
//JDBC and MySQL connection
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class makeConnection {
	
	 
	    private static makeConnection instance = new makeConnection();
	    public static final String url = "jdbc:mysql://localhost/shweta";
	    public static final String user = "root";
	    public static final String password = "check*123#";
	    public static final String driver_class= "com.mysql.jdbc.Driver";
	     
	    //private constructor
	    private makeConnection() {
	        try {
	            //Load MySQL Java driver
	        	
	            Class.forName(driver_class);
	        } 
	        catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	     
	    private Connection createConnection() {
	 
	        Connection connection = null;
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
	
	    //main function to evaluate the result for success or failure, remove when linking to other code
	public static void main(String args[]){
		instance.getConnection();
		}
	}
