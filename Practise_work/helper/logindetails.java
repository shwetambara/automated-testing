package helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.*;

public class logindetails {

	public WebDriver driver;
	String baseUrl; 
	public String usrnm;
	public String pswd;
	public void login() throws IOException{
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		System.out.println("enter the username");
		usrnm = br.readLine();
		System.out.println("enter the password");
		pswd = br.readLine();
   
	driver.get(baseUrl);
    driver.findElement(By.id("focus__this")).click();
    driver.findElement(By.id("focus__this")).clear();
    driver.findElement(By.id("focus__this")).sendKeys(usrnm);
    driver.findElement(By.name("p")).clear();
    driver.findElement(By.name("p")).sendKeys(pswd);
    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	
	}
}
