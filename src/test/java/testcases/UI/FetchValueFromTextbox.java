package testcases.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FetchValueFromTextbox {

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
        textbox.clear();
        textbox.sendKeys("Hello");

        //Fetching the text from textbox
        String textbox_txt = textbox.getAttribute("value");
        System.out.println("Textbox text is: " + textbox_txt);


    }
}
