package myTests;
//Make a class for common code in other test cases


	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;

	import org.junit.*;

	import static org.junit.Assert.*;
	import static org.hamcrest.CoreMatchers.*;

	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class CommonMeth {
	
	  protected WebDriver driver;
	  protected String baseUrl;
	  protected boolean acceptNextAlert = true;
	  protected StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://systers.org/systers-dev/doku.php/gsocstudents2014?do=login";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

