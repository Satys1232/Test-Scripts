package server_tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class ServerTest {
@Test
public void homePageCheck() throws MalformedURLException, URISyntaxException
{
	DesiredCapabilities caps = new DesiredCapabilities();
	//caps.setBrowserName("chrome");
	caps.setPlatform(Platform.WIN11);
	caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
	WebDriver driver = new RemoteWebDriver(new URI("http://192.168.152.161:4444").toURL(),caps); 
	driver.get("https://google.com");
	driver.findElement(By.name("q")).sendKeys("rahulshettyacademy");
	System.out.println(driver.getCurrentUrl());
	driver.close();
}
}
