package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNG_Listeners implements ITestListener {

 @Override
 public void onTestSuccess(ITestResult result)
 {
	 System.out.println("Test Ran Successfully");
	 
 }
 
 @Override
 public void onTestFailure(ITestResult result)
 {
	 System.out.println("Test Failed::"+result.getName()); 
 }
}
