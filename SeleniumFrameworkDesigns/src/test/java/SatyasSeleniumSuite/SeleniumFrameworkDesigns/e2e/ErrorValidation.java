package SatyasSeleniumSuite.SeleniumFrameworkDesigns.e2e;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components.BaseTest;
import SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components.Retry;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CartPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CheckoutPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.OrderPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.ProductCatalogue;

@Test
public class ErrorValidation extends BaseTest {
	@Test(retryAnalyzer = Retry.class)
	public void loginAndvalidateError() {
		landingPage.login("satyabratapatra80@gmail.com", "Satya@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

	@Test
	public void productErrorValidation() throws InterruptedException, IOException {

		String countryName = "India"; // 🌏 Country selection
		String productName = "ZARA COAT 3"; // 👗 Product to buy
		ProductCatalogue catalogue = landingPage.login("satyabratapatra299@gmail.com", "Satya@123"); // 📝 Enter // //
																										// Credentials
         catalogue.getProductList(); // 📦 Get Product List
		catalogue.addToCart(productName); // ➕ Add to Cart
		CartPage cart = catalogue.clickOnCartIcon(); // 🛒 Open Cart
		boolean isPresent = cart.isProductPresent(productName); // 🔍 Check Product in Cart
		Assert.assertTrue(isPresent); // ✅ Assert Product Present
		CheckoutPage checkout = cart.clickOnCheckOutButton(); // 🏁 Proceed to Checkout
		checkout.findAndSelectCountry(countryName); // 🌍 Select Country
		OrderPage order = checkout.waitAndPlaceOrder(); // 🕒 Place Order
		order.getVerified();
	}
}
