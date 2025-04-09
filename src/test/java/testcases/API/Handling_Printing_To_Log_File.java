package testcases.API;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Handling_Printing_To_Log_File {

    @Test
    public void test_print_complete_Req_Res() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        //Providing the path for printing the logs
        PrintStream ps = new PrintStream(new File("./API_Request_Response_Log/restAssured.log"));

        Response response = RestAssured
                .given()
                .header("","")
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .filter(new RequestLoggingFilter(ps))
                .filter(new ResponseLoggingFilter(ps))
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .statusCode(201)
                .extract()
                .response();
    }

    @Test
    public void test_print_specific_Req_Res_details() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        //Providing the path for printing the logs
        PrintStream ps = new PrintStream(new File("./API_Request_Response_Log/restAssured.log"));

        Response response = RestAssured
                .given()
                .header("","")
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .filter(new RequestLoggingFilter(LogDetail.BODY, ps))
                .filter(new ResponseLoggingFilter(LogDetail.STATUS, ps))
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .statusCode(201)
                .extract()
                .response();
    }

}
