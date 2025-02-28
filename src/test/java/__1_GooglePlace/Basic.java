package __1_GooglePlace;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

;


public class Basic
{
    public static void main(String[] args)
//    {
//        //given= all input details
//        // when = submit the API  : resource and endpoint
//        //then = validate the API
////        RestAssured.baseURI="https://rahulshettyacademy.com/";
////        given().queryParam("key","qaclick123").header("Content-Type","application/json")
////                .body(GooglePlace.AddPlace.payLoad())
////                .when().post("maps/api/place/add/json")
////                .then().log().all().assertThat().statusCode(200);
//           //                .header("User-Agent","PostmanRuntime/7.36.0");
//         // Add place >update place with new address > Get place to validate new address is present in the Response
////        String payload = GooglePlace.AddPlace.payLoad();
////        System.out.println("{\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"location\\\\\\\": {\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"    \\\\\\\"lat\\\\\\\": -38.383494,\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"    \\\\\\\"lng\\\\\\\": 33.427362\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  },\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"accuracy\\\\\\\": 50,\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"name\\\\\\\": \\\\\\\"Frontline house\\\\\\\",\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"phone_number\\\\\\\": \\\\\\\"(+91) 983 893 3937\\\\\\\",\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"address\\\\\\\": \\\\\\\"29, side layout, cohen 09\\\\\\\",\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"types\\\\\\\": [\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"    \\\\\\\"shoe park\\\\\\\",\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"    \\\\\\\"shop\\\\\\\"\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  ],\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"website\\\\\\\": \\\\\\\"http://google.com\\\\\\\",\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"  \\\\\\\"language\\\\\\\": \\\\\\\"French-IN\\\\\\\"\\\\n\\\" +\\n\" +\n" +
////                "                \"                        \\\"}\\\"" + payload);
//
////        Response response = given()
////                .baseUri("https://rahulshettyacademy.com")
////                .queryParam("key", "qaclick123")
////                .header("Content-Type", "application/json")
////                .body(GooglePlace.AddPlace.payLoad())
////                .when()
////                .post("/maps/api/place/add/json")
////                .then()
////                .log().all()
////                .assertThat().statusCode(200)
////                .extract().response();
//
//
////        Response response = given()
////                .baseUri("https://rahulshettyacademy.com")
////                .queryParam("key", "qaclick123")
////                .header("Content-Type", "application/json")
////                .body(GooglePlace.AddPlace.payLoad())
////                .when()
////                .post("/maps/api/place/add/json")
////                .then()
////                .log().all()
////                .assertThat().statusCode(200)
////                .extract().response();
////
////        System.out.println("Response Status Code: " + response.getStatusCode());
////        System.out.println("Response Body: " + response.asString());
//
//
//
//
////
////        System.out.println("Response Status Code: " + response.getStatusCode());
////        System.out.println("Response Body: " + response.asString());
//
//        baseURI="https://rahulshettyacademy.com";
//        String response= given().queryParam("key","qaclick123").header("Content-Type","application/json")
//                .body(GooglePlace.AddPlace.payLoad())
//                .when().post("maps/api/place/add/json")
//                .then().log().all().assertThat().statusCode(200).extract().response().asString();
//        System.out.println(response);
//    }

    {

// TODO Auto-generated method stub

                RestAssured.useRelaxedHTTPSValidation();



                RestAssured.baseURI = "https://rahulshettyacademy.com/";

                String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")

                        .body(AddPlace.payLoad()).when().post("/maps/api/place/add/json").then().log().all().statusCode(200)

                        .body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)").extract().response()

                        .asString();
                System.out.println(response);



                JsonPath js = new JsonPath(response);

                String placeId = js.getString("place_id");



                System.out.println(placeId);



                given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")

                        .body("{\r\n" + "    \"place_id\": \"" + placeId + "\",\r\n"

                                + "    \"address\": \"78 Summer walk, USA\",\r\n" + "    \"key\": \"qaclick123\"\r\n" + "}")

                        .when().put("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)

                        .body("msg", equalTo("Address successfully updated"));



            }







}
