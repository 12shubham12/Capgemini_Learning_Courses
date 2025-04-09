package utility;
import java.io.*;

import java.util.Properties;

public class ConfigDataProvider {

    Properties prop;
    ConfigDataProvider() throws IOException {
        File file = new File("./Config/config.properties");
        FileInputStream fis = new FileInputStream(file);
        prop = new Properties();
        prop.load(fis);
    }

    public String getURL(){
        return prop.getProperty("multiple_window_url");
    }

    public String getBrowser(){
        return prop.getProperty("browser");
    }


}
