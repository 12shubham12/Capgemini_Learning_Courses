package testcases.UI;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.MultipleWindow_Page;
import utility.BaseClass_CrossBrowser;

public class WindowHandle_Test extends BaseClass_CrossBrowser {

    @Test
    public void test_handle_multipleWindow(){
        mwp = PageFactory.initElements(driver, MultipleWindow_Page.class);
        mwp.newWindow(driver);

    }
}
