package myTests;
//Test for reset of password

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test17 extends CommonMeth {
	@Test
	  public void test7() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.linkText("Set new password")).click();
	    
	    String str = driver.getCurrentUrl();
	  
	    assertEquals("http://systers.org/systers-dev/doku.php/gsocstudents2014?do=resendpwd", str);
	     
	  }


}
