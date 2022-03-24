package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.modules.DeliveryModule;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@aria-label=\"Headsets\"]")
    private WebElement headsetesLink;

    private WebElement deliverIcon;

    @FindBy(xpath = "//span[text()=\"Apply\"]/..")
    private WebElement applyZipCodeButton;

    @FindBy(id = "glow-ingress-line2")
    private WebElement destinationName;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage headsetsLinkClick() {
        headsetesLink.click();
        return new SearchPage(driver);
    }

    public void changeZipCode(String zipCode) {
        deliverIcon.click();
        DeliveryModule deliveryModule = new DeliveryModule(driver);
        deliveryModule.setZipCode(zipCode);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(deliverIcon));
        destinationName = driver.findElement(By.id("glow-ingress-line2"));
    }

    public void setInvalidZipcode(String zipCode) {
        deliverIcon.click();
        DeliveryModule deliveryModule = new DeliveryModule(driver);
        deliveryModule.setInvalidZipCode(zipCode);
    }

    public MainPage changeCountry(String country) {
        deliverIcon.click();
        DeliveryModule deliveryModule = new DeliveryModule(driver);
        deliveryModule.setCountry(country);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.stalenessOf(deliverIcon));
        return this;
    }

    public List<String> getAvailableCountires() {
        deliverIcon.click();
        DeliveryModule deliveryModule = new DeliveryModule(driver);
        return deliveryModule.getCountiresList().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public String getDestinationName() {
        return destinationName.getText();
    }

    public MainPage open() {
        driver.get("https://amazon.com/");
//        need to initialize deliverIcon here because after using @FindBy stalenessOf doesn't work
        deliverIcon = driver.findElement(By.id("glow-ingress-block"));
        return this;
    }

    public SearchPage searchForKeyword(String searchKeyword) {
        searchBar.sendKeys(searchKeyword);
        searchBar.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }

    public RegistrationPage openPopUpAndClickStartHereToRegister(){
        Actions actions = new Actions(driver);
        actions.moveToElement(accountLink);
        actions.perform();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable
                        (By.partialLinkText("Start here.")))
                .click();
        return new RegistrationPage(driver);
    }
}
