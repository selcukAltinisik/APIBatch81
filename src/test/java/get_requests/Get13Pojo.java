package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            {
            "meta": null,
            "data": {
                      "id": 2508,
                      "name": "Gemini Adiga",
                      "email": "adiga_gemini@weissnat-maggio.org",
                      "gender": "female",
                      "status": "inactive"
                    }
            }
    */

    @Test
    public void get13() {
        //  1. Set The Url.
        spec.pathParams("first","users","second",2508);

        //  2. Set the Expected Data ==> Payload (beklenen datanin olusturulmasi, Post, Put, Patch)
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508,"Gemini Adiga","adiga_gemini@weissnat-maggio.org","female","inactive");

        GoRestPojo expectedData = new GoRestPojo(null,goRestDataPojo);

        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        GoRestPojo actualData = response.as(GoRestPojo.class);

        assertEquals(expectedData.getMeta(),actualData.getMeta());

        assertEquals(expectedData.getData().getId(),actualData.getData().getId());
        assertEquals(expectedData.getData().getName(),actualData.getData().getName());
        assertEquals(expectedData.getData().getEmail(),actualData.getData().getEmail());
        assertEquals(expectedData.getData().getGender(),actualData.getData().getGender());
        assertEquals(expectedData.getData().getStatus(),actualData.getData().getStatus());


    }
}
