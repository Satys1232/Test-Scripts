package SatyaSeleniumSuite.SeleniumFrameworkDesigns.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components.BaseTest;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CartPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.CheckoutPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.LandingPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.OrderPage;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue catalogue;
    List<WebElement> productList;
    CheckoutPage checkout;
    OrderPage order;
    CartPage cart;

    // ADD THIS BACKGROUND STEP DEFINITION
    @Given("I am on the Ecommerce Home Page")
    public void i_am_on_the_ecommerce_home_page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^I log in using Gmail \"(.+)\" and Password \"(.+)\"$")
    public void i_log_in_using_gmail_and_password(String gmail, String password) {
        catalogue = landingPage.login(gmail, password);
    }

    @When("^I add the product \"(.+)\" to the cart$")
    public void adding_product_to_cart(String productName) throws InterruptedException {
        productList = catalogue.getProductList();
        catalogue.addToCart(productName);
    }

    @When("^I proceed to checkout , verify the \"(.+)\"and submit the order$")
    public void go_to_checkout_verify_the_product_and_submit(String productName) {
        cart = catalogue.clickOnCartIcon();
        boolean isPresent = cart.isProductPresent(productName);
        Assert.assertTrue(isPresent);
        checkout = cart.clickOnCheckOutButton();
        checkout.findAndSelectCountry("India");
        order = checkout.waitAndPlaceOrder();
    }

    @Then("^I should see \"(.+)\"$")
    public void order_message_verification(String expectedMessage) {
        String actualMessage = order.getVerified();
        Assert.assertTrue(actualMessage.contains(expectedMessage), 
            "Expected message not found. Expected: " + expectedMessage + 
            ", Actual: " + actualMessage);
        driver.close();
    }
}
