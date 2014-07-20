package helper;

import java.util.concurrent.TimeUnit;
import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openWebsite {
	
	public WebDriver driver = null;
	String baseurl;
	
//navigating to the website entered by the user
	 public void setUp() throws Exception {

	   driver = new FirefoxDriver();
	   InputStreamReader in = new InputStreamReader (System.in);
	   BufferedReader br = new BufferedReader(in);
	   System.out.println("Enter the website url");
	   baseurl = br.readLine();
	   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	   
	 }

	 
	 public void tearDown() throws Exception {
			// close the driver
			   driver.close();
		}
}
