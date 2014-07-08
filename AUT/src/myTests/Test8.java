package myTests;
// Test for the empty entry in reset password page

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test8 {
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
  public void test8() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.linkText("Set new password")).click();
    String currenturl = driver.getCurrentUrl();
    String expectedurl = "http://systers.org/systers-dev/doku.php/gsocstudents2014?do=resendpwd";
    boolean page_link = currenturl.equalsIgnoreCase(expectedurl);
    
    driver.findElement(By.cssSelector("fieldset > input.button")).click();
    boolean err_msg = driver.getPageSource().contains("Sorry, you must fill in all fields.");
  
    if(page_link&&err_msg)
    	System.out.println("valid");
    else
    	System.out.println("invalid");
    
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
