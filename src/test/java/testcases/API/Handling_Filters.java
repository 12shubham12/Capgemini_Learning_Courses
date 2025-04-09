package testcases.API;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//Can be used to filter the request or response
//Filter statement to be used with given() menthod
public class Handling_Filters {

    @Test
    public void test_POST() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        Response response = RestAssured
                .given()
                .header("","")
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .filter(new RequestLoggingFilter(LogDetail.BODY))
                .filter(new ResponseLoggingFilter(LogDetail.STATUS))
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .statusCode(201)
                .extract()
                .response();
    }
}
