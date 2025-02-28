package __1_GooglePlace;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class FirstTestAPICall
{

public static void main(String[] args) throws IOException {

  //given= all input details
//        // when = submit the API  : resource and endpoint
//        //then = validate the API
  // content of file to string -->  contecnt of can convert into Byte --> Byte data to String
//  RestAssured.baseURI = "https://rahulshettyacademy.com";
//  RestAssured.useRelaxedHTTPSValidation();
//
//Response output = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
//
//.body("{\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n" + "    \"lng\": 33.427362\n"
//
//+ "  },\n" + "  \"accuracy\": 50,\n" + "  \"name\": \"Frontline house\",\n"
//
//+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
//
//+ "  \"address\": \"29, side layout, cohen 09\",\n" + "  \"types\": [\n"
//
//+ "    \"shoe park\",\n" + "    \"shop\"\n" + "  ],\n"
//
//+ "  \"website\": \"http://google.com\",\n" + "  \"language\": \"French-IN\"\n" + "}\n" + "")
//
//.when().post("/maps/api/place/add/json").then().log().all().extract().response();
//  System.out.println(output.asString());
//  JsonPath js = new JsonPath(output.asString()); System.out.println(js.getString("place_id"));

//
  RestAssured.baseURI = "https://rahulshettyacademy.com";
  RestAssured.useRelaxedHTTPSValidation();

  Response response = given().log().all().queryParam("key", "qaclick123")
          .header("Content-Type", "application/json")
//          .body(Files.readAllBytes(Paths.get("")))  // we will get in byte format
          //  then  we need to do like this
          .body(new String(Files.readAllBytes(Paths.get(""))))
          .when().post("/maps/api/place/add/json").then().log().all().extract().response();
  System.out.println(response.asString());
  JsonPath js1 = new JsonPath(response.asString()); System.out.println(js1.getString("place_id"));

}



}

