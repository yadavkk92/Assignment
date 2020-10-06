package amazonauto;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import listeners.Listeners;
import utility.ExtentReportManager;

public class BaseTest {

	static WebDriver driver;
    Listeners listener;
	ExtentTest test ;

	
	public void initBrowser() {
		
		System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	
}
