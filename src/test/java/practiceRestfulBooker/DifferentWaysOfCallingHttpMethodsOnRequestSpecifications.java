package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifferentWaysOfCallingHttpMethodsOnRequestSpecifications {

    RequestSpecification requestSpecification ;

    @BeforeClass
    public void requestSpecificationcreation(){

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        System.out.println("requestSpecification");

    }

    // We can directly call http verbs on RequestSpecification
    @Test
    public void usingDirectHttpCall(){
        Response responseOnDirectCall = requestSpecification.get();
        System.out.println(responseOnDirectCall.asString());
    }

    // We can also pass RequestSpecification reference variable in overloaded given() method
    @Test
    public void usingOverloadCall(){
        Response responseOnOverloadCall = RestAssured.given(requestSpecification).get();
        System.out.println(responseOnOverloadCall.asString());
    }

    // We can also pass RequestSpecification using spec() method
    @Test
    public void usingSpecMethod(){
        Response responseOnSpecMethod = RestAssured.given().spec(requestSpecification).get();
        System.out.println(responseOnSpecMethod.asString());
    }
}
