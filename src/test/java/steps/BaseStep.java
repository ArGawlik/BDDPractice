package steps;

import factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pageobjects.BasePage;

import java.util.HashMap;
import java.util.Map;

public class BaseStep {
    public static final Map<String, BasePage> PAGES = new HashMap<>();
    public static WebDriver webDriver;

    @Before
    public void initWebDriver() {
        webDriver = new WebDriverFactory().getWebDriver();
    }

    @After
    public void afterScenario() {
        webDriver.close();
        webDriver.quit();
    }
}
