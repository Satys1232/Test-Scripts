package Satya.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	
	ExtentReports extent;
	@Test
	public void initialDemo()
	{
		ExtentTest test = extent.createTest("initial demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
	    System.out.println(	driver.getTitle());
	   // test.addScreenCaptureFromBase64String(null);
	    driver.close();
	    test.fail("Something Went Wrong.");
	    extent.flush();
	}

	 @BeforeTest
	 public void config()
	 {
		 String reportPath = System.getProperty("user.dir")+"/test-output/ExtentReports/ExtentReport.html";
		 ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		 reporter.config().setReportName("Test Results");
		 reporter.config().setDocumentTitle("Selenium Test Report");
		 extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Tester", "SatyaBrataPatra");
	 }
}
