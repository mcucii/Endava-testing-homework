package tests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class SecondHomework {
    private WebDriver driver = null;

    @Parameters({"browser"})
    @BeforeMethod
    public void startBrowser(@Optional("firefox") @NotNull String browser){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new WebDriverException(String.format("%s is not supported browser", browser));
        }
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        if (driver != null) {
            driver.quit();
        }
    }


    @Test(dataProvider = "credentials")
    public void test2(String username, String password){
        driver.get("https://www.saucedemo.com/");

        WebElement usernameFiled = driver.findElement(By.id("username"));
        usernameFiled.sendKeys(username);

        WebElement passwordFiled = driver.findElement(By.name("password"));
        passwordFiled.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";

        assertEquals(currentURL, expectedURL, "ERROR: URLs don't match!");
    }


    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{
                {"abc","sdasd"},
                {"user", "passwor"},
                {"users", "password"},
                {" user ", " password "}
        };
    }

}
