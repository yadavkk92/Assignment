package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import amazonauto.BaseTest;
import utility.ExtentReportManager;
import utility.Utility;

public class Listeners implements ITestListener{
	ExtentTest test ;
	ExtentReports extent;


	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onStart(ITestContext context) {
		 extent= ExtentReportManager.getReportObject();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		
		//String methodName = result.getMethod().getMethodName();
		//WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	test.log(Status.FAIL, result.getThrowable());
	test.addScreenCaptureFromPath(Utility.getScreenshot());
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	public void reportLog(String msg) {
		test.log(Status.INFO, msg);
	}
	
}
