package data_excel_implementation.selenium_cdp_integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v137.network.Network;
import org.openqa.selenium.devtools.v137.network.model.ConnectionType;

public class Cdp_Network_Emulation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(true, // offline
				3000, // latency in ms
				100000, // download throughput in bytes/sec
				200000, // upload throughput in bytes/sec
				Optional.of(ConnectionType.ETHERNET), // network type
				Optional.empty(), Optional.empty(), Optional.empty()));

		devTools.addListener(Network.loadingFailed(), loadingFailed->{
        System.out.println(loadingFailed.getTimestamp());
		System.out.println(loadingFailed.getErrorText());
		});
		
//		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
//		timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//
//		long millisStart = System.currentTimeMillis();
//		String startTime = timeFormat.format(new Date(millisStart));
//		System.out.println("Start Time: " + startTime);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

//		long millisEnd = System.currentTimeMillis();
//		String endTime = timeFormat.format(new Date(millisEnd));
//		System.out.println("End Time: " + endTime);
//
//		double totalSeconds = (millisEnd - millisStart) / 1000.0;
//		System.out.println("Total Time Taken: " + totalSeconds + " seconds");

		driver.close();

	}

}
