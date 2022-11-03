package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get11 extends GoRestBaseUrl {

    /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            Pres. Amarnath Dhawan, Sujata Chaturvedi and Navin Panicker are among the users
        And
            The female users are less than or equals to male users
    */

    @Test
    public void get11(){
        //  1. Set The Url
        spec.pathParam("first","users");

        //  2. Set the Expected Data ==> Payload (beklenen datanin olusturulmasi, Post, Put, Patch)


        //  3. Send The Request And Get The Response ( Talep gondermek icin kod yazimi)
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //  4. Do Assertion (dogrulama yapmak)
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Pres. Amarnath Dhawan", "Sujata Chaturvedi", "Navin Panicker"));
        //  AKdın ve erkek sayılarını karşılaştıralım.
        //  1. Yol:
        List<String> genders = response.jsonPath().getList("data.gender");
        System.out.println(genders);
        System.out.println();

        int numOfFemale = 0;
        for (String w : genders) {

            if (w.equalsIgnoreCase("female")){
                numOfFemale++;
            }

        }

        assertTrue(numOfFemale<=genders.size()-numOfFemale);

        //  2. Yol: KAdın ve erkek sayılarını Groovy ile bulalım.
        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println("femaleNames = " + femaleNames);
        List<String> maleNames = response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println("maleNames = " + maleNames);

        assertTrue(femaleNames.size()<= maleNames.size());

    }

}
