package com;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieUsed {

	public static void main(String[] args) {
		CookieSessionManager.performLogin(); 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		for(Cookie cookie: CookieSessionManager.loginCookies)
		{
			driver.manage().addCookie(cookie);
		}
		driver.navigate().refresh();
		//driver.quit();

	}

}
