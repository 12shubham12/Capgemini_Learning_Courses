package testcases.API;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utility.ConfigDataProvider;
import utility.ConfigDataProvider_API;
import utility.Helper_API;

/*
We need to write common methods to Helper class for both Request and Response using
RequestSpecBuilder and ResponseSpecBuilder
 */
public class Handling_ReqSpec_ResSpec_Builder {

    ConfigDataProvider_API config_API = new ConfigDataProvider_API(); // preferable to write in BaseClass

    @Test
    public void create_Students() {
        Response response = RestAssured.given()
                .spec(Helper_API.requestSetup(config_API.readStringStudentALI_URL()))
                .body("")
                .log().all()
                //.pathParam(" ", " ")
                .when()
                .post("/Students")
                .then()
                .log().all()
                .assertThat()
                .spec(Helper_API.responseSetup(201))
                .extract()
                .response();
    }
}
