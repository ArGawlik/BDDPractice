package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ProductPage;
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
        }
    }

    @When("User on {string} clicks on the first product")
    public void userOnClicksOnTheFirstProduct(String pageName) {
        ((SearchPage)PAGES.get(pageName)).clickFirstResult();
    }
}
