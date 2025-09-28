package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class ProductPage extends HomePage {

    private final By menMenu = By.xpath("//*[@id=\"ui-id-5\"]");
    private final By topsMenu = By.xpath("//*[@id=\"ui-id-17\"]");
    private final By jacketsMenu = By.xpath("//*[@id=\"ui-id-19\"]");
    private final By proteusFitnessJackshirt = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img");
    private final By montanaWindJacket = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[2]/div/a/span/span/img");
    private final By sizeM = By.xpath("//*[@id='option-label-size-143-item-168']");
    private final By colorBlue = By.xpath("//*[@id='option-label-color-93-item-50']");
    private final By colorGreen = By.xpath("//*[@id='option-label-color-93-item-53']");
    private final By jacketsLinkMenu = By.xpath("/html/body/div[2]/div[2]/ul/li[4]/a");
    private final By addToCartButton = By.xpath("//*[@id=\"product-addtocart-button\"]");
    private final By cartIcon = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
    private final By proceedToCheckoutButton = By.xpath("//*[@id='top-cart-btn-checkout']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverMenAndClickJackets() {
        Actions actions = new Actions(driver);

        WebElement men = driver.findElement(menMenu);
        actions.moveToElement(men).perform();

        WebElement tops = driver.findElement(topsMenu);
        actions.moveToElement(tops).perform();

        WebElement jackets = driver.findElement(jacketsMenu);
        jackets.click();
    }

    public void addProteusFitnessJackshirtToCart() {
        WebElement jackshirt = driver.findElement(proteusFitnessJackshirt);
        jackshirt.click();

        WebElement size = driver.findElement(sizeM);
        size.click();

        WebElement color = driver.findElement(colorBlue);
        color.click();

        WebElement addToCart = driver.findElement(addToCartButton);
        addToCart.click();

    }


    public void addMontanaWindJacketToCart() {
        WebElement jacket = driver.findElement(montanaWindJacket);
        jacket.click();

        WebElement size = driver.findElement(sizeM);
        size.click();

        WebElement color = driver.findElement(colorGreen);
        color.click();

        WebElement addToCart = driver.findElement(addToCartButton);
        addToCart.click();
        
    }

    public void proceedToCart() {
        WebElement cart = driver.findElement(cartIcon);
        cart.click();
    }
    public void proceedToCheckout(){
        WebElement checkoutButton = driver.findElement(proceedToCheckoutButton);
        checkoutButton.click();
    }

    public String getSuccessMsgForJackshirt() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement successMsgContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@data-ui-id='message-success']")));

            return successMsgContainer.getText();
        } catch (TimeoutException e) {
            return "Jackshirt not found";
        }
    }

    public String getSuccessMsgForJacket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement successMsgContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@data-ui-id='message-success']")));

            return successMsgContainer.getText();
        } catch (TimeoutException e) {
            return "Jacket not found";
        }
    }


    public void ClickOnJacketsLink() {
        WebElement jacketsLink = driver.findElement(jacketsLinkMenu);
        jacketsLink.click();
    }


}
