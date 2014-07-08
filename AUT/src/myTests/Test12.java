package myTests;
//Test for empty text fields

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test12 extends CommonMeth{


		@Test
		  public void test12() throws Exception {
		    driver.get(baseUrl);
		    driver.findElement(By.cssSelector("fieldset > input.button")).click();
		    
		    boolean b1 = driver.getPageSource().contains("You are currently not logged in! Enter your authentication credentials below to log in. You need to have cookies enabled to log in.");
		    WebElement currentElement = driver.switchTo().activeElement();
			WebElement usernameElement = driver.findElement(By.id("focus__this"));
			boolean b2 = usernameElement.equals(currentElement);
			
			assertTrue(b1&&b2);
		  }

	}

