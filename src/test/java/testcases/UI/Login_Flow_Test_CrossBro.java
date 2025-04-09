package testcases.UI;

import org.testng.annotations.Test;
import utility.BaseClass_CrossBrowser;
import utility.ExcelDataProvider;

public class Login_Flow_Test_CrossBro extends BaseClass_CrossBrowser {

    @Test
    public static void testLogin(){
        System.out.println("Login Success using cross browser");
    }

    @Test
    public void readDataFromExcel(){
        System.out.println(ExcelDataProvider.getStringValue("data",0,0));
        System.out.println(ExcelDataProvider.getIntegerValue("data",0,1));
    }
}
