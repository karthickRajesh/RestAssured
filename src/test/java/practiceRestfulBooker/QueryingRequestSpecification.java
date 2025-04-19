package practiceRestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class QueryingRequestSpecification {

    public static void main(String[] args) {

        String jsonBody = "{\"firstName\":\"Amod\"}";

        RequestSpecification requestSpecification = RestAssured.with();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.body(jsonBody);
        requestSpecification.header("header1","headervalue1");
        requestSpecification.header("header2","headervalue2");

        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        String basePath = queryableRequestSpecification.getBasePath();
        System.out.println("basePath is " + basePath);

        String baseURI = queryableRequestSpecification.getBaseUri();
        System.out.println("baseURI is " + baseURI);

        String body = queryableRequestSpecification.getBody();
        System.out.println("body is " + body);

        Headers headers = queryableRequestSpecification.getHeaders();
        for (Header header : headers){
            System.out.println("Headers is "+ header);
        }

    }
}
