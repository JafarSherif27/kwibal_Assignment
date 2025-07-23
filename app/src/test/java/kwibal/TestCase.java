package kwibal;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase {
    protected WebDriver driver;
    private WebDriverWait wait;
    private static final int MAX_WAIT_TIME = 10;
    private static final String HOME_PAGE_URL = "https://web.platform.kwibal.com/";
    private String product = "iPhone";

    // Setup
    @BeforeClass(enabled = true)
    public void setup() {
        try {
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.get(HOME_PAGE_URL);
            System.out.println("Driver initialized: " + (driver != null));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    // Test
    @Test
    public void homePage() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_WAIT_TIME));

            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SEARCH_BOX)).sendKeys(product,
                    Keys.ENTER);
            WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.RESULTS));
            Assert.assertTrue(results.isDisplayed(), "Faild to validate whether search results are displayed");

            System.out.println("Are Search results displayed: " + (results.isDisplayed()));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

    // Tear-down
    @AfterClass(enabled = true)
    public void tearDown() {
        driver.quit();
    }

}
