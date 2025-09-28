package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignInPage {
    private  WebDriver driver;
    private  WebDriverWait wait;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("pass");

    private By SignInButton = By.id("send2");

    private JavascriptExecutor js;


    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver;
    }

    private void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void login(String email, String password) {
        scrollIntoView(emailInput);
        driver.findElement(emailInput).sendKeys(email);
        scrollIntoView(passwordInput);
        driver.findElement(passwordInput).sendKeys(password);
        scrollIntoView(SignInButton);
        driver.findElement(SignInButton).click();
    }

    public void verifySignUp() {
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/", "cannot Sign Up");
    }


}
