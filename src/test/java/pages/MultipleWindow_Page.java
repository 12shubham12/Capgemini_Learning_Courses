package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.BaseClass_CrossBrowser;

import java.time.Duration;

public class MultipleWindow_Page extends BaseClass_CrossBrowser {

    @FindBy(name ="newbrowserwindow123") private WebElement newWindow_btn;

    //Method to click on New Window button
    public void newWindow(WebDriver driver){
        String parentWindow = driver.getWindowHandle();
        newWindow_btn.click();
        for(String s: driver.getWindowHandles()){
            if(!s.equals(parentWindow)){
                driver.switchTo().window(s);
                driver.manage().window().maximize();
                break;
            }
        }
        String child1_window = driver.getWindowHandle();
        System.out.println("Second window handle is: "+child1_window);
    }
}
