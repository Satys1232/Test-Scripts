package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoProxy {
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");

		// Replace with authenticated proxy if needed
		String proxyAddress = "184.169.154.119:80"; // Test proxy
		options.addArguments("--proxy-server=http://" + proxyAddress);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://httpbin.io/ip");
		Thread.sleep(5000);
		System.out.println(driver.getPageSource());
		driver.quit();
	}
}
