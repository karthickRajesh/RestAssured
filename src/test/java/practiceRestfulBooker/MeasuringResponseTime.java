package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

public class MeasuringResponseTime {

    public static void main(String[] args) {

        String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
        RequestSpecification requestSpecification = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON).body(jsonString);

        Response response = requestSpecification.post();

        System.out.println("Time taken in milliseconds :" + response.time());
        System.out.println("Time taken in Seconds :" + response.timeIn(TimeUnit.SECONDS));

        System.out.println("Time taken in milliseconds :" + response.getTime());
        System.out.println("Time taken in Seconds :" + response.getTimeIn(TimeUnit.SECONDS));

        ValidatableResponse validatableResponse = response.then();
        validatableResponse.time(Matchers.lessThan(2000l));
//        validatableResponse.time(Matchers.greaterThan(2000l));
        validatableResponse.time(Matchers.both(Matchers.lessThanOrEqualTo(2000l)).and(Matchers.greaterThanOrEqualTo(1000l)));

        validatableResponse.time(Matchers.lessThan(2l),TimeUnit.SECONDS);

    }
}
