package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Handling_Authorization {

    @Test
    public Response test_BasicAuth(){
        Response response = RestAssured.given().
                auth().
                preemptive().
                basic("username", "password").
                header("", "").
                contentType(ContentType.JSON).
                baseUri("").
                body("").
                when().
                post("").
                then().
                extract().
                response();

        return response;
    }

    @Test
    public Response test_BearerorOAUTH(){
        Response response = RestAssured.given().
                auth().
                oauth2("token").
                header("", "").
                contentType(ContentType.JSON).
                baseUri("").
                body("").
                when().
                post("").
                then().
                extract().
                response();

        return response;
    }
}
