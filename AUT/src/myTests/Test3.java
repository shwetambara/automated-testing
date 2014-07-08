package myTests;
// Test for the missing username
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test3 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://systers.org/systers-dev/doku.php/gsocstudents2014?do=login";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test3() throws Exception {
	  driver.get(baseUrl);
	  driver.findElement(By.name("p")).click();
	  driver.findElement(By.name("p")).clear();
	  driver.findElement(By.name("p")).sendKeys("password1");
	  driver.findElement(By.cssSelector("fieldset > input.button")).click();
	  
	  boolean b1 = driver.getPageSource().contains("You are currently not logged in! Enter your authentication credentials below to log in. You need to have cookies enabled to log in.");
	  WebElement currentElement = driver.switchTo().activeElement();
	  WebElement usernameElement = driver.findElement(By.id("focus__this"));
	  boolean b2 = usernameElement.equals(currentElement);
		
	  if(b1&&b2)
			{
		  driver.findElement(By.name("p")).clear();
		  System.out.println("Valid");
			}
	  else
			System.out.println("Invalid");
	  
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
