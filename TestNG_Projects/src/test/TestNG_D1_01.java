package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_D1_01 {
//	@BeforeClass
//	public void beforeClass()
//	{
//		System.out.println("This will run before fist method");
//	}
//	@BeforeMethod
//	public void beforeMethod()
//	{
//		System.out.println("i will run before all methods");
//	}
	//@Parameters({ "URL"  , "ApiKey/username"})
	@Test
	//(enabled = true)
	// (groups = {"smoke"})
	public void webPersonalLoanLogin()
	//(String urlname , String apikey) {
		// selenium
	{
  	System.out.println("weblogin Personal !");
//		System.out.println(urlname);
//		System.out.println(apikey);
	}

	@Test(dataProvider = "getData")
	//(timeOut = 4000)
	public void mobilePersonalLoanLogin(String username , String password) {
		// appium
		System.out.println("mobilelogin Personal @");
	}

	@Test
	//(dependsOnMethods = { "mobilePersonalLoanLogin" })
	public void apiPersonalLoanLogin() {
		// Rest Api
		System.out.println("apilogin Personl #");

	}
	@DataProvider
	public Object getData()
	{
	 // LIST COMBINATION USERNAME AND PASSOWORD.
     // 2ND , 3RD .. MANY MORE.
		Object[][] data = new Object[3][2];
		//first set data.
		data[0][0] = "firstsetusername" ;
		data[0][1] = "firstsetpassword" ;
		//second set data.
		data[1][0] = "secondsetusername" ;
		data[1][1] = "secondsetpassword" ;
		//third set
		data[2][0] = "thirdsetusername" ;
		data[2][1] = "thirdsetpassword" ;
		return data;
	  }
//	@AfterClass
//	public void afterClass()
//	{
//		System.out.println("This will run after last method");
//	}
//	@AfterMethod
//	public void aftermethod()
//	{
//		System.out.println("this will runa after all methods");
//	}
}
