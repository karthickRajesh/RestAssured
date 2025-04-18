package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PartialUpdateBookingPATCHAPI {

    @Test
    public static void partialUpdateBooking(){

        String requestJson = "{\n" +
                "    \"firstname\" : \"KK\",\n" +
                "    \"lastname\" : \"RR\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token","9965c54368e05c2");
        requestSpecification.body(requestJson);

        Response response = requestSpecification.patch("/booking/1");
        System.out.println(response.asString());

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("KK"));
        validatableResponse.body("lastname",Matchers.equalTo("RR"));

    }
}
