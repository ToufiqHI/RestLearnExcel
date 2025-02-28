package BDD.stepDefinition;

import BDD.Resources.APIResources;
import BDD.Resources.TestDataBuild;
import BDD.Resources.Utils;
import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class stepDefinition  extends Utils
{

    RequestSpecification req;
    ResponseSpecification resSpec;
    RequestSpecification res;
    Response response;
    JsonPath jsonPath;
    static String  place_id;
    TestDataBuild data = new TestDataBuild();


//    @Given("Add place payload")   we are passing data via feature file
    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload(String name, String languages, String address) throws Exception
    {
       req = requestSpecification();
        resSpec = new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK).build();
        res = given()
                .spec(req)
                .body(data.addPlacePayload(name,languages,address));

    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method)
    {
        APIResources resourceAPI = APIResources.valueOf(resource);
        if (method.equalsIgnoreCase("POST"))
        {
            response = res.when().post(resourceAPI.getResource());
        } else if (method.equalsIgnoreCase("GET"))
        {
            response = res.when().get(resourceAPI.getResource());
        }
        else if (method.equalsIgnoreCase("DELETE"))
        {
            response = res.when().delete(resourceAPI.getResource());
        }
        else if (method.equalsIgnoreCase("PUT"))
        {
            response = res.when().put(resourceAPI.getResource());
        }
//            response = res.when().post("/maps/api/place/add/json")  passing it through enum
//               response = res.when().post(resourceAPI.getResource())
//                    .then().spec(resSpec).extract().response();
        System.out.println( resourceAPI.getResource());
    }

    @Then("Response with success and status should be ok and status code should {int}")
    public void response_with_success_and_status_should_be_ok_and_status_code_should(Integer statusCode)
    {
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
    }

    @Then("{string} in Response body is {string}")
    public void in_Response_body_is(String keyValue, String expectedValue)
    {
        Assert.assertEquals(getJsonPath(response,keyValue),expectedValue);
    }


    @Then("Verify placeId created maps to {string} using {string}")
    public void verify_placeId_created_maps_to_using(String expectedName, String resource) throws Exception
    {
        place_id=getJsonPath(response,"place_id");
        res = given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_with_http_request(resource,"GET");
        String actualName=getJsonPath(response,"name");
        assertEquals(actualName,expectedName);

    }
    @Given("Delete place payload")
    public void delete_place_payload() throws Exception
    {
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));

    }


   // @When("user calls DeletePlaceAPI with post request")
//    public void user_calls_DeletePlaceAPI_with_post_request() throws Exception {
//        req = requestSpecification();
//
//        // Creating JSON body with place_id for deletion
//        String deletePayload = "{ \"place_id\": \"" + place_id + "\" }";
//
//        response = given().spec(req).body(deletePayload)
//                .when().post("/maps/api/place/delete/json")
//                .then().spec(resSpec).extract().response();
//
//        System.out.println("Delete Response: " + response.asString());
//    }

}
