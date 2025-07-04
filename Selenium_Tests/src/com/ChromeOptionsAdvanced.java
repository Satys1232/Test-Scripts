package com;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsAdvanced {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--headless=new");
		// options.addArguments("window-size=1920,1080");
		// options.setAcceptInsecureCerts(true);
		// options.addArguments("--disable-notifications");
		// options.addArguments("--disable popup-blocking");
		// options.addArguments("--incognito");
//		options.setPageLoadStrategy(PageLoadStrategy.NONE);
//		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.get("https:google.com");
		System.out.println(driver.getTitle());

	}
}
