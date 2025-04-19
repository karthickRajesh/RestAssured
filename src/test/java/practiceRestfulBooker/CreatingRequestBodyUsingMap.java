package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.when;

public class CreatingRequestBodyUsingMap {

@Test
        public void passBodyAsMap(){
        Map authPayload = new HashMap();
        authPayload.put("username", "admin");
        authPayload.put("password", "password123");

        //Given
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/auth").contentType(ContentType.JSON)
                .body(authPayload).log().all()

        //When
        .when().post()

        //then
                .then().assertThat().statusCode(200).log().all();

    }
}
