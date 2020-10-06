package utility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import amazonauto.BaseTest;

public class Utility {

	public static void switchToTab(WebDriver driver) {
		String parent=driver.getWindowHandle();
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		while(itr.hasNext())
		{
		String child_window=itr.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
	}
	
	public static String getScreenshot() {
		String destFile=null;
		try {
		TakesScreenshot ts = (TakesScreenshot) BaseTest.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		 destFile = System.getProperty("user.dir")+"\\Screenshot\\" + "PageScreenshot"+System.currentTimeMillis()+".png";
		FileUtils.copyFile(srcFile, new File(destFile));
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return destFile;
}
}
