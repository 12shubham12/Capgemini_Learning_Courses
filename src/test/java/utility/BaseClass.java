package utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseClass {

    public ConfigDataProvider config;
    public ExcelDataProvider excel;
    public WebDriver driver;

    @BeforeSuite
    public void setup() throws IOException {
        config = new ConfigDataProvider();
        excel = new ExcelDataProvider();
    }

    @BeforeClass
    public void launchBrowser(){
        driver=BrowserSetup.browserInit(driver, config.getURL(), config.getBrowser());
    }

    @AfterClass
    public void terminateBrowser(){
        //BrowserSetup.quitBrowser(driver);
    }
}
