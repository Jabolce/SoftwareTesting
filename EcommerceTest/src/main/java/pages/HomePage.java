package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;
    private By createAccountLink = By.linkText("Create an Account");

    private By SignInAccount = By.linkText("Sign In");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }

    public void clickSignInAccount(){
        driver.findElement(SignInAccount).click();
    }
}
