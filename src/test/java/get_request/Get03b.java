package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.equalTo;

public class Get03b extends ReqresBaseUrl {
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
    public void test03() {
        // 1. Set The Url
        spec.pathParams("first","users","second","2");

        //  2. Set the Expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        //  HTTP Status Code should be 200
        //  Response format should be "application/json"
        //  "email" is "janet.weaver@reqres.in",
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email",equalTo("janet.weaver@reqres.in"),
                        "data.first_name",equalTo("Janet"),
                        "data.last_name",equalTo("Weaver"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));





        //  "first_name" is "Janet"

        //  "last_name" is "Weaver"

        //  "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"


    }
}
