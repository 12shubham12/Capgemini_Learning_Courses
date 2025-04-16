package testcases.UI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utility.BaseClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Handling_Screenshot extends BaseClass {

    //DateTimeStamp
    public static String getCurrentDateTime(){
        return LocalDateTime.now().format((DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")));
    }

    public static void getScreenshot(String testCaseName){
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./reports/"+testCaseName+getCurrentDateTime()+".png"));
        }
        catch(IOException e){
            System.out.println("Invalid File location "+e.getMessage());
        }
        //return System.getProperty("./src/reports"+testCaseName+getCurrentDateTime()+".png");
    }
}
