package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

import static testcases.API.Handling_TokenGeneration.renewoAuthToken;

public class Handling_PathParameters {

    @Test
    public void test_SinglePathParameter_GET(){

        //we have given object as it will accept integer and String both
        Response response = RestAssured.given().
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                pathParam("user_id",2).
                when().
                get("/api/users/{user_id}").
                then().
                extract().
                response();

        System.out.println(response.prettyPrint());
    }

    @Test
    public void test_MultiplePathParameter_GET(){

        //we have given object as it will accept integer and String both
        Response response = RestAssured.given().
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                pathParam("user_id",2).
                pathParam("email", "janet.weaver@reqres.in").
                when().
                get("/api/users/{user_id}/{email}").
                then().
                extract().
                response();

        System.out.println(response.prettyPrint());
    }

    @Test
    public void test_SinglePathParameter_PUT(){

        //we have given object as it will accept integer and String both
        Response response = RestAssured.given().
                header("Authorization","oAuth2 "+renewoAuthToken()).
                contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                pathParam("user_id",2).
                when().
                put("/api/users/{user_id}").
                then().
                extract().
                response();

        System.out.println(response.prettyPrint());
    }

    @Test
    public void test_SinglePathParameter_PATCH(){

        //we have given object as it will accept integer and String both
        Response response = RestAssured.given().
                header("Authorization","oAuth2 "+renewoAuthToken()).
                contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                pathParam("user_id",2).
                when().
                patch("/api/users/{user_id}").
                then().
                extract().
                response();

        System.out.println(response.prettyPrint());
    }
}
