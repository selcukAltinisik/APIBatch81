package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get08 extends JsonplaceholderBaseUrl {
    //De-Serialization: Json datayı Java objesine çevirme
    //Serialization: Java objesini Json formatına çevirme.
    //De-Serialization: Iki türlü yapacağız.
    //Gson: Google tarafından üretilmiştir.
    //Object Mapper: Daha popüler...

    /*
       Given
          https://jsonplaceholder.typicode.com/todos/2
      When
          I send GET Request to the URL
      Then
          Status code is 200
      And "completed" is false
      And "userId" is 1
      And "title" is "quis ut nam facilis et officia qui"
      And header "Via" is "1.1 vegur"
      And header "Server" is "cloudflare"
           {
          "userId": 1,
          "id": 2,
          "title": "quis ut nam facilis et officia qui",
          "completed": false
            }
        */

    @Test
    public void get08() {

        //  1. Set The Url
        spec.pathParams("first","todos","second",2);

        //  2. Set the Expected Data 00> Payload (beklenen datanin olusturulmasi, Post, Put, Patch)
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        System.out.println("expectedData = " + expectedData);

        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        Map<String, Object> actualData = response.as(HashMap.class);    //  De-Serialization
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        //  Status code is 200
        assertEquals(200,response.statusCode());

        //  "completed" is false

        //  "userId" is 1

        //  "title" is "quis ut nam facilis et officia qui"

        //  header "Via" is "1.1 vegur"
        assertEquals("1.1 vegur",response.header("Via"));

        //  header "Server" is "cloudflare"
        assertEquals("cloudflare",response.header("Server"));

        //   {
        //  "userId": 1,
        //  "id": 2,
        //  "title": "quis ut nam facilis et officia qui",
        //  "completed": false
        //    }

    }
}
