package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Credentials;

import java.time.Duration;

public class BaseTest {
    protected  WebDriver driver;
    protected  WebDriverWait wait;
    protected  String randomEmail;
    protected  String randomPassword;
    protected  String randomFirstName;
    protected  String randomLastName;
    protected  String address = "Elmore Street";
    protected  String city = "Kumanovo";
    protected  String zip = "1300";
    protected  String phone = "69696420";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        if (randomEmail == null) {
            randomEmail = Credentials.getRandomEmail();
            randomPassword = Credentials.getRandomPassword();
            randomFirstName = Credentials.generateRandomFirstName();
            randomLastName = Credentials.generateRandomLastName();
        }
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
