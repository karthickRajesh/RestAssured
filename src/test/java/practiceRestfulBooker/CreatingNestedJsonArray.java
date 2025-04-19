package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatingNestedJsonArray {

@Test
        public void passBodyAsMap(){
        Map bookingOne = new HashMap();
        bookingOne.put("firstname", "Amod");
        bookingOne.put("lastname", "Mahajan");
        bookingOne.put("totalprice", 222);
        bookingOne.put("depositpaid", true);

        Map bookingDatesMapForAmod = new HashMap<>();
        bookingDatesMapForAmod.put("checkin", "2021-08-01");
        bookingDatesMapForAmod.put("checkout", "2021-08-02");

        bookingOne.put("bookingdates", bookingDatesMapForAmod);
        bookingOne.put("additionalneeds", "Breakfast");

        // JSON Object for second guest
        Map bookingTwo = new HashMap();
        bookingTwo.put("firstname", "Animesh");
        bookingTwo.put("lastname", "Prashant");
        bookingTwo.put("totalprice", 111);
        bookingTwo.put("depositpaid", true);

        Map bookingDatesMapForAnimesh = new HashMap<>();
        bookingDatesMapForAnimesh.put("checkin", "2021-07-01");
        bookingDatesMapForAnimesh.put("checkout", "2021-07-01");

        bookingTwo.put("bookingdates", bookingDatesMapForAnimesh);
        bookingTwo.put("additionalneeds", "Breakfast");

        // Creating JSON array to add both JSON objects
        List<Map> jsonArrayPayload = new ArrayList<>();

        jsonArrayPayload.add(bookingOne);
        jsonArrayPayload.add(bookingTwo);

        //Given
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON)
                .body(jsonArrayPayload).log().all()

        //When
        .when().post()

        //then
                .then().assertThat().statusCode(200).log().all();

    }
}
