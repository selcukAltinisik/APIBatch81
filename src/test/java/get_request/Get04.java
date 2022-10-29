package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.*;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get04 extends JsonplaceholderBaseUrl {

    /*
    Given   https://jsonplaceholder.typicode.com/todos                          https://jsonplaceholder.typicode.com/todos
    When    I send a GET request to the Url                                     URL'ye bir GET isteği gönderiyorum
    And     Accept type is "application/json"                                   Kabul türü "application/json"
    Then    HTTP Status Code should be 200                                      HTTP Durum Kodu 200 olmalıdır
    And     Response format should be "application/json"                        Yanıt formatı "application/json" olmalıdır
    And     There should be 200 todos                                           200 todos olmalı
    And     "quis eius est sint explicabo" should be one of the todos title     "quis eius est sint explicabo" yapılacaklar başlığından biri olmalı
    And     2, 7, and 9 should be among the userIds                              2, 7 ve 9 kullanıcı kimlikleri arasında olmalıdır
    */

    @Test
    public void get01() {

        //  1)  Set the Url

        spec.pathParam("first","todos");

        //  2)  Set The Expected  Data (Put, Patch, Post)

        //  3)  Send the request and Get Response
        Response response = given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
        response.prettyPrint();

        //  4)  Do Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", hasSize(200),
                        "title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));



    }
}
