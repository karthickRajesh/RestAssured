package practiceRestfulBooker;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetBookingAPIBDD {

    @Test
    public static void getBookingsAPI() {

        RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                    .when()
                        .get("/booking")
                    .then()
                        .statusCode(200)
                        .statusLine("HTTP/1.1 200 OK");
//                        .body("bookingid", Matchers.hasSize(10))
//                        .body("bookingid[3]",Matchers.equalTo(1));

    }


}
