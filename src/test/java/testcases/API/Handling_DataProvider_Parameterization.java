package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Handling_DataProvider_Parameterization {

    @DataProvider(name="student_data")
    public Object[][] getData(){
        return new Object[][] {
                {"Kishor","Ingle","India"},{"Akshay","Rathi","India"},{"Amit","Jha","India"},{"Nikhil","Nag","India"}
        };
    }

    //Json Input
    public String returnInputJson_CreateStudent(String fname, String lname, String nation){

        String request_createStudent = "{\n" +
                "  \"firstName\": \""+fname+"\",\n" +  //create variable fname
                "  \"lastName\": \""+lname+"\",\n" +    // created variable lname
                "  \"country\": \""+nation+"\",\n" +
                "  \"postalCode\": \"401010\"\n" +
                "}";
        return request_createStudent;
    }

    List<Integer> ll = new ArrayList<>(); //storing the id from the responses
    @Test(dataProvider = "student_data")
    public void create_Student_with_variable(String fname, String lname, String nation) throws IOException {
        Response response = RestAssured.given()
                //.header(" ", " ")
                .contentType(ContentType.JSON)
                .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                .body(returnInputJson_CreateStudent(fname, lname, nation))
                .when()
                .post("/Students")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

        ll.add(response.jsonPath().getInt("id"));
    }
}
