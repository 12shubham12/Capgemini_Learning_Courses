package testcases.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utility.BaseClass;

import java.time.Duration;

public class Handling_Frames_Integrated_withListeners extends BaseClass {

    public WebDriver driver;

    @Test
    public void test_FrameHandle() {

        //Waiting for frame to appear and switch to it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        //Or, switching to first frame
        //driver.switchTo().frame(0);

        //switching to second frame and clicking on button
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        driver.findElement(By.xpath("/html/body/div/button")).click();

        //or,
        //driver.switchTo().frame(0);

        //switching to immediate parent frame and click on button
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("/html/body/div[1]/button")).click();

    }
}
