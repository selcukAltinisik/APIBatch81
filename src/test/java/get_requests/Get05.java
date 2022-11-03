package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get05 extends RestfulBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Javier" and lastname is "Combs"
    */

    @Test
    public void get01() {
        //  https://restful-booker.herokuapp.com/booking?firstname=Ali&lastname=Cengiz
        //  1)  Set the Url
        spec.pathParam("first","booking").queryParams("firstname","Javier","lastname","Combs");

        //  2)  Set The Expected  Data (Put, Patch, Post)

        //  3)  Send the request and Get Response
        Response response = given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
        response.prettyPrint();

        //  4)  Do Assertion
        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
