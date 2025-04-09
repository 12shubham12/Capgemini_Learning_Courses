package testcases.API;

//Query Parameter appears after ? in Endpoint URL
//It is used to filter the response
//We can send Single or multiple query parameters based on the requirement

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Handling_QueryParamenter {

    //Try the code with some real example
    @Test
    public void test_SingleQueryParameter(){

        Response response = RestAssured.given().
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                queryParam("page",2).
                when().
                get("/api/users").
                then().
                log().headers().
                extract().
                response();
        System.out.println(response.prettyPrint());
    }

    @Test
    public void test_MultipleQueryParameter(){

        Response response = RestAssured.given().
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri("https://someapiurl.com").
                queryParam("user_id",456).
                queryParam("status","Active").
                when().
                get("/endpoint/").
                then().
                extract().
                response();
    }

    //Use of HashMap in case of large number of query parameter
    @Test
    public void test_LargeQueryParameter(){

        //we have given object as it will accept integer and String both
        HashMap<String, Object> queryparams = new HashMap<>();
        queryparams.put("User_id", 465);
        queryparams.put("status", "Active");
        queryparams.put("createdDate", "10/04/2025");

        Response response = RestAssured.given().
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri("https://someapiurl.com").
                queryParams(queryparams).
                when().
                get("/endpoint/").
                then().
                extract().
                response();
    }

    @Test
    public void test_MultiValueQueryParameter(){

        //we have given object as it will accept integer and String both
                Response response = RestAssured.given().
                header("Authorization", "").
                contentType(ContentType.JSON).
                baseUri("https://someapiurl.com").
                queryParams("id", "AC001, AC002, AC003").
                when().
                get("/endpoint/").
                then().
                extract().
                response();
    }

    //Similar to QueryParameter we can create HashMap for pathParam in case we have so many pathParam
}
