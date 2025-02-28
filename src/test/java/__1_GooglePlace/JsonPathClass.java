package __1_GooglePlace;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;


public class JsonPathClass
{
    public static void main(String[] args)
    {
        RestAssured.baseURI="https://rahulshettyacademy.com";
       String response= given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                .body(AddPlace.payLoad()).when().post("maps/api/place/add/json")
                .then().extract().response().asString();
        System.out.println(response);




//       JsonPath json=new JsonPath(response);// for parsing JSOn
//         String place_id=json.getString("place_id");
//        System.out.println(place_id);


    }
}
