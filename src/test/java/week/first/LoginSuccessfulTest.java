package week.first;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginSuccessfulTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSuccessfulLogin() {
        String baseUrl = "https://www.saucedemo.com/";
        String username = "error_user";
        String password = "secret_sauce";

        driver.get(baseUrl);

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        WebElement welcomeMessage = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login was successful");
    }
}
