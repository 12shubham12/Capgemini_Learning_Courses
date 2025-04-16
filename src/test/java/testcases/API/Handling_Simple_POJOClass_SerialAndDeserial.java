package testcases.API;

//Serialization means converting the Java Object(POJO/MAP) to JSON or XML
//Deserializations is vice-versa of serialization
//Library use to do this is Jackson/Jackson2/Gson and lombok
//This process of Serialization and Deserialization is called Object Mapping

//We need to create the POJO class inside src/main/java/pojos package


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.CreateStudent_POJO;
import java.io.IOException;

//This is serialization example
public class Handling_Simple_POJOClass_SerialAndDeserial{

    /*Below code we can put inside a Payloads class(this class will have all the methods to
    read or json create payload and this class we can put inside src/main/java/payloads package
    */

    public static CreateStudent_POJO getCreateStudentPayloadFromPojo(){
        return CreateStudent_POJO
                .builder()
                .firstName("Pankaj")
                .lastName("Kapoor")
                .country("India")
                .postalCode("499999")
                .build();
    }

    @Test
    public void create_Student_POST() throws IOException {
        Response response = RestAssured.given()
                //.header(" ", " ")
                .contentType(ContentType.JSON)
                .baseUri("https://67f7445642d6c71cca648461.mockapi.io")
                .body(getCreateStudentPayloadFromPojo())
                .log().all()
                .when()
                .post("/Students")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

        //De-serialization using POJO and lombok
        CreateStudent_POJO createStudentPojo = response.getBody().as(CreateStudent_POJO.class);
        System.out.println("********************************");
        System.out.println(createStudentPojo.getFirstName());
        System.out.println(createStudentPojo.getPostalCode());
    }
}
