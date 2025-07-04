package test;

import org.testng.annotations.Test;

public class TestNG_D1_03 {

	@Test
	public void webHomeLoanLogin()
	{
		//selenium
		System.out.println("weblogin home !");
	}
	@Test
	public void mobileHomeLoanLogin()
	{
		//appium
		System.out.println("mobilelogin home @");
	}
	
	@Test(groups = {"smoke"})
	public void mobileHomeLoanPay()
	{
		//appium
		System.out.println("mobilepay home @");
	}
	
	@Test
	public void mobileHomeLoanRestart()
	{
		//appium
		System.out.println("mobilerestart home @");
	}
	
	@Test
	public void  apiHomeLoanLogin()
	{
		//Rest Api
		System.out.println("apilogin home #");
	}
//	@BeforeTest
//	public void prerequisite()
//	{
//		System.out.println("I will execute first");
//	}
//	@AfterTest
//	public void afterTest()
//	{
//		System.out.println("This ran after test");
//	}
//	@BeforeSuite
//	public void beforeSuite()
//	{
//		System.out.println("I AM FIRST");
//	}
//	@AfterSuite
//	public void afterSuite()
//	{
//		System.out.println("I AM LAST");
//	}
}
