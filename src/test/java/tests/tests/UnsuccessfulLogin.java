package tests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;


public class UnsuccessfulLogin {
    WebDriver driver;

    @BeforeTest
    private void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void test() {
        String baseUrl = "https://www.saucedemo.com/";
        String username = "fake_user";
        String password = "wrong_password";

        driver.get(baseUrl);

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class, 'error-message-container')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Failed to login");
    }
}
