package myTests;
//Test for the missing password

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test14 extends CommonMeth {
	@Test
	public void test14() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.id("focus__this")).click();
	    driver.findElement(By.id("focus__this")).clear();
	    driver.findElement(By.id("focus__this")).sendKeys("username1");
	    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	    
	    assertTrue(driver.getPageSource().contains("Sorry, username or password was wrong."));
	    
	    WebElement currentElement = driver.switchTo().activeElement();
		WebElement usernameElement = driver.findElement(By.id("focus__this"));
		assertTrue(usernameElement.equals(currentElement));
		
		WebElement userid = driver.findElement(By.id("focus__this"));
		String str = userid.getAttribute("value");
		assertTrue(str.contentEquals("username1"));
				
	  }
}
