package testcases.UI;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class Handling_Wait {

    public WebDriver driver;

    @Test
    public void test_wait_pageLoadTimeout() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/multiple-windows/");

        //Implicit wait to load each element of the webpage
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

    }
    @Test
    public void test_webdriverWait() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/multiple-windows/");

        //Explicit Wait for a specific button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement newBrowserWindow_btn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("newbrowserwindow123")));

        newBrowserWindow_btn.click();
    }

    @Test
    public void test_fluentWait(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/multiple-windows/");

        //Implementing Fluent wait
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(5)).
                pollingEvery(Duration.ofSeconds(1)).
                ignoring(NoSuchElementException.class);

        WebElement newBrowserWindow_btn =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("newbrowserwindow123")));

        newBrowserWindow_btn.click();

        //Other methods available for checking the condition of webelement
        //WebElement el1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

        //waiting for alert and switch to it
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
    }

}