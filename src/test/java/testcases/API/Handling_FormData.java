package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static testcases.API.Handling_TokenGeneration.renewoAuthToken;

/*
Form Data is Key-Value Pair
Used when we send huge amount of data through the server -
Eg to send the file using multi parts form data
The file is not sent in one go to the server, rather it is sent in parts.
Form Data can be send along with the POST or PUT API Request
Request Body can be send as a Form Data
 */
public class Handling_FormData {

    @Test
    public void test_multipart_form_data(){

        Response response = RestAssured.given().
                header("Authorization","oAuth2 "+renewoAuthToken()).
                //contentType is not need when using multiPart - Maybe
                //contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                multiPart("key", "value").
                when().
                post("/api/users/").
                then().
                log().headers().
                extract().
                response();

        System.out.println(response.prettyPrint());
    }
}
