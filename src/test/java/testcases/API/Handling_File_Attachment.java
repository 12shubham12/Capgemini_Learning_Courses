package testcases.API;

/*
* This can be understood from a simple example of using Rest Assured to create a Jira Bug
* and then send the attachment like screenshot or doc file to the created Jira as part of
* formParam

* We will be actually doing bug creation and file attachment to Jira tool through Rest Assured

* Flow : Create a Bug using POST Request and from response body get the Id,
* and then pass that ID to another POST Request for file upload
*/

/*
Pre-Requisite Steps
1. Generate Authentication Token(we will use Basic Auth or Bearer token)
- Go to URL: https://developer.atlassian.com/cloud/jira/platform/rest/v3/intro/#authentication
- Scroll down and look for URL: Basic auth for REST APIs(https://developer.atlassian.com/cloud/jira/platform/basic-auth-for-rest-apis/)
- Follow the Steps 1,2 and 3
After step3: I have below token
c2h1cmFqOTNAZ21haWwuY29tOkFUQVRUM3hGZkdGMEVFS0hFb1VtYjgwMEc5WTg4RGNGaUJydXZhbE5OU1BTY2VSZjJyUGJyN09Yb1JzR0JOSzR1X1EyXzFGdF9lUVJyYWI1UTNEblU0dEpSMUJuUjlmUU93OEhOODAydEhXRFhTd1RvQVdrSFJKN1Jla3Fmd2hjT0lraVR4R0d0dmRZS0tpYkJFSlI5YU1QdlNYTVUxVk15a1NfQ3EzT0RTcjN2NHp3WldUaWp5MD04RkI2QTY5MQ==
request url inside post() method come from url "https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-issues/#api-rest-api-3-issue-bulk-post"*/

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class Handling_File_Attachment {

    /*Note here we are directly passing the request body, but we know this can be done in
    multiple ways(refer Handling_RequestInputJson class) */
    String create_bug_Req = "{\n" +
            "    \"fields\": {\n" +
            "       \"project\":\n" +
            "       {\n" +
            "          \"key\": \"SCRUM\"\n" + //Scrum we got from Jira toll -> Go to getting of project
            "       },\n" +
            "       \"summary\": \"Another Server is down\",\n" +
            "       \"issuetype\": {\n" +
            "          \"name\": \"Bug\"\n" +
            "       }\n" +
            "   }\n" +
            "}";

    int bug_id;
    @Test
    public void create_Bug(){
        Response response = RestAssured.given()
                .header("Authorization", "Basic c2h1cmFqOTNAZ21haWwuY29tOkFUQVRUM3hGZkdGMEVFS0hFb1VtYjgwMEc5WTg4RGNGaUJydXZhbE5OU1BTY2VSZjJyUGJyN09Yb1JzR0JOSzR1X1EyXzFGdF9lUVJyYWI1UTNEblU0dEpSMUJuUjlmUU93OEhOODAydEhXRFhTd1RvQVdrSFJKN1Jla3Fmd2hjT0lraVR4R0d0dmRZS0tpYkJFSlI5YU1QdlNYTVUxVk15a1NfQ3EzT0RTcjN2NHp3WldUaWp5MD04RkI2QTY5MQ==")
                .contentType(ContentType.JSON)
                .baseUri("https://shuraj93.atlassian.net")
                .body(create_bug_Req)
                .log().all()
                .when()
                .post("/rest/api/3/issue")
                .then()
                .log().all()
                .assertThat()
                .log().all()
                .statusCode(201)
                .extract()
                .response();

        bug_id = response.jsonPath().getInt("id");
    }

    //Script for add attachment to the Bug created
    //We need to pass additional header as per Jira documentation (check URL: https://developer.atlassian.com/cloud/jira/platform/rest/v3/api-group-issue-attachments/#api-rest-api-3-issue-issueidorkey-attachments-post)
    @Test(dependsOnMethods = {"create_Bug"})
    public void add_attachment(){
        Response response = RestAssured.given()
                .header("Authorization", "Basic c2h1cmFqOTNAZ21haWwuY29tOkFUQVRUM3hGZkdGMEVFS0hFb1VtYjgwMEc5WTg4RGNGaUJydXZhbE5OU1BTY2VSZjJyUGJyN09Yb1JzR0JOSzR1X1EyXzFGdF9lUVJyYWI1UTNEblU0dEpSMUJuUjlmUU93OEhOODAydEhXRFhTd1RvQVdrSFJKN1Jla3Fmd2hjT0lraVR4R0d0dmRZS0tpYkJFSlI5YU1QdlNYTVUxVk15a1NfQ3EzT0RTcjN2NHp3WldUaWp5MD04RkI2QTY5MQ==")
                .header("X-Atlassian-Token", "no-check")
                .contentType(ContentType.MULTIPART) //we need to send Multipart as content type
                .baseUri("https://shuraj93.atlassian.net")
                .multiPart("file", new File("./Screenshots/POT.docx")) //we can attach ant file txt, jpg, png, docx, pdf etc (depending what API accepts)
                .pathParam("issueIdOrKey", bug_id)
                .when()
                .post("/rest/api/3/issue/{issueIdOrKey}/attachments")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }
}
