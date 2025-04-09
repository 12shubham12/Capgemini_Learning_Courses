package testcases.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;


public class Handling_Multiple_Window {

    public WebDriver driver;
    @Test
    public void test_handle_multipleWindows(){
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/multiple-windows/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        //Taking parent window handle
        String parentWindow = driver.getWindowHandle();

        //Opening child window
        WebElement newWindow_btn = driver.findElement(
                By.xpath("//button[@id=\"button1\" and @name=\"newbrowserwindow123\"]"));
        newWindow_btn.click();

        //Taking child window handle
        for(String s: driver.getWindowHandles()){
            if(!s.equals(parentWindow)){
                driver.switchTo().window(s);
                break;
            }
        }
        String child1 = driver.getWindowHandle();
        driver.manage().window().maximize();

        //Suppose we have another child window opened after clicking some button from first child

        driver.findElement(By.xpath("")).click();

        for(String s : driver.getWindowHandles()){
            if(!s.equals(parentWindow) && !s.equals(child1)){
                driver.switchTo().window(s);
                break;
            }
        }
        String child2 = driver.getWindowHandle();
    }


}
