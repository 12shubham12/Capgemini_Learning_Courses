package testcases.UI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Hadling_DataProvider {

    @DataProvider(name="inputdata")
    public Object[][] inputData(){
        return new Object[][]{
                {"name1", "pass1"},
                {"name2", "pass2"},
                {"name3", "pass3"}
        };
    }

    @Test(dataProvider = "inputdata")
    public void login(String username, String password){
        System.out.println("Username: "+username + "  "+"Password: "+password);
    }

}
