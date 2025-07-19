
package SatyasSeleniumSuite.SeleniumFrameworkDesigns.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SatyaSeleniumSuite.SeleniumFrameworkDesigns.abstract_components.AbstractComponent;

public class RegistrationPage extends AbstractComponent {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userMobile")
    WebElement userMobile;

    @FindBy(css = "select[formcontrolname='occupation']")
    WebElement occupationDropdown;

    @FindBy(css = "input[type='radio'][value='Male']")
    WebElement genderMale;

    @FindBy(css = "input[type='radio'][value='Female']")
    WebElement genderFemale;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(css = "input[type='checkbox'][formcontrolname='required']")
    WebElement ageCheckbox;

    @FindBy(id = "login")
    WebElement registerButton;

    public void fillRegistrationForm(String fName, String lName, String email, String mobile, String occupation, String gender, String password, String confirmPwd, boolean isAdult) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        userEmail.sendKeys(email);
        userMobile.sendKeys(mobile);
        new Select(occupationDropdown).selectByVisibleText(occupation);
        if (gender.equalsIgnoreCase("Male")) {
            genderMale.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            genderFemale.click();
        }
        userPassword.sendKeys(password);
        confirmPassword.sendKeys(confirmPwd);
        if (isAdult && !ageCheckbox.isSelected()) {
            ageCheckbox.click();
        }
    }

    public void submitRegistration() {
        registerButton.click();
    }
}
