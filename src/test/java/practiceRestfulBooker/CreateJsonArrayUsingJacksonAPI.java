package practiceRestfulBooker;


import java.util.Arrays;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.Test;

public class CreateJsonArrayUsingJacksonAPI {

    @Test
    public void CreateJsonArrayUsingJacksonAPI() throws JsonProcessingException {

        // Create Json Array
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray =  objectMapper.createArrayNode();

        //Create First JSON
        ObjectNode firstBookingDetails = objectMapper.createObjectNode();

        firstBookingDetails.put("firstname", "Jim");
        firstBookingDetails.put("lastname", "Brown");
        firstBookingDetails.put("totalprice", 111);
        firstBookingDetails.put("depositpaid", true);
        firstBookingDetails.put("additionalneeds", "Breakfast");

        ObjectNode firstBookingDateDetails = objectMapper.createObjectNode();
        firstBookingDateDetails.put("checkin", "2021-07-01");
        firstBookingDateDetails.put("checkout", "2021-07-01");

        firstBookingDetails.set("bookingdates", firstBookingDateDetails);

        //Create Second Json
        ObjectNode secondBookingDetails = objectMapper.createObjectNode();

        secondBookingDetails.put("firstname", "Amod");
        secondBookingDetails.put("lastname", "Mahajan");
        secondBookingDetails.put("totalprice", 222);
        secondBookingDetails.put("depositpaid", true);
        secondBookingDetails.put("additionalneeds", "Breakfast");

        ObjectNode secondBookingDateDetails = objectMapper.createObjectNode();
        secondBookingDateDetails.put("checkin", "2022-07-01");
        secondBookingDateDetails.put("checkout", "2022-07-01");

        secondBookingDetails.set("bookingdates", secondBookingDateDetails);

        //Add jsonObjects to array one by one
        jsonArray.add(firstBookingDateDetails);
        jsonArray.add(secondBookingDateDetails);

        //Add jsonObjects to array in one shot
        jsonArray.addAll(Arrays.asList(firstBookingDateDetails,secondBookingDateDetails));

        String jsonArrayAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
        System.out.println("Created Json Array is : " + jsonArrayAsString);

        //retrive Json Array particular node
        JsonNode firstjson = jsonArray.get(0);
        String firstjsonstr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(firstjson);
        System.out.println("firstjsonstr is " +firstjsonstr);

        //iterate Json Array
        Iterator iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JsonNode currentJsonNode = (JsonNode) iterator.next();
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currentJsonNode));
        }

        // To get size of JSON array
        int sizeOfArray = jsonArray.size();
        System.out.println("Size of array is "+sizeOfArray);

        // To remove an element from array
        jsonArray.remove(0);
        System.out.println("After removing first element from array : "+ objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));

        // To empty JSON Array
        jsonArray.removeAll();
        System.out.println("After removing all elements from array : "+ objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));
    }
}
