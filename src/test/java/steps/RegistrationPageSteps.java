package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.RegistrationPage;

import static steps.BaseStep.PAGES;

public class RegistrationPageSteps {
    @When("User on {string} fill Your name with {string} Mobile number or mail with {string} Password with {string} and Re-enter password with {string}")
    public void userFillYourNameWithMobileNumberOrMailWithPasswordWithAndReEnterPasswordWith(String pageName, String name, String emailOrPhone, String password, String passwordCheck) {
        ((RegistrationPage) PAGES.get(pageName)).registerNegative(name, emailOrPhone, password, passwordCheck);

    }

    @Then("{string} should append on {string}")
    public void shouldAppendOn(String errorMessage, String pageName) {
        Assert.assertTrue(((RegistrationPage) PAGES.get(pageName)).getAlerts().contains(errorMessage));
    }
}
