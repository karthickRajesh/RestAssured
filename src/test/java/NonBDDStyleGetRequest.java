import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class NonBDDStyleGetRequest {

    public static void main(String[] args) {

        RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";

        RequestSpecification request = RestAssured.given();

        Response response = request.get();
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200,"Passed");

    }
}
