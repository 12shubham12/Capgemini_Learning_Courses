package testcases.API;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Handling_complex_Responses {

/*
* Note: Here we have created dummy response directly as we do not have the
* real API for testing complex scenario
* Also we have used JsonPath to perform response parsing*/

    SoftAssert softassert = new SoftAssert();
    @Test
    public void assertResponses() throws IOException {
        String jsonResponse = new String(Files.readAllBytes(Paths.get("./src/main/java/Responses/complexAPI_Response.json")));
        JsonPath js = new JsonPath(jsonResponse);

        //Validate number of courses
        int course_count = js.getInt("courses.size()");
        softassert.assertEquals(course_count, 3);
        System.out.println(course_count);

        //Validate purchased Amount
        int purchasedAmount = js.getInt("dashboard.purchaseAmount");
        softassert.assertEquals(purchasedAmount, 910);
        System.out.println(purchasedAmount);

        //Print title of hte first course
        String firstTitle = js.getString("courses[0].title");
        System.out.println(firstTitle);

        //Print title of hte first course
        String thirdTitle = js.getString("courses[2].title");
        System.out.println(thirdTitle);

        //Print all course titles and their respective prices
        HashMap<String, Object> hm = new HashMap<>();
        for(int i=0; i<js.getInt("courses.size()");i++){
            hm.put(js.getString("courses["+i+"].title"), js.getInt("courses["+i+"].price"));
        }
        System.out.println(hm);

        //Print number of copies sold by RPA course
        for(int i=0;i<js.getInt("courses.size()");i++){
            if(js.getString("courses["+i+"].title").equals("RPA")){
                System.out.println("Number of copies sold by RPA: "+js.getInt("courses["+i+"].copies"));
                break;
            }
        }

        //Verify if all course prices matches with the purchaseAmount
        int courses_Amt_sum = 0;

        for(int i=0;i<js.getInt("courses.size()");i++){
            courses_Amt_sum+=js.getInt("courses["+i+"].copies")*js.getInt("courses["+i+"].price");
        }
        softassert.assertEquals(courses_Amt_sum, purchasedAmount);
        System.out.println("Sum of Courses Amount is: "+courses_Amt_sum);
        System.out.println("Total sum is: "+purchasedAmount);
    }

}
