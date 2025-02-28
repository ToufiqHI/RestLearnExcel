package __5_Pojo.PassingBody;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Serialization
{

    @Test(description = "test description")
    public void testName()
    {
        // hard coded body
        Serialize  se=new Serialize();
        se.setName("Frontline");
        se.setAccuracy(60);
        se.setAddress("Kormangala 6th block ");
        se.setLanguage("English");
        se.setPhone_number("(+91) 983 893 3937");
        se.setWebsite("http://google.com");
        List <String> myList=new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        se.setTypes(myList);
        Serialize.location   loc=new Serialize.location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        se.setLocation(loc);

        RestAssured.baseURI="https://rahulshettyacademy.com";
        Response response=given().log().all().queryParam("key","qaclick123")
                .header("Content-Type","application/json")
                .body(se)
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(HttpStatus.SC_OK).extract().response();
        System.out.println(response.jsonPath().prettyPrint());

//        given().queryParam("","")
//                .header("","")
//                .body("")
//                .when()
//                .post()
//                .then().extract().response().asString();

    }
}
