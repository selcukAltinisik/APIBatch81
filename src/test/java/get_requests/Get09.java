package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends RestfulBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
    {
    "firstname": "Howard",
    "lastname": "Liu",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
        },
    "additionalneeds": "Breakfast"
    }
    */

    @Test
    public void get09() {

        //  1. Set The Url
        spec.pathParams("first","booking","second",91);

        //  2. Set the Expected Data ==> Payload (beklenen datanin olusturulmasi, Post, Put, Patch)
        Map<String,String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstname","Howard");
        expectedData.put("lastname","Liu");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingDatesMap);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println(expectedData);


        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        Map<String,Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));    //  Key-Value ikilileri String-Object
        // şeklinde olduğundan, Bookingdata value kısmını casting ile Map yaptık.
        assertEquals(bookingDatesMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        assertEquals(expectedData.get("additionalNeeds"),actualData.get("additionalNeeds"));


        //  Status code is 200


    }

}
