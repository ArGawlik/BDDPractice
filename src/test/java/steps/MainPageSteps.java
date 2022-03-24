package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.MainPage;

import static steps.BaseStep.PAGES;
import static steps.BaseStep.webDriver;

public class MainPageSteps {
    @Given("User is on {string}")
    public void userIsOnMainPage(String pageName) {
        MainPage mainPage = new MainPage(webDriver);
        PAGES.put(pageName, mainPage);
        mainPage.open();
    }

    @When("User on {string} set zip code as {string} and click Apply button")
    public void userClicksOnDeliveryIconAndSetZipCodeAsAndClickApplyButton(String pageName, String zipCode) {
        ((MainPage)PAGES.get(pageName)).changeZipCode(zipCode);
    }

    @Then("On {string} delivery icon contains {string}")
    public void onDeliveryIconContains(String pageName, String destination) {
        Assert.assertTrue(((MainPage) PAGES.get(pageName)).getDestinationName().contains(destination));
    }

    @When("User on {string} set country as {string} and click Done button")
    public void userSetCountryAsAndClickDoneButton(String pageName, String country) {
        ((MainPage)PAGES.get(pageName)).changeCountry(country);
    }

    @When("User on {string} clicks on Headsets link")
    public void userOnClicksOnHeadsetsLink(String pageName) {
        ((MainPage)PAGES.get(pageName)).headsetsLinkClick();
    }

    @When("User on {string} set invalid zip code  {string} and click Apply button")
    public void userOnSetInvalidZipCodeAndClickApplyButton(String pageName, String zipcode) {
        ((MainPage)PAGES.get(pageName)).setInvalidZipcode(zipcode);
    }

    @Then("On Delivery Module appears message {string}")
    public void onDeliveryModuleAppearsMessage(String expectedMessage) {
        String actualMessage = webDriver.findElement(By.id("GLUXZipError")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
