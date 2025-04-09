package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static testcases.API.Handling_TokenGeneration.renewBearerToken;
import static testcases.API.Handling_TokenGeneration.renewoAuthToken;

public class Handling_POST_PUT_DELETE_PATCH {

    @Test
    public void test_POST() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        Response response = RestAssured
                .given()
                    .header("Authorization","Bearer "+renewBearerToken())
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
    public void test_PUT() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/PUTInput.json")));

        Response response = RestAssured
                .given()
                .header("Authorization","oAuth2 "+renewoAuthToken())
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .when()
                .put("/api/users/2")
                .then()
                .log().headers()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.prettyPrint());
    }

    @Test
    public void test_DELETE() throws IOException {

        Response response = RestAssured
                .given()
                .header("Authorization","oAuth2 "+renewoAuthToken())
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .when()
                .delete("/api/users/2")
                .then()
                .log().headers()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    public void test_PATCH() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/PATCHInput.json")));

        Response response = RestAssured
                .given()
                .header("Authorization","oAuth2 "+renewoAuthToken())
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .when()
                .patch("/api/users/2")
                .then()
                .log().headers()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.prettyPrint());
    }
}
