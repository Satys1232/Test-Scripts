package data_excel_implementation.selenium_cdp_integration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class Cdp_CommandTest {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	DevTools devTools = driver.getDevTools();
	devTools.createSession();
	Map<String, Object> deviceMetrics = new HashMap<>();
	deviceMetrics.put("width", 600);
	deviceMetrics.put("height", 1000);
	deviceMetrics.put("deviceScaleFactor",50);
	deviceMetrics.put("mobile",true);
	driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
	driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Library")).click();
	devTools.close();
	driver.close();
}
}
