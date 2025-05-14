package practiceRestfulBooker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map.Entry;

public class CreateJsonObjectUsingJacksonAPI {

    @Test
    public void CreatingNestedJsonObjectTest() throws JsonProcessingException {

        // Create an object to ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Creating Node that maps to JSON Object structures in JSON content
        ObjectNode bookingDetails = objectMapper.createObjectNode();

        bookingDetails.put("firstname","Karthick");
        bookingDetails.put("lastname", "Rajesh");
        bookingDetails.put("totalprice", 111);
        bookingDetails.put("depositpaid", true);
        bookingDetails.put("additionalneeds", "Breakfast");

        String createdPlainJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("Created plain JSON Object is "+ createdPlainJsonObject);

    //Adding Nested Json
        ObjectNode bookingDateDetails = objectMapper.createObjectNode();
        bookingDateDetails.put("checkin", "2021-07-01");
        bookingDateDetails.put("checkout", "2021-07-01");

        bookingDetails.set("bookingdates",bookingDateDetails);

        String createdNestedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("Created Nested JsonObject is "+createdNestedJsonObject);

    //retrive values

        String firstname = bookingDetails.get("firstname").asText();
        String lastname = bookingDetails.get("lastname").asText();
        int totalprice = bookingDetails.get("totalprice").asInt();
        boolean depositpaid = bookingDetails.get("depositpaid").asBoolean();
        String additionalneeds = bookingDetails.get("additionalneeds").asText();
        String checkin = bookingDetails.get("bookingdates").get("checkin").asText();
        String checkout = bookingDetails.get("bookingdates").get("checkout").asText();

        System.out.println("firstname is " + firstname);
        System.out.println("lastname is " + lastname);
        System.out.println("totalprice is " + totalprice);
        System.out.println("depositpaid is " + depositpaid);
        System.out.println("additionalneeds is " + additionalneeds);
        System.out.println("checkin is " + checkin);
        System.out.println("checkout is " + checkout);

        //retrive All Field names
        Iterator<String> allFieldNames = bookingDetails.fieldNames();
        while (allFieldNames.hasNext()){
            System.out.println(allFieldNames.next());
        }

        //retrive All Field Values
        Iterator<JsonNode> allFieldvalues = bookingDetails.elements();
        while (allFieldvalues.hasNext()){
            System.out.println(allFieldvalues.next());
        }

        // To get all key-value pair
        Iterator<Entry<String , JsonNode>> allFieldsAndValues =  bookingDetails.fields();
        while (allFieldsAndValues.hasNext()){
            Entry node = allFieldsAndValues.next();
            System.out.println(node.getValue());
        }

        //Remocing a Fie
        String removedField = bookingDetails.remove("firstname").asText();
        System.out.println("removedField" + removedField);

        String jsonObjectAfterRemoval = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("jsonObjectAfterRemoval" + jsonObjectAfterRemoval);

        // To replace a field value, use put() method for non ObjectNode type and replace() or set() for ObjectNode
        bookingDetails.put("firstname", "Amod");
        bookingDetails.set("bookingdates",bookingDateDetails);
        bookingDetails.replace("bookingdates",bookingDateDetails);
        String updatedJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("updatedJsonObject" + updatedJsonObject);

    }
}
