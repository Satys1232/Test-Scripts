
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
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.RegistrationPage;

public class RegistrationIntegrated extends BaseTest {

    String countryName = "India";

    @Test(dataProvider = "getData", groups = { "Purchase" })
    public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {

        // Registration step
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm(
            input.get("firstName"),
            input.get("lastName"),
            input.get("email"),
            input.get("mobile"),
            input.get("occupation"),
            input.get("gender"),
            input.get("password"),
            input.get("confirmPassword"),
            true // isAdult
        );
        registrationPage.submitRegistration();

        // Login and purchase flow
        ProductCatalogue catalogue = landingPage.login(input.get("email"), input.get("password"));
        List<WebElement> productList = catalogue.getProductList();
        catalogue.addToCart(input.get("productName"));
        CartPage cart = catalogue.clickOnCartIcon();
        boolean isPresent = cart.isProductPresent(input.get("productName"));
        Assert.assertTrue(isPresent);
        CheckoutPage checkout = cart.clickOnCheckOutButton();
        checkout.findAndSelectCountry(countryName);
        OrderPage order = checkout.waitAndPlaceOrder();
        order.getVerified();
    }

    @DataProvider
    public Object getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap("PurchaseOrder.json");
        return new Object[][] { { data.get(0) }, { data.get(1) } };
    }
}
