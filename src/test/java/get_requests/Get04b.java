package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get04b extends RestfulBaseUrl {

    /*

    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

    */

    @Test
    public void get04() {
        // 1. Set The Url
        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");

        //  2. Set the Expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        //  Status code is 200
        //  Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"
        assertEquals(200,response.statusCode());
        assertFalse(response.asString().contains("bookingid"));

    }
}
