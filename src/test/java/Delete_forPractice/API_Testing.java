package Delete_forPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class API_Testing {

    @Test
    public void get_body_validation(){

        Response response = RestAssured.given()
                .header("Accept", "application/xml")
                //.contentType(ContentType.XML)
                .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                .queryParam("id", 5)
                .when()
                .get("/Students")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                //.body("firstName", equalTo("<[Harmon]>"),
                  //      "country", equalTo("<[Ecuador]>"))
                .extract()
                .response();

        System.out.println(response.prettyPrint());

    }
}
