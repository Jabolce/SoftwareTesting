package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Checkout extends HomePage {
    private final By streetAddressLine1 = By.name("street[0]");
    private final By zipCodeInput = By.name("postcode");
    private final By cityInput = By.name("city");
    private final By phoneNumberInput = By.name("telephone");
    private final By countryDropdown = By.name("country_id");


    private final By nextButton = By.cssSelector(".button.action.continue.primary");
    private final By placeOrderButton = By.cssSelector("button.action.primary.checkout");

    private final By orderConfirmation = By.cssSelector("h1.page-title span[data-ui-id='page-title-wrapper']");

    private final JavascriptExecutor js;
    private final WebDriverWait wait;

    public Checkout(WebDriver driver) {
        super(driver);
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait (driver, Duration.ofSeconds(10));
    }

    private void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public void fillOutShippingDetails(String address, String city, String zip, String phone) {
        scrollIntoView(streetAddressLine1);
        driver.findElement(streetAddressLine1).sendKeys(address);

        scrollIntoView(cityInput);
        driver.findElement(cityInput).sendKeys(city);

        scrollIntoView(zipCodeInput);
        driver.findElement(zipCodeInput).sendKeys(zip);

        scrollIntoView(phoneNumberInput);
        driver.findElement(phoneNumberInput).sendKeys(phone);
    }

    public void selectCountryByName(String countryName) {
        WebElement dropdown = driver.findElement(countryDropdown);

        Select select = new Select(dropdown);

        select.selectByVisibleText(countryName);

    }

    public void clickNextButton() {
        scrollIntoView(nextButton);
        driver.findElement(nextButton).click();
    }

    public void placeOrder() {
        scrollIntoView(placeOrderButton);
        driver.findElement(placeOrderButton).click();
    }

    public void VerifyOrder() {
        scrollIntoView(orderConfirmation);
        Assert.assertTrue(driver.findElement(orderConfirmation).isDisplayed(), "Order not confirmed");
    }

    public void verifyShippingPage() {
        wait.until(ExpectedConditions.urlToBe("https://magento.softwaretestingboard.com/checkout/#shipping"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://magento.softwaretestingboard.com/checkout/#shipping", "You are not on Payment Page");
    }

}
