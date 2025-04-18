package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class deleteBookingDELETEAPI {

    @Test
    public static void deleteBooking(){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.cookie("token","e490108392912e5");

        Response response = requestSpecification.delete("/booking/277");
        System.out.println(response.asString());
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(201);

        RequestSpecification requestSpecification1 = RestAssured.given();
        requestSpecification1.baseUri("https://restful-booker.herokuapp.com/booking/277");

        ValidatableResponse validatableResponse1 = requestSpecification1.get().then();
        validatableResponse1.statusCode(404);


    }
}
