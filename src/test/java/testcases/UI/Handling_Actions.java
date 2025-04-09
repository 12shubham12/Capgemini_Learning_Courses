package testcases.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Handling_Actions {

    public WebDriver driver;
    @Test
    public void test_getTextFromTextbox() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.html.am/html-codes/textboxes/html-textbox.cfm");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        //Locating textbox and clearing the existing input and sending the text
        WebElement textbox = driver.findElement(By.xpath("/html/body/div[1]/article/table[4]/tbody/tr[2]/td[2]/form/textarea"));

        //Code to interact with the textbox using Actions and Action

        Actions builder = new Actions(driver);
        Action action = builder.moveToElement(textbox).click()
                .keyDown(textbox, Keys.SHIFT)
                .sendKeys("Hello there")
                .keyUp(textbox, Keys.SHIFT)
                .doubleClick(textbox)
                .contextClick()
                .build();

        action.perform();
    }
}
