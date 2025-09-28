package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;



public class endToEnd extends BaseTest {

    @Test(priority = 0)
    public void testRegistrationWithRandomCredentials() {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);

        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickCreateAccount();
        registrationPage.register(randomFirstName, randomLastName, randomEmail, randomPassword);

        registrationPage.verifyRegistration();
    }

    @Test(priority = 1)
    public void testRegistrationWithSignInCredentials(){
        HomePage homePage = new HomePage(driver);
        SignInPage signinPage = new SignInPage(driver, wait);
        ProductPage productPage = new ProductPage(driver);

        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickSignInAccount();
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        signinPage.login(randomEmail,randomPassword);
        signinPage.verifySignUp();

        productPage.hoverOverMenAndClickJackets();
        productPage.addProteusFitnessJackshirtToCart();
        String SuccMSGJackshirt = productPage.getSuccessMsgForJackshirt();
        System.out.println("Jackshirt Success Message: " + SuccMSGJackshirt);
        Assert.assertTrue(SuccMSGJackshirt.contains("You added Proteus Fitness Jackshirt to your shopping cart"),
                "Expected success message not found. Actual message: " + SuccMSGJackshirt);
        productPage.ClickOnJacketsLink();
        productPage.addMontanaWindJacketToCart();
        String SuccMSGJacket = productPage.getSuccessMsgForJacket();
        System.out.println("Jacket Success Message: " + SuccMSGJacket);
        Assert.assertTrue(SuccMSGJacket.contains("You added Montana Wind Jacket to your shopping cart"),
                "Expected success message not found. Actual message: " + SuccMSGJacket);
    }

    @Test(priority = 2)
    public void testCheckOutPage(){
        HomePage homePage = new HomePage(driver);
        SignInPage signinPage = new SignInPage(driver, wait);
        ProductPage productPage = new ProductPage(driver);
        Checkout checkoutPage = new Checkout(driver);

        driver.get("https://magento.softwaretestingboard.com/");
        homePage.clickSignInAccount();
        signinPage.login(randomEmail,randomPassword);
        signinPage.verifySignUp();
        try {
            Thread.sleep(3000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.proceedToCart();
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productPage.proceedToCheckout();
        try {
            Thread.sleep(3000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.verifyShippingPage();
        checkoutPage.fillOutShippingDetails(address,city,zip,phone);
        checkoutPage.selectCountryByName("Tonga");
        try {
            Thread.sleep(4000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkoutPage.clickNextButton();
        try {
            Thread.sleep(4000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.placeOrder();
        try {
            Thread.sleep(5000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutPage.VerifyOrder();
    }

}
