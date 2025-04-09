package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Handling_MultipleHeaders {

    @Test
    public Response test_SingleHeader(){
        Response response = RestAssured.given().
                            header("Authorization", "").
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
    public Response test_TwoHeader(){
        Response response = RestAssured.given().
                header("Authorization", "").
                header("","").
                contentType(ContentType.JSON).
                baseUri("").
                body("").
                log().all(). //to log the request header and body
                when().
                post("").
                then().
                log().all(). //to log the response header and body
                extract().
                response();

        return response;
    }

    @Test
    public void test_MultipleHeader(){

        Map<String, String> headers = new HashMap<>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        headers.put("header3", "value3");
        Response response = RestAssured.given().
                headers(headers).
                contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                //body("").
                log().all(). //to log the request header and body
                when().
                get("/api/users/2").
                then().
                log().headers(). //to log the response header
                extract().
                response();

        System.out.println(response.prettyPrint());
    }
}
