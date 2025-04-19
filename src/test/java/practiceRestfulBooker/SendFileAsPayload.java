package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class SendFileAsPayload {

    @Test
    public void sendJsonFileAsPayload(){

        File jsonFile = new File("src/test/resources/AuthPayload.json");

        ValidatableResponse response = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON).body(jsonFile).post().then();

        response.assertThat().statusCode(200).body("token", Matchers.notNullValue())
                .body("token.length()", Matchers.is(15));

    }
}
