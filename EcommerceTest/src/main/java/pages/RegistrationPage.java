package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameInput = By.id("firstname");
    private By lastNameInput = By.id("lastname");
    private By emailInput = By.id("email_address");
    private By passwordInput = By.id("password");
    private By confirmPasswordInput = By.id("password-confirmation");
    private By createAccountButton = By.cssSelector("button[title='Create an Account']");
    private By welcomeMessage = By.cssSelector("[data-ui-id='message-success']");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void register(String firstName, String lastName, String email, String password) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
        driver.findElement(createAccountButton).click();
    }

    public void verifyRegistration() {
            Assert.assertTrue(driver.findElement(welcomeMessage).isDisplayed(), "Thank you for registering with Main Website Store.");
    }



}