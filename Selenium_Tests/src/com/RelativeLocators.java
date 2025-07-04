package com;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameField = driver.findElement(By.xpath("(//input[@name = 'name'])[1]"));
		WebElement dateField = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		WebElement checkBox = driver.findElement(By.xpath("//label[text() = 'Check me out if you Love IceCreams!']"));
		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameField)).getText());
		driver.findElement(with(By.id("exampleCheck1")).toLeftOf(checkBox)).click();
		driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).click();
		driver.findElement(with(By.tagName("input")).below(dateField)).click();

	}

}
