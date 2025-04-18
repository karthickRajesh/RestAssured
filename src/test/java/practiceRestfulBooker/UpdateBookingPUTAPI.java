package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class UpdateBookingPUTAPI {


    @Test
    public static void updateBooking(){

        String requestJson = "{\n" +
                "    \"firstname\" : \"Karthick\",\n" +
                "    \"lastname\" : \"Rajesh\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(requestJson);
        requestSpecification.cookie("token", "02ece6b3c55017a");
        Response response = requestSpecification.put("/booking/1");

        System.out.println(response.asString());

        ValidatableResponse validatableResponse = response.then();

        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Karthick"));
        validatableResponse.body("lastname", Matchers.equalTo("Rajesh"));

    }
}
