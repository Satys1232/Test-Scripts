package SatyasSeleniumSuite.SeleniumFrameworkDesigns.e2e;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class StandAloneTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LandingPage page = new LandingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String itemName = "ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("satyabratapatra299@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Satya@123");
		driver.findElement(By.id("login")).sendKeys(Keys.RETURN);
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(itemName)).findFirst()
				.orElse(null);
		WebElement addToCartButton = prod.findElement(By.cssSelector(".card-body button:last-of-type"));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ngx-spinner-overlay")));
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		js.executeScript("arguments[0].click();" , driver.findElement(By.cssSelector("[routerlink*='cart']")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".cart h3"))));
		boolean isPresent = driver.findElements(By.cssSelector(".cart h3")).stream()
				
				.anyMatch(s -> s.getText().contains(itemName));
		Assert.assertTrue(isPresent);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".cart
		// h3"))));
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("div[class='form-group'] input")), "ind").build().perform();
		// driver.findElement(By.cssSelector("div[class='form-group']
		// input")).sendKeys("ind");
		//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click(); By cssSelector
		//driver.findElement(By.cssSelector("(//button[contains(@class,'ta-item')])[2]")).click(); By xpath
		driver.findElements(By.cssSelector(".ta-item ")).stream()
				.filter(country -> country.getText().equalsIgnoreCase("India")).findFirst()
				.ifPresent(WebElement::click);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".actions a")));
		js.executeScript("arguments[0].click();" , driver.findElement(By.cssSelector(".actions a")));

		String submit = driver.findElement(By.cssSelector(".hero-primary")).getText();
		//Assert.assertEquals(submit, "THANKYOU FOR THE ORDER.");
		Assert.assertTrue(submit.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(submit+"✅");
		driver.quit();
	}

}
