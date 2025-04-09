package utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.MultipleWindow_Page;

import java.io.IOException;

public class BaseClass_CrossBrowser {

    public WebDriver driver;
    public ConfigDataProvider config;
    public ExcelDataProvider excel;
    public MultipleWindow_Page mwp;

    @BeforeTest
    public void setup() throws IOException {
        config = new ConfigDataProvider();
        excel = new ExcelDataProvider();
    }


    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(String browser){
        driver = BrowserSetup2.browserInit2(driver, config.getURL(), browser,
                false, false);
    }

    @AfterClass
    public void terminateBrowser(){
        //BrowserSetup2.quitBrowser2(driver);
        System.out.println("Quiting browser");
    }

}
