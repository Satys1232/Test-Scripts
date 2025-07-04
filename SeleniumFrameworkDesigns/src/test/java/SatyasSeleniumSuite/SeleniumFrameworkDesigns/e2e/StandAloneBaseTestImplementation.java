package SatyasSeleniumSuite.SeleniumFrameworkDesigns.e2e;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
public class StandAloneBaseTestImplementation extends BaseTest {
	
	String countryName = "India"; // 🌏 Country selection
	//String productName = "ZARA COAT 3"; // 👗 Product to buy
	@Test(dataProvider = "getData", groups = {"Purchase"})
	//(groups = {"ErrorHandling"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {

		ProductCatalogue catalogue = landingPage.login(input.get("email"),input.get("password")); // 📝 Enter // 																				// Credentials
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
//	@Test(alwaysRun = false)
//	public void OrderHistoryTest()
//	{
//     ProductCatalogue catalogue =landingPage.login("satyabratapatra299@gmail.com", "Satya@123"); // 📝 Enter credentials //																			// Credentials
//     OrderPage ordersPage = catalogue.goToOrdersPage();
//     Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
//	}
	@DataProvider
	public Object getData() throws IOException
	{
//	    HashMap<String,String>map = new HashMap<String,String>();
//	    map.put("email" , "satyabratapatra299@gmail.com");
//	    map.put("password", "Satya@123");
//	    map.put("productName","ZARA COAT 3");
//	    
//	    HashMap<String,String>map1 = new HashMap<String,String>();
//	    map1.put("email" , "satyabratapatra80@gmail.com");
//	    map1.put("password", "Satya#123");
//	    map1.put("productName","ADIDAS ORIGINALS");
//	    
	    List<HashMap<String , String>> data = getJsonDataToMap("PurchaseOrder.json");
	    
		return new Object[][]  { {data.get(0)} ,{data.get(1)}};
	}
}
