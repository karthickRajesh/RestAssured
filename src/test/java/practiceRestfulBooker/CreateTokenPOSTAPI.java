package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateTokenPOSTAPI {

    @Test
    public static void createToken(){

        String jsonRequest = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonRequest);

        Response response = requestSpecification.post("/auth");

        System.out.println("Token is " + response.getBody().asString());
        System.out.println("Token is " + response.asString());

        ValidatableResponse validatableResponse = response.then();

        validatableResponse.statusCode(200).toString();
        validatableResponse.body("token", Matchers.notNullValue());
//        validatableResponse.body("token.lenght()",Matchers.is(15));
        validatableResponse.body("token", Matchers.matchesRegex("^[a-z0-9]+$"));


    }
}
