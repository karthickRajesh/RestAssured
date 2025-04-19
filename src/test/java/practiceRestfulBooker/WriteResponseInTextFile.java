package practiceRestfulBooker;

import com.google.common.io.Files;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class WriteResponseInTextFile {

    @Test
    public static void writeResponseInTextFile()throws IOException {

        String jsonString = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/auth");
        requestSpecification.body(jsonString);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.post();

        System.out.println(response.asString());

        // Converting in to byte array before writing
        String responseAsString = response.asString();
        byte[] responseAsByteArrayFromString = responseAsString.getBytes();
        File targetFileForByteArrayFromString = new File("src/test/resources/targetFileForByteArrayFromString.json");
        Files.write(responseAsByteArrayFromString, targetFileForByteArrayFromString);

        // Getting response as input stream and writing in to a file
        InputStream responseAsInputStream = response.asInputStream();
        byte[] responseAsInputStreamByte = new byte[responseAsInputStream.available()];
        responseAsInputStream.read(responseAsInputStreamByte);
        File targetFileForResponseAsInputStream = new File("src/test/resources/targetFileForResponseAsInputStream.json");
        Files.write(responseAsInputStreamByte,targetFileForResponseAsInputStream);

        // Directly getting a byte array
        byte[] responseAsByteArray = response.asByteArray();
        File targetFileForResponseAsByteArray = new File("src/test/resources/targetFileForResponseAsByteArray.json");
        Files.write(responseAsByteArray,targetFileForResponseAsByteArray);

    }
}
