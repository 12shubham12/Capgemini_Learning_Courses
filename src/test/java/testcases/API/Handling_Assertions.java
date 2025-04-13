package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.testng.Assert.assertEquals;
import static testcases.API.Handling_TokenGeneration.renewoAuthToken;

public class Handling_Assertions {

    @Test
    public void usingHamcrest() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        Response response = RestAssured
                .given()
                .header("Authorization","Bearer "+renewoAuthToken())
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .assertThat()
                .statusCode(201)
                .body("actual_result.name", equalTo("expected"),
                        "actual.workspace", hasItems("item1", "item2", "item3"))
                .body("result.email", containsString("@gmail.com"))
                .extract()
                .response();

        //validating response Time
        assertThat(response.getTime(), lessThan(2000L));

        //Printing headers
        Headers headers = response.getHeaders();
        System.out.println(headers);

        //Printing Cookie
        String cookie = response.getCookie("session");
        System.out.println(cookie);
        //or
        Cookies cookie2 = response.getDetailedCookies();
        System.out.println(cookie2);

    }

    @Test
    public void usingTestNG() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        Response response = RestAssured
                .given()
                .header("Authorization","Bearer "+renewoAuthToken())
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .extract()
                .response();

        assertEquals(response.jsonPath().getString("workspace_name"), "Amit");
        assertEquals(response.jsonPath().getInt("workspace.name.id"),11001);
        //for boolean -> assertTrue(response.jsonPath().getBoolean("AccStatusActive"));
        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json");

        //Print the response in console
        System.out.println(response.prettyPrint());
    }

    @Test
    public void usingTestNG_SoftAssert() throws IOException {

        //Reading the input json file
        String input_body_put = new String(Files.readAllBytes(Paths.get("./Requests/POSTInput.json")));

        Response response = RestAssured
                .given()
                .header("Authorization","Bearer "+renewoAuthToken())
                .contentType(ContentType.JSON)
                .baseUri("https://reqres.in")
                .body(input_body_put)
                .when()
                .post("/api/users")
                .then()
                .log().headers()
                .extract()
                .response();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.jsonPath().getString("workspace_name"), "Amit");
        softAssert.assertEquals(response.jsonPath().getInt("workspace.name.id"),11001);
        //for boolean -> assertTrue(response.jsonPath().getBoolean("AccStatusActive"));
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.contentType(), "application/json");

        softAssert.assertAll();

        //Print the response in console
        System.out.println(response.prettyPrint());
    }
}
