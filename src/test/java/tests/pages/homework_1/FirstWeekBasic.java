package week.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstWeekBasic {

    @Test
    public void firstTest(){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usernameFieldID =
                driver.findElement(By.id("user-name"));

        usernameFieldID.sendKeys("AAAAAAAAAAAAA");

        WebElement usernameFieldName =
                driver.findElement(By.name("user-name"));

        usernameFieldName.sendKeys("BBBBBBBBBBBB");

        driver.quit();
    }

    @Test
    public void secondTest(){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");

        String currentURL =
                driver.getCurrentUrl();

        System.out.println("CURRENT URL IS -> " + currentURL);

        WebElement usernameFieldXPath =
                driver.findElement(By.xpath("//input[@type='text']"));

        usernameFieldXPath.sendKeys("standard_user");


        WebElement usernameFieldCSS =
                driver.findElement(By.cssSelector("input[type='password']"));

        usernameFieldCSS.sendKeys("secret_sauce");

        WebElement logInButtonCSS =
                driver.findElement(By.cssSelector("input[value='Login']"));

        logInButtonCSS.click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Swag Labs"));


        currentURL =
                driver.getCurrentUrl();

        System.out.println("CURRENT URL IS -> " + currentURL);

        WebElement menu = driver.findElement((By.id("react-burger-menu-btn")));
        menu.click();

        WebElement logOutButton =
                driver.findElement(By.id("logout_sidebar_link"));

        logOutButton.click();

        currentURL =
                driver.getCurrentUrl();

        System.out.println("CURRENT URL IS -> " + currentURL);

        driver.close();
    }


    /*
    Thread.sleep(10000);






    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='alert alert-success text-center']")
                ));
    */

}






