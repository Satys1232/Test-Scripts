package com;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/angularpractice/");
	driver.switchTo().newWindow(WindowType.WINDOW);
	Set<String> handles = driver.getWindowHandles();
	Iterator<String> it = handles.iterator();
	String parentWinid = it.next();
	String childWinid =  it.next();
	driver.switchTo().window(childWinid);
	driver.get("https://rahulshettyacademy.com/#/index");
	String text = driver.findElements(By.cssSelector("a[href*=\"https://courses.rahulshettyacademy.com/p\"]")).get(1).getText();
	driver.switchTo().window(parentWinid);
	driver.findElement(By.xpath("(//input[@name=\"name\"])[1]")).sendKeys(text);
	
}
}
