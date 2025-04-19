package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DefaultRequestSpecificationExample {

    RequestSpecification defaultrequestSpecification;
    @BeforeClass
    public void setupDefaultRequestSpecification(){
        defaultrequestSpecification = RestAssured.given();
        defaultrequestSpecification.baseUri("https://restful-booker.herokuapp.com");
        defaultrequestSpecification.basePath("/booking");
        RestAssured.requestSpecification = defaultrequestSpecification;
    }

    @Test
    public void useDefaultRequestSpecification(){
        Response response = RestAssured.get();
        System.out.println("Response for default: "+response.asString());
    }

    @Test
    public void overrideDefaultRequestSpecification(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/ping");
        Response response = requestSpecification.get();
        System.out.println("Response for Overide: "+response.asString());

    }
}
