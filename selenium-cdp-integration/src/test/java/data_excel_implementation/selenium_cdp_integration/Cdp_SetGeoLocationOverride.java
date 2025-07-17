package data_excel_implementation.selenium_cdp_integration;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cdp_SetGeoLocationOverride {
	public static void main(String[] args) {
        String proxyAddress = "18.100.202.104:14109	";

        // Configure proxy settings
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyAddress);
        proxy.setSslProxy(proxyAddress);

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.setProxy(proxy);

		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
//		DevTools tool = driver.getDevTools();
//		tool.createSession();
//		Map<String, Object> coordinates = new HashMap<>();
//		coordinates.put("latitude", 40);
//		coordinates.put("longitude", 3);
//		coordinates.put("accuracy", 1);
//		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Netflix", Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".LC20lb.MBeuO.DKV0Md"))));
		driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).click();
	}
}
