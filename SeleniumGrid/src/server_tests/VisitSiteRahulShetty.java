package server_tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class VisitSiteRahulShetty {
	@Test
	public void homePageChecks() throws MalformedURLException, URISyntaxException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.WIN11);
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		WebDriver driver = new RemoteWebDriver(new URI("http://192.168.152.161:4444").toURL(),caps); 
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}
}
