package testcases.API;

//Normally Json schema validation is done on the response body
//dependency is json-schema-validator
//For this we will have to keep jsonschema file for the response in resources folder under main
//Created GET_Schema.json file inside main.java/Resources/JsonSchemaFiles

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static testcases.API.Handling_TokenGeneration.renewoAuthToken;

public class Handling_JsonSchema_Validation {

    @Test
    public void test_jsonSchemaValidation_GET(){
        Response response = RestAssured.given().
                header("Authorization","oAuth2 "+renewoAuthToken()).
                contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                when().
                get("/api/users/2").
                then().
                assertThat().
                body(matchesJsonSchema(new File("./src/main/java/Resources/JsonSchemaFiles/GET_Schema.json"))).
                extract().
                response();

        System.out.println(response.prettyPrint());
    }
}
