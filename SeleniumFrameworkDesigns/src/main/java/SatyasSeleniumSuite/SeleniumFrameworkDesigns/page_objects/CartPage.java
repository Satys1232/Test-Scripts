package SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.abstract_components.AbstractComponent;

public class CartPage extends AbstractComponent{
	
	@FindBy(css = ".cart h3")
	private List<WebElement> finalProducts;
	
	@FindBy(css = ".totalRow button")
	private WebElement cartButton;

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  boolean isProductPresent(String productName)
	{
		waitForElementToAppear(By.cssSelector(".cart h3"));
		boolean isPresent = finalProducts.stream()
				.anyMatch(s -> s.getText().contains(productName));
		return isPresent;
	}
	public CheckoutPage clickOnCheckOutButton()
	{
		cartButton.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	

}
