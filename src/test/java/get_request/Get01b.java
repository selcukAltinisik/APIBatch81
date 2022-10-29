package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01b {

    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
    */

    @Test
    public void get01() {
        //  i)  Set the URL,
        String url = "ttps://reqres.in/api/users/3"
        Response response = given().when().get(url);
        response.prettyPrint();

        //  ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        //  iii) Type code to send request ( Talep gondermek icin kod yazimi)
        //  iv) Do Assertion (dogrulama yapmak)


    }
}
