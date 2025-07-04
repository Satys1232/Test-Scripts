package SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.abstract_components.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement loginButton;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	By errorMsg = By.cssSelector("[class*='flyInOut']");
	

	public ProductCatalogue login(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		ProductCatalogue catalogue = new ProductCatalogue(driver);
		return catalogue;
	}

	public void goToLoginPage() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		 return errorMessage.getText();
	}
}
