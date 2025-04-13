package testcases.API;

//For this can create a common class which will have method(say returnInputJson_CreateStudent) that will return input json
//But for understanding purpose we are keeping everything at single place

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Handling_DynamicReqJson {

    public int student_id = 0;
    public String returnInputJson_CreateStudent(String fname, String lname, String nation, String zip){

        String request_createStudent = "{\n" +
                "  \"firstName\": \""+fname+"\",\n" +  //create variable fname
                "  \"lastName\": \""+lname+"\",\n" +    // created variable lname
                "  \"country\": \""+nation+"\",\n" +    //created variable nation
                "  \"postalCode\": \""+zip+"\"\n" +     //created variable zip
                "}";
        return request_createStudent;
    }

    @Test
    public void create_Student_with_variable() throws IOException {
        Response response = RestAssured.given()
                //.header(" ", " ")
                .contentType(ContentType.JSON)
                .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                .body(returnInputJson_CreateStudent("Ashish", "Saraf", "India", "401011"))
                .when()
                .post("/Students")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

        student_id= response.jsonPath().getInt("id");
    }

    @Test
    public void get_Student() throws IOException {
        Response response = RestAssured.given()
                //.header(" ", " ")
                .contentType(ContentType.JSON)
                .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                .queryParam("id", student_id)
                .when()
                .get("/Students")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.jsonPath().getString("firstName"));
    }

    //Write the code to delete the data as it is the best way.
}
