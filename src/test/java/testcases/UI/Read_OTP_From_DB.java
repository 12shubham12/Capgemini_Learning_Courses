package testcases.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.sql.*;

public class Read_OTP_From_DB {

    String host="";
    String username= "";
    String password= "";
    String otp = null;
    WebDriver driver;
    @Test
    public void readSimpleOTP(String host, String username, String password) throws SQLException {

        Connection connection = DriverManager.getConnection(" ", " ", " ");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select otp from otp_table created by desc limit 1");
        otp = resultSet.getString("otp");
        driver.findElement(By.xpath(" ")).sendKeys(otp);
    }

    @Test
    //if encryption is known then apply decryption logic
    //for now we will be using Base64
    public void readEncryptedOTP(){
       // Connection connection = DriverManager.getConnection(" ", " ", " ");
        //Statement statement = connection.createStatement();
        //ResultSet resultSet = statement.executeQuery("select otp from otp_table created by desc limit 1");
        //String encrypted_otp = resultSet.getString("otp");

    }
}
