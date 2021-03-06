package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.ProductPage;
import pageobjects.RegistrationPage;
import pageobjects.SearchPage;

import static steps.BaseStep.PAGES;
import static steps.BaseStep.webDriver;

public class SearchPageSteps {
    @Then("User is navigated to {string}")
    public void userIsNavigatedTo(String pageName) {
        switch (pageName) {
            case "Search Page" -> {
                SearchPage searchPage = new SearchPage(webDriver);
                PAGES.put(pageName, searchPage);
            }
            case "Product Page" -> {
                ProductPage productPage = new ProductPage(webDriver);
                PAGES.put(pageName, productPage);
            }
            case "Registration Page" -> {
                RegistrationPage registrationPage = new RegistrationPage(webDriver);
                PAGES.put(pageName, registrationPage);
            }
        }
    }

    @When("User on {string} clicks on the first product")
    public void userOnClicksOnTheFirstProduct(String pageName) {
        ((SearchPage)PAGES.get(pageName)).clickFirstResult();
    }

    @And("Results header on {string} contains {string} keyword")
    public void resultsHeaderOnContainsKeyword(String pageName, String keyword) {
        Assert.assertTrue(((SearchPage) PAGES.get(pageName)).getResultsHeaderText().contains(keyword));
    }

    @And("On {string} the message No results for {string} is shown")
    public void onTheMessageIsShown(String pageName, String keyword) {
        String actualMessage = ((SearchPage)PAGES.get(pageName)).getNoResultsMessage();
        Assert.assertEquals(actualMessage, "No results for " + keyword + ".");
    }
}
