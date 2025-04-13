/*
Refer class: Handling_TokenGeneration before this
 */

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
                oauth2("token"). //or we can pass the method name that will return String token
                header("", ""). //other header values if needed
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
