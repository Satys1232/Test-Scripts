package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).sendKeys(Keys.RETURN);
		System.out.println("URL after login: "+driver.getCurrentUrl());
		Cookie sessionCookie = driver.manage().getCookieNamed("session-username");
		System.out.println("Session cookie after login: "+sessionCookie);
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		System.out.println("URL after deleting cookies:"+driver.getCurrentUrl());
		driver.get("https://www.saucedemo.com/");
		driver.manage().addCookie(sessionCookie);
		driver.navigate().refresh();
		System.out.println("URL after adding cookie: "+driver.getCurrentUrl());
		driver.quit();

	}

}
