package testcases.API;

//Here we will be creating a student and using student Id we will update the country and
//using Get we will validate if Country is coming correct for the update student

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class Handling_E2E_POST_PUT_GET {

    public int student_id;

    @Test(priority = 1)
    public void create_Student_POST() throws IOException {
        String reqBody = new String(Files.readAllBytes(Paths.get("./src/main/java/Resources/JsonSchemaFiles/createStudent.json")));
        Response response = RestAssured.given()
                    //.header(" ", " ")
                    .contentType(ContentType.JSON)
                    .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                    .body(reqBody)
                .when()
                    .post("/Students")
                .then()
                    .log().all()
                    .assertThat()
                    .statusCode(201)
                    .extract()
                    .response();

        student_id = response.jsonPath().getInt("id");
        System.out.println("ID of new created student is: "+student_id);
    }

    @Test(priority = 2)
    public void update_Student_PUT() throws IOException {
        String reqBody = new String(Files.readAllBytes(Paths.get("./src/main/java/Resources/JsonSchemaFiles/req_updateStudent_PUT.json")));
        Response response = RestAssured.given()
                //.header(" ", " ")
                .contentType(ContentType.JSON)
                .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                .pathParam("id", student_id)
                .body(reqBody)
                .log().all()
                .when()
                .put("/Students/{id}")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test(priority = 3)
    public void get_Student_GET() throws IOException {
        String reqBody = new String(Files.readAllBytes(Paths.get("./src/main/java/Resources/JsonSchemaFiles/req_updateStudent_PUT.json")));
        Response response = RestAssured.given()
                //.header(" ", " ")
                .contentType(ContentType.JSON)
                .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                .queryParam("id", student_id)
                .log().all()
                .when()
                .get("/Students")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String country = response.jsonPath().getString("country");
        assertEquals(country, "[India]");

    }

}
