package utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.sql.*;

public class Helper_API {
    public static RequestSpecification reqSpec;
    public static ResponseSpecification resSpec;

    public static RequestSpecification requestSetup(String baseURL) {
        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseURL)
                .build();
        return reqSpec;
    }

    public static ResponseSpecification responseSetup(int statusCode) {

        if(statusCode==200) {
            resSpec = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .expectContentType(ContentType.JSON).build();
        }
        else if(statusCode==201){
            resSpec = new ResponseSpecBuilder()
                    .expectStatusCode(201)
                    .expectContentType(ContentType.JSON)
                    .build();
        }

        //write for all status code
        return resSpec;
    }

    //DataBase connection (ojdbc11 dependency)
    String username = "";
    String password = "";
    String hostname ="";
    public String getDatafromDB(String data) throws SQLException {
        Connection connections = DriverManager.getConnection(username, password, hostname);
        Statement statement = connections.createStatement();
        ResultSet res = statement.executeQuery("Select otp from otp_table where sys_creation_date<''");
        return res.getString(data);
    }
}
