package myTests;
//Test for the empty entry in reset password page

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test18 extends CommonMeth{

	@Test
	  public void test8() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.linkText("Set new password")).click();
	    String currenturl = driver.getCurrentUrl();
	    String expectedurl = "http://systers.org/systers-dev/doku.php/gsocstudents2014?do=resendpwd";
	    boolean page_link = currenturl.equalsIgnoreCase(expectedurl);
	    
	    driver.findElement(By.cssSelector("fieldset > input.button")).click();
	    boolean err_msg = driver.getPageSource().contains("Sorry, you must fill in all fields.");
	  
	    assertTrue(page_link&&err_msg);
	  }
}
