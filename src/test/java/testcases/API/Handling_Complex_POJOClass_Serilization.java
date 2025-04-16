package testcases.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.testng.annotations.Test;
import pojos.AddStore_Complex_POJO;
import pojos.Category;
import pojos.CreateStudent_POJO;
import pojos.Tag;

import java.io.IOException;
import java.util.List;

public class Handling_Complex_POJOClass_Serilization {

    /*Below code we can put inside a Payloads class(this class will have all the methods to
    read or json create payload and this class we can put inside src/main/java/payloads package
    */

    public static AddStore_Complex_POJO getReq_payload_pojo() {
        return AddStore_Complex_POJO.builder()
                .id(10)
                .name("Shubham")
                .status("available")
                .category(Category.builder().id(11).name("Raj").build())
                .photoUrls(List.of("URLS"))
                .tags(List.of(Tag.builder().id(12).name("hi").build()))
                .build();
    }

    @Test
    public void create_data_POST() throws IOException {
        Response response = RestAssured.given()
                //.header(" ", " ")
                .contentType(ContentType.JSON)
                .baseUri("https://petstore.swagger.io")
                .body(getReq_payload_pojo())
                .log().all()
                .when()
                .post("/pet/addPet")
                .then()
                .log().all()
                .assertThat()
                .statusCode(201)
                .extract()
                .response();

    }
}
