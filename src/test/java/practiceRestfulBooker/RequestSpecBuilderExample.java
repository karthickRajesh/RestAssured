package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RequestSpecBuilderExample {

    RequestSpecification requestSpecification;
    @BeforeClass
    public void requestSpecBuildertrial(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://restful-booker.herokuapp.com");
        requestSpecBuilder.setBasePath("/booking");
        requestSpecification = requestSpecBuilder.build();
    }

    public void usingDirectCall(){
        Response responseOnDirectCall = requestSpecification.get();
        System.out.println(responseOnDirectCall.asString());
    }
    @Test
    public void usingOverrideCall(){
        Response responseOnOverrideCall = RestAssured.given(requestSpecification).get();
        System.out.println(responseOnOverrideCall.asString());
    }
    @Test
    public void usingSpecCall(){
        Response responseOnSpecCall = RestAssured.given().spec(requestSpecification).get();
        System.out.println(responseOnSpecCall.asString());
    }
}