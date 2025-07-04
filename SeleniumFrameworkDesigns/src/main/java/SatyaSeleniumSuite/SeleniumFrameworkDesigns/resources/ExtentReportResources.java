package SatyaSeleniumSuite.SeleniumFrameworkDesigns.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportResources {

	public static ExtentReports getReportObject()
	{
		String reportPath = System.getProperty("user.dir")+"/test-output/ExtentReports/ExtentReport.html";
		 ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		 reporter.config().setReportName("Test Results");
		 reporter.config().setDocumentTitle("Selenium Test Report");
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "SatyaBrataPatra");
		 return extent;
	}
}
