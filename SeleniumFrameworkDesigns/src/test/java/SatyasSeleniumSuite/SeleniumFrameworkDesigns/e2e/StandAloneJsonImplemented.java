package SatyasSeleniumSuite.SeleniumFrameworkDesigns.e2e;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components.BaseTest;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CartPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CheckoutPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.OrderPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.ProductCatalogue;

@SuppressWarnings("unused")
public class StandAloneJsonImplemented extends BaseTest {

	String countryName = "India"; // 🌏 Country selection
	// String productName = "ZARA COAT 3"; // 👗 Product to buy

	@Test(dataProvider = "getData", groups = { "Purchase" })
	// (groups = {"ErrorHandling"})
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

		ProductCatalogue catalogue = landingPage.login(input.get("email"), input.get("password")); // 📝 Enter // //																							// Credentials
		List<WebElement> productList = catalogue.getProductList(); // 📦 Get Product List
		catalogue.addToCart(input.get("productName")); // ➕ Add to Cart
		CartPage cart = catalogue.clickOnCartIcon(); // 🛒 Open Cart
		boolean isPresent = cart.isProductPresent(input.get("productName")); // 🔍 Check Product in Cart
		Assert.assertTrue(isPresent); // ✅ Assert Product Present
		CheckoutPage checkout = cart.clickOnCheckOutButton(); // 🏁 Proceed to Checkout
		checkout.findAndSelectCountry(countryName); // 🌍 Select Country
		OrderPage order = checkout.waitAndPlaceOrder(); // 🕒 Place Order
		order.getVerified();
	}

	@DataProvider
	public Object getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap("PurchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
	
	
}

