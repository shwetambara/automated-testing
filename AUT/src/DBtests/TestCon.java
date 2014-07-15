package DBtests;


import java.sql.DriverManager;
 
public class TestCon {
 
    private static final String url = "jdbc:mysql://localhost/shweta";
 
    private static final String user = "root";
 
    private static final String password = "check*123#";
 
    public static void main(String args[]) {
        try {
            DriverManager.getConnection(url, user, password);
            
            	System.out.println("Success");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

