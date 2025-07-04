package SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.abstract_components.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	JavascriptExecutor js;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.js = (JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;


	By productsBy = By.cssSelector(".mb-3");
	By productNameBy = By.tagName("b");
	By selectProductBy = By.cssSelector(".card-body button:last-of-type");
	By toastMessageBy = By.cssSelector("#toast-container");
	By animationBy = By.cssSelector(".ngx-spinner-overlay");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		return getProductList().stream()
				.filter(product -> product.findElement(productNameBy).getText().equals(productName)).findFirst()
				.orElse(null);
	}

	public void addToCart(String productName) throws InterruptedException {
		WebElement productSelected = getProductByName(productName);
		productSelected.findElement(selectProductBy).click();
		waitForElementToAppear(toastMessageBy);
		sleep();
	}


}
