package myTests;
//testing wrong detail entries
import static org.junit.Assert.*;

import java.util.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@RunWith(Parameterized.class)
public class ParaTest extends CommonMeth {

  String username, password;
  int index;
	
  public ParaTest(String username, String password, int index){
	  this.username = username;
	  this.password = password;
	  this.index = index;
  }
  
  @Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] { {"", "",1}, {"","password1",2}, {"username1","",3}, {"username1","password1",4} };
	   return Arrays.asList(data);
	 }
	 @Test
	 public void testValues() {
	   System.out.println("username is : " + username);
	   System.out.println("password is : " + password);
	   WebElement currentElement;
	   WebElement usernameElement;
	   String str;
	   driver.get(baseUrl);
	 
	 switch(index){
	 case 1://empty fields
	    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	    
	    boolean b1 = driver.getPageSource().contains("You are currently not logged in! Enter your authentication credentials below to log in. You need to have cookies enabled to log in.");
	    currentElement = driver.switchTo().activeElement();
		usernameElement = driver.findElement(By.id("focus__this"));
		boolean b2 = usernameElement.equals(currentElement);
		
		assertTrue(b1&&b2);
		 break;
		 
	 case 2://empty username field
	  driver.findElement(By.name("p")).click();
	  driver.findElement(By.name("p")).clear();
	  driver.findElement(By.name("p")).sendKeys("password1");
	  driver.findElement(By.cssSelector("fieldset > input.button")).click();
	  
	  assertTrue(driver.getPageSource().contains("You are currently not logged in! Enter your authentication credentials below to log in. You need to have cookies enabled to log in."));
	  
	  currentElement = driver.switchTo().activeElement();
	  usernameElement = driver.findElement(By.id("focus__this"));
	  assertTrue(usernameElement.equals(currentElement));
		 
	  WebElement pwd = driver.findElement(By.name("p"));
	  str = pwd.getAttribute("value");
	  assertTrue(str.contentEquals(""));
		 break;
		 
	 case 3://empty password field
	    driver.findElement(By.id("focus__this")).click();
	    driver.findElement(By.id("focus__this")).clear();
	    driver.findElement(By.id("focus__this")).sendKeys("username1");
	    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	    
	    assertTrue(driver.getPageSource().contains("Sorry, username or password was wrong."));
	    
	    currentElement = driver.switchTo().activeElement();
		usernameElement = driver.findElement(By.id("focus__this"));
		assertTrue(usernameElement.equals(currentElement));
		
		WebElement userid = driver.findElement(By.id("focus__this"));
		str = userid.getAttribute("value");
		assertTrue(str.contentEquals("username1"));
				
		 break;
		 
	 case 4://wrong login details
	    driver.findElement(By.id("focus__this")).click();
	    driver.findElement(By.id("focus__this")).clear();
	    driver.findElement(By.id("focus__this")).sendKeys("username1");
	    driver.findElement(By.name("p")).clear();
	    driver.findElement(By.name("p")).sendKeys("password1");
	    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	    str = driver.getCurrentUrl();
	    
	    assertEquals("http://systers.org/systers-dev/doku.php/gsocstudents2014", str);
	    
		 break; 

	 }
	 
	 }
  
}
