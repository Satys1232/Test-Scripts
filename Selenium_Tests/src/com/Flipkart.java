package com;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static void main(String[] args) {
		String phoneNumber = "7381170681";
		String phone = "iPhone 16 Black";
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		driver.findElement(By.cssSelector(".r4vIwl")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[text()='Request OTP']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".eIDgeN")));
		String verifier = driver.findElement(By.cssSelector(".eIDgeN")).getText();
		Assert.assertEquals(verifier, "Verification code sent to " + phoneNumber);
		driver.findElement(By.cssSelector(".XDRRi5")).sendKeys("876235");
		wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector(".XDRRi5"), "876235"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".H6-NpN span")));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(phone);
		driver.findElement(By.xpath("//div[text()=\"Apple iPhone 16 (Black, 128 GB)\"]")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		iterator.next();
		String ChildWindow = iterator.next();
		driver.switchTo().window(ChildWindow);
		driver.findElement(By.xpath("//button[text()='Buy Now']")).click();
		driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hTIkqv")));
		driver.findElement(By.xpath("//button[text()=\"Accept & Continue\"]"));

	}

}
