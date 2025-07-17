package data_excel_implementation.selenium_cdp_integration;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.devtools.v137.network.model.Request;
import org.openqa.selenium.devtools.v137.network.model.Response;

public class Cdp_Network_Activity_Log {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), request -> {
         @SuppressWarnings("unused")
		 Request req = request.getRequest();
         //System.out.println("Url is: "+req.getUrl());
		});
		devTools.addListener(Network.responseReceived(), response -> {
			Response resp = response.getResponse();
			//System.out.println("Response Status: "+resp.getStatus());
			//System.out.println("Response Headers: "+resp.getHeaders());
			if(resp.getStatus().toString().startsWith("4"))
			{
				System.out.println(resp.getUrl() +"is failing with status code"+resp.getStatus());
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();

	}
}
