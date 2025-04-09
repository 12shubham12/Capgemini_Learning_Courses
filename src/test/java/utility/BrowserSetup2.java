package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserSetup2 {
    public static WebDriver browserInit2(WebDriver driver, String url, String browserName,
                                        Boolean NoBrowser, Boolean Incognito){

        if(browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
            ChromeOptions chromeoption = new ChromeOptions();
            if(NoBrowser) chromeoption.addArguments("--headless");
            if(Incognito) chromeoption.addArguments("--incognito");
            driver = new ChromeDriver(chromeoption);
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

    public static void quitBrowser2(WebDriver driver){
        driver.quit();
    }
}
