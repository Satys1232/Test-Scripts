package SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.abstract_components.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css =".hero-primary")
	WebElement fromOrderText;
	
	@FindBy(css ="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	By text = By.cssSelector(".hero-primary");
	
	public String getVerified()
	{
		waitForElementToAppear(text);
		String confirmText = fromOrderText.getText();
		System.out.println(confirmText + "✅");
		return confirmText;
	}
	
	public Boolean verifyOrderDisplay(String productName)
	{
		waitForWebElementsToAppear(productNames);
		Boolean match = productNames.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
		return match;
	}
}
