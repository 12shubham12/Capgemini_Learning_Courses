package testcases.UI;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Handling_Alert {

    public WebDriver driver;
    @Test
    public void test_AlertIsPresent() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/webtable/");

        //clicking on button so that alert will open
        driver.findElement(By.xpath("//button[@id=\"addBtn\"]")).click();

        //code to check if Alert is present
        if(isAlertPresent()){
            System.out.println("Alert Present");
        }
        else{
            System.out.println("Alert not present");
        }
    }

    public Boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }
        catch(NoAlertPresentException e){
            return false;
        }
    }

    @Test
    public void test_AlertIsPresent_withWait(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/webtable/");

        //clicking on button so that alert will open
        //Comment below field so that catch block will be executed
        driver.findElement(By.xpath("//button[@id=\"addBtn\"]")).click();

        //waiting for alert and switch to it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert is present");
        }
        catch (TimeoutException e){
            System.out.println("No Alert is present");
        }
    }

}
