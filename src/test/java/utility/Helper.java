package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v132.page.model.Screenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper extends BaseClass{


    //DateTimeStamp
    public static String getCurrentDateTime(){
        return LocalDateTime.now().format((DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")));
    }

    //Taking the screenshot in test failure
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
