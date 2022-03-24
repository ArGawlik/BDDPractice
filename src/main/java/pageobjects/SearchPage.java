package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "(//div[contains(@class,'s-result-item') and not(contains(@class,\"AdHolder\")) and not(contains(@class,\"s-widget-spacing-large\"))]//a)[1]")
    List<WebElement> searchResults;

    @FindBy(xpath = "//span[contains(@data-component-type, \"s-result-info-bar\")]")
    private WebElement resultsHeader;

    @FindBy(xpath = "//div[contains(@class, \"s-no-outline\")]/div")
    private WebElement noResultsHeader;

    public ProductPage clickFirstResult() {
        searchResults.get(0).click();
        return new ProductPage(driver);
    }

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getResultsHeaderText() {
        return resultsHeader.getText();
    }

    public String getNoResultsMessage() {
        return noResultsHeader.getText();
    }
}
