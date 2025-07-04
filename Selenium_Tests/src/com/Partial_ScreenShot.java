package com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Partial_ScreenShot {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.lyft.com/business");
		WebElement email = driver.findElement(By.id(":R1b5a3blm:"));
		email.sendKeys("satyabratapatra299@gmail.com");
		File ss = email.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss,new File("logon.png"));
		System.out.print("Height is: "+email.getRect().getDimension().getHeight()+" ");
		System.out.print("Width is: "+email.getRect().getDimension().getWidth());
	}

}
