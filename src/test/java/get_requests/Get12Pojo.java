package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12Pojo extends RestfulBaseUrl {

    /*
     Given
         https://restful-booker.herokuapp.com/booking/19
        When
            I send GET Request to the URL
        Then
            Status code is 200
        And
            Response body is like:
                 {
                 "firstname": "Jim",
                 "lastname": "ozan",
                 "totalprice": 111,
                 "depositpaid": true,
                 "bookingdates": {
                                  "checkin": "2022-01-01",
                                  "checkout": "2022-01-01"
                                 },
                 "additionalneeds": "kahvaltı"
                 }
        */

    @Test
    public void get12Pojo() {
        //  1. Set The Url.
        spec.pathParams("first","booking","second",19);

        //  2. Set the Expected Data ==> Payload (beklenen datanin olusturulmasi, Post, Put, Patch)
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2022-01-01","2022-01-01");
        System.out.println(bookingDatesPojo.toString());

        BookingPojo expectedData = new BookingPojo("Jim","ozan",111,true,bookingDatesPojo,"kahvaltı");
        System.out.println("expectedData = " + expectedData);

        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());

        //  1. Yol:
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());

        //  2. Yol:
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());


    }
}
