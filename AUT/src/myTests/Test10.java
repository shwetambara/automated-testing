package myTests;

import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.*;

// Test for the focus on the username field

public class Test10 extends CommonMeth{

  @Test
  public void test10() throws Exception {
	  driver.get(baseUrl);
	  WebElement currentElement = driver.switchTo().activeElement();
	  WebElement usernameElement = driver.findElement(By.id("focus__this"));
	  boolean b = usernameElement.equals(currentElement);
	  assertTrue(b);
  }
}

  