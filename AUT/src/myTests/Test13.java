package myTests;
//Test for the missing username

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test13 extends CommonMeth {

	@Test
	public void test3() throws Exception {
		  driver.get(baseUrl);
		  driver.findElement(By.name("p")).click();
		  driver.findElement(By.name("p")).clear();
		  driver.findElement(By.name("p")).sendKeys("password1");
		  driver.findElement(By.cssSelector("fieldset > input.button")).click();
		  
		  assertTrue(driver.getPageSource().contains("You are currently not logged in! Enter your authentication credentials below to log in. You need to have cookies enabled to log in."));
		  
		  WebElement currentElement = driver.switchTo().activeElement();
		  WebElement usernameElement = driver.findElement(By.id("focus__this"));
		  assertTrue(usernameElement.equals(currentElement));
			 
		  WebElement pwd = driver.findElement(By.name("p"));
		  String str = pwd.getAttribute("value");
		  assertTrue(str.contentEquals(""));
				  
	  }
}
