package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.HashMap;

public class Handling_TokenGeneration {
    private static String access_token;
    private static Instant expiry_time;

    //Renewal of Token
    public static String renewBearerToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing Token");
                Response response = getBearerToken();
                access_token = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds-300);
            }
            else{
                System.out.println("Token is valid to use");
            }
        }
        catch(Exception e){
            throw new RuntimeException("ABORT!!! Failed to generate token");
        }
        return access_token;
    }

    public static String renewoAuthToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing Token");
                Response response = getoAuthToken();
                access_token = response.path("access_token");
                int expiryDurationInSeconds = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds-300);
            }
            else{
                System.out.println("Token is valid to use");
            }
        }
        catch(Exception e){
            throw new RuntimeException("ABORT!!! Failed to generate token");
        }
        return access_token;
    }

    //Token Generation to be make as private so that it is accessible within the class only
    private static Response getBearerToken(){
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("client_id", "id");
        formParams.put("client_secret", "client_secred_value");
        formParams.put("grant_type", "refresh_token");
        formParams.put("usernam", "usernameDetail");
        formParams.put("password", "passwordDetails");

        Response response = RestAssured.given().
                            formParams(formParams).
                            contentType(ContentType.URLENC).
                            baseUri("tokenURL").
                            when().
                            post("/api/token").
                            then().
                            extract().
                            response();

        return response;
    }

    private static Response getoAuthToken(){
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("client_id", "id");
        formParams.put("client_secret", "client_secred_value");
        formParams.put("grant_type", "password");
        formParams.put("usernam", "usernameDetail");
        formParams.put("password", "passwordDetails");

        Response response = RestAssured.given().
                formParams(formParams).
                contentType(ContentType.URLENC).
                baseUri("tokenURL").
                when().
                post("/api/token").
                then().
                extract().
                response();

        return response;
    }


}
