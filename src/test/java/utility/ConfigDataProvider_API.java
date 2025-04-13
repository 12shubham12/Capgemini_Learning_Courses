package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider_API {

    Properties prop;

    public ConfigDataProvider_API() {

        try {
            File file = new File("./config/config.properties");
            FileInputStream fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        }
        catch (IOException e) {
            System.out.println("No File Present");
        }
    }

    public String readStringStudentALI_URL(){
        return prop.getProperty("student_API_BaseURL");
    }
}
