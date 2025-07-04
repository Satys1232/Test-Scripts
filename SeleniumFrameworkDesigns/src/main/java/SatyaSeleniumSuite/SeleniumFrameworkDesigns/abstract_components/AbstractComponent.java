package SatyaSeleniumSuite.SeleniumFrameworkDesigns.abstract_components;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CartPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.OrderPage;

public class AbstractComponent {
	
	 WebDriver driver;
	JavascriptExecutor js;

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartIcon;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement OrderHeader;
	

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.js = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}

	public  void waitForElementToAppear( By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public  void waitForWebElementToAppear( WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public  void waitForWebElementsToAppear( List<WebElement> findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(findBy));

	}
	
	public void waitForElementToDisappear( By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

	}
	
	public void waitForElementToBeClickable( By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));

	}
	
	public void sleep() throws InterruptedException
	{
		Thread.sleep(1000);
	}
	
	public OrderPage goToOrdersPage()
	{
		waitForWebElementToAppear(OrderHeader);
		OrderHeader.click();
		OrderPage ordersPage = new OrderPage(driver);
		return ordersPage;
	}
	
	public CartPage clickOnCartIcon() {
		js.executeScript("arguments[0].click();", cartIcon);
		// 🛒 Cart Page Object
				CartPage cart = new CartPage(driver);
				return cart;
		
	}
}
