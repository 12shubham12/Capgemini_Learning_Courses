package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserSetup {


    public static WebDriver browserInit(WebDriver driver, String url, String browserName){

        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else if(browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("No Such Browser");
        }

        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }

    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }
}
