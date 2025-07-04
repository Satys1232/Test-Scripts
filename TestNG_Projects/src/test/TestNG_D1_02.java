package test;

import org.testng.annotations.Test;

public class TestNG_D1_02 {

	@Test
	public void webCarLoanLogin()
	{
		//selenium
		System.out.println("weblogin car !");
	}
	
	@Test
	//(groups = {"smoke"})
	public void mobileCarLoanLogin()
	{
		//appium
		System.out.println("mobilelogin car @");
	}
	@Test
	public void  apiCarLoanLogin()
	{
		//Rest Api
		System.out.println("apilogin car #");
		
	}
}
