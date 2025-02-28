package SpecBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Serialization
{

    @Test(description = "test description")
    public void testName() {
        // hard coded body
        Serialize se = new Serialize();
        se.setName("Frontline");
        se.setAccuracy(60);
        se.setAddress("Kormangala 6th block ");
        se.setLanguage("English");
        se.setPhone_number("(+91) 983 893 3937");
        se.setWebsite("http://google.com");
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        se.setTypes(myList);
        Serialize.location loc = new Serialize.location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        se.setLocation(loc);


        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        ResponseSpecification res = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();

        Response response = given().spec(req)
                .body(se)
                .when().post("/maps/api/place/add/json")
                .then().spec(res).extract().response();
        System.out.println(response.jsonPath().prettyPrint());





    }
}
