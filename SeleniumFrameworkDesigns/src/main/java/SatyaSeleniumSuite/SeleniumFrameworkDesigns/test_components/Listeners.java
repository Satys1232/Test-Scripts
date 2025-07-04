package SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.resources.ExtentReportResources;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReportResources.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed!");

	}

	public void onTestFailure(ITestResult result) {

		String filePath = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().fail(result.getThrowable());
		try {
			filePath = takeScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().fail("Error Occured", MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
} 