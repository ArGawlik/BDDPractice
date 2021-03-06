package pageobjects.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BasePage;
import pageobjects.MainPage;

import java.time.Duration;
import java.util.List;

public class DeliveryModule extends BasePage {
    private WebElement zipCodeInput;

    private WebElement applyButton;

    private WebElement countryDropdownButton;

    private WebElement doneButton;

    public DeliveryModule(WebDriver driver) {
        super(driver);
        zipCodeInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("GLUXZipUpdateInput")));
        applyButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("GLUXZipUpdate")));
        countryDropdownButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("GLUXCountryListDropdown")));
        zipCodeInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("GLUXZipUpdateInput")));
        doneButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.name("glowDoneButton")));
    }

    public List<WebElement> getCountiresList() {
        countryDropdownButton.click();
        return driver.findElements(By.xpath("//ul[contains(@class, \"a-list-link\")]/li"));
    }

    public MainPage setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        applyButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id=\"GLUXConfirmClose\"]/../..)[2]"))).click();
        return new MainPage(driver);
    }

    public MainPage setCountry(String country) {
        countryDropdownButton.click();
        WebElement countryLink = driver.findElement(By.xpath(String.format("//a[text()=\"%s\"]", country)));
        countryLink.click();
        doneButton.click();
        return new MainPage(driver);
    }

    public void setInvalidZipCode(String zipcode) {
        zipCodeInput.sendKeys(zipcode);
        applyButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipError")));
    }
}
