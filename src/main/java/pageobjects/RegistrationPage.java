package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.StringJoiner;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "ap_customer_name")
    private WebElement nameInput;

    @FindBy(id = "ap_email")
    private WebElement emailOrPhoneInput;

    @FindBy(id = "ap_password")
    private WebElement passwordInput;

    @FindBy(id = "ap_password_check")
    private WebElement passwordCheckInput;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "auth-customerName-missing-alert")
    private WebElement nameMissingAlert;

    @FindBy(id = "auth-email-missing-alert")
    private WebElement emailOrPhoneMissingAlert;

    @FindBy(id = "auth-email-invalid-claim-alert")
    private WebElement emailOrPhoneInvalidAlert;

    @FindBy(id = "auth-password-invalid-password-alert")
    private WebElement invalidPasswordAlert;

    @FindBy(id = "auth-password-mismatch-alert")
    private WebElement passwordMismatchAlert;

    public void registerNegative(String name, String emailOrPhone, String password, String passwordCheck) {
        nameInput.sendKeys(name);
        emailOrPhoneInput.sendKeys(emailOrPhone);
        passwordInput.sendKeys(password);
        passwordCheckInput.sendKeys(passwordCheck);
        continueButton.click();
    }

    public String getAlerts() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(nameMissingAlert.getText());
        stringJoiner.add(emailOrPhoneMissingAlert.getText());
        stringJoiner.add(emailOrPhoneInvalidAlert.getText());
        stringJoiner.add(invalidPasswordAlert.getText());
        stringJoiner.add(passwordMismatchAlert.getText());
        return stringJoiner.toString();
    }
}
