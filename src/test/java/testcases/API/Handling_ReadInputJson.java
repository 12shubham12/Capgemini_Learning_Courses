package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Handling_ReadInputJson {

    @Test
    public void test_POST_SendingAsStringObject() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        Response response = RestAssured
                .given()
                .header("","")
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .statusCode(201)
                .extract()
                .response();

        System.out.println(response.prettyPrint());
    }

    @Test
    public void test_POST_SendingAsFileObject() throws IOException {

        //Reading the input json file
        File file = new File("./Requests/POSTInput.json");

        Response response = RestAssured
                .given()
                .header("","")
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(file)
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .statusCode(201)
                .extract()
                .response();

        System.out.println(response.prettyPrint());
    }

}
