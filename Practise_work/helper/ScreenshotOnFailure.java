package helper;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotOnFailure extends openWebsite{
	
	public void takeScreenshotonFailure() throws IOException{
		// take the screenshot at the end of every test
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // now save the screenshot to a file some place
        FileUtils.copyFile(scrFile, new File("/home/shwetambara/ScreenshotOnFail/sample.png"));   
	}
}
