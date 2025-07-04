package SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.abstract_components.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	Actions sendCountryName;
	JavascriptExecutor js;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.js = (JavascriptExecutor)driver;
		this.sendCountryName = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='form-group'] input")
	WebElement countryEntryField;

	@FindBy(css = ".ta-item")
	List<WebElement> countries;
	
	@FindBy(css = ".actions a")
	WebElement placeOrder;

	public void sendCountryName(String countryName) {
		sendCountryName.sendKeys(countryEntryField, countryName).build().perform();
	}

	public void findAndSelectCountry(String countryName) {
		sendCountryName(countryName);
		waitForElementToAppear(By.cssSelector(".ta-item"));
		countries.stream().filter(country -> country.getText().equalsIgnoreCase(countryName)).findFirst()
				.ifPresent(WebElement::click);
	}
	public OrderPage waitAndPlaceOrder()
	{
		waitForElementToBeClickable(By.cssSelector(".actions a"));
		js.executeScript("arguments[0].click();",placeOrder);
		OrderPage order = new OrderPage(driver);
		return order;

	}

}
