package SatyaSeleniumSuite.SeleniumFrameworkDesigns.stepdefinition;

import java.io.IOException;
import org.testng.Assert;
import SatyaSeleniumSuite.SeleniumFrameworkDesigns.test_components.BaseTest;
import SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitionErrorValidation extends BaseTest {

    public LandingPage landingPage;

    @Given("I navigate to the Ecommerce Page for error testing")
    public void i_navigate_to_ecommerce_page_for_error_testing() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^I attempt login with Gmail \"(.+)\" and Password \"(.+)\"$")
    public void i_attempt_login_with_gmail_and_password(String gmail, String password) {
        landingPage.login(gmail, password);
    }

    @Then("^I should see error message \"(.+)\"$")
    public void i_should_see_error_message(String expectedErrorMessage) {
        String actualErrorMessage = landingPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        driver.close();
    }
}
