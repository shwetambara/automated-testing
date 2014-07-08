package myTests;
//To test the correct login

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class Test15 extends CommonMeth {

	
	@Test
	public void test5() throws Exception {
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
