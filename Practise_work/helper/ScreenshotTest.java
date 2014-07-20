package helper;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotTest {
	private WebDriver driver;
	  private String baseUrl;
	 

	@Before
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://systers.org/systers-dev/doku.php/gsocstudents2014?do=login";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {  
		// take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        FileUtils.copyFile(scrFile, new File("/home/shwetambara/ScreenshotOnFail/screenshot.png"));   
    //quit WebDriver session
        driver.quit();
    }
	

	@Test
	public void test() {
		driver.get(baseUrl);
	    driver.findElement(By.id("focus__this")).click();
	    driver.findElement(By.id("focus__this")).clear();
	    driver.findElement(By.id("focus__this")).sendKeys("username1");
	    driver.findElement(By.name("p")).clear();
	    driver.findElement(By.name("p")).sendKeys("password1");
	    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	    String str = driver.getCurrentUrl();
	    assertEquals("http://systers.org/systers-dev/doku.php/gsocstudents2014", str);
	    
	}

}
