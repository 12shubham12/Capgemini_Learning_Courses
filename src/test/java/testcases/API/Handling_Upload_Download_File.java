package testcases.API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class Handling_Upload_Download_File {

    @Test
    public void test_uploadFile(){

        File file = new File("C:/Users/sraj8/OneDrive - Capgemini/Desktop/Interview Questions/multiPart_delete.txt");

        Response response = RestAssured.given().
                header("Authorization", "").
                //contentType is not need when using multiPart - Maybe
                //contentType(ContentType.JSON).
                baseUri("https://reqres.in").
                multiPart(file).
                log().headers().
                when().
                post("/api/users/").
                then().
                log().headers().
                extract().
                response();

        System.out.println(response.prettyPrint());
    }

    //Download file is lengthy and hence I skipped ir(Video 106
    // link https://capgemini.udemy.com/course/rest-assured-api-automation/learn/lecture/25232680#overview)
}
