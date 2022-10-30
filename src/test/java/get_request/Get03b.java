package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get03b {
    /*
        Given
            https://reqres.in/api/users/2
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response format should be "application/json"
        And
            "email" is "janet.weaver@reqres.in",
        And
            "first_name" is "Janet"
        And
            "last_name" is "Weaver"
        And
            "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void get03() {
        // 1. Set The Url.

        //  2. Set the Expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)

        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)

        //  4. Do Assertion (dogrulama yapmak)
        //  Response format should be "application/json"

        //  "email" is "janet.weaver@reqres.in",

        //  "first_name" is "Janet"

        //  "last_name" is "Weaver"

        //  "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"


    }
}
