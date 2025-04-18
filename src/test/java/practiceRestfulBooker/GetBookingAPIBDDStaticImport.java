package practiceRestfulBooker;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetBookingAPIBDDStaticImport {

    @Test
    public static void getBookingsAPI() {

                    given()
                        .baseUri("https://restful-booker.herokuapp.com")
                    .when()
                        .get("/booking")
                    .then()
                        .statusCode(200)
                        .statusLine("HTTP/1.1 200 OK");

    }
}
