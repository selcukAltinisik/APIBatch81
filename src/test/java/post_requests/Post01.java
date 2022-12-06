package post_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {

        /*
            Given
              1)  https://jsonplaceholder.typicode.com/todos
              2)  {
                    "userId": 55,
                    "title": "Tidy your room",
                    "completed": false
                   }
           When
            I send POST Request to the Url
           Then
               Status code is 201
           And
               response body is like {
                                       "userId": 55,
                                       "title": "Tidy your room",
                                       "completed": false,
                                       "id": 201
                                       }
        */

    @Test
    public void post01() {
        //  1. Set The Url
        spec.pathParam("first","todos");

        //  2. Set the Expected Data ==> Payload (beklenen datanin olusturulmasi, Post, Put, Patch)
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = obj.expectedDataMethod(55,"Tidy your room",false);

        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)...
        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));


    }
}
