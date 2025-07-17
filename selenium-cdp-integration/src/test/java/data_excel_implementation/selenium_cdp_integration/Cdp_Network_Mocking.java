package data_excel_implementation.selenium_cdp_integration;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.fetch.Fetch;
import org.openqa.selenium.devtools.v137.network.model.Request;

public class Cdp_Network_Mocking {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			Request req = request.getRequest();
			if (req.getUrl().contains("shetty")) {
				String newUrl = req.getUrl().replace("=shetty", "=BadGuy");
				System.out.println("New url" + newUrl);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newUrl), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[@routerlink='/library']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
	}
}
