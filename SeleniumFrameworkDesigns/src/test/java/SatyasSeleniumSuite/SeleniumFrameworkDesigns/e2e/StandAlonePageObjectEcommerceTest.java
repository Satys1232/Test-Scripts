package SatyasSeleniumSuite.SeleniumFrameworkDesigns.e2e;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components.BaseTest;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CartPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CheckoutPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.LandingPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.OrderPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class StandAlonePageObjectEcommerceTest extends BaseTest {
	public static void main(String[] args) throws InterruptedException {

		String countryName = "India"; // 🌏 Country selection

		// 🚗 Setup ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// 🏠 Landing Page Object
		LandingPage page = new LandingPage(driver);

		// 🛍️ Product Catalog Page Object
		ProductCatalogue catalogue = new ProductCatalogue(driver);

		// 🛒 Cart Page Object
		CartPage cart = new CartPage(driver);

		// 💳 Checkout Page Object
		CheckoutPage checkout = new CheckoutPage(driver);

		// 📦 Order Page Object
		OrderPage order = new OrderPage(driver);

		// ⏳ Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String productName = "ZARA COAT 3"; // 👗 Product to buy

		// 🕒 Implicit Wait & Maximize Window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// 🔑 Login Process
		page.goToLoginPage(); // 🚪 Go to Login Page
		page.login("satyabratapatra299@gmail.com", "Satya@123"); // 📝 Enter Credentials

		// 🛍️ Product Selection
		List<WebElement> productList = catalogue.getProductList(); // 📦 Get Product List
		catalogue.addToCart(productName); // ➕ Add to Cart
		catalogue.clickOnCartIcon(); // 🛒 Open Cart

		// 🛒 Cart Verification
		boolean isPresent = cart.isProductPresent(productName); // 🔍 Check Product in Cart
		Assert.assertTrue(isPresent); // ✅ Assert Product Present
		cart.clickOnCheckOutButton(); // 🏁 Proceed to Checkout

		// 💳 Checkout Process
		checkout.findAndSelectCountry(countryName); // 🌍 Select Country
		checkout.waitAndPlaceOrder(); // 🕒 Place Order

		// 📦 Order Confirmation
		order.getVerified(); // 🎉 Verify Order

		// ❌ Close Browser
		driver.quit(); // 👋 Goodbye!
	}
}
