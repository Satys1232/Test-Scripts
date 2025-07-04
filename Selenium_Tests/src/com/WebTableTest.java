package com;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Ordering;

public class WebTableTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\satya\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		System.out.println(isSorted(driver.findElements(By.xpath("//tr/td[1]")).stream().map(WebElement::getText)
				.collect(Collectors.toList())));
		driver.findElements(By.xpath("//tr/td[1]")).stream().filter(e -> e.getText().contains("Beans"))
				.map(e -> e.findElement(By.xpath("./following-sibling::td[1]")).getText()).forEach(System.out::println);
	}

	public static boolean isSorted(List<String> List) {
		return Ordering.natural().isOrdered(List);
	}
}
