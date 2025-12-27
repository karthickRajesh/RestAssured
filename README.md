# RestAssured

## Overview
This project is the outcome of my self-learning about the RestAssured using Java.  
It covers practical API automation examples using real-world REST APIs.

## Technologies will be Used
- Java
- Maven
- TestNG
- RestAssured

## Dependencies used
- io.rest-assured.rest-assured  
- org.testng.testng  
- io.rest-assured.json-schema-validator  
- com.fasterxml.jackson.core.jackson-databind  

## Practice Websites
- https://restful-booker.herokuapp.com/apidoc/index.html

## Test Cases Practiced

<details>
<summary><b>Restful Booker Cases Practiced</b></summary>

#### API CRUD Operations
- Create a POST Request and validate (`CreateTokenPOSTAPI.java`)
- Create a PUT Request and validate (`UpdateBookingPUTAPI.java`)
- Create a PATCH Request and validate (`PartialUpdateBookingPATCHAPI.java`)
- Create a GET Request and validate (`GetBookingsAPI.java`)
- Create a DELETE Request and validate (`DeleteBookingDELETEAPI.java`)

#### Request Body Creation
- Creating and Sending RequestBody as Map (`CreatingRequestBodyUsingMap.java`)
- Creating JSONObject using Jackson API (`CreateJsonObjectUsingJacksonAPI.java`)
- Creating JSONARRAY using Jackson API (`CreateJsonArrayUsingJacksonAPI.java`)

#### Serialization & Deserialization
- Serialization and Deserialization (`EmployeeSerializationDeserialization.java`)

#### File Handling
- Writing response in TextFile (`WriteResponseInTextFile.java`)
- Sending File as Payload (`SendFileAsPayload.java`)

</details>
