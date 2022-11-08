package post_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03Pojo extends JsonplaceholderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
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
    public void post03Pojo() {
        //  1. Set The Url
            spec.pathParam("first","todos");

        //  2. Set the Expected Data ==> Payload (beklenen datanin olusturulmasi, Post, Put, Patch)
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        JsonPlaceHolderPojo actualData= response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());



    }

}
