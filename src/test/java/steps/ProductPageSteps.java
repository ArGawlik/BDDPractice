package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.ProductPage;
import pageobjects.SearchPage;

import static steps.BaseStep.PAGES;
import static steps.BaseStep.webDriver;

public class ProductPageSteps {
    @And("On {string} the country name is {string}")
    public void onTheCountryNameIs(String pageName, String country) {
        Assert.assertEquals(((ProductPage) PAGES.get(pageName)).getCountryName(), country);
    }
}
