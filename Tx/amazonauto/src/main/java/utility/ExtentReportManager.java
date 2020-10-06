package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"/Reports/extentReport.html" ;
		ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kaushal");

		return extent;
	}
	
	
}
