/*
Basically I have handled 3 types of Authorization
1. Basic - which needs username and password (refer Class: Handling_Authorization amd method: test_BasicAuth)
2. oAuth2 - two type based on grant type (a. client credentials b. password credentials) - refer class: refer Class: Handling_Authorization)
3. Bearer Token(Token generated from oAuth2.0): We directly pass in the header i.e .header("Authorization", Bearer "SDF#$%^%$#456=")
 */

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
    public static String renewoAuthToken(){
        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing Token");
                Response response = getoAuthToken_with_ClientCrendetials_GrantType(); //used one of the method based on grant type
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
    //We can cross check from postman
    private static Response getoAuthToken_with_ClientCrendetials_GrantType(){
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("client_id", "id");
        formParams.put("client_secret", "client_secret_value");
        formParams.put("grant_type", "client_credentials");  //one of the type of Grant Type
        formParams.put("scope", "trust");

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

    private static Response getoAuthToken_with_PasswordCrendetials_GrantType(){
        HashMap<String, String> formParams = new HashMap<>();
        formParams.put("client_id", "id");
        formParams.put("client_secret", "client_secret_value");
        formParams.put("grant_type", "password_credentials");  //one of the type of Grant Type
        formParams.put("username", "usernameDetail");
        formParams.put("password", "passwordDetail");
        formParams.put("scope", "trust");

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

/*
************************Practice Detail for oAUTH*****************************************
Authorization Server EndPoint:

https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token

HTTP Method : POST

Form parameters :
client_id: 692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com
client_secret:  erZOWM9g3UtwNRj340YYaK_W
grant_type:   client_credentials
scope:  trust

******************************************************************

GetCourseDetails EndPoint (Secured by OAuth) :

https://rahulshettyacademy.com/oauthapi/getCourseDetails
HTTP Method : GET
Query Parameter : access_token
 */
