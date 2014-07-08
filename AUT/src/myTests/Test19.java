package myTests;
//reset password using wrong userid

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test19 extends CommonMeth{

	@Test
	  public void test9() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.linkText("Set new password")).click();
	    driver.findElement(By.name("login")).click();
	    driver.findElement(By.name("login")).clear();
	    driver.findElement(By.name("login")).sendKeys("username1");
	    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	    boolean b = driver.getPageSource().contains("Sorry, we can't find this user in our database.");
	    assertTrue(b);
	  }
}
